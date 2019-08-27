package com.lxtech.ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxtech.ssh.dao.ManagerDao;
import com.lxtech.ssh.entity.Manager;
import com.lxtech.ssh.service.ManagerService;

@Service("managerService")
public class ManagerServiceIpml  extends BaseServiceImpl<Long, Manager> implements ManagerService{
	@Autowired
	private ManagerDao userDao;
}
