package com.xzsd.app.managerInformation.controller;

import com.xzsd.app.managerInformation.service.ManagerInformationService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 查询店长门下的司机信息接口
 * @author xukunyuan
 * @date 2020-04-26 19:54
 */
@RestController
@RequestMapping("/managerInformation")
public class ManagerInformationController {
    private static final Logger logger = LoggerFactory.getLogger(ManagerInformationController.class);
    @Resource
    private ManagerInformationService managerInformationService;
    /** 
    * @Description: 查询店长门下司机信息 接口
    * @Param:  
    * @return:  AppResponse
    * @Author: xukunyuan
    * @Date: 2020/4/26 
    */
    @PostMapping("listManagerDrivers")
    public AppResponse listManagerDrivers(){
        try{
            return managerInformationService.listManagerDrivers();
        }catch (Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }

}


