package com.qd.modules.login.service.impl;


import com.qd.modules.login.dao.UserDao;
import com.qd.modules.login.model.User;
import com.qd.modules.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenlongbo on 2017/4/13.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    public UserDao userDao;


    public User login(User user) {
        return userDao.login(user);
    }
}
