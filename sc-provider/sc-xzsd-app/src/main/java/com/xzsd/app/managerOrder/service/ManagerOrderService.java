package com.xzsd.app.managerOrder.service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.clientOrder.dao.ClientOrderDao;
import com.xzsd.app.clientOrder.entity.OrderDetailInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.app.managerOrder.dao.ManagerOrderDao;
import com.xzsd.app.managerOrder.entity.ManagerOrderInfo;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 店长订单查询，订单状态修改
 * @author xukunyuan
 * @date 2020-04-26 15:18
 */
@Service
public class ManagerOrderService {
    @Resource
    private ManagerOrderDao managerOrderDao;
    @Resource
    private ClientOrderDao clientOrderDao;
    /**
     * @Description: 查询店长订单列表详情
     * @Param:  managerOrderInfo
     * @return:  Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/26
     */
    public AppResponse listManagerOrders(ManagerOrderInfo managerOrderInfo){
        PageHelper.startPage(managerOrderInfo.getPageNum(),managerOrderInfo.getPageSize());
        String managerId = SecurityUtils.getCurrentUserId();
        managerOrderInfo.setManagerId(managerId);
        List<ManagerOrderInfo> managerOrderInfoList = managerOrderDao.listManagerOrders(managerOrderInfo);
        if (managerOrderInfoList.size() == 0){
            return AppResponse.versionError("查询失败，请重试");
        }
        PageInfo<ManagerOrderInfo> pageDate = new PageInfo<>(managerOrderInfoList);
        return AppResponse.success("查询成功",pageDate);
    }

    /**
     * @Description: 查询店长订单详情
     * @Param:  orderId
     * @return:  Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/26
     */
    public AppResponse listManagerOrderDeepen(String orderId){
        String managerId  = SecurityUtils.getCurrentUserId();
        ManagerOrderInfo managerOrderInfo = managerOrderDao.listManagerOrderDeepen(orderId,managerId);
        if (managerOrderInfo == null){
            return AppResponse.versionError("查询失败，请重试");
        }
        //查询门店名字和地址
        ManagerOrderInfo managerOrderInfo1 = managerOrderDao.getStore(orderId);
        if (managerOrderInfo1 == null){
            return AppResponse.versionError("查询门店名字和地址失败，请重试");
        }
        //将门店名字和地址加入到managerOrderInfo类中
        managerOrderInfo.setStoreName(managerOrderInfo1.getStoreName());
        managerOrderInfo.setAddress(managerOrderInfo1.getAddress());
        return AppResponse.success("查询成功",managerOrderInfo);
    }

    /**
     * @Description: 修改店长订单状态接口
     * @Param:  managerOrderInfo
     * @return:  Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/26
     */
    public AppResponse updateManagerOrderState(ManagerOrderInfo managerOrderInfo){
        //当订单取消时，修改库存量
        List<OrderDetailInfo> list = clientOrderDao.getGoodsDetail(managerOrderInfo.getOrderId());
        //当订单状态变为1时，即订单已取消，修改商品库存量
        String userId = SecurityUtils.getCurrentUserId();
        if (managerOrderInfo.getOrderStateId().equals("1")) {
            if (clientOrderDao.updateGoodsCountS(list,userId) == 0) {
                return AppResponse.versionError("修改库存量失败，请重试");
            }
        }
        //修改订单状态
        managerOrderInfo.setUserId(userId);
        if (managerOrderDao.updateManagerOrderState(managerOrderInfo) == 0){
            return AppResponse.versionError("修改订单状态失败，请重试");
        }
        return AppResponse.success("修改成功");
    }

}
