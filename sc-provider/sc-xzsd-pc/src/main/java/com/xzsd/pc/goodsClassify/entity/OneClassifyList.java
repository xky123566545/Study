package com.xzsd.pc.goodsClassify.entity;

import java.util.List;

/**
 * @Description 包装list
 * @author xukunyuan
 * @date 2020-04-23 15:26
 */
public class OneClassifyList {
    /**
     * 封装数据
     */
    List<GoodsClassifyInfo> oneClassifyList;

    public List<GoodsClassifyInfo> getOneClassifyList() {
        return oneClassifyList;
    }

    public void setOneClassifyList(List<GoodsClassifyInfo> oneClassifyList) {
        this.oneClassifyList = oneClassifyList;
    }
}
