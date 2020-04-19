package com.xzsd.pc.driver.service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.driver.dao.DriverDao;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.store.dao.StoreDao;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import com.xzsd.pc.util.PasswordUtils;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 司机信息增删查改
 * @author xukunyuan
 * @date 2020-04-17 10:33
 */
@Service
public class DriverServer {

    @Resource
    private DriverDao driverDao;
    @Resource
    private UserDao userDao;
    @Resource
    private StoreDao storeDao;
    /**
     * @Description:  新增司机信息
     * @Param:  driverInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/17
     */
    public AppResponse addDriver(DriverInfo driverInfo){
        driverInfo.setDriverId(StringUtil.getCommonCode(2));
        driverInfo.setCreateUser(SecurityUtils.getCurrentUserId());
        //密码加密
        driverInfo.setUserPassword(PasswordUtils.generatePassword(driverInfo.getUserPassword()));
        //判断账号是否存在
        if (userDao.countUserAcct(driverInfo.getUserAcct()) != 0){
            return AppResponse.versionError("用户账号已存在,请重新输入");
        }
        //新增司机
        if (driverDao.addDriver(driverInfo) == 0){
            return AppResponse.versionError("新增失败，请重试");
        }
        return AppResponse.success("新增成功");

    }
    /**
     * @Description:  查询司机信息
     * @Param:  driverId
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/17
     */
    public AppResponse getDriver(String driverId){
        DriverInfo driverInfo = driverDao.getDriver(driverId);
        if (driverInfo == null){
            return AppResponse.versionError("查询失败,请重试");
        }
        //获取省级编号名字 先调用store中的getArea获取名字，返回方式为对象，将名字获取出来設置到driverInfo中
        driverInfo.setProvinceName(storeDao.getArea(driverInfo.getProvinceId()).getAreaName());
        //获取市级编号
        driverInfo.setCityName(storeDao.getArea(driverInfo.getCityId()).getAreaName());
        //获取区级编号
        driverInfo.setAreaName(storeDao.getArea(driverInfo.getAreaId()).getAreaName());

        return AppResponse.success("查询成功",driverInfo);
    }
    /**
     * @Description:  列表查询司机信息
     * @Param:  driverInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/17
     */
    public AppResponse listDrivers(DriverInfo driverInfo){
        PageHelper.startPage(driverInfo.getPageNum(),driverInfo.getPageSize());
        //如果登录角色为2  即店长登录，店长可以查询该区域司机信息，即负责其门店的司机信息
        if (driverInfo.getRole().equals("2"))
        {
            //获取当前登录店长编号
           driverInfo.setUserId(AuthUtils.getCurrentUserId());
            List<DriverInfo> driverInfoList = driverDao.listDriversStore(driverInfo);
            PageInfo<DriverInfo> list = new PageInfo<>(driverInfoList);
            if (driverInfoList.size() == 0){
                return AppResponse.versionError("查询失败,请重试");
            }
            return AppResponse.success("查询成功",list);
        }
        //管理员查询权限，查看所有司机的信息
        else{
            List<DriverInfo> driverInfoList = driverDao.listDriversAdmin(driverInfo);
            PageInfo<DriverInfo> list = new PageInfo<>(driverInfoList);
            if (driverInfoList.size() == 0){
                return AppResponse.versionError("查询失败,请重试");
            }
            return AppResponse.success("查询成功",list);
        }
    }
    /**
     * @Description:  修改司机信息
     * @Param:  driverInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/17
     */
    public AppResponse updateDriver(DriverInfo driverInfo){
        driverInfo.setUpdateUser(SecurityUtils.getCurrentUserId());
        if (driverDao.updateDriver(driverInfo) == 0){
            return AppResponse.versionError("修改失败,请重试");
        }
        return AppResponse.success("修改成功");
    }
    /**
     * @Description:  删除司机信息
     * @Param:  driverId
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/17
     */
    public AppResponse deleteDriver(String driverId){
        List<String> listCode = Arrays.asList(driverId.split(","));
        String userId = SecurityUtils.getCurrentUserId();
        if (driverDao.deleteDriver(listCode,userId) == 0){
            return AppResponse.versionError("删除失败，请重试");
        }
        return AppResponse.success("删除成功");
    }
}
