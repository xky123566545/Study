package com.xzsd.pc.goodsClassify.dao;

import com.xzsd.pc.goodsClassify.entity.GoodsClassifyInfo;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Descriptions 商品分类增删查改
 * @author xukunyuan
 * @date 2020-04-14 10:28
 */
@Mapper
public interface GoodsClassifyDao {
    /**
    * @Description: 计算分类名称数量
    * @Param:  goodsClassifyInfo
    * @return:  int
    * @Author: xukunyuan
    * @Date: 2020/4/14
    */
    int countClassifyName(GoodsClassifyInfo goodsClassifyInfo);
    /**
     * @Description: 计算分类id数量
     * @Param:  goodsClassifyInfo
     * @return:  int
     * @Author: xukunyuan
     * @Date: 2020/4/14
     */
    int countClassifyId(String classifyId);
    /**
     * @Description: 新增商品分类
     * @Param:  goodsClassifyInfo
     * @return:  int
     * @Author: xukunyuan
     * @Date: 2020/4/14
     */
    int addClassify(GoodsClassifyInfo goodsClassifyInfo);
    /**
    * @Description: 查询商品分类
    * @Param:  classifyId
    * @return:  goodsClassifyInfo
    * @Author: xukunyuan
    * @Date: 2020/4/14
    */
    GoodsClassifyInfo getClassify(String classifyId);
    /**
    * @Description: 列表查询一级分类信息
    * @Param:  goodsClassifyInfo
    * @return:  PageInfo
    * @Author: xukunyuan
    * @Date: 2020/4/14
    */
   List<GoodsClassifyInfo> getListClassify(GoodsClassifyInfo goodsClassifyInfo);
   /**
   * @Description: 修改商品分类信息
   * @Param:  goodsClassifyInfo
   * @return:  int
   * @Author: xukunyuan
   * @Date: 2020/4/14
   */
   int updateClassify(GoodsClassifyInfo goodsClassifyInfo);
   /**
   * @Description: 删除分类信息
   * @Param:   listCode
    * @Param:   userId
   * @return:  int
   * @Author: xukunyuan
   * @Date: 2020/4/14
   */
   int deleteClassify(List<String> listCode, String userId);
}
