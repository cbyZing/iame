package com.qd.dao;

import com.qd.base.BaseDao;
import com.qd.entity.SysUserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    /**
     * 查询用户的所有菜单ID
     */
    public List<Long> queryAllMenuId(Long userId) {
        String hql = " select distinct rm.menuId from SysUserRoleEntity ur " +
                " LEFT JOIN SysRoleMenuEntity rm on ur.roleId = rm.roleId " +
                " where ur.userId = :userId  ";
        List<Long> menuIdList = getSession().createQuery(hql).setParameter("useId",userId).list();

        return menuIdList;
    }

    public static List<SysUserEntity> queryUsersList(Map<String, Object> map) {
    }

    public static int queryTotal(Map<String, Object> map) {
    }
}
