package com.xzsd.app.register.controller;

import com.xzsd.app.register.entity.RegisterInfo;
import com.xzsd.app.register.service.RegisterService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 用户注册查询个人信息
 * @author xukunyuan
 * @date 2020-04-20 17:12
 */
@RestController
public class RegisterController {
    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
    @Resource
    private RegisterService registerService;
    /**
    * @Description:  App端用户注册
    * @Param:  registerInfo
    * @return: Appresponse
    * @Author: xukunyuan
    * @Date: 2020/4/20
    */
    @PostMapping("/register/clientRegister")
    public AppResponse clientRegister(RegisterInfo registerInfo){
        try{
            return registerService.clientRegister(registerInfo);
        }catch (Exception e){
            logger.error("注册失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * @Description:  App端查询个人信息接口
     * @Param:
     * @return: Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/20
     */
    @PostMapping("/userInformation/getUser")
    public AppResponse getUser(){
        try{
            return registerService.getUser();
        }catch (Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * @Description:  App端修改个人密码
     * @Param:  registerInfo
     * @return: Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/20
     */
    @PostMapping("/userInformation/updateUserPassword")
    public AppResponse updateUserPassword(RegisterInfo registerInfo){
        try{
            return registerService.updateUserPassword(registerInfo);
        }catch (Exception e){
            logger.error("修改失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
}
