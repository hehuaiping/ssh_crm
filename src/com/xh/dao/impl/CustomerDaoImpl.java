package com.xh.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.xh.dao.CustomerDao;
import com.xh.domain.Customer;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

	public List<Object[]> getIndustryList() {
		//1、书写SQL
		final String sql =   "SELECT                         "+
							 "	bd.dict_item_name industry,  "+
							 "	count(*) total               "+
							 "FROM                           "+
							 "	cst_customer c,              "+
							 "	base_dict bd                 "+
							 "WHERE                          "+
							 "	c.cust_industry = bd.dict_id "+
							 "GROUP BY                       "+
							 "	c.cust_industry             ";
		//2、执行查询
		return getHibernateTemplate().execute(new HibernateCallback<List<Object[]>>() {
			public List<Object[]> doInHibernate(Session session) throws HibernateException {
				Query query = session.createSQLQuery(sql);
				return query.list();
			}
		});
	}
	public List<Object[]> getSourceList() {
		//1、书写SQL
		final String sql =   "SELECT                         "+
							 "	bd.dict_item_name industry,  "+
							 "	count(*) total               "+
							 "FROM                           "+
							 "	cst_customer c,              "+
							 "	base_dict bd                 "+
							 "WHERE                          "+
							 "	c.cust_source = bd.dict_id "+
							 "GROUP BY                       "+
							 "	c.cust_source             ";
		//2、执行查询
		return getHibernateTemplate().execute(new HibernateCallback<List<Object[]>>() {
			public List<Object[]> doInHibernate(Session session) throws HibernateException {
				Query query = session.createSQLQuery(sql);
				return query.list();
			}
		});
	}

}
