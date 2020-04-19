package com.xzsd.pc.order.controller;

import com.xzsd.pc.goods.controller.GoodsController;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.service.OrderService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 订单查询修改
 * @author xukunyuan
 * @date 2020-04-14 19:24
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
    @Resource
    private OrderService orderService;
    /** 
    * @Description:  查询订单详情接口
    * @Param:  orderId
    * @return:  Appresponse
    * @Author: xukunyuan
    * @Date: 2020/4/14 
    */
    @GetMapping("getListOrder")
    public AppResponse getListOrder(String orderId){
        try{
            return orderService.getListOrder(orderId);
        }catch (Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
    * @Description: 分页查询列表接口
    * @Param:  orderInfo
    * @return:  AppResponse
    * @Author: xukunyuan
    * @Date: 2020/4/14
    */
    @GetMapping("listOrders")
    public AppResponse listOrders(OrderInfo orderInfo){
        try{
            return orderService.listOrders(orderInfo);
        }catch (Exception e){
            logger.error("查询失败,请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /** 
    * @Description: 修改订单状态接口 
    * @Param:  orderInfo
    * @return:  AppResponse
    * @Author: xukunyuan
    * @Date: 2020/4/14 
    */
    @PostMapping("updateOrderState")
    public AppResponse updateOrderState(OrderInfo orderInfo){
        try{
            return orderService.updateOrderState(orderInfo);
        }catch (Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }

}
