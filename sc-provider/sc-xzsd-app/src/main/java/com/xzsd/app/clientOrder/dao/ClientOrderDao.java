package com.xzsd.app.clientOrder.dao;

import com.xzsd.app.clientOrder.entity.ClientOrderInfo;
import com.xzsd.app.clientOrder.entity.OrderDetailInfo;
import com.xzsd.app.clientOrder.entity.OrderEva;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Description 订单增删查改
 * @author xukunyuan
 * @date 2020-04-23 21:28
 */
@Mapper
public interface ClientOrderDao {
    /**
     * @Description:  新增订单接口
     * @Param:  clientOrderInfo
     * @return:  int
     * @Author: xukunyuan
     * @Date: 2020/4/24
     */
    int addOrder(ClientOrderInfo clientOrderInfo);
    /**
     * @Description:  新增订单明细接口
     * @Param:  list
     * @return:  int
     * @Author: xukunyuan
     * @Date: 2020/4/24
     */
    int addOrderDetail(@Param("list") List<OrderDetailInfo> list);
    /**
     * @Description:  列表查询订单详情
     * @Param:  clientOrderInfo
     * @return:  List
     * @Author: xukunyuan
     * @Date: 2020/4/24
     */
    List<ClientOrderInfo> listOrder(ClientOrderInfo clientOrderInfo);
    /**
     * @Description:  修改订单状态接口
     * @Param:  clientOrderInfo
     * @return:  int
     * @Author: xukunyuan
     * @Date: 2020/4/24
     */
    int updateOrderState(ClientOrderInfo clientOrderInfo);
    /**
     * @Description:  查询订单详情接口
     * @Param:  orderId
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/24
     */
    ClientOrderInfo listOrderDeepen(@Param("orderId") String orderId);
    /**
     * @Description:  新增订单评价商品信息列表接口
     * @Param:  orderEva
     * @return:  int
     * @Author: xukunyuan
     * @Date: 2020/4/24
     */
    int addGoodsEvaluate(OrderEva orderEva);
    /**
     * @Description:  查询订单评价商品信息列表接口
     * @Param:  orderId
     * @return:  List
     * @Author: xukunyuan
     * @Date: 2020/4/24
     */
    List<ClientOrderInfo> listGoodsForEvaluate(@Param("orderId") String orderId,@Param("evaluateScore") String evaluateScore);
    /**
     * @Description:  新增时修改商品库存量
     * @Param:  list
     * @return:  int
     * @Author: xukunyuan
     * @Date: 2020/4/24
     */
    int updateGoodsCount(@Param("list") List<OrderDetailInfo> list);
    /**
     * @Description: 查询商品信息
     * @Param:  orderId
     * @return:  List
     * @Author: xukunyuan
     * @Date: 2020/4/26
     */
    List<OrderDetailInfo> getGoodsDetail(@Param("orderId") String orderId );

    /**
     * @Description:  修改订单状态时修改商品库存量
     * @Param:  list
     * @return:  int
     * @Author: xukunyuan
     * @Date: 2020/4/24
     */
    int updateGoodsCountS(@Param("list") List<OrderDetailInfo> list,@Param("userId") String userId);
    /**
    * @Description: 计算商品价格
    * @Param:
    * @return:  int
    * @Author: xukunyuan
    * @Date: 2020/4/27
    */
    int countGoodsPrice();
    /**
    * @Description: 修改商品星级
    * @Param:
    * @return:  int
    * @Author: xukunyuan
    * @Date: 2020/4/30
    */
    int addGoodsLevel(OrderEva orderEva);
}
