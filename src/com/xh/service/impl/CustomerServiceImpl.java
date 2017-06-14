package com.xh.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.xh.dao.CustomerDao;
import com.xh.domain.Customer;
import com.xh.service.CustomerService;
import com.xh.utils.Page;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao custDao;
	
	public void saveCustomer(Customer cust) {
		//1、调用custDao保存客户
		custDao.save(cust);
	}

	public void setCustDao(CustomerDao custDao) {
		this.custDao = custDao;
	}

	public Page<Customer> getCustomerList(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		Page<Customer> page = new Page<Customer>();
		//1、调用custDao查询符合当前条件的记录数
		Integer countNum = custDao.getTotalCount(dc);
		//总共多少条记录
		page.setCountNum(countNum);
		//当前页
		page.setCurrentPage(currentPage);
		//每页显示多少条记录
		page.setPageSize(pageSize);
		//总共多少页
		page.setCountPage(countNum/pageSize+(countNum%pageSize==0?0:1));
		//上一页
		page.setUpPage(currentPage==page.getFirstPage()?1:currentPage-1);
		//下一页
		page.setNextPage(currentPage==page.getCountPage()?currentPage:currentPage+1);
		//2、调用custDao获取数据集合
		page.setList(custDao.getPageList(dc, (currentPage-1)*pageSize, pageSize));
		return page;
	}
	public List<Object[]> getIndustryList() {
		return custDao.getIndustryList();
	}
	public List<Object[]> getSourceList() {
		return custDao.getSourceList();
	}


	public Customer getCustomerById(Long cust_id) {
		return custDao.getById(cust_id);
	}

	public void updateCustomer(Customer cust) {
		custDao.saveOrUpdate(cust);
	}

	public void deleteCustomer(Long cust_id) {
		custDao.delete(cust_id);
	}

	
	
	

}
