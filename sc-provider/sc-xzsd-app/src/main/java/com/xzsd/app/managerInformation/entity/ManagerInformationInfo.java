package com.xzsd.app.managerInformation.entity;
/**
 * @Description 查询店长门下的司机信息接口
 * @author xukunyuan
 * @date 2020-04-26 19:54
 */
public class ManagerInformationInfo {
    /**
     * 司机名字
     */
    private String userName;
    /**
     * 司机编号
     */
    private String phone;
    /**
     * 店长编号
     */
    private String userId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ManagerInformationInfo{" +
                "userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
