package com.xzsd.pc.goodsClassify.controller;

import com.xzsd.pc.goodsClassify.entity.GoodsClassifyInfo;
import com.xzsd.pc.goodsClassify.service.GoodsClassifyService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Descriptions 商品分类增删查改
 * @author xukunyuan
 * @date 2020-04-14 10:28
 */
@RestController
@RequestMapping("/goodsClassify")
public class GoodsClassifyController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsClassifyController.class);

    @Resource
    private GoodsClassifyService goodsClassifyService;
    /** 
    * @Description:  新增商品分类
    * @Param:  goodsClassifyInfo
    * @return:  Appresponse
    * @Author: xukunyuan
    * @Date: 2020/4/14 
    */
    @PostMapping("addGoodsClassify")
    private AppResponse addGoodsClassify(GoodsClassifyInfo goodsClassifyInfo){
        try{
            return goodsClassifyService.addClassify(goodsClassifyInfo);
        }catch (Exception e){
            logger.error("新增失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    @GetMapping("getGoodsClassify")
    private AppResponse getGoodsClassify(String classifyId){
        try{
            return goodsClassifyService.getClassify(classifyId);
        }catch(Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /** 
    * @Description: 商品分类列表查询 
    * @Param:  goodsClassifyInfo
    * @return:  Appresponse
    * @Author: xukunyuan
    * @Date: 2020/4/14 
    */
    @GetMapping("listAllGoodsClassify")
    public AppResponse listAllGoodsClassify(GoodsClassifyInfo goodsClassifyInfo){
        try{
            return goodsClassifyService.listClassify(goodsClassifyInfo);
        }catch (Exception e){
            logger.error("查询失败,请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /** 
    * @Description:  修改商品分类
    * @Param:  goodsClassifyInfo
    * @return:  Appresponse
    * @Author: xukunyuan
    * @Date: 2020/4/14 
    */
    @PostMapping("updateGoodsClassify")
    public AppResponse updateGoodsClassify(GoodsClassifyInfo goodsClassifyInfo){
        try{
            return goodsClassifyService.updateClassify(goodsClassifyInfo);
        }catch (Exception e){
            logger.error("修改失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
    * @Description: 删除商品分类接口
    * @Param:  classifyId
    * @return:  Appresponse
    * @Author: xukunyuan
    * @Date: 2020/4/14
    */
    @PostMapping("deleteGoodsClassify")
    public AppResponse deleteGoodsClassify(String classifyId){
        try{
            return goodsClassifyService.deleteClassify(classifyId);
        }catch (Exception e){
            logger.error("删除失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }

}
