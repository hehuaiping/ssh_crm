package com.xh.dao;

import java.util.List;

import com.xh.domain.Customer;

public interface CustomerDao extends BaseDao<Customer> {
	/**
	 * 获取客户统计分析
	 * @return 返回客户统计分析数据
	 */
	public List<Object[]> getIndustryList();
	/**
	 * 获取客户统计分析
	 * @return 返回客户统计分析数据
	 */
	public List<Object[]> getSourceList();
}
