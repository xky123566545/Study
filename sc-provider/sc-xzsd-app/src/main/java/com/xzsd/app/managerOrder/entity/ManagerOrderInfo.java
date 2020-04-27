package com.xzsd.app.managerOrder.entity;

import java.util.List;

/**
 * @Description 店长订单查询，订单状态修改实体类
 * @author xukunyuan
 * @date 2020-04-26 15:18
 */
public class ManagerOrderInfo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 订单状态
     */
    private String orderStateId;
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 店长编号
     */
    private String managerId;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 客户电话
     */
    private String phone;
    /**
     * 订单总价
     */
    private String orderAllCost;
    /**
     * 订单商品总数量
     */
    private String orderAllGoodsCount;
    /**
     *  版本号
     */
    private String version;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     *门店地址
     */
    private String address;
    /**
     * 商品信息列表
     */

    private List<GoodsList> goodsList;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderStateId() {
        return orderStateId;
    }

    public void setOrderStateId(String orderStateId) {
        this.orderStateId = orderStateId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrderAllCost() {
        return orderAllCost;
    }

    public void setOrderAllCost(String orderAllCost) {
        this.orderAllCost = orderAllCost;
    }

    public String getOrderAllGoodsCount() {
        return orderAllGoodsCount;
    }

    public void setOrderAllGoodsCount(String orderAllGoodsCount) {
        this.orderAllGoodsCount = orderAllGoodsCount;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<GoodsList> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsList> goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        return "ManagerOrderInfo{" +
                "pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", orderId='" + orderId + '\'' +
                ", orderStateId='" + orderStateId + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", orderAllCost='" + orderAllCost + '\'' +
                ", orderAllGoodsCount='" + orderAllGoodsCount + '\'' +
                ", version='" + version + '\'' +
                ", goodsList=" + goodsList +
                '}';
    }
}
