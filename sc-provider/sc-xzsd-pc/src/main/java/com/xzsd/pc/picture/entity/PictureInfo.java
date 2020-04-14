package com.xzsd.pc.picture.entity;

import java.util.Date;

public class PictureInfo {
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 排序
     */
    private int slideshowNum;
    /**
     * 图片序号
     */
    private String slideshowId;
    /**
     * 图片地址
     */
    private String imagePath;
    /**
     * 图片地址
     */
    private String slideshowPath;
    /**
     * 图片开始使用时间
     */
    private String startTime;
    /**
     * 图片结束使用时间
     */
    private String endTime;
    /**
     * 商品编号
     */
    private String goodsId;
    /**
     * 商品状态 0为禁用 1为使用
     */
    private String slideshowStateId;
    /**
     * 作废标记
     */
    private int isDelete;

    /**
     * 创建人
     *
     */
    private String createUser;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改人
     */
    private String updateUser;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 版本号
     */
    private String version;

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

    public int getSlideshowNum() {
        return slideshowNum;
    }

    public void setSlideshowNum(int slideshowNum) {
        this.slideshowNum = slideshowNum;
    }

    public String getSlideshowId() {
        return slideshowId;
    }

    public void setSlideshowId(String slideshowId) {
        this.slideshowId = slideshowId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getSlideshowPath() {
        return slideshowPath;
    }

    public void setSlideshowPath(String slideshowPath) {
        this.slideshowPath = slideshowPath;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getSlideshowStateId() {
        return slideshowStateId;
    }

    public void setSlideshowStateId(String slideshowStateId) {
        this.slideshowStateId = slideshowStateId;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "PictureInfo{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", slideshowNum=" + slideshowNum +
                ", slideshowId='" + slideshowId + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", slideshowPath='" + slideshowPath + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", slideshowStateId='" + slideshowStateId + '\'' +
                ", isDelete=" + isDelete +
                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", updateUser='" + updateUser + '\'' +
                ", updateTime=" + updateTime +
                ", version='" + version + '\'' +
                '}';
    }
}
