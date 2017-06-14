package com.xh.service.impl;

import com.xh.dao.UserDao;
import com.xh.domain.User;
import com.xh.service.UserService;
import com.xh.utils.MD5Utils;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	public void save(User u) {
		//1、调用userDao查询该用户是否存在
		if(userDao.getUserByCode(u.getUser_code()) == null) {
			u.setUser_password(MD5Utils.md5(u.getUser_password()));
			userDao.save(u);
		}else {
			 //用户已存在
			throw new RuntimeException("用户名已存在，请您输入新的用户名！");
		}
	}

	public User existUser(User user) {
		//1、调用userDao根据用户名获取User的方法
		User existU = userDao.getUserByCode(user.getUser_code());
		//2、判断user是否为空
		if(null == existU ) {
		    //如果为空 抛出异常
			throw new RuntimeException("该用户不存在！");
		}
		//3、如果不为空判断密码是否正确
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		if(!existU.getUser_password().equals(user.getUser_password())) {
			throw new RuntimeException("用户名或密码错误，请您重新登录");
		}
		//4、用户名密码无误 返回用户
		return existU;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
}
