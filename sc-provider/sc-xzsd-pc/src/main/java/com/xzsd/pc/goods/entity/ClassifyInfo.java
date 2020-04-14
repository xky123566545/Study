package com.xzsd.pc.goods.entity;

/**
 * @Description 商品分类下拉框查询类
 * @author xukunyuan
 * @date 2020-04-13 11:30
 */
public class ClassifyInfo {
    /**
     * 商品分类id
     */
    private String classifyId;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 商品分类名字
     */
    private String classifyName;

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId;
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

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    @Override
    public String toString() {
        return "ClassifyInfo{" +
                "classifyId='" + classifyId + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", classifyName='" + classifyName + '\'' +
                '}';
    }
}
