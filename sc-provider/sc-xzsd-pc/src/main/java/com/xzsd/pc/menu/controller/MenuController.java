package com.xzsd.pc.menu.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.menu.entity.MenuInfo;
import com.xzsd.pc.menu.service.MenuService;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xukunyuan
 * @Description Menu增删查改
 * @date 2020-03-26 15:39
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Resource
    private MenuService menuService;

    /**
     * @Description: Menu菜单新增
     * @Param: menuInfo
     * @return: appResponse
     * @Author: xukunyuan
     * @Date: 2020/3/26
     */
    @PostMapping("addMenu")
    public AppResponse addMenu(MenuInfo menuInfo) {
        try {
            AppResponse appResponse = menuService.addMenu(menuInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("菜单新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
    * @Description: 查询菜单menu
    * @Param:  menuName
    * @return:  appResponse
    * @Author: xukunyuan
    * @Date: 2020/3/26
    */
    @PostMapping("getMenu")
    public AppResponse getMenu(String menuId){
        try{
            AppResponse appResponse = menuService.getMenuByMenuName(menuId);
            return appResponse;

        } catch(Exception e){
            logger.error("菜单查询失败,请重试",e);
            System.out.println(e.toString());
            throw e ;
        }
    }

    /**
    * @Description: 菜单列表查询(分页)
    * @Param:  menuInfo 菜单信息
    * @return:  AppResponse
    * @Author: xukunyuan
    * @Date: 2020/3/26
    */
    @PostMapping("listMenu")
    public AppResponse listMenu(MenuInfo menuInfo){
        try {
            return menuService.listMenu(menuInfo);
        }catch (Exception e){
            logger.error("菜单列表查询失败，请重试",e);
            System.out.printf(e.toString());
            throw e;
        }
    }
    /**
    * @Description: 菜单修改
    * @Param:  menuInfo
    * @return:  Appresponse
    * @Author: xukunyuan
    * @Date: 2020/3/26
    */
    @PostMapping("updateMenu")
    public AppResponse updateMenu(MenuInfo menuInfo){
        try{
            return menuService.updateMenu(menuInfo);
        }catch (Exception e){
            logger.error("修改失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
    * @Description: 菜单删除
    * @Param:  menuId 菜单名字
    * @return: AppResponse
    * @Author: xukunyuan
    * @Date: 2020/3/27
    */
    @PostMapping("deleteMenu")
    public AppResponse deleteMenu(String menuId){
        try{

            return menuService.deleteMenu(menuId);
        }catch(Exception e){
            logger.error("删除失败,请重试");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * @Description: 根据角色菜单列表查询
     * @Param:  menuInfo 菜单信息
     * @return:  AppResponse
     * @Author: xukunyuan
     * @Date: 2020/3/26
     */
    @PostMapping("listMenuHome")
    public AppResponse listMenuHome(String role){
        try {
            return menuService.listMenuHome(role);
        }catch (Exception e){
            logger.error("菜单列表查询失败，请重试",e);
            System.out.printf(e.toString());
            throw e;
        }
    }

}

