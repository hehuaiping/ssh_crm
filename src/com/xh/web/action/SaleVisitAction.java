package com.xh.web.action;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xh.domain.SaleVisit;
import com.xh.domain.User;
import com.xh.service.SaleVisitService;
import com.xh.utils.Page;

public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {
	private SaleVisitService svService;

	// 模型驱动获取参数
	private SaleVisit saleVisit = new SaleVisit();

	// 属性驱动获取参数
	private Integer currentPage;
	private Integer pageSize;

	// 保存客户拜访记录
	public String saveSaleVisit() throws Exception {
		// 检查数据

		// 1、调用svService保存拜访记录
		User user = ((User) ActionContext.getContext().getSession().get("user"));
		saleVisit.setUser(user);
		svService.saveSaleVisit(saleVisit);
		// 2、重定向到拜访记录列表页面
		 ActionContext.getContext().put("visit_cust_id", saleVisit.getCustomer().getCust_id());
		return "toSaleVisitList";
	}

	// 获取客户拜访记录列表
	public String getSaleVisitList() throws Exception {
		// 1、创建离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);
		// 2、判断有没有查询条件
		if (null != saleVisit.getCustomer() && null != saleVisit.getCustomer().getCust_id()) {
			dc.add(Restrictions.eq("customer.cust_id", saleVisit.getCustomer().getCust_id()));
		} 
		// 3、检查分页数据 当前页 每页显示多少条记录
		if (null == currentPage || currentPage <= 0) {
			currentPage = 1;
		}
		if (null == pageSize || pageSize <= 0) {
			pageSize = 10;
		}
		// 4、调用svService查询分页列表数据
		Page<SaleVisit> page = svService.getSaleVisitList(dc,currentPage,pageSize);
		ActionContext.getContext().put("page", page);
		return "saleVisitList";
	}
	
	//编辑客户拜访记录
	public String editSaleVisit() throws Exception {
		//1、调用svService查询客户拜访记录
		SaleVisit sv = svService.getSaleVisitListById(saleVisit.getVisit_id());
		//2、转发到编辑页面
		ActionContext.getContext().put("saleVisit", sv);
		return "edit";
	}

	public SaleVisit getModel() {
		return saleVisit;
	}

	public void setSvService(SaleVisitService svService) {
		this.svService = svService;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
