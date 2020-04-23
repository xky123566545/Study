package com.xzsd.pc.topOfColumn.controller;

import com.xzsd.pc.topOfColumn.service.TopOfColumnService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 顶部栏接口
 * @author xukunyuan
 * @date 2020-04-20 9:49
 */
@RestController
@RequestMapping("/topOfColumn")
public class TopOfColumnController {
    private static final Logger logger = LoggerFactory.getLogger(TopOfColumnController.class);
    @Resource
    private TopOfColumnService topOfColumnService;
    /** 
    * @Description:  顶部栏接口
    * @Param:  
    * @return:  AppResponse
    * @Author: xukunyuan
    * @Date: 2020/4/20 
    */
    @PostMapping("getTopOfColumn")
    public AppResponse getTopOfColumn(){
        try{
            return topOfColumnService.getTopOfColumn();
        }catch (Exception e){
            logger.error("查询失败,请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
}
