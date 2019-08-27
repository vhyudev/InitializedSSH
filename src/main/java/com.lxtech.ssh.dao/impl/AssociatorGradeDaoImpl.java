package com.lxtech.ssh.dao.impl;

import org.springframework.stereotype.Repository;

import com.lxtech.ssh.dao.AssociatorGradeDao;
import com.lxtech.ssh.entity.AssociatorGrade;
@Repository("ssociatorGradeDao")
public class AssociatorGradeDaoImpl extends BaseDaoImpl<Long, AssociatorGrade> implements AssociatorGradeDao{

	public AssociatorGradeDaoImpl() {
		super(AssociatorGrade.class);
		// TODO Auto-generated constructor stub
	}

}
