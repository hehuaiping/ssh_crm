package com.xh.dao;

import java.util.List;

import com.xh.domain.BaseDict;

public interface BaseDictDao extends BaseDao<BaseDict> {
	/**
	 * 根据字典类型获取字典集合
	 * @param dict_type_code 字典类型
	 * @return 返回符合类型的字典集合
	 */
	List<BaseDict> getBadeDictByTypeCode(String dict_type_code);

}
