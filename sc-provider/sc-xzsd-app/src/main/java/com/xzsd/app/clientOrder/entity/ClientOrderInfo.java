package com.xzsd.app.clientOrder.entity;

import java.util.Date;
import java.util.List;

/**
 * @Description 订单增删查改实体类
 * @author xukunyuan
 * @date 2020-04-23 21:28
 */
public class ClientOrderInfo {
    /**
     * 作废标记
     */
    private int isDelete;

    /**
     * 创建人
     *
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
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 商品编号,逗号隔开
     */
    private String goodsId;
    /**
     * 商品价格，逗号隔开
     */
    private String goodsPrice;
    /**
     * 商品数量，逗号隔开
     */
    private String clientGoodsNum;
    /**
     * 购物车编号，逗号隔开
     */
    private String shopCartId;
    /**
     * 门店编码
     */
    private String storeId;
    /**
     * 订单状态编号：0已下单， 2待取货，4或5已完成（按钮对应的订单状态）
     */
    private String orderStateId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 图片路径
     */
    private String goodsImagePath;
    /**
     * 商品介绍
     */
    private String goodsDescribe;
    /**
     * 商品数量
     */
    private int cartGoodsCount;
    /**
     * 订单总价
     */
    private String orderAllCost;
    /**
     * 订单商品总数量
     */
    private int orderAllGoodsCount;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 评价内容
     */
    private String evaluateContent;
    /**
     * 商品等级
     */
    private int evaluateScore;
    /**
     * 图片序号
     */
    private String imageNum;
    /**
     * 图片路径
     */
    private String imagePath;

    /**
     * 商品list
     */
    private List<GoodsList> goodsList;

    public List<GoodsList> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsList> goodsList) {
        this.goodsList = goodsList;
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

    public String getClientGoodsNum() {
        return clientGoodsNum;
    }

    public void setClientGoodsNum(String clientGoodsNum) {
        this.clientGoodsNum = clientGoodsNum;
    }

    public String getShopCartId() {
        return shopCartId;
    }

    public void setShopCartId(String shopCartId) {
        this.shopCartId = shopCartId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getOrderStateId() {
        return orderStateId;
    }

    public void setOrderStateId(String orderStateId) {
        this.orderStateId = orderStateId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImagePath() {
        return goodsImagePath;
    }

    public void setGoodsImagePath(String goodsImagePath) {
        this.goodsImagePath = goodsImagePath;
    }

    public String getGoodsDescribe() {
        return goodsDescribe;
    }

    public void setGoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
    }

    public int getCartGoodsCount() {
        return cartGoodsCount;
    }

    public void setCartGoodsCount(int cartGoodsCount) {
        this.cartGoodsCount = cartGoodsCount;
    }

    public String getOrderAllCost() {
        return orderAllCost;
    }

    public void setOrderAllCost(String orderAllCost) {
        this.orderAllCost = orderAllCost;
    }


    public int getOrderAllGoodsCount() {
        return orderAllGoodsCount;
    }

    public void setOrderAllGoodsCount(int orderAllGoodsCount) {
        this.orderAllGoodsCount = orderAllGoodsCount;
    }

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

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
    }

    public int getEvaluateScore() {
        return evaluateScore;
    }

    public void setEvaluateScore(int evaluateScore) {
        this.evaluateScore = evaluateScore;
    }

    public String getImageNum() {
        return imageNum;
    }

    public void setImageNum(String imageNum) {
        this.imageNum = imageNum;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "ClientOrderInfo{" +
                "isDelete=" + isDelete +
                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", updateUser='" + updateUser + '\'' +
                ", updateTime=" + updateTime +
                ", version='" + version + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", orderId='" + orderId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", goodsPrice='" + goodsPrice + '\'' +
                ", clientGoodsNum='" + clientGoodsNum + '\'' +
                ", shopCartId='" + shopCartId + '\'' +
                ", storeId='" + storeId + '\'' +
                ", orderStateId='" + orderStateId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsImagePath='" + goodsImagePath + '\'' +
                ", goodsDescribe='" + goodsDescribe + '\'' +
                ", cartGoodsCount=" + cartGoodsCount +
                ", orderAllCost='" + orderAllCost + '\'' +
                ", orderAllGoodsCount=" + orderAllGoodsCount +
                ", storeName='" + storeName + '\'' +
                ", address='" + address + '\'' +
                ", evaluateContent='" + evaluateContent + '\'' +
                ", evaluateScore=" + evaluateScore +
                ", imageNum='" + imageNum + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
