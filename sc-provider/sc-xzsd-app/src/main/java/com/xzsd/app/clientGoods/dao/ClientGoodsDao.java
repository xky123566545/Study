package com.xzsd.app.clientGoods.dao;

import com.xzsd.app.clientGoods.entity.ClientGoodsInfo;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Description App端查询商品信息，评价，一级分类，二级分类接口实体类
 * @author xukunyuan
 * @date 2020-04-22 9:35
 */
@Mapper
public interface ClientGoodsDao {
    /**
     * @Description: 查询商品信息详情接口
     * @Param:  goodsId
     * @return:  ClientGoodsInfo
     * @Author: xukunyuan
     * @Date: 2020/4/22
     */
    ClientGoodsInfo getGoods(String goodsId);
    /**
     * @Description: 查询商品评价列表接口
     * @Param:  clientGoodsInfo
     * @return:  List
     * @Author: xukunyuan
     * @Date: 2020/4/22
     */
    List<ClientGoodsInfo> listGoodsEvaluates(ClientGoodsInfo clientGoodsInfo);
    /**
     * @Description: 查询一级商品分类列接口
     * @Param:
     * @return:  List
     * @Author: xukunyuan
     * @Date: 2020/4/22
     */
    List<ClientGoodsInfo> listOneGoodsClassify();
    /**
     * @Description: 查询二级商品分类列接口
     * @Param:    listGetClassGoods
     * @return:  List
     * @Author: xukunyuan
     * @Date: 2020/4/22
     */
    List<ClientGoodsInfo> listGetClassGoods(ClientGoodsInfo clientGoodsInfo);
}
