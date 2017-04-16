package com.qd.service;

import com.qd.entity.SysUserEntity;

/**
 * Created by chenlongbo on 2017/4/16.
 */
public interface SysUserService {

    SysUserEntity queryByUsername(String username);

}
