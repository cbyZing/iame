package com.qd.modules.hello.controller;

import com.qd.modules.login.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenlongbo on 2017/4/12.
 */
@Controller
@RequestMapping("/manager/helloworld")
public class HelloWorldCtrl {

    @RequestMapping("/sayhi")
    public String sayhi(HttpServletRequest request){

        request.setAttribute("skey","sayhi.");

        return "first/hello_result";

    }

    @RequestMapping("/json")
    @ResponseBody
    public Map<String,Object> getJson(){
        Map<String,Object> map = new HashMap<String,Object>();
        List<User> list = new ArrayList<User>();
        User u = new User();
        u.setId("1234567890");
        u.setName("jelli");
        u.setAccount("root");
        u.setPassword("admin");
        list.add(u);
        map.put("success",Boolean.TRUE);
        map.put("data",list);
        return  map;
    }
}
