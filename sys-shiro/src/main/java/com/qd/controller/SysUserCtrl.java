package com.qd.controller;

import com.qd.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chenlongbo on 2017/4/17.
 */
@Controller
@RequestMapping("/sys/user")
public class SysUserCtrl extends BaseController{
    /**
     * 获取登录用户信息
     */
    @RequestMapping("/info")
    @ResponseBody
    public R info () {
        return R.ok().put("user",getUser());
    }
}
