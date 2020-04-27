package com.xzsd.app.clientOrder.entity;

import java.util.Date;

/**
 * @Description 批量插入数据库实体类
 * @author xukunyuan
 * @date 2020-04-25 18:48
 */
public class OrderDetailInfo {
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 商品编号
     */
    private String goodsId;
    /**
     * 商品价格
     */
    private String goodsPrice;
    /**
     * 商品数量
     */
    private String goodsCnt;
    /**
     * 商品数量
     */
    private int listCntInt;
    /**
     * 作废标记
     */
    private int isDelete;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 订单状态
     */
    private String orderStateId;
    /**
     * 版本号
     */
    private String version;

    public int getListCntInt() {
        return listCntInt;
    }

    public void setListCntInt(int listCntInt) {
        this.listCntInt = listCntInt;
    }

    public String getOrderStateId() {
        return orderStateId;
    }

    public void setOrderStateId(String orderStateId) {
        this.orderStateId = orderStateId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsCnt() {
        return goodsCnt;
    }

    public void setGoodsCnt(String goodsCnt) {
        this.goodsCnt = goodsCnt;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "OrderStateInfo{" +
                "orderId='" + orderId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", goodsPrice='" + goodsPrice + '\'' +
                ", goodsCnt='" + goodsCnt + '\'' +
                ", isDelete=" + isDelete +
                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", version='" + version + '\'' +
                '}';
    }
}
