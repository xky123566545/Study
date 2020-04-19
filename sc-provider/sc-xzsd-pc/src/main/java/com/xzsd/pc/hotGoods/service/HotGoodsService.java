package com.xzsd.pc.hotGoods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.hotGoods.dao.HotGoodsDao;
import com.xzsd.pc.hotGoods.entity.HotGoodsInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 热门商品位增删查改
 * @author xukunyuan
 * @date 2020-04-14 21:47
 */
@Service
public class HotGoodsService {
    @Resource
    private HotGoodsDao hotGoodsDao;

    /**
     * @Description:  新增热门商品接口
     * @Param:  hotGoodsInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/15
     */
    public AppResponse addHotGoods(HotGoodsInfo hotGoodsInfo) {
        hotGoodsInfo.setCreateUser(SecurityUtils.getCurrentUserId());
        hotGoodsInfo.setHotGoodsId(StringUtil.getCommonCode(2));
        if (hotGoodsDao.countHotGoodsNum(hotGoodsInfo.getHotGoodsNum()) != 0){
            return AppResponse.bizError("热门商品序号已存在，请重新输入");
        }
        if (hotGoodsDao.countGoodsId(hotGoodsInfo.getGoodsId()) == 0){
            return AppResponse.bizError("商品编号不存在，请重新输入");
        }
        if (hotGoodsDao.addHotGoods(hotGoodsInfo) == 0){
            return AppResponse.bizError("新增失败,请重试");
        }
        return AppResponse.success("新增成功");
    }
    /**
     * @Description:  查询热门商品接口
     * @Param:  hotGoodsId
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/15
     */
    public AppResponse getHotGoods(String hotGoodsId) {
        HotGoodsInfo hotGoodsInfo = hotGoodsDao.getHotGoods(hotGoodsId);
        if (hotGoodsDao.countHotGoodsId(hotGoodsId) == 0){
            return AppResponse.bizError("热门商品编号不存在，请重新输入");
        }
        if (hotGoodsInfo == null){
            return AppResponse.bizError("查询失败,请重试");
        }
        return AppResponse.success("查询成功",hotGoodsInfo);
    }
    /**
     * @Description:  分页查询热门商品接口
     * @Param:  hotGoodsInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/15
     */
    public AppResponse listHotGoods(HotGoodsInfo hotGoodsInfo){
        PageHelper.startPage(hotGoodsInfo.getPageNum(),hotGoodsInfo.getPageSize());
        //查询出热门商品展示数量
        hotGoodsInfo.setHotGoodsShowNum(hotGoodsDao.getHotGoodsNum().getHotGoodsShowNum());
        List<HotGoodsInfo> hotGoodsInfoList = hotGoodsDao.listHotGoods(hotGoodsInfo);
        PageInfo<HotGoodsInfo> list = new PageInfo<>(hotGoodsInfoList);

        if(hotGoodsInfoList.size() == 0){
            return AppResponse.bizError("查询失败，请重试");
        }
        return AppResponse.success("查询成功",list);
    }
    /**
     * @Description:  修改热门商品接口
     * @Param:  hotGoodsInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/15
     */
    public AppResponse updateHotGoods(HotGoodsInfo hotGoodsInfo){
        hotGoodsInfo.setUpdateUser(SecurityUtils.getCurrentUserId());
        //判断热门商品序号是否存在，防止出现相同序号的情况
        if (hotGoodsDao.countHotGoodsNum1(hotGoodsInfo.getHotGoodsNum(),hotGoodsInfo.getHotGoodsId()) != 0){
            return AppResponse.bizError("热门商品序号已存在，请重新输入");
        }
        if (hotGoodsDao.countGoodsId(hotGoodsInfo.getGoodsId()) == 0){
            return AppResponse.bizError("商品编号不存在，请重新输入");
        }
        if (hotGoodsDao.updateHotGoods(hotGoodsInfo) == 0){
            return AppResponse.bizError("修改失败,请重试");
        }
        return AppResponse.success("修改成功");
    }
    /**
     * @Description:  删除热门商品接口
     * @Param:  hotGoodsId
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/15
     */
    public AppResponse deleteHotGoods(String hotGoodsId){
        List<String> listCode = Arrays.asList(hotGoodsId.split(","));
        String userId = SecurityUtils.getCurrentUserId();
        if (hotGoodsDao.deleteHotGoods(listCode,userId) == 0){
            return AppResponse.bizError("删除失败,请重试");
        }
        return AppResponse.success("删除成功");
    }
    /**
     * @Description: 查询热门商品展示数量
     * @Param:
     * @return:  Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/19
     */
    public AppResponse getHotGoodsNum(){
        HotGoodsInfo hotGoodsInfo = hotGoodsDao.getHotGoodsNum();
        if (hotGoodsInfo == null)
        {
            return AppResponse.versionError("查询失败,请重试");
        }
        return AppResponse.success("查询成功",hotGoodsInfo);
    }
    /**
     * @Description: 修改热门商品展示数量
     * @Param:      hotGoodsInfo
     * @return:  Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/19
     */
    public AppResponse updateHotGoodsNum(HotGoodsInfo hotGoodsInfo){
        hotGoodsInfo.setUpdateUser(SecurityUtils.getCurrentUserId());
        if (hotGoodsDao.updateHotGoodsNum(hotGoodsInfo) == 0){
            return AppResponse.versionError("修改失败,请重试");
        }
        return AppResponse.success("修改成功");
    }
}
