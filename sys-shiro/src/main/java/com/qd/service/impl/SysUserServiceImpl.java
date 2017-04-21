package com.qd.service.impl;

import com.qd.dao.SysUserDao;
import com.qd.entity.SysUserEntity;
import com.qd.service.SysUserService;
import com.qd.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Override
    public List<SysUserEntity> queryUsersList(Map<String, Object> map) {
        return SysUserDao.queryUsersList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return SysUserDao.queryTotal(map);    }
}
