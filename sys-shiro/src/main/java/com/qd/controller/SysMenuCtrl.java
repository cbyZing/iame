package com.qd.controller;

import com.qd.entity.SysMenuEntity;
import com.qd.service.SysMenuService;
import com.qd.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by chenlongbo on 2017/4/17.
 */
@Controller
@RequestMapping("/sys/menu")
public class SysMenuCtrl extends BaseController{
    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 用户菜单列表
     */
    @RequestMapping("/user")
    @ResponseBody
    public R user(){

        List<SysMenuEntity> menuList = sysMenuService.getUserMenuList(getUserId());

        return R.ok().put("menuList",menuList);

    }
}
