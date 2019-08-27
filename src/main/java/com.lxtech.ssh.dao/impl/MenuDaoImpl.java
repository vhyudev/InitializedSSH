package com.lxtech.ssh.dao.impl;

import org.springframework.stereotype.Repository;

import com.lxtech.ssh.dao.MenuDao;
import com.lxtech.ssh.entity.Menu;

@Repository("menuDao")
public class MenuDaoImpl extends BaseDaoImpl<Integer, Menu> implements MenuDao{
	public MenuDaoImpl() {
		super(Menu.class);
	}
}
