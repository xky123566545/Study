package com.xzsd.pc.goods.dao;

import com.xzsd.pc.goods.entity.ClassifyInfo;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goods.entity.GoodsVO;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Description 商品增删查改上架下架
 * @author xukunyuan
 * @date 2020-03-27 12:26
 */
@Mapper
public interface GoodsDao {
    /**
    * @Description: 计算商品id数量
    * @Param:  goodsInfo
    * @return:
    * @Author: xukunyuan
    * @Date: 2020/3/27
    */
    int countGoodsId(GoodsInfo goodsInfo);
    /**
    * @Description: 新增商品
    * @Param:  goodsInfo 商品信息
    * @return:
    * @Author: xukunyuan
    * @Date: 2020/3/27
    */
    int saveGoods(GoodsInfo goodsInfo);
    /**
    * @Description: 查询商品信息
    * @Param:  goodsId
    * @return:  GoodsVO
    * @Author: xukunyuan
    * @Date: 2020/3/27
    */
    GoodsVO getGoodsByGoodsId(String goodsId);
    /**
    * @Description: 分页查询商品信息
    * @Param:  goodVOList
    * @return:
    * @Author: xukunyuan
    * @Date: 2020/3/27
    */
    List<GoodsVO> listGoods(GoodsVO goodsVO);
    /**
    * @Description:  修改商品信息
    * @Param: goodsInfo
    * @return:
    * @Author: xukunyuan
    * @Date: 2020/3/27
    */
    int updateGoods(GoodsInfo goodsInfo);
    /**
    * @Description: 删除商品信息
    * @Param:  listcode
     * @Param:  userId
    * @return:
    * @Author: xukunyuan
    * @Date: 2020/3/27
    */
    int deleteGoods(@Param("listCode") List<String> listCode, @Param("userId") String userId);
    /**
    * @Description: 商品上架下架操作 goodsIsSell为0则是商品批量下架 为1则是批量上架
    * @Param:  listCode
     * @Param:  goodsInfo
    * @return:
    * @Author: xukunyuan
    * @Date: 2020/3/28
    */
    int goodsSell(@Param("listCode") List<String> listCode, int goodsIsSell, String userId, List<String> listVersion);
    /** 
    * @Description: 查询商品分类详情接口
    * @Param:  goodsVO
    * @return:  
    * @Author: xukunyuan
    * @Date: 2020/4/13 
    */
    List<ClassifyInfo> listGoodsClassify(ClassifyInfo classifyInfo);
}
