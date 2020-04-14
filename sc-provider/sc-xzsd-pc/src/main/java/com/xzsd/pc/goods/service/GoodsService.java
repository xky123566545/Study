package com.xzsd.pc.goods.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.goods.dao.GoodsDao;
import com.xzsd.pc.goods.entity.ClassifyInfo;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goods.entity.GoodsVO;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
        goodsInfo.setCreateUser("管理员");
        goodsInfo.setVersion("0");

        if (goodsDao.countGoodsId(goodsInfo) != 0){
            return AppResponse.bizError("商品id生成错误，请重新点击修改");
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
        GoodsVO goodsVO = goodsDao.getGoodsByGoodsId(goodsId);
        if (goodsVO == null){
           return AppResponse.bizError("该账号不存在，请重试");
        }
        return AppResponse.success("查询成功",goodsVO);
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
            if (list == null){
                AppResponse.bizError("输入账号不存在，请重新输入");
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
        goodsInfo.setUpdateUser("许坤源");
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
        String userId = "管理员";
        if (goodsDao.deleteGoods(listCode,userId) == 0){
            return AppResponse.bizError("删除失败，请重试");
        }
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
        String userId = "管理员";
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
        PageHelper.startPage(classifyInfo.getPageNum(),classifyInfo.getPageSize());
        List<ClassifyInfo> classifyInfoList = goodsDao.listGoodsClassify(classifyInfo);
        //包装page对象
        PageInfo<ClassifyInfo> goodsClassifyList = new PageInfo<>(classifyInfoList);
        if (null == goodsClassifyList){
            return AppResponse.bizError("查询失败，请重试");
        }
        return AppResponse.success("查询成功",goodsClassifyList);
    }

}
