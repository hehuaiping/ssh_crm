package com.xh.service;

import com.xh.domain.User;

public interface UserService {
	/**
	 * 保存用户
	 * @param u
	 */
	void save(User u);
	/**
	 * 检查用户名密码是否正确
	 * @param user
	 * @return 
	 */
	User existUser(User user);
}
