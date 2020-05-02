package com.xzsd.pc.order.dao;

import com.xzsd.pc.order.entity.OrderInfo;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {
    /**
    * @Description: 查询订单详情
    * @Param:  orderId
    * @return:  List<orderId>
    * @Author: xukunyuan
    * @Date: 2020/4/14
    */
    List<OrderInfo> getListOrder(@Param("orderId") String orderId);
    /**
     * @Description: 分页查询列表接口
     * @Param:  orderInfo
     * @return:  List
     * @Author: xukunyuan
     * @Date: 2020/4/14
     */
    List<OrderInfo> listOrders(OrderInfo orderInfo);
    /**
    * @Description:  修改订单状态接口
    * @Param:  listCode
     * @Param:  listVersion
     * @Param:  orderStateId
     * @Param:  userId
    * @return:  int
    * @Author: xukunyuan
    * @Date: 2020/4/14
    */
    int updateOrderState(@Param("listCode") List<String> listCode,@Param("listVersion") List<String> listVersion,@Param("orderStateId") String orderStateId,@Param("userId") String userId);
    /**
     * @Description: 分页查询列表接口（店长权限）
     * @Param:  orderInfo
     * @return:  List
     * @Author: xukunyuan
     * @Date: 2020/4/14
     */
    List<OrderInfo> listOrdersStore(OrderInfo orderInfo);
}
