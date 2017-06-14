package com.xh.dao;

import com.xh.domain.User;

public interface UserDao extends BaseDao<User> {
	/**
	 * 根据用户名获取用户
	 * @param user_code 用户名
	 * @return
	 */
	User getUserByCode(String user_code);

}
