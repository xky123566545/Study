package com.xzsd.app.clientGoods.entity;

import java.util.List;

/**
 * @Description 讲实体类包装成列表
 * @author xukunyuan
 * @date 2020-04-29 20:57
 */
public class OneClassifyList {
    /**
     * 列表ClientGoodsInfo类
     */
    private List<ClientGoodsInfo> oneClassifyList;

    /**
     * 获取二级分类和商品List
     */
    private List<ClientGoodsInfo> twoClassifyList;

    public List<ClientGoodsInfo> getTwoClassifyList() {
        return twoClassifyList;
    }

    public void setTwoClassifyList(List<ClientGoodsInfo> twoClassifyList) {
        this.twoClassifyList = twoClassifyList;
    }

    public List<ClientGoodsInfo> getOneClassifyList() {
        return oneClassifyList;
    }

    public void setOneClassifyList(List<ClientGoodsInfo> oneClassifyList) {
        this.oneClassifyList = oneClassifyList;
    }
}
