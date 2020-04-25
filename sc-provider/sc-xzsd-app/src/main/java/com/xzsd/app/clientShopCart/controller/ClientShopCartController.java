package com.xzsd.app.clientShopCart.controller;

import com.xzsd.app.clientShopCart.entity.ClientShopCartInfo;
import com.xzsd.app.clientShopCart.service.ClientShopCartService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 购物车增删查改
 * @author xukunyuan
 * @date 2020-04-23 10:37
 */
@RestController
@RequestMapping("/clientShopCart")
public class ClientShopCartController {
    private static final Logger logger = LoggerFactory.getLogger(ClientShopCartController.class);
    @Resource
    private ClientShopCartService clientShopCartService;

    /**
    * @Description: 新增购物车信息
    * @Param:   clientShopCartInfo
    * @return:  AppResponse
    * @Author: xukunyuan
    * @Date: 2020/4/23
    */
    @PostMapping("addShoppingCart")
    public AppResponse addShoppingCart(ClientShopCartInfo clientShopCartInfo){
        try{
            return clientShopCartService.addShoppingCart(clientShopCartInfo);
        }catch (Exception e){
            logger.error("新增失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * @Description: 查询购物车信息
     * @Param:   clientShopCartInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/23
     */
    @PostMapping("listShoppingCarts")
    public AppResponse listShoppingCarts(ClientShopCartInfo clientShopCartInfo){
        try{
            return clientShopCartService.listShoppingCarts(clientShopCartInfo);
        }catch (Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * @Description: 修改购物车信息
     * @Param:   clientShopCartInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/23
     */
    @PostMapping("updateShoppingCart")
    public AppResponse updateShoppingCart(ClientShopCartInfo clientShopCartInfo){
        try{
            return clientShopCartService.updateShoppingCart(clientShopCartInfo);
        }catch (Exception e){
            logger.error("修改失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * @Description: 删除购物车信息
     * @Param:   shopCartId
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/23
     */
    @PostMapping("deleteShoppingCart")
    public AppResponse deleteShoppingCart(String shopCartId){
        try{
            return clientShopCartService.deleteShoppingCart(shopCartId);
        }catch (Exception e){
            logger.error("删除失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }


}
