package com.lxtech.ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxtech.ssh.dao.RoleDao;
import com.lxtech.ssh.dao.UserDao;
import com.lxtech.ssh.entity.Role;
import com.lxtech.ssh.entity.User;
import com.lxtech.ssh.service.RoleService;
import com.lxtech.ssh.service.UserService;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Integer, Role> implements RoleService{
	
	@Autowired
	private RoleDao roleDao;
}
