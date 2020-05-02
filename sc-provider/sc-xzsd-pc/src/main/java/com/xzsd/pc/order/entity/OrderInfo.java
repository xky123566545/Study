package com.xzsd.pc.order.entity;

import java.util.Date;

/**
 * @Description 订单实体类
 * @author xukunyuan
 * @date 2020-04-14 19:09
 */
public class OrderInfo {
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 用户编码
     */
    private String userId;
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 商品编号
     */
    private String goodsId;
    /**
     * 门店编号
     */
    private String storeId;
    /**
     * 商品数量
     */
    private int goodsCount;
    /**
     * 总金额
     */
    private String theGoodsAllPrice;
    /**
     * 订单总金额
     */
    private String orderAllCost;
    /**
     * 付款时间范围起
     */
    private String payTimeStart;
    /**
     * 付款时间范围止
     */
    private String payTimeEnd;
    /**
     * 付款时间
     */
    private String payTime;
    /**
     * 订单状态
     */
    private String orderStateId;
    /**
     * 角色编号
     */
    private String role;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品定价
     */
    private String goodsShelfCost;
    /**
     * 商品售价
     */
    private String goodsPrice;
    /**
     * 下单人
     */
    private String userName;
    /**
     * 手机号
     */
    private String phone;
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
     * 修改人
     */
    private String updateUser;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 版本号
     */
    private String version;

    public String getOrderAllCost() {
        return orderAllCost;
    }

    public void setOrderAllCost(String orderAllCost) {
        this.orderAllCost = orderAllCost;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getTheGoodsAllPrice() {
        return theGoodsAllPrice;
    }

    public void setTheGoodsAllPrice(String theGoodsAllPrice) {
        this.theGoodsAllPrice = theGoodsAllPrice;
    }

    public String getPayTimeStart() {
        return payTimeStart;
    }

    public void setPayTimeStart(String payTimeStart) {
        this.payTimeStart = payTimeStart;
    }

    public String getPayTimeEnd() {
        return payTimeEnd;
    }

    public void setPayTimeEnd(String payTimeEnd) {
        this.payTimeEnd = payTimeEnd;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getOrderStateId() {
        return orderStateId;
    }

    public void setOrderStateId(String orderStateId) {
        this.orderStateId = orderStateId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsShelfCost() {
        return goodsShelfCost;
    }

    public void setGoodsShelfCost(String goodsShelfCost) {
        this.goodsShelfCost = goodsShelfCost;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
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

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", userId='" + userId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", storeId='" + storeId + '\'' +
                ", goodsCount=" + goodsCount +
                ", theGoodsAllPrice='" + theGoodsAllPrice + '\'' +
                ", orderAllCost='" + orderAllCost + '\'' +
                ", payTimeStart='" + payTimeStart + '\'' +
                ", payTimeEnd='" + payTimeEnd + '\'' +
                ", payTime='" + payTime + '\'' +
                ", orderStateId='" + orderStateId + '\'' +
                ", role='" + role + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsShelfCost='" + goodsShelfCost + '\'' +
                ", goodsPrice='" + goodsPrice + '\'' +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", isDelete=" + isDelete +
                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", updateUser='" + updateUser + '\'' +
                ", updateTime=" + updateTime +
                ", version='" + version + '\'' +
                '}';
    }
}
