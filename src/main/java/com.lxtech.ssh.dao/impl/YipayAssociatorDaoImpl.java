package com.lxtech.ssh.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.lxtech.ssh.dao.YipayAssociatorDao;
import com.lxtech.ssh.entity.User;
import com.lxtech.ssh.entity.YipayAssociator;
import com.lxtech.ssh.util.QueryResult;

@Repository("yipayAssociator")
public class YipayAssociatorDaoImpl extends BaseDaoImpl<Long, YipayAssociator> implements YipayAssociatorDao{

	public YipayAssociatorDaoImpl() {
		super(YipayAssociator.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public YipayAssociator findByYiId(String yiId) throws Exception {
		Session session = getSession();
		Criteria criteria = session.createCriteria(YipayAssociator.class);
		criteria.add(Restrictions.eq("yiId", yiId));
		List<YipayAssociator> lsit= criteria.list();
		YipayAssociator yipayAssociator = null;
		if(lsit != null && lsit.size()!=0){
			yipayAssociator =  lsit.get(0);
		}
		
		return yipayAssociator;
	}

}
