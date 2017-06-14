package com.xh.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	/**
	 * 保存用户
	 * @param t 保存对象
	 */
	void save(T t);
	/**
	 * 保存或者更新
	 * @param t 保存对象
	 */
	void saveOrUpdate(T t);
	/**
	 * 删除
	 * @param t 删除对象
	 */
	void delete(T t);
	/**
	 * 根据ID删除
	 * @param id 删除对象的ID
	 */
	void delete(Serializable id);
	/**
	 * 更新
	 * @param t 更新对象
	 */
	void update(T t);
	/**
	 * 根据ID查询
	 * @param id id
	 * @return 返回查询到的对象
	 */
	T getById(Serializable id);
	/**
	 * 获取符合条件的总记录数
	 * @param dc 离线查询对象
	 * @return 返回符合条件的记录数
	 */
	Integer getTotalCount(DetachedCriteria dc);
	/**
	 * 查询分页数据
	 * @param dc 离线查询对象
	 * @param currentPage 当前页
	 * @param pageSize 每页显示多少条记录
	 * @return 返回查询到的数据集合
	 */
	List<T> getPageList(DetachedCriteria dc,Integer currentPage,Integer pageSize);
}
