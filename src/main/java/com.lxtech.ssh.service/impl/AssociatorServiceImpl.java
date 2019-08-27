package com.lxtech.ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxtech.ssh.dao.AssociatorDao;
import com.lxtech.ssh.entity.Associator;
import com.lxtech.ssh.service.AssociatorService;
@Service("associatorService")
public class AssociatorServiceImpl extends BaseServiceImpl<Long, Associator> implements AssociatorService {
	@Autowired
	private AssociatorDao associatorDao;
}
