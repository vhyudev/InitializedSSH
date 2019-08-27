package com.lxtech.ssh.service;

import java.util.List;

import com.lxtech.ssh.entity.Hospital;

public interface HospitalService extends BaseService<Long, Hospital>{

	List<Hospital> getPgeListBydecitiion(String page, String name, String rank);

	int findcountByDecitidion(String name, String rank);

}
