package com.qd.service.impl;

import com.qd.dao.SysUserDao;
import com.qd.entity.SysUserEntity;
import com.qd.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenlongbo on 2017/4/16.
 */
@Service
public class SysUserServiceImpl implements SysUserService{
    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public SysUserEntity queryByUsername(String username) {

        return sysUserDao.queryByUsername(username);
    }

    @Override
    public List<Long> queryAllMenuId(Long userId) {
        return sysUserDao.queryAllMenuId(userId);
    }
}
