package com.xzsd.pc.goods.controller;


import com.xzsd.pc.goods.entity.ClassifyInfo;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goods.entity.GoodsVO;
import com.xzsd.pc.goods.service.GoodsService;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 商品管理增删查改上架下架
 * @author xukunyuan
 * @date 2020-03-27 10:28
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Resource
    private GoodsService goodsService;
    /**
    * @Description:新增商品
    * @Param:  goodsInfo
    * @return:  AppResponse
    * @Author: xukunyuan
    * @Date: 2020/3/27
    */
    @PostMapping("addGoods")
    public AppResponse addGoods(GoodsInfo goodsInfo){
        try{
            //随机生成goodsId
            goodsInfo.setGoodsId(StringUtil.getCommonCode(2));
            AppResponse appResponse = goodsService.saveGoods(goodsInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("商品新增失败,请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /** 
    * @Description: 查询商品信息 
    * @Param:  goodsId
    * @return:  
    * @Author: xukunyuan
    * @Date: 2020/3/27 
    */
    @GetMapping("getGoods")
    public AppResponse getGoods(String goodsId){
        try{
            AppResponse appResponse = goodsService.getGoods(goodsId);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /** 
    * @Description: 查询商品信息（分页） 
    * @Param:  goodsVO
    * @return:  AppResponse
    * @Author: xukunyuan
    * @Date: 2020/3/27 
    */
    @GetMapping("listGoods")
    public AppResponse listGoods(GoodsVO goodsVO){
        try{
            return goodsService.listGoods(goodsVO);
        }catch (Exception e){
            logger.error("查询失败,请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
    * @Description: 修改商品
    * @Param:  goodsInfo
    * @return: AppResponse
    * @Author: xukunyuan
    * @Date: 2020/3/27
    */
    @PostMapping("updateGoods")
    public AppResponse updateGoods(GoodsInfo goodsInfo){
        try{
            return goodsService.updateGoods(goodsInfo);
        }catch (Exception e){
            logger.error("修改失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
    * @Description: 删除商品
    * @Param:  goodsId
    * @return:  AppResponse
    * @Author: xukunyuan
    * @Date: 2020/3/27
    */
    @PostMapping("deleteGoods")
    public AppResponse deleteGoods(String goodsId){
        try{
            return goodsService.deleteGoods(goodsId);
        } catch (Exception e){
            logger.error("删除失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /** 
    * @Description: 商品上架下架
    * @Param:  goodsInfo
    * @return:  Appresponse
    * @Author: xukunyuan
    * @Date: 2020/3/28 
    */
    @PostMapping("updateGoodsShelfState")
    public AppResponse updateGoodsShelfState(GoodsInfo goodsInfo){
        try{
            return goodsService.goodsSell(goodsInfo);
        } catch(Exception e){
            logger.error("上架下架失败请重试");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * @Description: 查询商品分类下拉框
     * @Param:  classifyId 分类编号
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/13
     */
    @GetMapping("listGoodsClassify")
    public AppResponse listGoodsClassify(ClassifyInfo classifyInfo){
        try{
            return goodsService.listGoodsClassify(classifyInfo);
        }
        catch (Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }


}
