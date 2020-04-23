package com.xzsd.pc.hotGoods.controller;

import com.xzsd.pc.hotGoods.entity.HotGoodsInfo;
import com.xzsd.pc.hotGoods.service.HotGoodsService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 热门商品位增删查改
 * @author xukunyuan
 * @date 2020-04-14 21:47
 */
@RestController
@RequestMapping("/hotGoods")
public class HotGoodsController {
    private static final Logger logger = LoggerFactory.getLogger(HotGoodsController.class);
    @Resource
    private HotGoodsService hotGoodsService;

    /** 
    * @Description:  新增热门商品接口
    * @Param:  hotGoodsInfo
    * @return:  AppResponse
    * @Author: xukunyuan
    * @Date: 2020/4/15 
    */
    @PostMapping("addHotGoods")
    public AppResponse addHotGoods(HotGoodsInfo hotGoodsInfo){
        try{
            return hotGoodsService.addHotGoods(hotGoodsInfo);
        }catch (Exception e){
            logger.error("新增失败,请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * @Description:  查询热门商品接口
     * @Param:  hotGoodsId
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/15
     */
    @PostMapping("getHotGoods")
    public AppResponse getHotGoods(String hotGoodsId){
        try{
            return hotGoodsService.getHotGoods(hotGoodsId);
        }catch (Exception e){
            logger.error("查询失败,请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * @Description:  分页查询热门商品接口
     * @Param:  hotGoodsInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/15
     */
    @PostMapping("listHotGoods")
    public AppResponse listHotGoods(HotGoodsInfo hotGoodsInfo){
        try{
            return hotGoodsService.listHotGoods(hotGoodsInfo);
        }catch (Exception e){
            logger.error("查询失败,请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * @Description:  修改热门商品接口
     * @Param:  hotGoodsInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/15
     */
    @PostMapping("updateHotGoods")
    public AppResponse updateHotGoods(HotGoodsInfo hotGoodsInfo){
        try{
            return hotGoodsService.updateHotGoods(hotGoodsInfo);
        }catch (Exception e){
            logger.error("修改失败,请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * @Description:  删除热门商品接口
     * @Param:  hotGoodsId
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/15
     */
    @PostMapping("deleteHotGoods")
    public AppResponse deleteHotGoods(String hotGoodsId){
        try{
            return hotGoodsService.deleteHotGoods(hotGoodsId);
        }catch (Exception e){
            logger.error("删除失败,请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /** 
    * @Description: 查询热门商品展示数量
    * @Param:  
    * @return:  Appresponse
    * @Author: xukunyuan
    * @Date: 2020/4/19 
    */
    @PostMapping("getHotGoodsShowNum")
    public AppResponse getHotGoodsNum(){
        try{
            return hotGoodsService.getHotGoodsNum();
        }catch (Exception e){
            logger.error("查询失败,请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * @Description: 修改热门商品展示数量
     * @Param:      hotGoodsInfo
     * @return:  Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/19
     */
    @PostMapping("updateHotGoodsShowNum")
    public AppResponse updateHotGoodsNum(HotGoodsInfo hotGoodsInfo){
        try{
            return hotGoodsService.updateHotGoodsNum(hotGoodsInfo);
        }catch (Exception e){
            logger.error("修改失败,请重试");
            System.out.println(e.toString());
            throw e;
        }
    }

}
