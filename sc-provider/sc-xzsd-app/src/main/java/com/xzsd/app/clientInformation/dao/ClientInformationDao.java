package com.xzsd.app.clientInformation.dao;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

/**
 * @Description 修改邀请码
 * @author xukunyuan
 * @date 2020-04-26 14:22
 */
@Mapper
public interface ClientInformationDao {
    /**
     * @Description: 检验门店邀请码是否存在
     * @Param:  inviteCode
     * @return:  int
     * @Author: xukunyuan
     * @Date: 2020/4/26
     */
    int countInviteCode(@Param("inviteCode") String inviteCode);
    /**
     * @Description: 修改门店邀请码
     * @Param:  inviteCode
     * @Param   userId
     * @return:  AppResposne
     * @Author: xukunyuan
     * @Date: 2020/4/26
     */
    int updateClientInvite(@Param("inviteCode") String inviteCode, @Param("userId") String userId);
}
