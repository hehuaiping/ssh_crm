package com.xh.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.xh.dao.BaseDictDao;
import com.xh.domain.BaseDict;

public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao {

	public List<BaseDict> getBadeDictByTypeCode(String dict_type_code) {
		//创建离线查询对象
		DetachedCriteria dc  = DetachedCriteria.forClass(BaseDict.class);
		//添加查询条件
		dc.add(Restrictions.eq("dict_type_code", dict_type_code));
		return (List<BaseDict>) getHibernateTemplate().findByCriteria(dc);
	}
	
}	
