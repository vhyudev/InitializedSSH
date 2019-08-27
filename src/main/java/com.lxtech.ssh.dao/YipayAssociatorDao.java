package com.lxtech.ssh.dao;

import com.lxtech.ssh.entity.YipayAssociator;

public interface YipayAssociatorDao extends BaseDao<Long, YipayAssociator>{
	public YipayAssociator findByYiId(String yiId) throws Exception;
}
