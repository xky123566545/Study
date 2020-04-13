package com.xzsd.pc.menu.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.menu.dao.MenuDao;
import com.xzsd.pc.menu.entity.MenuInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 实现类
 * @author xukunyuan
 * @date 2020-03-26 16:29
 */
@Service
public class MenuService {

    @Resource
    private MenuDao menuDao;

    /**
    * @Description: menu新增菜单
    * @Param:  menuInfo
    * @return:  AppResponse
    * @Author: xukunyuan
    * @Date: 2020/3/26
    */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addMenu(MenuInfo menuInfo) {
        menuInfo.setMenuId(StringUtil.getCommonCode(2));
        //检验菜单名字是否存在
        int countMenuName = menuDao.countMenuName(menuInfo);
        if(0 != countMenuName) {
            return AppResponse.bizError("菜单已存在，请重新输入！");
        }
        //将菜单是否生效設置为0
        menuInfo.setIsDelete(0);
        //新增菜单
        int count = menuDao.saveMenu(menuInfo);
        if (count == 0){
            return AppResponse.bizError("新增失败,请重试");
        }
        return AppResponse.success("新增菜单成功");

    }

    /**
    * @Description: menu菜单查询
    * @Param:  menuName 菜单名字
    * @return: AppResponse
    * @Author: xukunyuan
    * @Date: 2020/3/26
    */
    public AppResponse getMenuByMenuName(String menuId){
        MenuInfo menuInfo = menuDao.getMenuByMenuName(menuId);
        if (menuInfo == null){
            return AppResponse.bizError("查询失败,该菜单不存在");
        }
        return AppResponse.success("菜单查询成功",menuInfo);
    }
    /**
    * @Description: 菜单查询（分页）
    * @Param:  menuInfo 菜单信息
    * @return: AppResponse
    * @Author: xukunyuan
    * @Date: 2020/3/26
    */
    public AppResponse listMenus(MenuInfo menuInfo){
        PageHelper.startPage(menuInfo.getPageNum(),menuInfo.getPageSize());
        List<MenuInfo> menuInfoList = menuDao.listMenus(menuInfo);
        //包装page对象
        PageInfo<MenuInfo> pageDate = new PageInfo(menuInfoList);
        return AppResponse.success("查询成功！",pageDate);
    }
    /**
    * @Description: 修改菜单信息
    * @Param:  menuInfo
    * @return:
    * @Author: xukunyuan
    * @Date: 2020/3/26
    */
    public AppResponse updateMenu(MenuInfo menuInfo){
        if (menuDao.updateMenu(menuInfo) == 0){
            return AppResponse.bizError("修改失败，请重试");
        }
        return AppResponse.success("修改成功");
    }
    /** 
    * @Description: 删除菜单 
    * @Param:  menuCode
     * @Param:  userId
    * @return:  
    * @Author: xukunyuan
    * @Date: 2020/3/27 
    */
    public AppResponse deleteMenu(String menuId, String userId){
        List<String> listCode = Arrays.asList(menuId.split(","));
        // 校验菜单是否存在
        if (menuDao.deleteMenu(listCode,userId) == 0){
            AppResponse.bizError("删除失败,请重试");
        }
        return AppResponse.success("删除成功");
    }

}
