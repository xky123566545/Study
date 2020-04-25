package com.xzsd.pc.user.dao;

import com.xzsd.pc.user.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName DemoDao
 * @Description Demo
 * @Author dingning
 * @Date 2020-03-21
 */
@Mapper
public interface UserDao {
    /**
     * 统计userAcct数量
     * @param userAcct 用户编码
     * @return
     */
    int countUserAcct(@Param("userAcct") String userAcct);
    /**
     * 新增用户
     * @param userInfo 用户信息
     * @return
     */
    int addUser(UserInfo userInfo);

    /**
     * 获取所有用户信息
     * @param userInfo 用户信息
     * @return 所有用户信息
     */
    List<UserInfo> listUsersByPage(UserInfo userInfo);

    /**
     * 删除用户信息
     * @param listCode 选中的用户编号集合
     * @param userAcct 更新人
     * @return
     */
    int deleteUser(@Param("listCode") List<String> listCode, @Param("userAcct") String userAcct);
    /**
     * 修改用户信息
     * @param userInfo 用户信息
     * @return 修改结果
     */
    int updateUser(UserInfo userInfo);

    /**
     * 查询用户信息
     * @param userId 用户编号
     * @return 修改结果
     */
    UserInfo getUserByUserCode(@Param("userId") String userId);
}
