package com.xzsd.pc.goodsClassify.entity;

/**
 * @Description 二级分类商品类
 * @author xukunyuan
 * @date 2020-04-14 12:54
 */
public class GoodsClassifyVO {
    /**
     * 商品编号分类
     */
    private String classifyId;
    /**
     * 商品编号名称
     */
    private String classifyName;
    /**
     * 版本号
     */
    private String version;

    /**
     * 父节点
     */
    private String classifyParent;

    public String getClassifyParent() {
        return classifyParent;
    }

    public void setClassifyParent(String classifyParent) {
        this.classifyParent = classifyParent;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "GoodsClassifyVO{" +
                "classifyId='" + classifyId + '\'' +
                ", classifyName='" + classifyName + '\'' +
                ", version='" + version + '\'' +
                ", classifyParent='" + classifyParent + '\'' +
                '}';
    }
}
