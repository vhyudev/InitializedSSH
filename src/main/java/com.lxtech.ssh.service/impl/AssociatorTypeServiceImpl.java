package com.lxtech.ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lxtech.ssh.dao.AssociatorTypeDao;
import com.lxtech.ssh.entity.AssociatorType;
import com.lxtech.ssh.service.AssociatorTypeService;
@Repository("associatorTypeService")
public class AssociatorTypeServiceImpl extends BaseServiceImpl<Long, AssociatorType> implements AssociatorTypeService{
	@Autowired
	private AssociatorTypeDao associatorTypeDao;
}
