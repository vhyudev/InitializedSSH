package com.lxtech.ssh.dao.impl;

import org.springframework.stereotype.Repository;

import com.lxtech.ssh.dao.PermissionDao;
import com.lxtech.ssh.entity.Permission;
@Repository("permissionDao")
public class PermissionDaoImpl extends BaseDaoImpl<Integer, Permission> implements PermissionDao {

	public PermissionDaoImpl() {
		super(Permission.class);
		
	}

}
