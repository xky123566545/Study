package com.xzsd.app.clientHome.entity;
/**
 * @Description 查询首页轮播图，热门商品实体类
 * @author xukunyuan
 * @date 2020-04-21 20:35
 */
public class ClientHomeInfo {
    /**
     * 轮播图片路径
     */
    private String slideshowPath;
    /**
     * 商品编号
     */
    private String goodsId;
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

    public String getSlideshowPath() {
        return slideshowPath;
    }

    public void setSlideshowPath(String slideshowPath) {
        this.slideshowPath = slideshowPath;
    }

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
        return "ClientHomeInfo{" +
                "slideshowPath='" + slideshowPath + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsImagePath='" + goodsImagePath + '\'' +
                ", goodsPrice='" + goodsPrice + '\'' +
                '}';
    }
}
