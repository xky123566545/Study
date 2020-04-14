package com.xzsd.pc.picture.entity;

/**查询商品接口
 * @Description
 * @author xukunyuan
 * @date 2020-04-13 21:09
 */
public class GoodsInfo {
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 商品状态编号： 1在售（只有在售商品）
     */
    private String goodsStateId;
    /**
     * 一级分类名称
     */
    private String oneClassifyName;
    /**
     * 二级分类名称
     */
    private String twoClassifyName;

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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsStateId() {
        return goodsStateId;
    }

    public void setGoodsStateId(String goodsStateId) {
        this.goodsStateId = goodsStateId;
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

    @Override
    public String toString() {
        return "GoodsInfo{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", goodsName='" + goodsName + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", goodsStateId='" + goodsStateId + '\'' +
                ", oneClassifyName='" + oneClassifyName + '\'' +
                ", twoClassifyName='" + twoClassifyName + '\'' +
                '}';
    }
}
