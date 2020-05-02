package com.xzsd.app.clientGoods.entity;


import java.util.Date;
import java.util.List;

/**
 * @Description App端查询商品信息，评价，一级分类，二级分类接口
 * @author xukunyuan
 * @date 2020-04-22 9:35
 */
public class ClientGoodsInfo {
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 商品编号
     */
    private String goodsId;
    /**
     * 书名
     */
    private String goodsName;
    /**
     * 书号
     */
    private String isbn;
    /**
     * 商品介绍
     */
    private String goodsDescribe;
    /**
     * 在售价
     */
    private String goodsPrice;
    /**
     * 商品图片路径
     */
    private String goodsImagePath;
    /**
     * 商品评价星级
     */
    private String goodsEvaluateScore;
    /**
     * 商品评价星级
     */
    private Integer goodsEvaluateScoreInt;
    /**
     * 作者
     */
    private String Author;
    /**
     * 出版社
     */
    private String goodsPress;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 商品等级
     */
    private String evaluateScore;
    /**
     * 用户编号
     */
    private String userAcct;
    /**
     * 评价内容
     */
    private String evaluateContent;
    /**
     * 图片路径
     */
    private String imagePath;
    /**
     * 一级分类编号
     */
    private String classifyId;
    /**
     * 一级分类名称
     */
    private String classifyName;
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

    private List<ClientGoodsVO> goodsList;

    public List<ClientGoodsVO> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<ClientGoodsVO> goodsList) {
        this.goodsList = goodsList;
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

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGoodsDescribe() {
        return goodsDescribe;
    }

    public void setGoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsImagePath() {
        return goodsImagePath;
    }

    public void setGoodsImagePath(String goodsImagePath) {
        this.goodsImagePath = goodsImagePath;
    }

    public String getGoodsEvaluateScore() {
        return goodsEvaluateScore;
    }

    public void setGoodsEvaluateScore(String goodsEvaluateScore) {
        this.goodsEvaluateScore = goodsEvaluateScore;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getGoodsPress() {
        return goodsPress;
    }

    public void setGoodsPress(String goodsPress) {
        this.goodsPress = goodsPress;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getEvaluateScore() {
        return evaluateScore;
    }

    public void setEvaluateScore(String evaluateScore) {
        this.evaluateScore = evaluateScore;
    }

    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
    }

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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

    public Integer getGoodsEvaluateScoreInt() {
        return goodsEvaluateScoreInt;
    }

    public void setGoodsEvaluateScoreInt(Integer goodsEvaluateScoreInt) {
        this.goodsEvaluateScoreInt = goodsEvaluateScoreInt;
    }

    @Override
    public String toString() {
        return "ClientGoodsInfo{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", goodsId='" + goodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", isbn='" + isbn + '\'' +
                ", goodsDescribe='" + goodsDescribe + '\'' +
                ", goodsPrice='" + goodsPrice + '\'' +
                ", goodsImagePath='" + goodsImagePath + '\'' +
                ", goodsEvaluateScore='" + goodsEvaluateScore + '\'' +
                ", goodsEvaluateScoreInt=" + goodsEvaluateScoreInt +
                ", Author='" + Author + '\'' +
                ", goodsPress='" + goodsPress + '\'' +
                ", storeName='" + storeName + '\'' +
                ", evaluateScore='" + evaluateScore + '\'' +
                ", userAcct='" + userAcct + '\'' +
                ", evaluateContent='" + evaluateContent + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", classifyId='" + classifyId + '\'' +
                ", classifyName='" + classifyName + '\'' +
                ", isDelete=" + isDelete +
                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", updateUser='" + updateUser + '\'' +
                ", updateTime=" + updateTime +
                ", version='" + version + '\'' +
                ", goodsList=" + goodsList +
                '}';
    }
}
