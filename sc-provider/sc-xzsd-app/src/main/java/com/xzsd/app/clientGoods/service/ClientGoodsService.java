package com.xzsd.app.clientGoods.service;

import com.xzsd.app.clientGoods.dao.ClientGoodsDao;
import com.xzsd.app.clientGoods.entity.ClientGoodsInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.app.clientGoods.entity.OneClassifyList;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description App端查询商品信息，评价，一级分类，二级分类接口
 * @author xukunyuan
 * @date 2020-04-22 9:35
 */
@Service
public class ClientGoodsService {
    @Resource
    private ClientGoodsDao clientGoodsDao;

    /**
     * @Description: 查询商品信息详情接口
     * @Param: goodsId
     * @return: Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/22
     */
    public AppResponse getGoods(String goodsId) {
        ClientGoodsInfo clientGoodsInfo = clientGoodsDao.getGoods(goodsId);
        if (clientGoodsInfo == null) {
            return AppResponse.versionError("查询失败，请重试");
        }
        return AppResponse.success("查询成功", clientGoodsInfo);
    }

    /**
     * @Description: 查询商品评价列表接口
     * @Param: clientGoodsInfo
     * @return: Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/22
     */
    public AppResponse listGoodsEvaluates(ClientGoodsInfo clientGoodsInfo) {
        PageHelper.startPage(clientGoodsInfo.getPageNum(), clientGoodsInfo.getPageSize());
        //将星级String类型改为int类型
        if (clientGoodsInfo.getEvaluateScore() != null) {
            clientGoodsInfo.setGoodsEvaluateScoreInt(Integer.parseInt(clientGoodsInfo.getEvaluateScore()));
        }
        List<ClientGoodsInfo> clientGoodsInfoList = clientGoodsDao.listGoodsEvaluates(clientGoodsInfo);
        //包装list
        PageInfo<ClientGoodsInfo> list = new PageInfo<>(clientGoodsInfoList);
        if (clientGoodsInfoList.size() == 0) {
            return AppResponse.versionError("查询失败，请重试");
        }
        return AppResponse.success("查询成功", list);
    }
    /**
     * @Description: 查询一级商品分类列接口
     * @Param:
     * @return:  Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/22
     */
    public AppResponse listOneGoodsClassify(){
        List<ClientGoodsInfo> list = clientGoodsDao.listOneGoodsClassify();
        OneClassifyList oneClassifyList = new OneClassifyList();
        oneClassifyList.setOneClassifyList(list);
        if (list.size() == 0){
            return AppResponse.versionError("查询失败，请重试");
        }
        return AppResponse.success("查询成功",oneClassifyList);
    }
    /**
     * @Description: 查询二级商品分类列接口
     * @Param:    listGetClassGoods
     * @return:  Appresponse
     * @Author: xukunyuan
     * @Date: 2020/4/22
     */
    public AppResponse listGetClassGoods(ClientGoodsInfo clientGoodsInfo){
        List<ClientGoodsInfo> list = clientGoodsDao.listGetClassGoods(clientGoodsInfo);
        OneClassifyList twoClassifyList = new OneClassifyList();
        twoClassifyList.setTwoClassifyList(list);
        if (list.size() == 0){
            return AppResponse.versionError("查询失败，请重试");
        }
        return AppResponse.success("查询成功",twoClassifyList);
    }
}

