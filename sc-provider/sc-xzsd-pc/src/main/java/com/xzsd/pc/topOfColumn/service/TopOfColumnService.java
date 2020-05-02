package com.xzsd.pc.topOfColumn.service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.topOfColumn.dao.TopOfColumnDao;
import com.xzsd.pc.topOfColumn.entity.TopOfColumnInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description 顶部栏接口
 * @author xukunyuan
 * @date 2020-04-20 9:49
 */
@Service
public class TopOfColumnService {
    @Resource
    private TopOfColumnDao topOfColumnDao;
    /**
     * @Description:  顶部栏接口
     * @Param:
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/20
     */
    public AppResponse getTopOfColumn(){
        //获取当前登录用户id
        String userId = SecurityUtils.getCurrentUserId();
        TopOfColumnInfo topOfColumnInfo = topOfColumnDao.getTopOfColumn(userId);
        if (topOfColumnInfo == null){
            return AppResponse.bizError("查询失败，请重试");
        }
        return AppResponse.success("查询成功",topOfColumnInfo);
    }
}
