package com.xzsd.pc.goodsClassify.entity;

import java.util.Date;
import java.util.List;

/**
 * @Description 商品分类实体类
 * @author xukunyuan
 * @date 2020-04-14 9:25
 */
public class GoodsClassifyInfo {
    /**
     * 商品编号分类
     */
    private String classifyId;
    /**
     * 商品编号名称
     */
    private String classifyName;
    /**
     * 商品分类备注
     */
    private String classifyComment;
    /**
     * 父级编号(一级分类传0，二级传一级分类id)
     */
    private String classifyParent;
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
    private List<GoodsClassifyVO> twoClassifyList;

    public List<GoodsClassifyVO> getTwoClassifyList() {
        return twoClassifyList;
    }

    public void setTwoClassifyList(List<GoodsClassifyVO> twoClassifyList) {
        this.twoClassifyList = twoClassifyList;
    }

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public String getClassifyComment() {
        return classifyComment;
    }

    public void setClassifyComment(String classifyComment) {
        this.classifyComment = classifyComment;
    }

    public String getClassifyParent() {
        return classifyParent;
    }

    public void setClassifyParent(String classifyParent) {
        this.classifyParent = classifyParent;
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
        return "GoodsClassifyInfo{" +
                ", classifyId='" + classifyId + '\'' +
                ", classifyName='" + classifyName + '\'' +
                ", classifyComment='" + classifyComment + '\'' +
                ", classifyParent='" + classifyParent + '\'' +
                ", isDelete=" + isDelete +
                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", updateUser='" + updateUser + '\'' +
                ", updateTime=" + updateTime +
                ", version='" + version + '\'' +
                '}';
    }
}
