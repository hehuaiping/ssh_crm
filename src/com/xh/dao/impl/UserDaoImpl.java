package com.xh.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.xh.dao.UserDao;
import com.xh.domain.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	
	public User getUserByCode(String user_code) {
		//创建离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("user_code", user_code));
		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(dc);
		if(list.size()>=1) { 
			return list.get(0);
		}
		return null;
	}

}
