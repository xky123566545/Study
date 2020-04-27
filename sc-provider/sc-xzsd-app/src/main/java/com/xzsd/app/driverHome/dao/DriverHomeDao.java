package com.xzsd.app.driverHome.dao;

import com.xzsd.app.driverHome.entity.DriverHomeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description 查询司机负责的门店信息接口
 * @author xukunyuan
 * @date 2020-04-26 19:54
 */
@Mapper
public interface DriverHomeDao {
    /**
     * @Description: 查询司机负责的门店信息接口
     * @Param:  userId
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/26
     */
    List<DriverHomeInfo> listDriverStores(@Param("userId") String userId);
}
