package com.xzsd.pc.topOfColumn.entity;
/**
 * @Description 顶部栏接口实体类
 * @author xukunyuan
 * @date 2020-04-20 9:49
 */
public class TopOfColumnInfo {
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户头像图片路径
     */
    private String userImage;
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 用户角色编号：0超级管理员、1管理员、2店长
     */
    private String role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "TopOfColumnInfo{" +
                "userName='" + userName + '\'' +
                ", userImage='" + userImage + '\'' +
                ", userId='" + userId + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
