package com.lxtech.ssh.dao.impl;

import org.springframework.stereotype.Repository;

import com.lxtech.ssh.dao.AssociatorTypeDao;
import com.lxtech.ssh.entity.AssociatorType;
@Repository("associatorTypeDao")
public class AssociatorTypeDaoImpl extends BaseDaoImpl<Long, AssociatorType> implements AssociatorTypeDao{

	public AssociatorTypeDaoImpl() {
		super(AssociatorType.class);
		// TODO Auto-generated constructor stub
	}

}
