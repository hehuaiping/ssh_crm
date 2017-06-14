package com.xh.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.xh.domain.Customer;
import com.xh.domain.LinkMan;

public class Demo extends HibernateDaoSupport {
	@Test
	public void fun1() {
		Customer customer = getHibernateTemplate().get(Customer.class, 1l);
		System.out.println(customer);
	}
}
