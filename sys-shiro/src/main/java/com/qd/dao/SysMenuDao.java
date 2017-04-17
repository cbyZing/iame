package com.qd.dao;

import com.qd.base.BaseDao;
import com.qd.controller.BaseController;
import com.qd.entity.SysMenuEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chenlongbo on 2017/4/17.
 */
@Repository
public class SysMenuDao extends BaseDao {
    public List<SysMenuEntity> queryListParentId(Long parentId) {

        String hql = " from SysMenuEntity where parentId =:parentId order by orderNum asc ";

        List<SysMenuEntity> list =  getSession().createQuery(hql).setParameter("parentId",parentId).list();

        return  list;
    }
}
