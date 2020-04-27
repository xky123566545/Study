package com.xzsd.app.clientHome.service;

import com.xzsd.app.clientHome.dao.ClientHomeDao;
import com.xzsd.app.clientHome.entity.ClientHomeInfo;
import com.xzsd.app.clientHome.entity.SlideshowList;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 查询首页轮播图，热门商品接口
 * @author xukunyuan
 * @date 2020-04-21 20:35
 */
@Service
public class ClientHomeService {
    @Resource
    private ClientHomeDao clientHomeDao;

    /**
     * @Description:  查询首页轮播图接口
     * @Param:
     * @return:  Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/21
     */
    public AppResponse listRotationCharHome(){
        List<ClientHomeInfo> slideshowList = clientHomeDao.listRotationCharHome();
        SlideshowList slideshowList1 = new SlideshowList();
        slideshowList1.setSlideshowList(slideshowList);
        if(slideshowList.size() == 0){
            return AppResponse.versionError("查询失败，请重试");
        }
        return AppResponse.success("查询成功",slideshowList);
    }

    /**
     * @Description:  查询热门商品接口
     * @Param:
     * @return:  Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/21
     */
    public AppResponse listHotGoods(){
        List<ClientHomeInfo> listInfo = clientHomeDao.listHotGoods();
        SlideshowList list = new SlideshowList();
        list.setList(listInfo);
        if(listInfo.size() == 0){
            return AppResponse.versionError("查询失败，请重试");
        }
        return AppResponse.success("查询成功",list);
    }


}
