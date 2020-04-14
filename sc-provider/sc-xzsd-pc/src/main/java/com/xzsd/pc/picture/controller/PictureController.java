package com.xzsd.pc.picture.controller;


import com.xzsd.pc.picture.entity.GoodsInfo;
import com.xzsd.pc.picture.entity.PictureInfo;
import com.xzsd.pc.picture.service.PictureService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 轮播图增删查改
 * @author xukunyuan
 * @date 2020-03-28 14:48
 */
@RestController
@RequestMapping("/slideshowHome")
public class PictureController {
    @Resource
    private PictureService pictureService;
    private static final Logger logger = LoggerFactory.getLogger(PictureController.class);
    /**
    * @Description: 轮播图新增 savePicture
    * @Param:  pictureInfo  轮播图信息
    * @return:  AppResponse
    * @Author: xukunyuan
    * @Date: 2020/3/28
    */
    @PostMapping("addSlideshowHome")
    public AppResponse addSlideshowHome(PictureInfo pictureInfo){
        try{
            return pictureService.savePicture(pictureInfo);

        }catch (Exception e){
            logger.error("新增失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /** 
    * @Description: 轮播图列表查询
    * @Param:  pictureInfo
    * @return:  Appresponse
    * @Author: xukunyuan
    * @Date: 2020/4/2 
    */
    @GetMapping("listSlideshowHome")
    public AppResponse listSlideshowHome(PictureInfo pictureInfo){
        try{
            return pictureService.listPicture(pictureInfo);
        }catch(Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }

    }
    /**
    * @Description: 删除轮播图
    * @Param:   slideshowId
    * @return:  AppResponse
    * @Author: xukunyuan
    * @Date: 2020/4/2
    */
    @PostMapping("deleteSlideshowHome")
    public AppResponse deletePicture(String slideshowId){
        try{
            return pictureService.deletePicture(slideshowId);
        }catch(Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }

    /** 
    * @Description:  修改首页轮播图状态
    * @Param:  pictureInfo
    * @return:  AppResponse
    * @Author: xukunyuan
    * @Date: 2020/4/13 
    */
    @PostMapping("updateSlideshowHomeState")
    public AppResponse updateSlideshowHomeState(PictureInfo pictureInfo){
        try{
            return pictureService.updateState(pictureInfo);
        }catch (Exception e){
            logger.error("修改失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
    * @Description: 查询商品接口
    * @Param:  goodsInfo
    * @return:  Appresponse
    * @Author: xukunyuan
    * @Date: 2020/4/13
    */
    @GetMapping("listGoods")
    public AppResponse listGoods(GoodsInfo goodsInfo){
        try{
            return pictureService.listGoods(goodsInfo);
        }catch (Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
}
