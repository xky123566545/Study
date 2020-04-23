package com.xzsd.pc.hotGoods.dao;

import com.xzsd.pc.hotGoods.entity.HotGoodsInfo;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Description 热门商品位增删查改
 * @author xukunyuan
 * @date 2020-04-14 21:47
 */
@Mapper
public interface HotGoodsDao {
    /**
    * @Description: 查询热门序号是否已存在
    * @Param:  hotGoodsNum
    * @return:  int
    * @Author: xukunyuan
    * @Date: 2020/4/15
    */
    int countHotGoodsNum(int hotGoodsNum);
    /**
     * @Description: 查询热门序号是否已存在(不包括当前行的情况 用于修改时判断)
     * @Param:  hotGoodsNum
     * @return:  int
     * @Author: xukunyuan
     * @Date: 2020/4/15
     */
    int countHotGoodsNum1(@Param("hotGoodsNum") int hotGoodsNum,@Param("hotGoodsId") String hotGoodsId);
    /**
     * @Description: 计算商品id数量
     * @Param:  goodsInfo
     * @return:
     * @Author: xukunyuan
     * @Date: 2020/3/27
     */
    int countGoodsId(String goodsId);
    /**
     * @Description: 查询热门序号是否已存在
     * @Param:  hotGoodsNum
     * @return:  int
     * @Author: xukunyuan
     * @Date: 2020/4/15
     */
    int addHotGoods(HotGoodsInfo hotGoodsInfo);
    /**
     * @Description: 计算热门商品编号数量
     * @Param:  goodsInfo
     * @return:
     * @Author: xukunyuan
     * @Date: 2020/3/27
     */
    int countHotGoodsId(String hotGoodsId);
    /**
     * @Description:  查询热门商品接口
     * @Param:  hotGoodsId
     * @return:  HotGoodsInfo
     * @Author: xukunyuan
     * @Date: 2020/4/15
     */
    HotGoodsInfo getHotGoods(String hotGoodsId);
    /**
     * @Description:  分页查询热门商品接口
     * @Param:  hotGoodsInfo
     * @return:  List
     * @Author: xukunyuan
     * @Date: 2020/4/15
     */
    List<HotGoodsInfo> listHotGoods(HotGoodsInfo hotGoodsInfo);
    /**
     * @Description:  修改热门商品接口
     * @Param:  hotGoodsInfo
     * @return:  int
     * @Author: xukunyuan
     * @Date: 2020/4/15
     */
    int updateHotGoods(HotGoodsInfo hotGoodsInfo);
    /**
     * @Description:  删除热门商品接口
     * @Param:  hotGoodsId
     * @Param:  userId
     * @return:  int
     * @Author: xukunyuan
     * @Date: 2020/4/15
     */
    int deleteHotGoods(@Param("listCode") List<String> listCode,@Param("userId") String userId);
    /**
     * @Description: 查询热门商品展示数量
     * @Param:
     * @return:  Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/19
     */
    HotGoodsInfo getHotGoodsNum();
    /**
     * @Description: 修改热门商品展示数量
     * @Param:      hotGoodsInfo
     * @return:  int
     * @Author: xukunyuan
     * @Date: 2020/4/19
     */
    int updateHotGoodsNum(HotGoodsInfo hotGoodsInfo);
}
