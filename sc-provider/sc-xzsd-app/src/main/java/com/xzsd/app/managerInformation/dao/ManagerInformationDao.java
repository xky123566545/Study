package com.xzsd.app.managerInformation.dao;

import com.xzsd.app.managerInformation.entity.ManagerInformationInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description 查询店长门下的司机信息接口
 * @author xukunyuan
 * @date 2020-04-26 19:54
 */
@Mapper
public interface ManagerInformationDao {
    /**
     * @Description: 查询店长门下司机信息 接口
     * @Param:
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/26
     */
    List<ManagerInformationInfo> listManagerDrivers(@Param("userId") String userId);
}
