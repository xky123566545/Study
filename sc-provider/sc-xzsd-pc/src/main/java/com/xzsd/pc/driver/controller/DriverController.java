package com.xzsd.pc.driver.controller;

import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.service.DriverServer;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 司机信息增删查改
 * @author xukunyuan
 * @date 2020-04-17 10:33
 */
@RestController
@RequestMapping("/driver")
public class DriverController {
    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);
    @Resource
    private DriverServer driverServer;
    /**
     * @Description:  新增司机信息
     * @Param:  driverInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/17
     */
    @PostMapping("addDriver")
    public AppResponse addDriver(DriverInfo driverInfo){
        try{
            return driverServer.addDriver(driverInfo);

        }catch (Exception e){
            logger.error("新增失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * @Description:  查询司机信息
     * @Param:  driverId
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/17
     */
    @GetMapping("getDriver")
    public AppResponse getDriver(String driverId){
        try{
            return driverServer.getDriver(driverId);
        }catch (Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * @Description:  列表查询司机信息
     * @Param:  driverInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/17
     */
    @GetMapping("listDrivers")
    public AppResponse listDrivers(DriverInfo driverInfo){
        try{
            return driverServer.listDrivers(driverInfo);
        }catch (Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * @Description:  修改司机信息
     * @Param:  driverInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/17
     */
    @PostMapping("updateDriver")
    public AppResponse updateDriver(DriverInfo driverInfo){
        try{
            return driverServer.updateDriver(driverInfo);
        }catch (Exception e){
            logger.error("修改失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * @Description:  删除司机信息
     * @Param:  driverId
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/17
     */
    @PostMapping("deleteDriver")
    public AppResponse deleteDriver(String driverId){
        try{
            return driverServer.deleteDriver(driverId);
        }catch (Exception e){
            logger.error("删除失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
}
