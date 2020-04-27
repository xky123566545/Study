package com.xzsd.app.managerOrder.controller;

import com.xzsd.app.managerOrder.entity.ManagerOrderInfo;
import com.xzsd.app.managerOrder.service.ManagerOrderService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 店长订单查询，订单状态修改
 * @author xukunyuan
 * @date 2020-04-26 15:18
 */
@RestController
@RequestMapping("/managerOrder")
public class ManagerOrderController {
    private static final Logger logger = LoggerFactory.getLogger(ManagerOrderController.class);
    @Resource
    private ManagerOrderService managerOrderService;
    
    /** 
    * @Description: 查询店长订单列表详情 
    * @Param:  managerOrderInfo
    * @return:  Appresponse
    * @Author: xukunyuan
    * @Date: 2020/4/26 
    */
    @PostMapping("listManagerOrders")
    public AppResponse listManagerOrders(ManagerOrderInfo managerOrderInfo){
        try{
            return managerOrderService.listManagerOrders(managerOrderInfo);
        }catch (Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * @Description: 查询店长订单详情
     * @Param:  orderId
     * @return:  Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/26
     */
    @PostMapping("listManagerOrderDeepen")
    public AppResponse listManagerOrderDeepen(String orderId){
        try{
            return managerOrderService.listManagerOrderDeepen(orderId);
        }catch (Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * @Description: 修改店长订单状态接口
     * @Param:  managerOrderInfo
     * @return:  Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/26
     */
    @PostMapping("updateManagerOrderState")
    public AppResponse updateManagerOrderState(ManagerOrderInfo managerOrderInfo){
        try{
            return managerOrderService.updateManagerOrderState(managerOrderInfo);
        }catch (Exception e){
            logger.error("修改失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }

}
