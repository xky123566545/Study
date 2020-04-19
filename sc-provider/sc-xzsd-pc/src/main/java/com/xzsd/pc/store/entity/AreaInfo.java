package com.xzsd.pc.store.entity;
/**
 * @Description 省市区实体类
 * @author xukunyuan
 * @date 2020-04-15 22:05
 */
public class AreaInfo {
    /**
     * 区域编号
     */
    private String areaId;
    /**
     * 区域名称
     */
    private String areaName;

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Override
    public String toString() {
        return "AreaInfo{" +
                "areaId='" + areaId + '\'' +
                ", areaName='" + areaName + '\'' +
                '}';
    }
}
