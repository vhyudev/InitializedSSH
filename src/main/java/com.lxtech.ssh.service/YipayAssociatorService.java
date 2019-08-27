package com.lxtech.ssh.service;

import com.lxtech.ssh.entity.YipayAssociator;

public interface YipayAssociatorService extends BaseService<Long, YipayAssociator>{
	public YipayAssociator findByYiId(String yiId) throws Exception;
}
