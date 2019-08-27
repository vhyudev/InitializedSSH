package com.lxtech.ssh.dao;

import java.util.List;

import com.lxtech.ssh.entity.Hospital;

public interface HospitalDao extends BaseDao<Long, Hospital>{

	List<Hospital> getPgeListBydecitiion(String page, String name, String rank);

	int findcountByDecitidion(String name, String rank);

}
