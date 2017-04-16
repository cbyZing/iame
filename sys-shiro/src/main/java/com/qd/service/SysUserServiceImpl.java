package com.qd.service;

import com.qd.dao.SysUserDao;
import com.qd.entity.SysUserEntity;
import com.qd.service.impl.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenlongbo on 2017/4/16.
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService{
    @Autowired
    SysUserDao sysUserDao;

    @Override
    public SysUserEntity queryByUsername(String username) {
        return sysUserDao.queryByUsername(username);
    }
}
