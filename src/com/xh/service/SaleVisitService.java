package com.xh.service;

import org.hibernate.criterion.DetachedCriteria;

import com.xh.domain.SaleVisit;
import com.xh.utils.Page;

public interface SaleVisitService {
	/**
	 * 保存拜访记录
	 * @param saleVisit
	 */
	void saveSaleVisit(SaleVisit saleVisit);
	/**
	 * 查询客户拜访记录列表
	 * @param dc	离线查询对象
	 * @param currentPage 当前页
	 * @param pageSize 每页显示多少条
	 * @return 返回符合条件的列表数据
	 */
	Page<SaleVisit> getSaleVisitList(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	/**
	 * 根据拜访记录ID查询拜访记录
	 * @param visit_id 拜访记录ID
	 * @return	返回查询到的拜访记录
	 */
	SaleVisit getSaleVisitListById(String visit_id);

}
