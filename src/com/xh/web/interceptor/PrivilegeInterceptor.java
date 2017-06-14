package com.xh.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class PrivilegeInterceptor extends MethodFilterInterceptor {
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//1、获取session中的user
		Object user = ActionContext.getContext().getSession().get("user");
		//2、判断user是否为空
		if(null == user ) {
			//用户未登录
			return "toLogin";
		} 
		//放行
		return invocation.invoke();
	}

}
