package com.xh.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.xh.domain.Customer;
import com.xh.utils.Page;

public interface CustomerService {
	/**
	 * 保存客户
	 * @param cust
	 */
	void saveCustomer(Customer cust);
	/**
	 * 按条件获取客户列表
	 * @param dc 离线查询对象
	 * @param currentPage 当前页
 	 * @param pageSize 每页显示多少条记录
	 * @return 返回符合条件的数据集合
	 */
	Page<Customer> getCustomerList(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	/**
	 * 根据客户ID查询客户
	 * @param cust_id 客户ID
	 * @return	返回查询到的客户
	 */
	Customer getCustomerById(Long cust_id);
	/**
	 * 更新客户
	 * @param cust 客户
	 */
	void updateCustomer(Customer cust);
	/**
	 * 删除客户
	 * @param cust_id 客户ID
	 */
	void deleteCustomer(Long cust_id);
	/**
	 * 获取客户统计分析
	 * @return 返回客户统计分析数据
	 */
	public List<Object[]> getIndustryList();
	/**
	 * 获取客户统计分析
	 * @return 返回客户统计分析数据
	 */
	List<Object[]> getSourceList();

}
