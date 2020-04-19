package com.xzsd.pc.client.dao;

import com.xzsd.pc.client.entity.ClientInfo;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Description 分页查询客户信息
 * @author xukunyuan
 * @date 2020-04-14 17:38
 */
@Mapper
public interface ClientDao {
    /**
    * @Description: 分页查询客户信息(管理员查询)
    * @Param:  clientInfo
    * @return:  List<clientInfo></clientInfo>
    * @Author: xukunyuan
    * @Date: 2020/4/14
    */
    List<ClientInfo> listClients(ClientInfo clientInfo);
    /**
     * 店长查询客户信息
     */
    List<ClientInfo> listClientsStore(ClientInfo clientInfo);
}
