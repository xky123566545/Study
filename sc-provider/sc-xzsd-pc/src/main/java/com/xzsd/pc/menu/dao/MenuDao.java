package com.xzsd.pc.menu.dao;

import com.xzsd.pc.menu.entity.MenuInfo;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Description 方法实现 对数据库代码访问
 * @author xukunyuan
 * @date 2020-03-26 16:38
 */
@Mapper
public interface MenuDao {
    /**
     * @Description: 统计菜单数量
     * @Param: menuInfo 菜单信息
     * @return:
     * @Author: xukunyuan
     * @Date: 2020/3/26
     */
    int countMenuName(MenuInfo menuInfo);
    /**
    * @Description: 新增菜单
    * @Param:  menuInfo 菜单信息
    * @return:
    * @Author: xukunyuan
    * @Date: 2020/3/26
    */
    int saveMenu(MenuInfo menuInfo);
    /**
    * @Description: 菜单查询
    * @Param:  menuName 菜单名字
    * @return:
    * @Author: xukunyuan
    * @Date: 2020/3/26
    */
    MenuInfo getMenuByMenuName(@Param("menuId") String menuId);

    /**
    * @Description: 列表分页查询
    * @Param:  menuInfo 列表信息
    * @return:  List<MenuInfo></MenuInfo>
    * @Author: xukunyuan
    * @Date: 2020/3/26
    */
    List<MenuInfo> listMenu(MenuInfo menuInfo);
    /**
    * @Description:修改菜单信息
    * @Param:   menuInfo 菜单信息
    * @return:
    * @Author: xukunyuan
    * @Date: 2020/3/26
    */
    int updateMenu(MenuInfo menuInfo);
    /**
    * @Description: 删除菜单
    * @Param:  listCode
     * @Param:  userId
    * @return:
    * @Author: xukunyuan
    * @Date: 2020/3/27
    */
    int deleteMenu(@Param("listCode") List<String> listCode, @Param("userId") String userId);
    /**
     * @Description: 根据角色列表分页查询
     * @Param:  menuInfo 列表信息
     * @return:  List<MenuInfo></MenuInfo>
     * @Author: xukunyuan
     * @Date: 2020/3/26
     */
    List<MenuInfo> listMenuHome(@Param("role") String role);
}