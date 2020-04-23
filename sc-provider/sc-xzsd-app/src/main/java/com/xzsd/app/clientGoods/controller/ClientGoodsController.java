package com.xzsd.app.clientGoods.controller;

import com.xzsd.app.clientGoods.entity.ClientGoodsInfo;
import com.xzsd.app.clientGoods.service.ClientGoodsService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description App端查询商品信息，评价，一级分类，二级分类接口
 * @author xukunyuan
 * @date 2020-04-22 9:35
 */
@RestController
@RequestMapping("/clientGoods")
public class ClientGoodsController {
    private static final Logger logger = LoggerFactory.getLogger(ClientGoodsController.class);

    @Resource
    private ClientGoodsService clientGoodsService;
    /**
     * @Description: 查询商品信息详情接口
     * @Param:  goodsId
     * @return:  Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/22
     */
    @PostMapping("getGoods")
    public AppResponse getGoods(String goodsId){
        try{
            return clientGoodsService.getGoods(goodsId);
        }catch (Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * @Description: 查询商品评价列表接口
     * @Param:  clientGoodsInfo
     * @return:  Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/22
     */
    @PostMapping("listGoodsEvaluates")
    public AppResponse listGoodsEvaluates(ClientGoodsInfo clientGoodsInfo){
        try{
            return clientGoodsService.listGoodsEvaluates(clientGoodsInfo);
        }catch (Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * @Description: 查询一级商品分类列接口
     * @Param:
     * @return:  Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/22
     */
    @PostMapping("listOneGoodsClassify")
    public AppResponse listOneGoodsClassify(){
        try{
            return clientGoodsService.listOneGoodsClassify();
        }catch (Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * @Description: 查询二级商品分类列接口
     * @Param:    listGetClassGoods
     * @return:  Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/22
     */
    @PostMapping("listGetClassGoods")
    public AppResponse listGetClassGoods(ClientGoodsInfo clientGoodsInfo){
        try{
            return clientGoodsService.listGetClassGoods(clientGoodsInfo);
        }catch (Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
}
