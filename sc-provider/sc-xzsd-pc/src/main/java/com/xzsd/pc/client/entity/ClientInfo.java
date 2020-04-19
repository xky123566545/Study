package com.xzsd.pc.client.entity;
/**
 * @Description 查询客户列表实体类
 * @author xukunyuan
 * @date 2020-04-14 17:29
 */
public class ClientInfo {
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 页码（每页显示几条信息）
     */
    private int pageSize;
    /**
     * 客户编号
     */
    private String userId;
    /**
     * 客户名称
     */
    private String userName;
    /**
     * 客户账号
     */
    private String userAcct;
    /**
     * 客户角色
     */
    private String role;
    /**
     * 客户电话
     */
    private String phone;
    /**
     * 客户邮箱
     */
    private String mail;
    /**
     * 客户身份证号码
     */
    private String idCard;
    /**
     * 性别:0男1女
     */
    private int sex;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "ClientInfo{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userAcct='" + userAcct + '\'' +
                ", role='" + role + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", idCard='" + idCard + '\'' +
                ", sex=" + sex +
                '}';
    }
}
