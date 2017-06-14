package com.xh.service.impl;

import org.hibernate.criterion.DetachedCriteria;

import com.xh.dao.SaleVisitDao;
import com.xh.domain.SaleVisit;
import com.xh.service.SaleVisitService;
import com.xh.utils.Page;

public class SaleVisitServiceImpl implements SaleVisitService {
	private SaleVisitDao svDao;

	// 保存拜访记录
	public void saveSaleVisit(SaleVisit saleVisit) {
		svDao.saveOrUpdate(saleVisit);
	}

	// 获取客户拜访记录列表
	public Page<SaleVisit> getSaleVisitList(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		Page<SaleVisit> page = new Page<SaleVisit>();
		// 1、调用custDao查询符合当前条件的记录数
		Integer countNum = svDao.getTotalCount(dc);
		// 总共多少条记录
		page.setCountNum(countNum);
		// 当前页
		page.setCurrentPage(currentPage);
		// 每页显示多少条记录
		page.setPageSize(pageSize);
		// 总共多少页
		page.setCountPage(countNum / pageSize + (countNum % pageSize == 0 ? 0 : 1));
		// 上一页
		page.setUpPage(currentPage == page.getFirstPage() ? 1 : currentPage - 1);
		// 下一页
		page.setNextPage(currentPage == page.getCountPage() ? currentPage : currentPage + 1);
		// 2、调用custDao获取数据集合
		page.setList(svDao.getPageList(dc, (currentPage - 1) * pageSize, pageSize));
		return page;
	}

	//获取拜访记录	
	public SaleVisit getSaleVisitListById(String visit_id) {
		return svDao.getById(visit_id);
	}

	public void setSvDao(SaleVisitDao svDao) {
		this.svDao = svDao;
	}

}
