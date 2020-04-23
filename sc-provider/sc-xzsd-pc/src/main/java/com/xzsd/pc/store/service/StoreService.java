package com.xzsd.pc.store.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.store.dao.StoreDao;
import com.xzsd.pc.store.entity.AreaInfo;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import com.xzsd.pc.util.InviteCode;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 门店信息增删查改
 * @author xukunyuan
 * @date 2020-04-15 20:41
 */
@Service
public class StoreService {
    @Resource
    private StoreDao storeDao;
    @Resource
    private UserDao userDao;
    /**
     * @Description: 查询省市区下拉框
     * @Param:  areaId
     * @return:  Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/15
     */
    public AppResponse listArea(String areaId){
        List<AreaInfo> areaList = storeDao.listArea(areaId);
        if(areaList.size() == 0){
            return AppResponse.versionError("查询失败,请重试");
        }
        return AppResponse.success("查询成功",areaList);
    }
    /**
     * @Description: 新增门店信息接口
     * @Param:  storeInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/16
     */
    public AppResponse addStore(StoreInfo storeInfo){
       storeInfo.setCreateUser(SecurityUtils.getCurrentUserId());
       storeInfo.setStoreId(StringUtil.getCommonCode(2));
       storeInfo.setInviteCode(InviteCode.getItemID(5));
       if (storeDao.countUserId(storeInfo.getUserId()) == 0){
           return AppResponse.versionError("店长编号不存在,请重试");
       }
       if (storeDao.addStore(storeInfo) == 0){
           return AppResponse.versionError("新增失败,请重试");
       }
       return AppResponse.success("新增成功");
    }
    /**
     * @Description: 查询门店信息接口
     * @Param:  storeId
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/16
     */
    public AppResponse getStore(String storeId){
        if (storeDao.countStoreId(storeId) == 0){
            return AppResponse.versionError("店铺编号不存在，请重新输入");
        }
        StoreInfo storeInfo = storeDao.getStore(storeId);
        if (storeInfo == null)
        {
            return  AppResponse.versionError("查询失败，请重试");
        }
        //根据storeId获取省级名称
        storeInfo.setProvinceName(storeDao.getArea(storeInfo.getProvinceId()).getAreaName());
        //根据storeId获取市级名称
        storeInfo.setCityName(storeDao.getArea(storeInfo.getCityId()).getAreaName());
        //根据storeId获取区级名称
        storeInfo.setAreaName(storeDao.getArea(storeInfo.getAreaId()).getAreaName());
        return AppResponse.success("查询成功",storeInfo);
    }
    /**
     * @Description: 分页查询门店信息接口
     * @Param:  storeInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/16
     */
    public AppResponse listStores(StoreInfo storeInfo){
        PageHelper.startPage(storeInfo.getPageNum(),storeInfo.getPageSize());
        //店长只可以查看自己门店的信息
        if (storeInfo.getRole().equals("2")){
            //获取当前登陆人编号
            storeInfo.setUserId(AuthUtils.getCurrentUserId());
            List<StoreInfo> storeInfoList = storeDao.listStores(storeInfo);
            PageInfo<StoreInfo> list = new PageInfo<>(storeInfoList);
            if (storeInfoList.size() == 0){
                return AppResponse.versionError("查询失败，请重试");
            }
            return AppResponse.success("查询成功",list);
        }
        //管理员可以查看所有门店的信息
        else{
            List<StoreInfo> storeInfoList = storeDao.adminListStores(storeInfo);
            PageInfo<StoreInfo> list = new PageInfo<>(storeInfoList);
            if (storeInfoList.size() == 0){
                return AppResponse.versionError("查询失败，请重试");
            }
            return AppResponse.success("查询成功",list);
        }
    }
    /**
     * @Description: 修改门店信息接口
     * @Param:  storeInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/16
     */
    public AppResponse updateStore(StoreInfo storeInfo) {
        storeInfo.setUpdateUser(SecurityUtils.getCurrentUserId());
        if (storeDao.updateStore(storeInfo) == 0){
            return AppResponse.versionError("修改失败，请重试");
        }
        return AppResponse.success("修改成功");
    }
    /**
     * @Description: 删除门店信息接口
     * @Param:  storeId
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/16
     */
    public AppResponse deleteStore(String storeId){
        List<String> listCode = Arrays.asList(storeId.split(","));
        String userId = SecurityUtils.getCurrentUserId();
        if(storeDao.deleteStore(listCode,userId) == 0){
            return AppResponse.versionError("删除失败，请重试");
        }
        return AppResponse.success("删除成功");
    }


}
