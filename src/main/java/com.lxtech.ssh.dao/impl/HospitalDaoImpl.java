package com.lxtech.ssh.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.criterion.MatchMode;

import org.hibernate.criterion.Restrictions;

import org.springframework.stereotype.Repository;

import com.lxtech.ssh.dao.HospitalDao;
import com.lxtech.ssh.entity.Hospital;
@Repository("hospitalDao")
public class HospitalDaoImpl extends BaseDaoImpl<Long, Hospital> implements HospitalDao{
	public HospitalDaoImpl() {
		super(Hospital.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Hospital> getPgeListBydecitiion(String page, String name, String rank) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Criteria ct = session.createCriteria(Hospital.class);
		ct.setFirstResult((Integer.parseInt(page)-1)*5);
		ct.setMaxResults(5);
		if(!("".equals(name))){
			ct.add(Restrictions.like("name", name,MatchMode.ANYWHERE));
		}
		if(!("0".equals(rank))){
			ct.add(Restrictions.eq("rank",Integer.parseInt(rank)));
		}
		
		return ct.list();
	}

	@Override
	public int findcountByDecitidion(String name, String rank) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql="select count(*) from Hospital where 1=1 ";
		if(!("".equals(name))){
			hql=hql+" and name like '%"+name+"%'";
		}
		if(!("0".equals(rank))){
			hql=hql+" and rank ="+rank;

		}
		
		Query query = session.createQuery(hql);
		long uniqueResult = (long)query.uniqueResult();
		//注释
		return (int)uniqueResult;
	}

}
