package com.xzsd.app.clientHome.dao;

import com.xzsd.app.clientHome.entity.ClientHomeInfo;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Description 查询首页轮播图，热门商品接口
 * @author xukunyuan
 * @date 2020-04-21 20:35
 */
@Mapper
public interface ClientHomeDao {
    /**
     * @Description:  查询首页轮播图接口
     * @Param:
     * @return:  ClientHomeInfo
     * @Author: xukunyuan
     * @Date: 2020/4/21
     */
    List<ClientHomeInfo> listRotationCharHome();
    /**
     * @Description:  查询热门商品接口
     * @Param:
     * @return:  ClientHomeInfo
     * @Author: xukunyuan
     * @Date: 2020/4/21
     */
    List<ClientHomeInfo> listHotGoods();
}
