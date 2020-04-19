package com.xzsd.pc.order.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 订单查询修改
 * @author xukunyuan
 * @date 2020-04-14 19:41
 */
@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;
    /** 
    * @Description: 查询订单详情接口
    * @Param:  orderId
    * @return:  Appresponse
    * @Author: xukunyuan
    * @Date: 2020/4/14 
    */
    public AppResponse getListOrder(String orderId){
       OrderInfo orderInfo= orderDao.getListOrder(orderId);
        if(orderInfo == null){
            return AppResponse.bizError("查询失败,请重试");
        }
        return AppResponse.success("查询成功",orderInfo);
    }
    /**
     * @Description: 分页查询列表接口
     * @Param:  orderInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/14
     */
    public AppResponse listOrders(OrderInfo orderInfo){
        PageHelper.startPage(orderInfo.getPageNum(),orderInfo.getPageSize());
        List<OrderInfo> orderInfoList = orderDao.listOrders(orderInfo);
        PageInfo<OrderInfo> list = new PageInfo<>(orderInfoList);

        if( orderInfoList.size() == 0){
            return AppResponse.bizError("查询失败，请重试");
        }
        return AppResponse.success("查询成功",list);
    }
    /**
     * @Description: 修改订单状态接口
     * @Param:  orderInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/14
     */
    public AppResponse updateOrderState(OrderInfo orderInfo) {
        List<String> listCode = Arrays.asList(orderInfo.getOrderId().split(","));
        List<String> listVersion = Arrays.asList(orderInfo.getVersion().split(","));
        String orderStateId = orderInfo.getOrderStateId();
        String userId = SecurityUtils.getCurrentUserId();
        if (orderDao.updateOrderState(listCode,listVersion,orderStateId,userId) == 0){
            return AppResponse.bizError("修改失败,请重试");
        }
        return AppResponse.success("修改订单状态成功");
    }
}
