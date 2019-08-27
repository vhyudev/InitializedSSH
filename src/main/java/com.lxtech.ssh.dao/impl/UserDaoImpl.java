package com.lxtech.ssh.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.lxtech.ssh.dao.UserDao;
import com.lxtech.ssh.entity.User;
import com.lxtech.ssh.util.QueryResult;


@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<Long, User> implements UserDao {

	public UserDaoImpl() {
		super(User.class);
	}
	/**
	 * 管理员查重
	 */
	public QueryResult<User> findByUserName(String userName,int sign){
		Session session = getSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("username", userName));
		criteria.add(Restrictions.eq("sign", sign));
		QueryResult<User> result = new QueryResult<>();
		System.out.println(criteria.list().size());
		result.setDatas(criteria.list());
		result.setTotalCount(Long.parseLong(criteria
				.setProjection(Projections.rowCount()).uniqueResult()
				.toString()));
		return result;
	}

}
