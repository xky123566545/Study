package com.xzsd.app.register.dao;

import com.xzsd.app.register.entity.RegisterInfo;
import com.xzsd.app.register.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

/**
 * @Description 用户注册
 * @author xukunyuan
 * @date 2020-04-20 17:12
 */
@Mapper
public interface RegisterDao {
    /**
     * @Description:  App端用户注册
     * @Param:  registerInfo
     * @return: Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/20
     */
    int clientRegister(RegisterInfo registerInfo);
    /**
    * @Description: 检验门店邀请码是否存在
    * @Param:  inviteCode
    * @return:  int
    * @Author: xukunyuan
    * @Date: 2020/4/26
    */
    int countInviteCode(@Param("inviteCode") String inviteCode);
    /** 
    * @Description:  获取用户编号
    * @Param:  userId
    * @return:  int
    * @Author: xukunyuan
    * @Date: 2020/4/21 
    */
    int getRole(String userId);
    /**
     * @Description: App端查询个人信息接口
     * @Param:  userId
     * @Param: role
     * @return: Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/20
     */
    UserInfo getUser(@Param("userId") String userId,@Param("role") int role);
    /**
     * 统计userAcct数量
     * @param userAcct 用户编码
     * @return
     */
    int countUserAcct(String userAcct);
    /**
    * @Description: 获取用户密码
    * @Param:  userId
    * @return:  registerinfo
    * @Author: xukunyuan
    * @Date: 2020/4/21
    */
    RegisterInfo getUserById(String userId);
    /**
    * @Description: 修改密码
    * @Param:  registerInfo
    * @return:  int
    * @Author: xukunyuan
    * @Date: 2020/4/21
    */
    int updateUserPwd(RegisterInfo registerInfo);

}

