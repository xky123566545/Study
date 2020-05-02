package com.xzsd.pc.store.entity;

import java.util.Date;

/**
 * @Description 门店信息实体类
 * @author xukunyuan
 * @date 2020-04-15 20:40
 */
public class StoreInfo {
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 作废标记
     */
    private int isDelete;

    /**
     * 创建人
     *
     * @return
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
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 联系电话
     */
    private Long phone;
    /**
     * 店长编号
     */
    private String userId;
    /**
     * 店长名称
     */
    private String userName;
    /**
     * 营业执照编码
     */
    private String businessCode;
    /**
     * 省级编号
     */
    private String provinceId;
    /**
     * 省级名称
     */
    private String provinceName;
    /**
     * 市级编号
     */
    private String cityId;
    /**
     * 市级名称
     */
    private String cityName;
    /**
     * 区级编号
     */
    private String areaId;
    /**
     * 区级名称
     */
    private String areaName;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 门店编号
     */
    private String storeId;
    /**
     * 角色编号
     */
    private String role;
    /**
     * 门店邀请码
     */
    private String inviteCode;
    /**
     * 门店账号
     */
    private String userAcct;

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

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "StoreInfo{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", isDelete=" + isDelete +
                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", updateUser='" + updateUser + '\'' +
                ", updateTime=" + updateTime +
                ", version='" + version + '\'' +
                ", storeName='" + storeName + '\'' +
                ", phone='" + phone + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", businessCode='" + businessCode + '\'' +
                ", provinceId='" + provinceId + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", cityId='" + cityId + '\'' +
                ", cityName='" + cityName + '\'' +
                ", areaId='" + areaId + '\'' +
                ", areaName='" + areaName + '\'' +
                ", address='" + address + '\'' +
                ", storeId='" + storeId + '\'' +
                ", role='" + role + '\'' +
                ", inviteCode='" + inviteCode + '\'' +
                ", userAcct='" + userAcct + '\'' +
                '}';
    }
}
