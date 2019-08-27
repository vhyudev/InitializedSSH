package com.lxtech.ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxtech.ssh.dao.MenuDao;
import com.lxtech.ssh.entity.Menu;
import com.lxtech.ssh.service.MenuService;

@Service("menuService")
public class MenuServiceImpl extends BaseServiceImpl<Integer, Menu> implements MenuService{
	@Autowired
	private MenuDao menuDao;
}
