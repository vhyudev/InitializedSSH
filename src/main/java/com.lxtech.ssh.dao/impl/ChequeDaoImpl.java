package com.lxtech.ssh.dao.impl;

import org.springframework.stereotype.Repository;
import com.lxtech.ssh.dao.ChequeDao;
import com.lxtech.ssh.entity.Cheque;

@Repository("chequeDao")
public class ChequeDaoImpl extends BaseDaoImpl<Long,  Cheque> implements  ChequeDao{

	public ChequeDaoImpl() {
		super(Cheque.class);
		// TODO Auto-generated constructor stub
	}

}
