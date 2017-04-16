package com.qd.base;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by chenlongbo on 2017/4/13.
 */
public class BaseDao extends HibernateDaoSupport {


    /**
     * 注入session
     * @param sessionFactory
     */
    @Resource(name="sessionFactory")
    public void setMySessionFactory(SessionFactory sessionFactory)
    {
        super.setSessionFactory(sessionFactory);
    }

    /**
     * 从工厂获取session
     * @return
     */
    public Session getSession() {
        Assert.notNull(this.getSessionFactory().openSession(), "缺少SessionFactory对象");
        //Session s = this.getSessionFactory().getCurrentSession();
        //if ( null == s && createNew ) {
        Session	s = this.getSessionFactory().openSession();
        //}
        return s;
    }




    public <Entity extends IBaseModel<? extends Serializable>> void save(Entity entity) {
        Assert.notNull(entity,"对象为空");
//		this.getSession().clear();
//		this.getSession().save(entity);
        this.getSession().persist(entity);
    }



    public <Entity extends IBaseModel<? extends Serializable>> void update(Entity entity) {
        Assert.notNull(entity,"对象为空");
        this.getSession().merge(entity);
    }



    public <Entity extends IBaseModel<? extends Serializable>> void delete(Entity entity) {
        Assert.notNull(entity,"对象为空");
        this.getSession().delete(entity);
    }



    public <Entity extends ILogicalDeletable<? extends Serializable>> void logicalDelete(Entity entity) {
        Assert.notNull(entity,"对象为空");
        entity.setLogicalDelete(true);
        this.getSession().update(entity);
    }



    public <ID extends Serializable, Entity extends IBaseModel<ID>> Entity get(Class<Entity> entityClass, ID id) {
        Assert.notNull(entityClass,"对象为空");
        Assert.notNull(id,"id为空");
        return (Entity) this.getSession().get(entityClass, id);
    }



    public <Entity extends IBaseModel<? extends Serializable>> Entity get(Entity entity) {
        Assert.notNull(entity,"对象为空");
        Assert.notNull(entity.getId(),"id为空");
        return (Entity) this.getSession().get(entity.getClass(), entity.getId());
    }



    public <Entity extends IBaseModel<? extends Serializable>> List<Entity> findList(Class<Entity> entityClass,
                                                                                     DetachedCriteria dc) {
        Assert.notNull(entityClass,"对象为空");
        Assert.notNull(dc,"DetachedCriteria对象null");
        Criteria c = dc.getExecutableCriteria(this.getSession());
        return c.list();
    }



    public <Entity extends IBaseModel<? extends Serializable>> Page<Entity> pageQuery(Class<Entity> entityClass,
                                                                                      DetachedCriteria dc, PageParam pageParam) {
        Assert.notNull(entityClass,"对象null");
        Assert.notNull(dc,"对象null");
        if ( null == pageParam ) pageParam = new PageParam();
        Criteria c = dc.getExecutableCriteria(this.getSession());
        Object ur = c.setProjection(Projections.rowCount()).uniqueResult();
        int total = 0;
        if ( null != ur )
            total = (Long.valueOf(ur.toString())).intValue();
        c.setProjection(null);
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        c.setFirstResult(pageParam.getStartPos());
        c.setMaxResults(pageParam.getRows());
        if ( null != pageParam.getSort() && !"".equalsIgnoreCase(pageParam.getSort()) ) {
            String dir = pageParam.getDir();
            if ( PageParam.DIR_ASC.equals(dir) ) {
                c.addOrder(Order.asc(pageParam.getSort()));
            } else {
                c.addOrder(Order.desc(pageParam.getSort()));
            }
        }
        List<Entity>list = c.list();
        return new Page<Entity>(total, list, pageParam.getPage(), pageParam.getRows());
    }


    public <Entity extends IBaseModel<? extends Serializable>> void flush(Class<Entity> entityClass) {
        Assert.notNull(entityClass,"对象null");
        this.getSession().flush();
    }



    public <Entity extends IBaseModel<? extends Serializable>> long count(Class<Entity> entityCls,
                                                                          DetachedCriteria dc) {
        Criteria c = dc.getExecutableCriteria(this.getSession());
        c.setProjection(Projections.rowCount());
        return  Long.valueOf(String.valueOf(c.uniqueResult())).longValue();
    }



    public <Entity extends IBaseModel<? extends Serializable>> void merge(Entity entity) {
        Assert.notNull(entity,"对象null");
        this.getSession().merge(entity);
    }




}
