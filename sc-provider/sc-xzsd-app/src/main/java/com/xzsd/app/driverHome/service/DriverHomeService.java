package com.xzsd.app.driverHome.service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.driverHome.dao.DriverHomeDao;
import com.xzsd.app.driverHome.entity.DriverHomeInfo;
import com.github.pagehelper.PageInfo;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 查询司机负责的门店信息接口
 * @author xukunyuan
 * @date 2020-04-26 19:54
 */
@Service
public class DriverHomeService {
    @Resource
    private DriverHomeDao driverHomeDao;

    /**
     * @Description: 查询司机负责的门店信息接口
     * @Param:
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/26
     */
    public AppResponse listDriverStores(){
        String userId = SecurityUtils.getCurrentUserId();
        List<DriverHomeInfo> list = driverHomeDao.listDriverStores(userId);
        if (list.size() == 0){
            return AppResponse.versionError("查询失败，请重试");
        }
        PageInfo<DriverHomeInfo> pageDate = new PageInfo<>(list);
        return AppResponse.success("查询成功",pageDate);
    }
}
