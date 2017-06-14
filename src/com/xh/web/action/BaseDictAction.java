package com.xh.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xh.domain.BaseDict;
import com.xh.service.BaseDictService;

import net.sf.json.JSONArray;

public class BaseDictAction extends ActionSupport {
	private BaseDictService bdService;
	
	//属性驱动获取参数
	private String dict_type_code;
		
	@Override
	public String execute() throws Exception {
		//1、调用BaseService获取根据type_code获取字典对象list
		List<BaseDict> list = bdService.getBadeDictByTypeCode(dict_type_code);
		//2、将数据转换成json返回
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(JSONArray.fromObject(list).toString());
		return null;
	}

	public String getDict_type_code() {
		return dict_type_code;
	}

	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}

	public void setBdService(BaseDictService bdService) {
		this.bdService = bdService;
	}
	
	
	
}
