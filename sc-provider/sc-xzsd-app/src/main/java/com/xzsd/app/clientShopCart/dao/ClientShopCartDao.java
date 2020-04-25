package com.xzsd.app.clientShopCart.dao;

import com.xzsd.app.clientShopCart.entity.ClientShopCartInfo;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Description 购物车增删查改
 * @author xukunyuan
 * @date 2020-04-23 10:37
 */
@Mapper
public interface ClientShopCartDao {
    /**
     * @Description: 新增购物车信息
     * @Param:   clientShopCartInfo
     * @return:  int
     * @Author: xukunyuan
     * @Date: 2020/4/23
     */
    int addShoppingCart(ClientShopCartInfo clientShopCartInfo);
    /**
     * @Description: 查询购物车信息
     * @Param:   clientShopCartInfo
     * @return:  List
     * @Author: xukunyuan
     * @Date: 2020/4/23
     */
    List<ClientShopCartInfo> listShoppingCarts(ClientShopCartInfo clientShopCartInfo);
    /**
     * @Description: 修改购物车信息
     * @Param:   clientShopCartInfo
     * @return:  int
     * @Author: xukunyuan
     * @Date: 2020/4/23
     */
    int updateShoppingCart(ClientShopCartInfo clientShopCartInfo);
    /**
     * @Description: 删除购物车信息
     * @Param:   shopCartId
     * @return:  int
     * @Author: xukunyuan
     * @Date: 2020/4/23
     */
    int deleteShoppingCart(@Param("listCode") List<String> listCode, @Param("userId") String userId);
}
