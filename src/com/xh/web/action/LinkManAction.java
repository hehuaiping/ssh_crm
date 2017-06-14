package com.xh.web.action;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xh.domain.Customer;
import com.xh.domain.LinkMan;
import com.xh.service.LinkManService;
import com.xh.utils.Page;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

	private LinkManService lkmService;
	// 模型驱动获取参数
	private LinkMan lkm = new LinkMan();

	//属性驱动获取参数
	private Integer currentPage;
	private Integer pageSize;
	
	// 保存联系人
	public String saveLinkMan() throws Exception {
		// 检查数据

		// 1、调用lkmService保存客户
		lkmService.saveLinkMan(lkm);
		// 2、回到联系人列表页面
		ActionContext.getContext().put("lkm_name", lkm.getLkm_name());
		return "toLinkManList";
	}

	// 获取联系人列表
	public String getLinkManList() throws Exception {
		// 1、创建离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		// 2、判断有无查询条件
		if (lkm.getLkm_name() != null) {
			dc.add(Restrictions.like("lkm_name", "%" + lkm.getLkm_name() + "%"));
		}
		if(lkm.getCustomer() != null && lkm.getCustomer().getCust_id() != null ) {
			dc.add(Restrictions.eq("customer.cust_id", lkm.getCustomer().getCust_id()));
		}
		// 当前页 每页显示多少条记录
		if( null == currentPage || currentPage <= 0) {
			currentPage = 1;
		}
		if( null == pageSize || pageSize <= 0 ) {
			pageSize = 10;
		}
		// 3、调用custService查询数据集合
		Page<LinkMan> page = lkmService.getlinkManList(dc, currentPage, pageSize);
		// 4、跳转到客户列表页面
		ActionContext.getContext().put("page", page);
		return "linkManList";
	}

	//编辑联系人
	public String editLinkMan() throws Exception {
		//1、根据联系人ID查询联系人
		LinkMan linkMan = lkmService.getLinkManById(lkm.getLkm_id());
		//2、将查询到的联系人带回页面显示
		ActionContext.getContext().put("linkMan", linkMan);
		return "edit";
	}
	
	//更新联系人
	public String updateLinkMan() throws Exception {
		//1、调用lkmService更新联系人
		lkmService.updateLinkMan(lkm);
		//2、重定向到联系人列表页面
		ActionContext.getContext().put("lkm_name",lkm.getLkm_name());
		return "toLinkManList";
	}
	
	//删除联系人
	public String deleteLinkMan() throws Exception {
		//1、调用lkmService删除联系下人
		lkmService.deleteLinkMan(lkm.getLkm_id());
		//2、回到联系人列表页面 
		ActionContext.getContext().put("currentPage", this.currentPage);
		ActionContext.getContext().put("pageSize", this.pageSize);
		ActionContext.getContext().put("lkm_name", lkm.getLkm_name());
		return "toLinkManList";
	}
	
	public LinkMan getModel() {
		return lkm;
	}

	public void setLkmService(LinkManService lkmService) {
		this.lkmService = lkmService;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
