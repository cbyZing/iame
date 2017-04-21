package com.qd.service;

import com.qd.entity.SysUserEntity;
import com.qd.utils.Query;

import java.util.List;
import java.util.Map;

/**
 * Created by chenlongbo on 2017/4/16.
 */
public interface SysUserService {

    SysUserEntity queryByUsername(String username);

    List<Long> queryAllMenuId(Long userId);

    List<SysUserEntity> queryUsersList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);
}
