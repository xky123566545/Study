package com.xzsd.pc.client.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.client.dao.ClientDao;
import com.xzsd.pc.client.entity.ClientInfo;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 分页查询客户信息
 * @author xukunyuan
 * @date 2020-04-14 17:26
 */
@Service
public class ClientService {

    @Resource
    private ClientDao clientDao;
    /**
     * @Description: 分页查询客户信息
     * @Param:  clientInfo
     * @return:  Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/14
     */
    public AppResponse listClients(ClientInfo clientInfo){
        PageHelper.startPage(clientInfo.getPageNum(),clientInfo.getPageSize());
        //店长可以查看自己门店的客户表
        if (clientInfo.getRole().equals("2")){
            clientInfo.setUserId(SecurityUtils.getCurrentUserId());
            List<ClientInfo> clientInfoList = clientDao.listClientsStore(clientInfo);
            PageInfo<ClientInfo> list = new PageInfo<>(clientInfoList);
            if(clientInfoList.size() == 0){
                return AppResponse.notFound("查询失败，请重试");
            }
            return AppResponse.success("查询成功",list);
        }
        //管理员可以查看所有客户表 包括管理员和店长
        else {
            List<ClientInfo> clientInfoList = clientDao.listClients(clientInfo);
            PageInfo<ClientInfo> list = new PageInfo<>(clientInfoList);
            if(clientInfoList.size() == 0){
                return AppResponse.bizError("查询失败，请重试");
            }
            return AppResponse.success("查询成功",list);
        }

    }
}
