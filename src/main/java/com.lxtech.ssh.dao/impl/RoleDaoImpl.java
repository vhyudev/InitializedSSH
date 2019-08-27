package com.lxtech.ssh.dao.impl;

import org.springframework.stereotype.Repository;

import com.lxtech.ssh.dao.RoleDao;
import com.lxtech.ssh.dao.UserDao;
import com.lxtech.ssh.entity.Role;
import com.lxtech.ssh.entity.User;
@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Integer, Role> implements RoleDao{
	public RoleDaoImpl() {
		super(Role.class);
	}
}
