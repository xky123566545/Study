package com.xzsd.pc.store.controller;

import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.service.StoreService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 门店信息增删查改
 * @author xukunyuan
 * @date 2020-04-15 20:41
 */
@RestController
//@RequestMapping("/store")
public class StoreController {
    private static final Logger logger = LoggerFactory.getLogger(StoreController.class);

    @Resource
    private StoreService storeService;
    
    /**
     * @Description: 查询省市区下拉框
     * @Param:  areaId
     * @return:  Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/15
     */
    @PostMapping("/selectCombox/listArea")
    public AppResponse listArea(String areaId){
        try{
            return storeService.listArea(areaId);
        }catch (Exception e){
            logger.error("查询失败,请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /** 
    * @Description: 新增门店信息接口
    * @Param:  storeInfo
    * @return:  AppResponse
    * @Author: xukunyuan
    * @Date: 2020/4/16 
    */
    @PostMapping("/store/addStore")
    public AppResponse addStore(StoreInfo storeInfo){
        try{
            return storeService.addStore(storeInfo);
        }catch (Exception e){
            logger.error("新增失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * @Description: 查询门店信息接口
     * @Param:  storeId
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/16
     */
    @PostMapping("/store/getStore")
    public AppResponse getStore(String storeId){
        try{
            return storeService.getStore(storeId);
        }catch (Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * @Description: 分页查询门店信息接口
     * @Param:  storeInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/16
     */
    @PostMapping("/store/listStores")
    public AppResponse listStores(StoreInfo storeInfo){
        try{
            return storeService.listStores(storeInfo);
        }catch (Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * @Description: 修改门店信息接口
     * @Param:  storeInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/16
     */
    @PostMapping("/store/updateStore")
    public AppResponse updateStore(StoreInfo storeInfo){
        try{
            return storeService.updateStore(storeInfo);
        }catch (Exception e){
            logger.error("修改失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * @Description: 删除门店信息接口
     * @Param:  storeId
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/16
     */
    @PostMapping("/store/deleteStore")
    public AppResponse deleteStore(String storeId){
        try{
            return storeService.deleteStore(storeId);
        }catch (Exception e){
            logger.error("删除失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }


}
