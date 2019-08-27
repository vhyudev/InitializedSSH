package com.lxtech.ssh.dao.impl;

import org.springframework.stereotype.Repository;

import com.lxtech.ssh.dao.ManagerDao;
import com.lxtech.ssh.entity.Manager;
@Repository("managerDao")
public class ManagerDaoImpl extends BaseDaoImpl<Long, Manager> implements ManagerDao {

	
	public ManagerDaoImpl() {
		super(Manager.class);
	}

}
