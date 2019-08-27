package com.lxtech.ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lxtech.ssh.dao.AssociatorGradeDao;
import com.lxtech.ssh.entity.AssociatorGrade;
import com.lxtech.ssh.service.AssociatorGradeService;

@Repository("associatorGradeService")
public class AssociatorGradeServiceImpl extends BaseServiceImpl<Long, AssociatorGrade> implements AssociatorGradeService{

	@Autowired
	private AssociatorGradeDao associatorGradeDao;
}
