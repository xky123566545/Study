package com.xzsd.pc.user.controller;


import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.service.UserService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @Description增删改查DEMO
 * @Author xukunyuan
 * @Date 2020-03-25
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    /**
     * demo 新增用户
     * @param userInfo
     * @return AppResponse
     * @author xukunyuan
     * @Date 2020-03-25
     */
    @PostMapping("addUser")
    public AppResponse addUser(UserInfo userInfo) {
        try {
            AppResponse appResponse = userService.addUser(userInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * demo 用户列表(分页)
     * @param userInfo
     * @return AppResponse
     * @author xukunyuan
     * @Date 2020-03-25
     */
    @PostMapping("listUsers")
    public AppResponse listUsers(UserInfo userInfo) {
        try {
            return userService.listUsersPage(userInfo);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 删除用户
     * @param userId
     * @return AppResponse
     * @author xukunyuan
     * @Date 2020-03-25
     */
    @PostMapping("deleteUser")
    public AppResponse deleteUser(String userId,String role,String nowRole) {
        try {
            return userService.deleteUser(userId,role,nowRole);
        } catch (Exception e) {
            logger.error("用户删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 修改用户
     * @param userInfo
     * @return AppResponse
     * @author xukunyuan
     * @Date 2020-03-25
     */
    @PostMapping("updateUser")
    public AppResponse updateUser(UserInfo userInfo) {
        try {
            return userService.updateUser(userInfo);
        } catch (Exception e) {
            logger.error("修改用户信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 查询用户详情
     * @param userId
     * @return AppResponse
     * @author xukunyuan
     * @Date 2020-03-25
     */
    @PostMapping("getUser")
    public AppResponse getUser(String userId) {
        try {
            return userService.getUser(userId);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
