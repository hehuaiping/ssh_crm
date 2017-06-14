package com.xh.service;

import org.hibernate.criterion.DetachedCriteria;

import com.xh.domain.Customer;
import com.xh.domain.LinkMan;
import com.xh.utils.Page;

public interface LinkManService {
	/**
	 * 保存联系人
	 * @param lkm 联系人
	 */
	void saveLinkMan(LinkMan lkm);
	/**
	 * 获取符合条件的数据列表
	 * @param dc 离线查询对象
	 * @param currentPage 当前页
	 * @param pageSize 每页显示多少条数据
	 * @return	返回符合条件的数据列表
	 */
	Page<LinkMan> getlinkManList(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	/**
	 * 根据联系人ID获取联系人
	 * @param lkm_id 联系人ID
	 * @return	返回查询到的联系人
	 */
	LinkMan getLinkManById(Long lkm_id);
	/**
	 * 更新联系人
	 * @param lkm 联系人
	 */
	void updateLinkMan(LinkMan lkm);
	/**
	 * 删除联系人
	 * @param long1 联系人
	 */
	void deleteLinkMan(Long long1);

}
