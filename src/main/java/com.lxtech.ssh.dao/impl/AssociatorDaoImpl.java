package com.lxtech.ssh.dao.impl;


import org.springframework.stereotype.Repository;

import com.lxtech.ssh.dao.AssociatorDao;
import com.lxtech.ssh.entity.Associator;
@Repository("associatorDao")
public class AssociatorDaoImpl extends BaseDaoImpl<Long, Associator> implements AssociatorDao {

	public AssociatorDaoImpl() {
		super(Associator.class);
		// TODO Auto-generated constructor stub
	}

}
