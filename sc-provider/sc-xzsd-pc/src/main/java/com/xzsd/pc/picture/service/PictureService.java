package com.xzsd.pc.picture.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.picture.dao.PictureDao;
import com.xzsd.pc.picture.entity.GoodsInfo;
import com.xzsd.pc.picture.entity.PictureInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 轮播图增删查改
 * @author xukunyuan
 * @date 2020-03-30 11:20
 */
@Service
public class PictureService {
    @Resource
    private PictureDao pictureDao;

    /**
    * @Description: 新增轮播图
    * @Param:  pictureInfo
    * @return:  Appresponse
    * @Author: xukunyuan
    * @Date: 2020/3/30
    */
    public AppResponse savePicture(PictureInfo pictureInfo){
        pictureInfo.setCreateUser(SecurityUtils.getCurrentUserId());
        //随机生成图片id
        pictureInfo.setSlideshowId(StringUtil.getCommonCode(2));
        if (pictureDao.savePicture(pictureInfo) == 0){
            return AppResponse.bizError("新增失败，请重试");
        }
        return AppResponse.success("新增成功");
    }
    /**
    * @Description: 轮播图列表查询
    * @Param:  pictureInfo
     * @return:AppResponse
    * @Author: xukunyuan
    * @Date: 2020/4/2
    */
    public AppResponse listPicture(PictureInfo pictureInfo){
        PageHelper.startPage(pictureInfo.getPageNum(),pictureInfo.getPageSize());
        List<PictureInfo> pictureInfoList = pictureDao.listPicture(pictureInfo);
        //包装page对象
        PageInfo<PictureInfo> list = new PageInfo(pictureInfoList);
        if (pictureInfoList.size() == 0){
            return AppResponse.bizError("查询失败，请重试");
        }
        return AppResponse.success("查询成功",list);
    }
    /**
    * @Description: 轮播图删除
    * @Param:  pictureId
    * @return:  Appresponse
    * @Author: xukunyuan
    * @Date: 2020/4/2
    */
    public AppResponse deletePicture(String pictureId){
        String userId = SecurityUtils.getCurrentUserId();
        List<String> listCode = Arrays.asList(pictureId.split(","));
        if (0 == pictureDao.deletePicture(listCode,userId)){
            return AppResponse.bizError("删除失败，请重试");
        }
        return AppResponse.success("删除成功");
    }
    /** 
    * @Description: 修改首页轮播图状态
    * @Param:  pictureInfo
    * @return:  AppResponse
    * @Author: xukunyuan
    * @Date: 2020/4/13 
    */
    public AppResponse updateState(PictureInfo pictureInfo){
        String userId = SecurityUtils.getCurrentUserId();
        List<String> listCode = Arrays.asList(pictureInfo.getSlideshowId().split(","));
        List<String> listVersion = Arrays.asList(pictureInfo.getVersion().split(","));
        //轮播图禁用
        if(pictureInfo.getSlideshowStateId().equals("0")) {
            if (0 == pictureDao.updateState(listCode, listVersion, userId,"0")) {
                return AppResponse.bizError("修改失败，请重试");
            }
        }
        //轮播图启用
        else{
            if (0 == pictureDao.updateState(listCode, listVersion, userId,"1")) {
                return AppResponse.bizError("修改失败，请重试");
            }
        }
        return AppResponse.success("修改成功");
    }
    /**
     * @Description: 查询商品接口
     * @Param:  goodsInfo
     * @return:  Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/13
     */
    public AppResponse listGoods(GoodsInfo goodsInfo){
        PageHelper.startPage(goodsInfo.getPageNum(),goodsInfo.getPageSize());
        List<GoodsInfo> goodsInfoPageInfo = pictureDao.listGoods(goodsInfo);
        PageInfo<GoodsInfo> list = new PageInfo<>(goodsInfoPageInfo);
        if(goodsInfoPageInfo == null){
            return AppResponse.bizError("查询失败，账号不存在，请重试");
        }
        return AppResponse.success("查询成功",list);
    }
}
