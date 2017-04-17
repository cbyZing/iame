package com.qd.service;

import com.qd.entity.SysMenuEntity;

import java.util.List;

/**
 * Created by chenlongbo on 2017/4/17.
 */
public interface SysMenuService {
    /**
     * 获取用户菜单列表
     * @param userId
     * @return
     */
    List<SysMenuEntity> getUserMenuList(Long userId);


    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     * @param menuIdList  用户菜单ID
     */
    List<SysMenuEntity> queryListParentId(Long parentId, List<Long> menuIdList);
}
