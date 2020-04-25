package com.xzsd.app.clientOrder.entity;

import java.util.List;

/**
 * @Description 订单评价实体类
 * @author xukunyuan
 * @date 2020-04-25 21:41
 */
public class OrderEva {
    /**
     *  订单编号
     */
    private String orderId;
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 商品评价列表
     */
    private List<EvaluateList> evaluateList;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "OrderEva{" +
                "orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                ", evaluateList=" + evaluateList +
                '}';
    }

    public static class EvaluateList{
        /**
         * 商品编号
         */
        private String goodsId;
        /**
         * 评价内容
         */
        private String evaluateContent;
        /**
         * 评价等级
         */
        private String evaluateScore;

        public String getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }

        public String getEvaluateContent() {
            return evaluateContent;
        }

        public void setEvaluateContent(String evaluateContent) {
            this.evaluateContent = evaluateContent;
        }

        public String getEvaluateScore() {
            return evaluateScore;
        }

        public void setEvaluateScore(String evaluateScore) {
            this.evaluateScore = evaluateScore;
        }

        @Override
        public String toString() {
            return "EvaluateList{" +
                    "goodsId='" + goodsId + '\'' +
                    ", evaluateContent='" + evaluateContent + '\'' +
                    ", evaluateScore='" + evaluateScore + '\'' +
                    '}';
        }
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<EvaluateList> getEvaluateList() {
        return evaluateList;
    }

    public void setEvaluateList(List<EvaluateList> evaluateList) {
        this.evaluateList = evaluateList;
    }

}
