package com.lxtech.ssh.dao;


import com.lxtech.ssh.entity.User;
import com.lxtech.ssh.util.QueryResult;

public interface UserDao extends BaseDao<Long, User> {
	public QueryResult<User> findByUserName(String userName, int sign);
}
