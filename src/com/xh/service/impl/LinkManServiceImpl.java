package com.xh.service.impl;

import org.hibernate.criterion.DetachedCriteria;

import com.xh.dao.LinkManDao;
import com.xh.domain.LinkMan;
import com.xh.service.LinkManService;
import com.xh.utils.Page;

public class LinkManServiceImpl implements LinkManService {
	private LinkManDao lkmDao;
	
	public void saveLinkMan(LinkMan lkm) {
		//1、调用lkmDao保存客户
		lkmDao.save(lkm);
	}

	public void setLkmDao(LinkManDao lkmDao) {
		this.lkmDao = lkmDao;
	}

	public Page<LinkMan> getlinkManList(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		Page<LinkMan> page = new Page<LinkMan>();
		//1、调用custDao查询符合当前条件的记录数
		Integer countNum = lkmDao.getTotalCount(dc);
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
		page.setList(lkmDao.getPageList(dc, (currentPage-1)*pageSize, pageSize));
		return page;
	}

	//更新联系人
	public void updateLinkMan(LinkMan lkm) {
		lkmDao.saveOrUpdate(lkm);
	}
	//删除联系人
	public void deleteLinkMan(Long long1) {
		lkmDao.delete(long1);
	}

	
	public LinkMan getLinkManById(Long lkm_id) {
		return lkmDao.getById(lkm_id);
	}


	
	
	

}
