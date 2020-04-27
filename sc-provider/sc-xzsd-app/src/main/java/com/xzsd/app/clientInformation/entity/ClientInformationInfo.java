package com.xzsd.app.clientInformation.entity;
/**
 * @Description 修改邀请码实体类
 * @author xukunyuan
 * @date 2020-04-26 14:22
 */
public class ClientInformationInfo {
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 门店邀请码
     */
    private String inviteCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    @Override
    public String toString() {
        return "ClientInformationInfo{" +
                "userId='" + userId + '\'' +
                ", inviteCode='" + inviteCode + '\'' +
                '}';
    }
}
