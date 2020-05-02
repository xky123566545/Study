package com.xzsd.pc.goodsClassify.service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.goodsClassify.dao.GoodsClassifyDao;
import com.xzsd.pc.goodsClassify.entity.GoodsClassifyInfo;
import com.xzsd.pc.goodsClassify.entity.OneClassifyList;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 商品分类增删查改
 * @author xukunyuan
 * @date 2020-04-14 10:42
 */
@Service
public class GoodsClassifyService {
    @Resource
    private GoodsClassifyDao goodsClassifyDao;
    /**
     * @Description:  新增商品分类
     * @Param:  goodsClassifyInfo
     * @return:  Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/14
     */
    public AppResponse addClassify(GoodsClassifyInfo goodsClassifyInfo){
        String userId = SecurityUtils.getCurrentUserId();
        goodsClassifyInfo.setCreateUser(userId);
        goodsClassifyInfo.setClassifyId(StringUtil.getCommonCode(2));
        if (goodsClassifyDao.countClassifyName(goodsClassifyInfo) != 0){
            return AppResponse.bizError("分类名称已存在，请重新输入");
        }
        if(goodsClassifyDao.addClassify(goodsClassifyInfo) == 0){
            return AppResponse.bizError("新增失败，请重试");
        }
        //判断该分类是一级分类还是二级分类，若为二级分类则将其parent_id存入数据库中，该一级分类在删除时无法操作
        if(!goodsClassifyInfo.getClassifyParent().equals("0")){
                if (goodsClassifyDao.addOneClassify(goodsClassifyInfo.getClassifyParent(), "1",goodsClassifyInfo.getClassifyId()) == 0) {
                    return AppResponse.bizError("添加一级分类进字典表失败，请重试");
                }
        }
        return AppResponse.success("新增菜单成功");
    }
    /** 
    * @Description: 查询商品分类查询
    * @Param:  classifyId
    * @return:  AppResponse
    * @Author: xukunyuan
    * @Date: 2020/4/14 
    */
    public AppResponse getClassify(String classifyId){
        GoodsClassifyInfo goodsClassifyInfo = goodsClassifyDao.getClassify(classifyId);
        if(goodsClassifyDao.countClassifyId(classifyId) == 0)
        {
            return AppResponse.bizError("分类账号不存在，请重新输入");
        }
        if(goodsClassifyInfo == null){
            return AppResponse.bizError("查询失败，请重试");
        }
        return AppResponse.success("查询成功",goodsClassifyInfo);
    }
    /**
    * @Description: 商品分类列表查询
    * @Param:  goodsClassifyInfo
    * @return:  AppResponse
    * @Author: xukunyuan
    * @Date: 2020/4/14
    */
    public AppResponse listClassify(GoodsClassifyInfo goodsClassifyInfo){
        List<GoodsClassifyInfo> listMap = goodsClassifyDao.getListClassify(goodsClassifyInfo);
        OneClassifyList oneClassifyList = new OneClassifyList();
        oneClassifyList.setOneClassifyList(listMap);
        return AppResponse.success("查询成功",oneClassifyList);
    }
     /**
     * @Description:  修改商品分类
     * @Param:  goodsClassifyInfo
     * @return:  Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/14
     */
     public AppResponse updateClassify(GoodsClassifyInfo goodsClassifyInfo){
         goodsClassifyInfo.setUpdateUser(SecurityUtils.getCurrentUserId());
         String classifyId = goodsClassifyInfo.getClassifyId();
         if(goodsClassifyDao.countClassifyId(classifyId) == 0)
         {
             return AppResponse.bizError("分类账号不存在，请重新输入");
         }
         if(goodsClassifyDao.updateClassify(goodsClassifyInfo) == 0){
             return AppResponse.bizError("修改失败，请重试");
         }
         return AppResponse.success("修改成功");
     }
    /**
     * @Description: 删除商品分类接口
     * @Param:  classifyId
     * @return:  Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/14
     */
    public AppResponse deleteClassify(String classifyId){
        List<String> listCode = Arrays.asList(classifyId.split(","));
        String userId = SecurityUtils.getCurrentUserId();
        //判断该分类下是否存在二级分类，或商品
        if (goodsClassifyDao.countClassifyIdDelete(listCode) != 0){
            return AppResponse.bizError("选择的分类下存在二级分类或者商品，无法删除");
        }
        if (goodsClassifyDao.deleteClassify(listCode,userId) == 0){
            return AppResponse.bizError("删除失败，请重试");
        }
        //将字典表中classifyId删除
        goodsClassifyDao.deleteDict(listCode);
        return AppResponse.success("删除成功");
    }
}
