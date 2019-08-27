package com.lxtech.ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lxtech.ssh.dao.HospitalDao;
import com.lxtech.ssh.entity.Hospital;
import com.lxtech.ssh.service.HospitalService;
@Repository("hospitalService")
public class HospitalServiceImpl extends BaseServiceImpl<Long, Hospital> implements HospitalService{
	@Autowired
	private HospitalDao hospitalDao;

	@Override
	public List<Hospital> getPgeListBydecitiion(String page, String name, String rank) {
		// TODO Auto-generated method stub
		String hql= "1=1";
		if(!("".equals(name))){
			hql=hql+" and o.name like '%"+name+"%'";
		}
		if(!("0".equals(rank))){
			hql=hql+" and o.rank ="+rank;

		}
		//return hospitalDao.getPgeListBydecitiion(page,name,rank);
		return hospitalDao.getScrollData((Integer.parseInt(page)-1)*5, 5, hql, null).getDatas();
	}

	@Override
	public int findcountByDecitidion(String name, String rank) {
		// TODO Auto-generated method stub
		
		
		return hospitalDao.findcountByDecitidion(name,rank);
	}
}
