package com.online.cms.read.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
import com.online.cms.read.dao.ElectronBookMapper;
import com.online.cms.read.domain.ElectronBook;
import com.online.cms.read.service.ElectronBookService;
import com.online.commons.dao.BaseDao;
import com.online.commons.service.impl.BaseServiceImpl;

/**
 * 电子书Service实现类
 * @author Willdas
 *
 */
@Service
@Transactional
public class ElectronBookServiceImpl extends BaseServiceImpl<ElectronBook> implements ElectronBookService {

	@Autowired
	private ElectronBookMapper electronBookDao;
	
	@Override
	public void delete(List<ElectronBook> entities) {
	}

	@Override
	protected BaseDao<ElectronBook, String> baseDao() {
		return electronBookDao;
	}

}
