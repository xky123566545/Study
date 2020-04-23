package com.xzsd.app.register.entity;

import java.util.Date;

/**
 * @Description 用户注册实体类
 * @author xukunyuan
 * @date 2020-04-20 17:12
 */
public class RegisterInfo {
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 用户账户
     */
    private String userAcct;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 性别：0表示男1表示女
     */
    private String sex;

    /**
     * 手机号
     */
    private String phone;
    /**
     * 用户邮箱
     */
    private String mail;
    /**
     * 身份证
     */
    private String idCard;
    /**
     * 用户角色编号
     */
    private String role;
    /**
     * 用户密码
     */
    private String userPassword;
    /**
     * 新密码
     */
    private String userNewPassword;
    /**
     * 用户头像路径
     */
    private String imagePath;
    /**
     * 门店邀请码
     */
    private String inviteCode;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserNewPassword() {
        return userNewPassword;
    }

    public void setUserNewPassword(String userNewPassword) {
        this.userNewPassword = userNewPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
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
        return "RegisterInfo{" +
                "userId='" + userId + '\'' +
                ", userAcct='" + userAcct + '\'' +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", idCard='" + idCard + '\'' +
                ", role='" + role + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userNewPassword='" + userNewPassword + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", inviteCode='" + inviteCode + '\'' +
                ", isDelete=" + isDelete +
                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", updateUser='" + updateUser + '\'' +
                ", updateTime=" + updateTime +
                ", version='" + version + '\'' +
                '}';
    }
}
