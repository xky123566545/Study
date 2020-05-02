package com.xzsd.pc.store.entity;

import java.util.List;

/**
 * @Description 将省市区下拉框打包成list
 * @author xukunyuan
 * @date 2020-04-27 12:53
 */
public class AreaList {
    /**
     * 省市区下拉框list
     */
    private List<AreaInfo> areaList;

    public List<AreaInfo> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<AreaInfo> areaList) {
        this.areaList = areaList;
    }
}
