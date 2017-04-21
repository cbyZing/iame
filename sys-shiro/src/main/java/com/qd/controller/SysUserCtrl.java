package com.qd.controller;

import com.qd.entity.SysUserEntity;
import com.qd.service.SysUserService;
import com.qd.utils.Constant;
import com.qd.utils.PageUtils;
import com.qd.utils.Query;
import com.qd.utils.R;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by chenlongbo on 2017/4/17.
 */
@Controller
@RequestMapping("/sys/user")
public class SysUserCtrl extends BaseController{
    @Autowired
    private SysUserService sysUserService;

    /**
     * 获取登录用户信息
     */
    @RequestMapping("/info")
    @ResponseBody
    public R info () {
        return R.ok().put("user",getUser());
    }

    /**
     * 所有用户列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:user:list")
    public R listUsers(@RequestParam Map<String,Object> params){
        //超级管理员
        if (getUserId() != Constant.SUPER_ADMIN){
            params.put("createUserId",getUserId());
        }
        //查询列表数据
        Query query = new Query(params);
        List<SysUserEntity> userList = sysUserService.queryUsersList(query);
        int total = sysUserService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }
}
