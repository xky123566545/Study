package com.xzsd.pc.goods.entity;

import java.util.List;

/**
 * @Description 将商品分类打包成List
 * @author xukunyuan
 * @date 2020-04-27 22:02
 */
public class GoodsClassifyList {
    /**
     * list商品类
     */
    private List<ClassifyInfo> goodsClassifyList;

    public List<ClassifyInfo> getGoodsClassifyList() {
        return goodsClassifyList;
    }

    public void setGoodsClassifyList(List<ClassifyInfo> goodsClassifyList) {
        this.goodsClassifyList = goodsClassifyList;
    }
}
