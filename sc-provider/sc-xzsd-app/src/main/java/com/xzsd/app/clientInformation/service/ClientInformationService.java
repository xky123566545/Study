package com.xzsd.app.clientInformation.service;

import com.xzsd.app.clientInformation.dao.ClientInformationDao;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description 修改邀请码
 * @author xukunyuan
 * @date 2020-04-26 14:22
 */
@Service
public class ClientInformationService {
    @Resource
    private ClientInformationDao clientInformationDao;
    /**
     * @Description: 修改门店邀请码
     * @Param:  inviteCode
     * @return:  AppResposne
     * @Author: xukunyuan
     * @Date: 2020/4/26
     */
    public AppResponse updateClientInvite(String inviteCode){
        //查看门店邀请码是否已存在
        if(clientInformationDao.countInviteCode(inviteCode) == 0){
            return AppResponse.versionError("修改失败，门店编码不存在");
        }
        String userId = "2020041920270928968";
        if(clientInformationDao.updateClientInvite(inviteCode,userId) == 0){
            return AppResponse.versionError("修改失败，请重试");
        }
        return AppResponse.success("修改成功");
    }
}
