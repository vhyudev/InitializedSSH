package com.lxtech.ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxtech.ssh.dao.PermissionDao;
import com.lxtech.ssh.entity.Permission;
import com.lxtech.ssh.service.PermissionService;
@Service("permissionService")
public class PermissionServiceImpl extends BaseServiceImpl<Integer, Permission> implements PermissionService {
	@Autowired
	private PermissionDao permissionDao;

}
