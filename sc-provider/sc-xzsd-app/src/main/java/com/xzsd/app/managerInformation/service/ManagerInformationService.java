package com.xzsd.app.managerInformation.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.managerInformation.dao.ManagerInformationDao;
import com.xzsd.app.managerInformation.entity.ManagerInformationInfo;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 查询店长门下的司机信息接口
 * @author xukunyuan
 * @date 2020-04-26 19:54
 */
@Service
public class ManagerInformationService {
    @Resource
    private ManagerInformationDao managerInformationDao;
    /**
     * @Description: 查询店长门下司机信息 接口
     * @Param:
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/26
     */
    public AppResponse listManagerDrivers(){
        //获取店长id
        String userId = SecurityUtils.getCurrentUserId();
        List<ManagerInformationInfo> list = managerInformationDao.listManagerDrivers(userId);
        if (list.size() == 0){
            return AppResponse.versionError("查询失败，请重试");
        }
        //包装page对象
        PageInfo<ManagerInformationInfo> pageDate = new PageInfo<>(list);
        return AppResponse.success("查询成功",pageDate);
    }
}
