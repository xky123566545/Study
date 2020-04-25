package com.xzsd.pc.store.dao;

import com.xzsd.pc.store.entity.AreaInfo;
import com.xzsd.pc.store.entity.StoreInfo;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Description 门店信息增删查改
 * @author xukunyuan
 * @date 2020-04-15 20:41
 */
@Mapper
public interface StoreDao {
    /**
     * @Description: 查询省市区下拉框
     * @Param:  areaId
     * @return:  list
     * @Author: xukunyuan
     * @Date: 2020/4/15
     */
    List<AreaInfo> listArea(@Param("areaId") String areaId);
    /**
     * @Description: 查询省市区名字
     * @Param:  areaId
     * @return:  list
     * @Author: xukunyuan
     * @Date: 2020/4/15
     */
    AreaInfo getArea(@Param("areaId") String areaId);
    /**
     * @Description: 新增门店信息接口
     * @Param:  storeInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/16
     */
    int addStore(StoreInfo storeInfo);
    /**
     * @Description: 查询书店编号数量
     * @Param:  storeId
     * @return:  int
     * @Author: xukunyuan
     * @Date: 2020/4/16
     */
    int countStoreId(@Param("storeId") String storeId);
    /**
     * @Description: 查询书店信息
     * @Param:  storeId
     * @return:  storeInfo
     * @Author: xukunyuan
     * @Date: 2020/4/16
     */
    StoreInfo getStore(@Param("storeId") String storeId);
    /**
     * @Description: 分页查询门店信息接口（店长查询）
     * @Param:  storeInfo
     * @return:  List
     * @Author: xukunyuan
     * @Date: 2020/4/16
     */
    List<StoreInfo> listStores(StoreInfo storeInfo);
    /**
     * @Description: 分页查询门店信息接口（管理员查询）
     * @Param:  storeInfo
     * @return:  List
     * @Author: xukunyuan
     * @Date: 2020/4/16
     */
    List<StoreInfo> adminListStores(StoreInfo storeInfo);
    /**
     * @Description: 修改门店信息接口
     * @Param:  storeInfo
     * @return:  int
     * @Author: xukunyuan
     * @Date: 2020/4/16
     */
    int updateStore(StoreInfo storeInfo);
    /**
     * @Description: 删除门店信息接口
     * @Param:  listCode
     * @Param:  userId
     * @return:  int
     * @Author: xukunyuan
     * @Date: 2020/4/16
     */
    int deleteStore(@Param("listCode") List<String> listCode,@Param("userId") String userId);
    /**
     * 统计userId数量
     * @param userId 用户编码
     * @return
     */
    int countUserId(@Param("userId") String userId);


}
