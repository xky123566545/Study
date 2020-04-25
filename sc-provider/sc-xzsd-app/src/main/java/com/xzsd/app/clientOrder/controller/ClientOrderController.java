package com.xzsd.app.clientOrder.controller;

import com.xzsd.app.clientOrder.entity.ClientOrderInfo;
import com.xzsd.app.clientOrder.service.ClientOrderService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.script.ScriptException;

/**
 * @Description 订单增删查改
 * @author xukunyuan
 * @date 2020-04-23 21:28
 */
@RestController
@RequestMapping("/clientOrder")
public class ClientOrderController {
    private static final Logger logger = LoggerFactory.getLogger(ClientOrderController.class);

    @Resource
    private ClientOrderService clientOrderService;
    
    /** 
    * @Description:  新增订单接口
    * @Param:  clientOrderInfo
    * @return:  AppResponse
    * @Author: xukunyuan
    * @Date: 2020/4/24 
    */
    @PostMapping("addOrder")
    public AppResponse addOrder(ClientOrderInfo clientOrderInfo) throws ScriptException {
        try{
            return clientOrderService.addOrder(clientOrderInfo);
        }catch (Exception e){
            logger.error("新增失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * @Description:  列表查询订单详情
     * @Param:  clientOrderInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/24
     */
    @PostMapping("listOrder")
    public AppResponse listOrder(ClientOrderInfo clientOrderInfo) {
        try{
            return clientOrderService.listOrder(clientOrderInfo);
        }catch (Exception e){
            logger.error("新增失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * @Description:  修改订单状态接口
     * @Param:  clientOrderInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/24
     */
    @PostMapping("updateOrderState")
    public AppResponse updateOrderState(ClientOrderInfo clientOrderInfo) {
        try{
            return clientOrderService.updateOrderState(clientOrderInfo);
        }catch (Exception e){
            logger.error("修改失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * @Description:  查询订单详情接口
     * @Param:  orderId
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/24
     */
    @PostMapping("listOrderDeepen")
    public AppResponse listOrderDeepen(String orderId) {
        try{
            return clientOrderService.listOrderDeepen(orderId);
        }catch (Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * @Description:  查询订单评价商品信息列表接口
     * @Param:  orderId
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/24
     */
    @PostMapping("listGoodsForEvaluate")
    public AppResponse listGoodsForEvaluate(String orderId) {
        try{
            return clientOrderService.listGoodsForEvaluate(orderId);
        }catch (Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * @Description:  新增订单评价商品信息列表接口
     * @Param:  JSONObject
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/24
     */
    @PostMapping("addGoodsEvaluate")
    public AppResponse addGoodsEvaluate(@RequestBody String evaluateOrder) {
        try{
            return clientOrderService.addGoodsEvaluate(evaluateOrder);
        }catch (Exception e){
            logger.error("新增失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
}
