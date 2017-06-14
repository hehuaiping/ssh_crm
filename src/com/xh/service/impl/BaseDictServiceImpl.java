package com.xh.service.impl;

import java.util.List;

import com.xh.dao.BaseDictDao;
import com.xh.domain.BaseDict;
import com.xh.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {
	private BaseDictDao bdDao;
	
	public List<BaseDict> getBadeDictByTypeCode(String dict_type_code) {
		return bdDao.getBadeDictByTypeCode(dict_type_code);
	}

	public void setBdDao(BaseDictDao bdDao) {
		this.bdDao = bdDao;
	}

	
}
