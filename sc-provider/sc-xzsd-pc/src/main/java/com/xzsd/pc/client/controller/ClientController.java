package com.xzsd.pc.client.controller;

import com.xzsd.pc.client.entity.ClientInfo;
import com.xzsd.pc.client.service.ClientService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 列表查询客户信息
 * @author xukunyuan
 * @date 2020-04-14 17:19
 */
@RestController
@RequestMapping("/client")
public class ClientController {
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Resource
    private ClientService clientService;
    /**
    * @Description: 分页查询客户信息
    * @Param:  clientInfo
    * @return:  Appresponse
    * @Author: xukunyuan
    * @Date: 2020/4/14
    */
    @PostMapping("listClients")
    public AppResponse listClients(ClientInfo clientInfo){
        try{
            return clientService.listClients(clientInfo);
        }catch (Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
}

