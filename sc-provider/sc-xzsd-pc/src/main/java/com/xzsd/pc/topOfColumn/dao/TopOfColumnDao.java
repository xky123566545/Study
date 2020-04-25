package com.xzsd.pc.topOfColumn.dao;

import com.xzsd.pc.topOfColumn.entity.TopOfColumnInfo;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

/**
 * @Description 顶部栏接口
 * @author xukunyuan
 * @date 2020-04-20 9:49
 */
@Mapper
public interface TopOfColumnDao {
    /**
     * @Description:  顶部栏接口
     * @Param:
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/20
     */
    TopOfColumnInfo getTopOfColumn(@Param("userId") String userId);
}
