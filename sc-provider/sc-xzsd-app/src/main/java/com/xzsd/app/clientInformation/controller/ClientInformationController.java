package com.xzsd.app.clientInformation.controller;

import com.xzsd.app.clientInformation.service.ClientInformationService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 修改邀请码
 * @author xukunyuan
 * @date 2020-04-26 14:22
 */
@RestController
@RequestMapping("/clientInformation")
public class ClientInformationController {
    private static final Logger logger = LoggerFactory.getLogger(ClientInformationController.class);

    @Resource
    private ClientInformationService clientInformationService;

    /**
    * @Description: 修改门店邀请码
    * @Param:  inviteCode
    * @return:  AppResposne
    * @Author: xukunyuan
    * @Date: 2020/4/26
    */
    @PostMapping("updateClientInvite")
    public AppResponse updateClientInvite(String inviteCode){
        try{
            return clientInformationService.updateClientInvite(inviteCode);
        }catch (Exception e){
            logger.error("修改失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
}
