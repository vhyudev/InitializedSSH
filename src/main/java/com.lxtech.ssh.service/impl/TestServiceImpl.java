package com.lxtech.ssh.service.impl;

import org.springframework.stereotype.Service;

import com.lxtech.ssh.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	public String test() {
		return "test";
	}
}