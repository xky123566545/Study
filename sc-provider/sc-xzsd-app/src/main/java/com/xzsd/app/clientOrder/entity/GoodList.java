package com.xzsd.app.clientOrder.entity;

import java.util.List;

/**
 * @Description 查询订单详情实体类
 * @author xukunyuan
 * @date 2020-04-25 22:51
 */
public class GoodList {
    /**
     * 实体类列表
     */
    private List<ClientOrderInfo> goodsList;

    public List<ClientOrderInfo> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<ClientOrderInfo> goodsList) {
        this.goodsList = goodsList;
    }
}
