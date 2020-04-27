package com.xzsd.app.clientHome.entity;

import java.util.List;

/**
 * @Description 打包List类
 * @author xukunyuan
 * @date 2020-04-26 9:00
 */
public class SlideshowList {
    /**
     * 轮播图信息List
     */
    private List<ClientHomeInfo> slideshowList;
    /**
     * 热门商品信息接口
     */
    private List<ClientHomeInfo> list;

    public List<ClientHomeInfo> getSlideshowList() {
        return slideshowList;
    }

    public void setSlideshowList(List<ClientHomeInfo> slideshowList) {
        this.slideshowList = slideshowList;
    }

    public List<ClientHomeInfo> getList() {
        return list;
    }

    public void setList(List<ClientHomeInfo> list) {
        this.list = list;
    }
}
