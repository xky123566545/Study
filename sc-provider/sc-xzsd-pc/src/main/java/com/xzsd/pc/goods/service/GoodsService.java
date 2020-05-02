package com.xzsd.pc.goods.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.goods.dao.GoodsDao;
import com.xzsd.pc.goods.entity.ClassifyInfo;
import com.xzsd.pc.goods.entity.GoodsClassifyList;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goods.entity.GoodsVO;
import com.xzsd.pc.goodsClassify.dao.GoodsClassifyDao;
import com.xzsd.pc.hotGoods.dao.HotGoodsDao;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @Description 商品增删查改上架下架
 * @author xukunyuan
 * @date 2020-03-27 11:47
 */

@Service
@Component
public class GoodsService {

    @Resource
    private GoodsDao goodsDao;

    @Resource
    private GoodsClassifyDao goodsClassifyDao;

    @Resource
    private HotGoodsDao hotGoodsDao;

    /** 
    * @Description:  新增商品
    * @Param:  goodsInfo
    * @return:  goodsInfo
    * @Author: xukunyuan
    * @Date: 2020/3/27 
    */
    public AppResponse saveGoods(GoodsInfo goodsInfo){
        //将商品是否存在設置为0 存在
        goodsInfo.setIsDelete(0);
        goodsInfo.setCreateUser(SecurityUtils.getCurrentUserId());
        goodsInfo.setVersion("0");
        String pageView = String.valueOf((int)((Math.random()*9+1)*1000));
        goodsInfo.setPageView(pageView);
        //将商品的二级分类添加入字典表，以便在分类删除时无法删除该编号
        if (goodsClassifyDao.addOneClassify(goodsInfo.getTwoClassifyId(),"2",goodsInfo.getGoodsId()) == 0){
            return AppResponse.bizError("将分类编号加入字典表中失败,请重试");
        }
        if (goodsDao.saveGoods(goodsInfo) == 0){
            return AppResponse.bizError("新增失败,请重试");
        }
        return AppResponse.success("新增成功");
    }

    /**
    * @Description: 查询商品信息
    * @Param:  goodsId
    * @return:
    * @Author: xukunyuan
    * @Date: 2020/3/27
    */
    public AppResponse getGoods(String goodsId){
        GoodsInfo goodsInfo = goodsDao.getGoodsByGoodsId(goodsId);
        if (goodsInfo == null){
           return AppResponse.bizError("查询失败，请重试");
        }
        return AppResponse.success("查询成功",goodsInfo);
    }

    /**
    * @Description: 分页查询商品信息
    * @Param:  goodsVO
    * @return:  AppResponse
    * @Author: xukunyuan
    * @Date: 2020/3/27
    */
    public AppResponse listGoods(GoodsVO goodsVO){
            PageHelper.startPage(goodsVO.getPageNum(),goodsVO.getPageSize());
            List<GoodsVO> goodsVOList = goodsDao.listGoods(goodsVO);
            //包装page对象
            PageInfo<GoodsVO> list = new PageInfo<>(goodsVOList);
            if (goodsVOList.size() ==0){
                AppResponse.bizError("查询失败，请重试");
            }
            return AppResponse.success("查询成功",list);
        }
    /**
    * @Description: 修改商品
    * @Param:  goodsInfo
    * @return:  AppResponse
    * @Author: xukunyuan
    * @Date: 2020/3/27
    */
    public AppResponse updateGoods(GoodsInfo goodsInfo){
        goodsInfo.setUpdateUser(SecurityUtils.getCurrentUserId());
        if (goodsDao.countGoodsId(goodsInfo) == 0){
            return AppResponse.bizError("账号不存在，请重新输入");
        }
        if (goodsDao.updateGoods(goodsInfo) == 0){
            return AppResponse.bizError("修改失败，请重试");
        }
        return  AppResponse.success("修改成功");
    }

    /**
    * @Description: 删除商品
    * @Param:  goodsInfo
    * @return:  AppResponse
    * @Author: xukunyuan
    * @Date: 2020/3/27
    */
    public AppResponse deleteGoods(String goodsId){
        List<String> listCode = Arrays.asList(goodsId.split(","));
        String userId = SecurityUtils.getCurrentUserId();
        if (goodsDao.deleteGoods(listCode,userId) == 0){
            return AppResponse.bizError("删除失败，请重试");
        }
        //删除商品时，将字典表中的商品的二级分类信息也删除了
        goodsClassifyDao.deleteDict(listCode);
        //删除商品时，若该商品存在热门商品中，将热门商品信息也删除
        goodsDao.deleteHotGoods(listCode,userId);
        //若该商品存在轮播图商品中，将轮播图信息也删除
        goodsDao.deletePicture(listCode,userId);
        return AppResponse.success("删除成功");
    }
    /**
    * @Description: 商品上架下架操作
    * @Param:  goodsInfo
    * @return:  AppResponse
    * @Author: xukunyuan
    * @Date: 2020/3/28
    */
    public AppResponse goodsSell(GoodsInfo goodsInfo){
        List<String> listCode = Arrays.asList(goodsInfo.getGoodsId().split(","));
        List<String> listVersion = Arrays.asList(goodsInfo.getVersion().split(","));
        String userId = SecurityUtils.getCurrentUserId();
        //判断是否存在卖完的商品，若存在，则上架失败
        List<String> listGoodsInventory = Arrays.asList(goodsInfo.getGoodsInventory().split(","));
        for (int i = 0; i < listGoodsInventory.size();i++){
            if (listGoodsInventory.get(i).equals("0")){
                return AppResponse.bizError("商品中存在已售罄的商品，无法上架，请重试");
            }
        }
        //提取出需求 商品上架还是下架 2为下架 1为上架
        System.out.println("-------"+goodsInfo.getGoodsStateId());
        if (goodsInfo.getGoodsStateId().equals("2")) {
            if (goodsDao.goodsSell(listCode,2,userId,listVersion) == 0) {
                return AppResponse.bizError("商品下架失败，请重试");
            }
            return AppResponse.success("商品下架成功");

        }
        else {
            if (goodsDao.goodsSell(listCode,1,userId,listVersion) == 0) {
                return AppResponse.bizError("商品上架失败，请重试");
            }
            return AppResponse.success("商品上架成功");
        }
    }
    /**
    * @Description: 查询商品分类下拉框
    * @Param:  goodsVo 分类编号
    * @return:  AppResponse
    * @Author: xukunyuan
    * @Date: 2020/4/13
    */
    public AppResponse listGoodsClassify(ClassifyInfo classifyInfo){
        List<ClassifyInfo> classifyInfoList = goodsDao.listGoodsClassify(classifyInfo);
        GoodsClassifyList goodsClassifyList = new GoodsClassifyList();
        goodsClassifyList.setGoodsClassifyList(classifyInfoList);
        if (null == goodsClassifyList){
            return AppResponse.bizError("查询失败，请重试");
        }
        return AppResponse.success("查询成功",goodsClassifyList);
    }

}
