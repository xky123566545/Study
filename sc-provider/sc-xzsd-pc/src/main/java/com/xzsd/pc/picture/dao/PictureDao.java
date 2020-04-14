package com.xzsd.pc.picture.dao;

import com.xzsd.pc.picture.entity.GoodsInfo;
import com.xzsd.pc.picture.entity.PictureInfo;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Description 轮播图增删查改
 * @author xukunyuan
 * @date 2020-03-30 11:30
 */
@Mapper
public interface PictureDao {
    /**
    * @Description: 计算轮播图id数量
    * @Param:  pictureInfo
    * @return:  int
    * @Author: xukunyuan
    * @Date: 2020/3/30
    */
    int countPictureByPictureId(PictureInfo pictureInfo);
    /**
    * @Description: 轮播图新增
    * @Param:  pictureInfo
    * @return:  int
    * @Author: xukunyuan
    * @Date: 2020/3/30
    */
    int savePicture(PictureInfo pictureInfo);
    /**
    * @Description: 轮播图列表查询
    * @Param:  pictureInfo
    * @return:  List<pictureInfo>
    * @Author: xukunyuan
    * @Date: 2020/4/2
    */
    List<PictureInfo> listPicture(PictureInfo pictureInfo);
    /**
    * @Description: 轮播图删除
    * @Param:  pictureId
     * @Patam： userId
    * @return:  int
    * @Author: xukunyuan
    * @Date: 2020/4/2
    */
    int deletePicture(@Param("listCode") List<String> listCode, @Param("userId") String userId);
    /**
    * @Description: 修改轮播图状态
    * @Param:  listCode
     *  @Param: listVersion
     * @Param： userId
    * @return:  int
    * @Author: xukunyuan
    * @Date: 2020/4/13
    */
    int updateState(@Param("listCode") List<String> listCode, @Param("listVersion") List<String> listVersion, String userId, String slideshowStateId);
    /**
     * @Description: 查询商品接口
     * @Param:  goodsInfo
     * @return:  List
     * @Author: xukunyuan
     * @Date: 2020/4/13
     */
    List<GoodsInfo> listGoods(GoodsInfo goodsInfo);
}
