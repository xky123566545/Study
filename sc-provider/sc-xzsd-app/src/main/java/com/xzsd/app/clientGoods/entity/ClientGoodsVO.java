package com.xzsd.app.clientGoods.entity;
/**
 * @Description 高级映射时商品实体类
 * @author xukunyuan
 * @date 2020-04-22 20:50
 */
public class ClientGoodsVO {
    /**
     * 商品编号
     */
    private String goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 图片路径
     */
    private String goodsImagePath;
    /**
     * 在售价
     */
    private String goodsPrice;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
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

    @Override
    public String toString() {
        return "ClientGoodsVO{" +
                "goodsId='" + goodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsImagePath='" + goodsImagePath + '\'' +
                ", goodsPrice='" + goodsPrice + '\'' +
                '}';
    }
}
