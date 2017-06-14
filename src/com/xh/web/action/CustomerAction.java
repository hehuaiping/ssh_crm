package com.xh.web.action;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xh.domain.Customer;
import com.xh.domain.User;
import com.xh.service.CustomerService;
import com.xh.utils.Page;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	public CustomerService custService;
	
	//模型驱动获取参数
	public Customer cust = new Customer();
	//属性驱动获取参数
	private Integer currentPage;
	private Integer pageSize;
	
	//添加客户
	public String addCustomer() throws Exception {
		//检查数据
		
		//1、调用custService保存客户
		cust.setCust_create_id(((User)ActionContext.getContext().getSession().get("user")).getUser_id());
		custService.saveCustomer(cust);
		//2、重定向到客户列表页面
		ActionContext.getContext().put("cust_name", cust.getCust_name());
		return "toCustList";
	}
	
	//查询客户列表
	public String getCustomerList() throws Exception {
		//1、创建离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		//2、判断有无查询条件
		if(cust.getCust_name() != null ) {
			dc.add(Restrictions.like("cust_name", "%"+cust.getCust_name()+"%"));
		}
		//当前页 每页显示多少条记录
		if( null == currentPage || currentPage <= 0) {
			currentPage = 1;
		}
		if( null == pageSize || pageSize < 0 ) {
			pageSize = 10;
		}
		//3、调用custService查询数据集合
		Page<Customer> page = custService.getCustomerList(dc,currentPage,pageSize);
		//4、跳转到客户列表页面
		ActionContext.getContext().put("page", page);
		return "custList";
	}
	
	//修改客户
	public String editCustomer() throws Exception {
		//1、调用custService获取当前客户
		Customer customer = custService.getCustomerById(cust.getCust_id());
		//2、转发到修改页面
		ActionContext.getContext().put("customer", customer);
		return "edit";
	}
	
	//更新客户
	public String updateCustomer() throws Exception {
		//1、调用custSerivce更新客户
		custService.updateCustomer(cust);
		//2、转发到客户列表页面
		ActionContext.getContext().put("cust_name", cust.getCust_name());
		return "toCustList";
	}
	
	//删除客户
	public String deleteCustomer() throws Exception {
		//1、调用custService删除客户
		custService.deleteCustomer(cust.getCust_id());
		return "custList";
	}
	
	//获取客户分析列表
	public String getIndustry() throws Exception {
		//1、调用custService删除客户
		List<Object[]> list = custService.getIndustryList();
		//2、将数据存入request域中
		//电子商务:3
		//房地产:1
		StringBuilder sb = new StringBuilder();
		for(Object[] obj : list ) {
			sb.append("['"+obj[0]+"',"+obj[1]+".0],");
		}
		String str = sb.substring(0, sb.length()-1);
		System.out.println(str);
		ActionContext.getContext().put("str", str);
		return "industry";
	}
	
	//获取客户分析列表
		public String getSource() throws Exception {
			//1、调用custService删除客户
			List<Object[]> list = custService.getSourceList();
			//2、将数据存入request域中
			//电子商务:3
			//房地产:1
			StringBuilder sb = new StringBuilder();
			for(Object[] obj : list ) {
				sb.append("['"+obj[0]+"',"+obj[1]+".0],");
			}
			String str = sb.substring(0, sb.length()-1);
			ActionContext.getContext().put("str", str);
			return "source";
		}
	
	public Customer getModel() {
		return cust;
	}



	public void setCustService(CustomerService custService) {
		this.custService = custService;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
}
