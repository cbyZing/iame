package com.qd.service;

import com.qd.entity.SysUserEntity;

import java.util.List;

/**
 * Created by chenlongbo on 2017/4/16.
 */
public interface SysUserService {

    SysUserEntity queryByUsername(String username);

    List<Long> queryAllMenuId(Long userId);
}
