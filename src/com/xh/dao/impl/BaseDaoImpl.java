package com.xh.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.xh.dao.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	//用户接受运行期泛型类型
	private Class clazz;
	public BaseDaoImpl() {
		//获取当前类型的带有泛型类型的类
		ParameterizedType pType = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获取运行期的泛型类型
		clazz = (Class) pType.getActualTypeArguments()[0];
	}

	public void save(T t) {
		getHibernateTemplate().save(t);	
	}

	public void saveOrUpdate(T t) {
		getHibernateTemplate().saveOrUpdate(t);
	}

	public void delete(T t) {
		getHibernateTemplate().delete(t);
	}

	public void delete(Serializable id) {
		getHibernateTemplate().delete(this.getById(id)); //先取出  再删除
	}

	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	public T getById(Serializable id) {
		return (T) getHibernateTemplate().get(clazz, id);
	}

	public Integer getTotalCount(DetachedCriteria dc) {
		//添加聚合查询函数
		dc.setProjection(Projections.rowCount());
		//执行查询
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
		//清空离线查询的聚合函数
		dc.setProjection(null);
		
		if(null != list && list.size() > 0) {
			 return list.get(0).intValue();
		}
		return null;
	}

	public List<T> getPageList(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		return (List<T>) getHibernateTemplate().findByCriteria(dc, currentPage, pageSize);
	}

}
