package com.xzsd.pc.driver.dao;

import com.xzsd.pc.driver.entity.DriverInfo;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Description 司机信息增删查改
 * @author xukunyuan
 * @date 2020-04-17 10:33
 */
@Mapper
public interface DriverDao {
    /**
     * @Description:  新增司机信息
     * @Param:  driverInfo
     * @return:  int
     * @Author: xukunyuan
     * @Date: 2020/4/17
     */
    int addDriver(DriverInfo driverInfo);
    /**
     * @Description:  查询司机信息
     * @Param:  driverId
     * @return:  driverInfo
     * @Author: xukunyuan
     * @Date: 2020/4/17
     */
    DriverInfo getDriver(@Param("driverId") String driverId);
    /**
     * @Description:  列表查询司机信息(店长权限)
     * @Param:  driverInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/17
     */
    List<DriverInfo> listDriversStore(DriverInfo driverInfo);
    /**
     * @Description:  列表查询司机信息(管理员权限)
     * @Param:  driverInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/17
     */
    List<DriverInfo> listDriversAdmin(DriverInfo driverInfo);
    /**
     * @Description:  修改司机信息
     * @Param:  driverInfo
     * @return:  int
     * @Author: xukunyuan
     * @Date: 2020/4/17
     */
    int updateDriver(DriverInfo driverInfo);
    /**
     * @Description:  删除司机信息
     * @Param:  driverId
     * @return:  int
     * @Author: xukunyuan
     * @Date: 2020/4/17
     */
    int deleteDriver(@Param("listCode") List<String> listCode,@Param("userId") String userId);
}
