package com.xzsd.pc.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.PasswordUtils;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @DescriptionDemo 实现类
 * @Author dingning
 * @Date 2020-03-21
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    /**
     * demo 新增用户
     * @param userInfo
     * @return
     * @Author dingning
     * @Date 2020-03-21
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addUser(UserInfo userInfo) {
        //获取用户id
        String userId = SecurityUtils.getCurrentUserId();
        userInfo.setCreateUser(userId);
        userInfo.setUserId(StringUtil.getCommonCode(2));
        userInfo.setIsDelete(0);
        //密码加密
        userInfo.setUserPassword(PasswordUtils.generatePassword(userInfo.getUserPassword()));
        // 校验账号是否存在
        int countUserAcct = userDao.countUserAcct(userInfo.getUserAcct());
        if(0 != countUserAcct) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        // 新增用户
        //超级管理员权限
        if(userId.equals("2020041919582146587")) {
            int count = userDao.addUser(userInfo);
            if (0 == count) {
                return AppResponse.bizError("新增失败，请重试！");
            }
            return AppResponse.success("新增成功！");
        }
        //普通管理员只能新增店长
        else{
            if(userInfo.getRole().equals("1")){
                return AppResponse.bizError("当前登录角色没有新增管理员的权限！");
            }
            if (0 == userDao.addUser(userInfo)){
                return AppResponse.bizError("新增失败");
            }
            return AppResponse.success("新增成功");
        }
    }

    /**
     * demo 查询用户列表（分页）
     * @param userInfo
     * @return
     * @Author dingning
     * @Date 2020-03-21
     */
    public AppResponse listUsersPage(UserInfo userInfo) {
        PageHelper.startPage(userInfo.getPageNum(), userInfo.getPageSize());
        List<UserInfo> User = userDao.listUsersByPage(userInfo);
        // 包装Page对象
        PageInfo<UserInfo> list = new PageInfo<UserInfo>(User);
        if (User.size() == 0){
            return AppResponse.bizError("查询失败，请重试");
        }
        return AppResponse.success("查询成功！",list);
    }

    /**
     * demo 删除用户
     * @param userId
     * @return
     * @Author xukunyuan
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteUser(String userId,String role,String nowRole) {
        //获取用户id
        String userAcct = SecurityUtils.getCurrentUserId();
        List<String> listCode = Arrays.asList(userId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        //删除用户
        //若不是超级管理员
        if (!userAcct.equals("2020041919582146587")){
            List<String> listRole = Arrays.asList(role.split(","));
            int temp = 1;
            //判断选择的用户里面是否存在管理员，若存在则删除失败
            for (int i = 0; i < listRole.size(); i++){
                if (listRole.get(i).equals("1")){
                    temp = 0;
                }
            }
            if (temp == 0){
                return AppResponse.notFound("该登录角色没有删除管理员权限，请重试");
            }
        }
        int count = userDao.deleteUser(listCode,userAcct);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * demo 修改用户
     * @param userInfo
     * @return
     * @Author dingning
     * @Date 2020-03-21
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUser(UserInfo userInfo) {
        //获取用户id
        String userId = SecurityUtils.getCurrentUserId();
        userInfo.setUpdateUser(userId);
        //密码加密
        userInfo.setUserPassword(PasswordUtils.generatePassword(userInfo.getUserPassword()));
        AppResponse appResponse = AppResponse.success("修改成功");
        // 修改用户信息超级管理员权限
        if(userId.equals("2020041919582146587")) {
            int count = userDao.updateUser(userInfo);
            if (0 == count) {
                appResponse = AppResponse.bizError("删除失败，请重试！");
                return appResponse;
            }
            return appResponse;
        }
        else{
            int count = userDao.updateUser(userInfo);
            if (0 == count) {
                appResponse = AppResponse.notFound("该登录角色没有修改管理员的的权限，请重试！");
                return appResponse;
            }
            return appResponse;
        }
    }


    /**
     * demo 查询用户详情
     * @param userId
     * @return
     * @Author dingning
     * @Date 2020-03-21
     */
    public AppResponse getUser(String userId) {
        UserInfo userInfo = userDao.getUserByUserCode(userId);
        return AppResponse.success("查询成功！",userInfo);
    }
}


