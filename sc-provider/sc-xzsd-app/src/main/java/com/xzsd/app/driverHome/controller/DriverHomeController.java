package com.xzsd.app.driverHome.controller;

import com.xzsd.app.driverHome.service.DriverHomeService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 查询司机负责的门店信息接口
 * @author xukunyuan
 * @date 2020-04-26 19:54
 */
@RestController
@RequestMapping("/driverHome")
public class DriverHomeController {
    private static final Logger logger = LoggerFactory.getLogger(DriverHomeController.class);
    @Resource
    private DriverHomeService driverHomeService;
    /**
     * @Description: 查询司机负责的门店信息接口
     * @Param:
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/26
     */
    @PostMapping("listDriverStores")
    public AppResponse listDriverStores(){
        try{
            return driverHomeService.listDriverStores();
        }catch (Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
}
