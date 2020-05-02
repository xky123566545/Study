package com.xzsd.pc.goods.entity;

import java.util.Date;

/**
 * @Description 返回给前端的商品类
 * @author xukunyuan
 * @date 2020-03-27 10:40
 */
public class GoodsVO {
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 页码
     */
    private int pageSize;

    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 书号
     */
    private String isbn;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 原价
     */
    private double goodsOriginalCost;
    /**
     * 在售价
     */
    private double goodsPrice;
    /**
     * 销售量
     */
    private String goodsSales;
    /**
     * 一级分类名称
     */
    private String oneClassifyName;
    /**
     * 二级分类名称
     */
    private String twoClassifyName;
    /**
     * 广告词
     */
    private String goodsAdvertise;
    /**
     * 商品介绍
     */
    private String goodsDescribe;
    /**
     * 商品状态：0售罄、1在售、2已下架、3未发布
     */
    private String goodsStateId;
    /**
     * 浏览量
     */
    private String goodsViewsNum;
    /**
     * 商家名称
     */
    private String supplierName;
    /**
     * 库存量
     */
    private String goodsInventory;
    /**
     * 图片路径
     */
    private String goodsImagePath;
    /**
     * 作者
     */
    private String goodsAuthor;
    /**
     * 出版社
     */
    private String goodsPress;
    /**
     * 商品上架时间
     */
    private Date goodsShelfTime;

    /**
     * 版本号
     */
    private String version;

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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getGoodsOriginalCost() {
        return goodsOriginalCost;
    }

    public void setGoodsOriginalCost(double goodsOriginalCost) {
        this.goodsOriginalCost = goodsOriginalCost;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsSales() {
        return goodsSales;
    }

    public void setGoodsSales(String goodsSales) {
        this.goodsSales = goodsSales;
    }

    public String getOneClassifyName() {
        return oneClassifyName;
    }

    public void setOneClassifyName(String oneClassifyName) {
        this.oneClassifyName = oneClassifyName;
    }

    public String getTwoClassifyName() {
        return twoClassifyName;
    }

    public void setTwoClassifyName(String twoClassifyName) {
        this.twoClassifyName = twoClassifyName;
    }

    public String getGoodsAdvertise() {
        return goodsAdvertise;
    }

    public void setGoodsAdvertise(String goodsAdvertise) {
        this.goodsAdvertise = goodsAdvertise;
    }

    public String getGoodsDescribe() {
        return goodsDescribe;
    }

    public void setGoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
    }

    public String getGoodsStateId() {
        return goodsStateId;
    }

    public void setGoodsStateId(String goodsStateId) {
        this.goodsStateId = goodsStateId;
    }

    public String getGoodsViewsNum() {
        return goodsViewsNum;
    }

    public void setGoodsViewsNum(String goodsViewsNum) {
        this.goodsViewsNum = goodsViewsNum;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getGoodsInventory() {
        return goodsInventory;
    }

    public void setGoodsInventory(String goodsInventory) {
        this.goodsInventory = goodsInventory;
    }

    public String getGoodsImagePath() {
        return goodsImagePath;
    }

    public void setGoodsImagePath(String goodsImagePath) {
        this.goodsImagePath = goodsImagePath;
    }

    public String getGoodsAuthor() {
        return goodsAuthor;
    }

    public void setGoodsAuthor(String goodsAuthor) {
        this.goodsAuthor = goodsAuthor;
    }

    public String getGoodsPress() {
        return goodsPress;
    }

    public void setGoodsPress(String goodsPress) {
        this.goodsPress = goodsPress;
    }

    public Date getGoodsShelfTime() {
        return goodsShelfTime;
    }

    public void setGoodsShelfTime(Date goodsShelfTime) {
        this.goodsShelfTime = goodsShelfTime;
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

    @Override
    public String toString() {
        return "GoodsVO{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", goodsId='" + goodsId + '\'' +
                ", isbn='" + isbn + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsOriginalCost='" + goodsOriginalCost + '\'' +
                ", goodsPrice='" + goodsPrice + '\'' +
                ", goodsSales='" + goodsSales + '\'' +
                ", oneClassifyName='" + oneClassifyName + '\'' +
                ", twoClassifyName='" + twoClassifyName + '\'' +
                ", goodsAdvertise='" + goodsAdvertise + '\'' +
                ", goodsDescribe='" + goodsDescribe + '\'' +
                ", goodsStateId='" + goodsStateId + '\'' +
                ", goodsViewsNum='" + goodsViewsNum + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ", goodsInventory='" + goodsInventory + '\'' +
                ", goodsImagePath='" + goodsImagePath + '\'' +
                ", goodsAuthor='" + goodsAuthor + '\'' +
                ", goodsPress='" + goodsPress + '\'' +
                ", goodsShelfTime=" + goodsShelfTime +
                '}';
    }
}
