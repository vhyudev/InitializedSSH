package com.lxtech.ssh.dao.impl;

import org.springframework.stereotype.Repository;

import com.lxtech.ssh.dao.AssociatorDao;
import com.lxtech.ssh.dao.GenderDao;
import com.lxtech.ssh.entity.Associator;
import com.lxtech.ssh.entity.Gender;
@Repository("gendeDao")
public class GenderDaoImpl extends BaseDaoImpl<Long, Gender> implements GenderDao{

	public GenderDaoImpl() {
		super(Gender.class);
		// TODO Auto-generated constructor stub
	}

}
