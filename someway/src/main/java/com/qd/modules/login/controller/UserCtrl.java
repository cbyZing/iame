package com.qd.modules.login.controller;

import com.qd.modules.login.model.User;
import com.qd.modules.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chenlongbo on 2017/4/13.
 */
@Controller
@RequestMapping("/manager/login")
public class UserCtrl {

    @Autowired
    public UserService userService;

    @RequestMapping("/home")
    public String checkLogin(@ModelAttribute User user){

        System.out.print("aaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.print(user.getAccount()+"----------------------");

        userService.login(user);

        return "first/hello";
    }
}
