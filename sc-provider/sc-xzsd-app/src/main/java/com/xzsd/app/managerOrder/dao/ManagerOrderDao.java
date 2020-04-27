package com.xzsd.app.managerOrder.dao;

import com.xzsd.app.managerOrder.entity.ManagerOrderInfo;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Description 店长订单查询，订单状态修改
 * @author xukunyuan
 * @date 2020-04-26 15:18
 */
@Mapper
public interface ManagerOrderDao {
    /**
     * @Description: 查询店长订单列表详情
     * @Param:  managerOrderInfo
     * @return:  List
     * @Author: xukunyuan
     * @Date: 2020/4/26
     */
    List<ManagerOrderInfo> listManagerOrders(ManagerOrderInfo managerOrderInfo);
    /**
     * @Description: 查询店长订单详情
     * @Param:  orderId
     * @return:  Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/26
     */
    ManagerOrderInfo listManagerOrderDeepen(@Param("orderId") String orderId, @Param("managerId") String managerId);
    /**
    * @Description: 查询门店名字和地址
    * @Param:  orderId
    * @return:  managerOrderInfo
    * @Author: xukunyuan
    * @Date: 2020/4/26
    */
    ManagerOrderInfo getStore(@Param("orderId") String orderId);
    /**
     * @Description: 修改店长订单状态接口
     * @Param:  managerOrderInfo
     * @return:  Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/26
     */
    int updateManagerOrderState(ManagerOrderInfo managerOrderInfo);
}
