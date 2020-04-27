package com.xzsd.app.register.service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.register.dao.RegisterDao;
import com.xzsd.app.register.entity.RegisterInfo;
import com.xzsd.app.register.entity.UserInfo;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.PasswordUtils;
import com.xzsd.app.util.StringUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description 用户注册
 * @author xukunyuan
 * @date 2020-04-20 17:12
 */
@Service
public class RegisterService {
    @Resource
    private RegisterDao registerDao;

    /**
     * @Description: App端用户注册
     * @Param: registerInfo
     * @return: Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/20
     */
    public AppResponse clientRegister(RegisterInfo registerInfo) {
        //生成用户编号
        registerInfo.setUserId(StringUtil.getCommonCode(2));
        registerInfo.setCreateUser(registerInfo.getUserId());
        //密码加密
        registerInfo.setUserPassword(PasswordUtils.generatePassword(registerInfo.getUserPassword()));
        //检验门店邀请码是否存在
        if(registerInfo.getInviteCode() != null){
            if (registerDao.countInviteCode(registerInfo.getInviteCode()) == 0){
                return AppResponse.versionError("门店邀请码不存在，请重新输入");
            }
        }
        //检验用户账号是否存在
        if (registerDao.countUserAcct(registerInfo.getUserAcct()) != 0) {
            return AppResponse.versionError("用户账号已存在，请重新输入");
        }
        if (registerDao.clientRegister(registerInfo) == 0) {
            return AppResponse.versionError("注册失败，请重试");
        }
        return AppResponse.success("注册成功");
    }

    /**
     * @Description: App端查询个人信息接口
     * @Param:
     * @return: Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/20
     */
    public AppResponse getUser() {
        String userId = SecurityUtils.getCurrentUserId();
        int role = registerDao.getRole(userId);
        UserInfo userInfo = registerDao.getUser(userId,role);
        if (userInfo == null){
            return AppResponse.versionError("查询失败，请重试");
        }
        return AppResponse.success("查询成功",userInfo);

    }
    /**
     * @Description:  App端修改个人密码
     * @Param:  registerInfo
     * @return: Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/20
     */
    public AppResponse updateUserPassword(RegisterInfo registerInfo){
        registerInfo.setCreateUser(SecurityUtils.getCurrentUserId());
        // 需要校验原密码是否正确
        if(null != registerInfo.getUserPassword() && !"".equals(registerInfo.getUserPassword())) {
            //获取用户输入的密码
            String oldPwd = registerInfo.getUserPassword();
            // 获取用户信息
            RegisterInfo userDetail = registerDao.getUserById(registerInfo.getCreateUser());
            //获取当前登录角色
            registerInfo.setRole(userDetail.getRole());
            //获取数据库中的密码
            String password = userDetail.getUserPassword();
            if(null == userDetail) {
                return AppResponse.bizError("用户不存在或已被删除！");
            } else {
                //比较密码是否相同
                Boolean isEquals = new BCryptPasswordEncoder().matches(oldPwd, password);
                if(!isEquals) {
                    return AppResponse.bizError("原密码不匹配，请重新输入！");
                }
            }
        }
        // 修改密码
        registerInfo.setUserNewPassword(PasswordUtils.generatePassword(registerInfo.getUserNewPassword()));
        int count = registerDao.updateUserPwd(registerInfo);
        if(0 == count) {
            return AppResponse.bizError("修改密码失败，请重试");
        }
        return AppResponse.success("修改密码成功");
    }

}
