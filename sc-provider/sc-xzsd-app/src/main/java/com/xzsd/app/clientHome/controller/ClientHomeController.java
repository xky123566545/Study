package com.xzsd.app.clientHome.controller;

import com.xzsd.app.clientHome.service.ClientHomeService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 查询首页轮播图，热门商品接口
 * @author xukunyuan
 * @date 2020-04-21 20:35
 */
@RestController
@RequestMapping("/clientHome")
public class ClientHomeController {
    private static final Logger logger = LoggerFactory.getLogger(ClientHomeController.class);
    @Resource
    private ClientHomeService clientHomeService;
    /** 
    * @Description:  查询首页轮播图接口
    * @Param:  
    * @return:  Appresponse
    * @Author: xukunyuan
    * @Date: 2020/4/21 
    */
    @PostMapping("listRotationCharHome")
    public AppResponse listRotationCharHome(){
        try{
            return clientHomeService.listRotationCharHome();

        }catch (Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * @Description:  查询热门商品接口
     * @Param:
     * @return:  Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/21
     */
    @PostMapping("listHotGoods")
    public AppResponse listHotGoods(){
        try{
            return clientHomeService.listHotGoods();

        }catch (Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
}
