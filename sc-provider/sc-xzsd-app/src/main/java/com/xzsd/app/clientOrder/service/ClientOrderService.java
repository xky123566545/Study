package com.xzsd.app.clientOrder.service;

import com.alibaba.fastjson.JSON;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.clientOrder.dao.ClientOrderDao;
import com.xzsd.app.clientOrder.entity.ClientOrderInfo;
import com.xzsd.app.clientOrder.entity.GoodList;
import com.xzsd.app.clientOrder.entity.OrderDetailInfo;
import com.xzsd.app.clientOrder.entity.OrderEva;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.AuthUtils;
import com.xzsd.app.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Description 订单增删查改
 * @author xukunyuan
 * @date 2020-04-23 21:28
 */
@Service
public class ClientOrderService {
    @Resource
    private ClientOrderDao clientOrderDao;

    /**
     * @Description:  新增订单接口
     * @Param:  clientOrderInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/24
     */
    public AppResponse addOrder(ClientOrderInfo clientOrderInfo) throws ScriptException {
        String userId = SecurityUtils.getCurrentUserId();
        clientOrderInfo.setCreateUser(userId);
        clientOrderInfo.setOrderId(StringUtil.getCommonCode(2));
        //将商品单价存入列表中
        List<String> listPrice = Arrays.asList(clientOrderInfo.getGoodsPrice().split(","));
        //将商品数量存入列表中
        List<String> listCnt = Arrays.asList(clientOrderInfo.getClientGoodsNum().split(","));
        //将商品编号存入列表中
        List<String> listGoodsId = Arrays.asList(clientOrderInfo.getGoodsId().split(","));
        String allPrice = null;
        String allCnt = null;
        int i = 0;
        for (i = 0;i < listPrice.size(); i++){
            //将运算式添加成一个新的字符串，总价格
            allPrice = allPrice + "+" + listPrice.get(i) + "*" + listCnt.get(i);
            //总数量
            allCnt = allCnt + "+" + listCnt.get(i) ;
        }
        ScriptEngine se = new ScriptEngineManager().getEngineByName("JavaScript");
        //根据计算式计算出总价格
        Double allCostPrice = (Double) se.eval(allPrice);
        //根据计算式计算出总数量
        Double allCostCnt = (Double) se.eval(allCnt);
        //将总数量double类型转换成int类型
        int allCostCntI = Integer.parseInt(new java.text.DecimalFormat("0").format(allCostCnt));
        //将总数量set进类中
        clientOrderInfo.setOrderAllGoodsCount(allCostCntI);
        //将double类型转换成String类型
        String allCostPriceS = String.valueOf(allCostPrice);
        //将总价格存入类中
        clientOrderInfo.setOrderAllCost(allCostPriceS);
        //将订单总信息存入订单表中
        if (clientOrderDao.addOrder(clientOrderInfo) == 0){
            return AppResponse.versionError("将数据新增入订单表中失败，请重试");
        }
        //将需要存入的数据存入list中，批量存入数据库中
        List<OrderDetailInfo> list = new ArrayList<>();
        String orderId = clientOrderInfo.getOrderId();
        //将cnt转换成int类型
        List<Integer> listCntInt = new ArrayList<>();
        for (int j = 0; j < listCnt.size(); j++){
            int temp = Integer.parseInt(listCnt.get(j));
            listCntInt.add(temp);
        }
        for (int j = 0; j < listGoodsId.size();j++){
            OrderDetailInfo t1 = new OrderDetailInfo();
            t1.setGoodsId(listGoodsId.get(j));
            t1.setGoodsPrice(listPrice.get(j));
            t1.setGoodsCnt(listCntInt.get(j));
            t1.setCreateUser(userId);
            t1.setCreateTime(new Date());
            t1.setIsDelete(0);
            t1.setOrderId(orderId);
            t1.setVersion("0");
            t1.setOrderStateId("0");
            list.add(t1);
        }
        //将订单分信息存入订单明细表中
        if (clientOrderDao.addOrderDetail(list) == 0){
            return AppResponse.versionError("将数据添加入订单明细表中失败，请重试");
        }
        //修改商品的库存的数量
        if (clientOrderDao.updateGoodsCount(list) == 0){
            return AppResponse.versionError("修改商品库存失败，请重试");
        }
        return AppResponse.success("新增成功");
    }

    /**
     * @Description:  列表查询订单详情
     * @Param:  clientOrderInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/24
     */
    public AppResponse listOrder(ClientOrderInfo clientOrderInfo) {
        PageHelper.startPage(clientOrderInfo.getPageNum(), clientOrderInfo.getPageSize());
        List<ClientOrderInfo> clientOrderInfoList = clientOrderDao.listOrder(clientOrderInfo);
        //包装page
        if (clientOrderInfoList.size() == 0) {
            return AppResponse.versionError("查询失败，请重试");
        }
        PageInfo<ClientOrderInfo> PageDate = new PageInfo<>(clientOrderInfoList);
        return AppResponse.success("查询成功", PageDate);
    }

    /**
     * @Description:  修改订单状态接口
     * @Param:  clientOrderInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/24
     */
    public AppResponse updateOrderState(ClientOrderInfo clientOrderInfo) {
        //根据商品编号，将商品信息查询出来
        List<OrderDetailInfo> list = clientOrderDao.getGoodsDetail(clientOrderInfo.getOrderId());
        //当订单状态变为1时，即订单已取消，修改商品库存量
        if (clientOrderInfo.getOrderStateId().equals("1")) {
            String userId = SecurityUtils.getCurrentUserId();
            if (clientOrderDao.updateGoodsCountS(list,userId) == 0) {
                return AppResponse.versionError("修改库存量失败，请重试");
            }
        }

        clientOrderInfo.setUpdateUser(SecurityUtils.getCurrentUserId());
        if (clientOrderDao.updateOrderState(clientOrderInfo) == 0){
            return AppResponse.versionError("修改失败，请重试");
        }
        return AppResponse.success("修改成功");
    }
    /**
     * @Description:  查询订单详情接口
     * @Param:  orderId
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/24
     */
    public AppResponse listOrderDeepen(String orderId) {
        ClientOrderInfo clientOrderInfo = clientOrderDao.listOrderDeepen(orderId);
        if (clientOrderInfo == null){
            return AppResponse.versionError("查询失败，请重试");
        }
        return AppResponse.success("查询成功",clientOrderInfo);
    }

    /**
     * @Description:  查询订单评价商品信息列表接口
     * @Param:  orderId
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/24
     */
    public AppResponse listGoodsForEvaluate(String orderId) {
        List<ClientOrderInfo> goodsLists = clientOrderDao.listGoodsForEvaluate(orderId);
        GoodList goodsList = new GoodList();
        goodsList.setGoodsList(goodsLists);
        if (goodsList == null){
            return AppResponse.versionError("查询失败，请重试");
        }
        return AppResponse.success("查询成功",goodsList);
    }

    /**
     * @Description:  新增订单评价商品信息列表接口
     * @Param:  JSONObject
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/24
     */
    public AppResponse addGoodsEvaluate(@RequestBody String evaluateOrder) {
        OrderEva orderEva = JSON.parseObject(evaluateOrder,OrderEva.class);
        orderEva.setUserId(SecurityUtils.getCurrentUserId());
        if(clientOrderDao.addGoodsEvaluate(orderEva) == 0){
            return AppResponse.versionError("新增失败，请重试");
        }
        return AppResponse.success("新增成功");
    }

}
