package com.qd.dao;

import com.qd.base.BaseDao;
import com.qd.entity.SysUserEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by chenlongbo on 2017/4/16.
 */
@Repository
public class SysUserDao extends BaseDao{

    public SysUserEntity queryByUsername(String username) {
        String hql = " from SysUserEntity  where username =? ";
        SysUserEntity user =(SysUserEntity) getSession().createQuery(hql).setParameter(0,username).uniqueResult();
        return  user;
    }
}
