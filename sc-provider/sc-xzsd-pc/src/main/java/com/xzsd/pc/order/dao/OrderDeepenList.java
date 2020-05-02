package com.xzsd.pc.order.dao;

import com.xzsd.pc.order.entity.OrderInfo;

import java.util.List;

/**
 * @Description 将订单详情存入列表中
 * @author xukunyuan
 * @date 2020-04-27 16:47
 */
public class OrderDeepenList {
    /**
     * 包装OrderInfo
     */
    private List<OrderInfo> orderDeepenList;

    public List<OrderInfo> getOrderDeepenList() {
        return orderDeepenList;
    }

    public void setOrderDeepenList(List<OrderInfo> orderDeepenList) {
        this.orderDeepenList = orderDeepenList;
    }
}
