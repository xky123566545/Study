package com.xzsd.app.clientShopCart.entity;

import java.util.Date;

/**
 * @Description 购物车增删查改实体类
 * @author xukunyuan
 * @date 2020-04-23 10:37
 */
public class ClientShopCartInfo {
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 页码
     */
    private int pageSize;
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
     * 商品编号
     */
    private String goodsId;
    /**
     * 客户选择的数量，默认为1
     */
    private int cartGoodsCount;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品图片路径
     */
    private String goodsImagePath;
    /**
     * 商品价格
     */
    private String goodsPrice;
    /**
     * 购物车编号
     */
    private String shopCartId;

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

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public int getCartGoodsCount() {
        return cartGoodsCount;
    }

    public void setCartGoodsCount(int cartGoodsCount) {
        this.cartGoodsCount = cartGoodsCount;
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

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getShopCartId() {
        return shopCartId;
    }

    public void setShopCartId(String shopCartId) {
        this.shopCartId = shopCartId;
    }

    @Override
    public String toString() {
        return "ClientShopCartInfo{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", isDelete=" + isDelete +
                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", updateUser='" + updateUser + '\'' +
                ", updateTime=" + updateTime +
                ", version='" + version + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", cartGoodsCount=" + cartGoodsCount +
                ", goodsName='" + goodsName + '\'' +
                ", goodsImagePath='" + goodsImagePath + '\'' +
                ", goodsPrice='" + goodsPrice + '\'' +
                ", shopCartId='" + shopCartId + '\'' +
                '}';
    }
}
