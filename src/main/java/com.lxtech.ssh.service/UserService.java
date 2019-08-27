package com.lxtech.ssh.service;


import com.lxtech.ssh.entity.User;
import com.lxtech.ssh.vo.MessegeDto;
import com.lxtech.ssh.vo.RegistDto;

public interface UserService extends BaseService<Long, User> {

	public MessegeDto regist(RegistDto registDto);
	
	public boolean checkUser(String userName, int sign);

}
