package com.lxtech.ssh.service.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxtech.ssh.dao.AssociatorDao;
import com.lxtech.ssh.dao.YipayAssociatorDao;
import com.lxtech.ssh.entity.User;
import com.lxtech.ssh.entity.YipayAssociator;
import com.lxtech.ssh.service.YipayAssociatorService;
import com.lxtech.ssh.util.QueryResult;

@Service("yipayAssociatorService")
public class YipayAssociatorServiceImpl extends BaseServiceImpl<Long, YipayAssociator> implements YipayAssociatorService{

	@Autowired
	private YipayAssociatorDao associatorDao;
	@Override
	public YipayAssociator findByYiId(String yiId) throws Exception{
		
		YipayAssociator yipayAssociator = associatorDao.findByYiId(yiId) ;
		
		return null;
	}

}
