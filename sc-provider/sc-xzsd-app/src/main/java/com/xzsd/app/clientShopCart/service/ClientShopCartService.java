package com.xzsd.app.clientShopCart.service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.clientShopCart.dao.ClientShopCartDao;
import com.xzsd.app.clientShopCart.entity.ClientShopCartInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.AuthUtils;
import com.xzsd.app.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 购物车增删查改
 * @author xukunyuan
 * @date 2020-04-23 10:37
 */
@Service
public class ClientShopCartService {
    @Resource
    private ClientShopCartDao clientShopCartDao;

    /**
     * @Description: 新增购物车信息
     * @Param:   clientShopCartInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/23
     */
    public AppResponse addShoppingCart(ClientShopCartInfo clientShopCartInfo){
        clientShopCartInfo.setCreateUser(SecurityUtils.getCurrentUserId());
        clientShopCartInfo.setShopCartId(StringUtil.getCommonCode(2));
        if (clientShopCartDao.addShoppingCart(clientShopCartInfo) == 0){
            return AppResponse.versionError("新增失败，请重试");
        }
        return AppResponse.success("新增成功");
    }

    /**
     * @Description: 查询购物车信息
     * @Param:   clientShopCartInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/23
     */
    public AppResponse listShoppingCarts(ClientShopCartInfo clientShopCartInfo){
        PageHelper.startPage(clientShopCartInfo.getPageNum(),clientShopCartInfo.getPageSize());
        List<ClientShopCartInfo> clientShopCartInfos = clientShopCartDao.listShoppingCarts(clientShopCartInfo);
        //包装page对象
        PageInfo<ClientShopCartInfo> pageDate = new PageInfo<>(clientShopCartInfos);
        if(clientShopCartInfos == null){
            return AppResponse.versionError("查询失败，请重试");
        }
        return AppResponse.success("查询成功",pageDate);
    }

    /**
     * @Description: 修改购物车信息
     * @Param:   clientShopCartInfo
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/23
     */
    public AppResponse updateShoppingCart(ClientShopCartInfo clientShopCartInfo){
        clientShopCartInfo.setUpdateUser(SecurityUtils.getCurrentUserId());
        if (clientShopCartDao.updateShoppingCart(clientShopCartInfo) == 0){
            return AppResponse.versionError("修改失败，请重试");
        }
        return AppResponse.success("修改成功");
    }

    /**
     * @Description: 删除购物车信息
     * @Param:   shopCartId
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/4/23
     */
    public AppResponse deleteShoppingCart(String shopCartId){
        List<String> listCode = Arrays.asList(shopCartId.split(","));
        String userId = SecurityUtils.getCurrentUserId();
        if (clientShopCartDao.deleteShoppingCart(listCode,userId) == 0){
            return AppResponse.versionError("删除失败，请重试");
        }
        return AppResponse.success("删除成功");
    }

}
