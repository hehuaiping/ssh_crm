package com.xh.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xh.domain.User;
import com.xh.service.UserService;

import javassist.expr.NewArray;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	//模型驱动获取参数
	private User user = new User();
	private UserService userService;
	
	//用户登录
	public String login() throws Exception {
		//1、调用userService判断用户名密码正确
		User existU = userService.existUser(user);
		//2、将user存入Session域,重定向到主页
		ActionContext.getContext().getSession().put("user", existU);
		return "toHome";
	}

	//用户注册
	public String regist() throws Exception {
		//1、调用userService保存用户
		userService.save(user);
		//2、重定向到主页
		ActionContext.getContext().getSession().put("user", user);
		return "toHome";
	}
	
	public User getModel() {
		return user;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	
}
