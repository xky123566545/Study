package com.xzsd.app.clientOrder.entity;
/**
 * @Description 订单中全部商品基本信息集合类
 * @author xukunyuan
 * @date 2020-04-25 17:17
 */
public class GoodsList {
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
     * 商品价格
     */
    private String goodsPrice;
    /**
     * 商品数量
     */
    private String cartGoodsCount;
    /**
     * 商品编号
     */
    private String goodsId;

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

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getCartGoodsCount() {
        return cartGoodsCount;
    }

    public void setCartGoodsCount(String cartGoodsCount) {
        this.cartGoodsCount = cartGoodsCount;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "GoodsList{" +
                "goodsName='" + goodsName + '\'' +
                ", goodsImagePath='" + goodsImagePath + '\'' +
                ", goodsDescribe='" + goodsDescribe + '\'' +
                ", goodsPrice='" + goodsPrice + '\'' +
                ", cartGoodsCount='" + cartGoodsCount + '\'' +
                ", goodsId='" + goodsId + '\'' +
                '}';
    }
}
