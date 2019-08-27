package com.lxtech.ssh.test;

public class JobTest {
	private int i=1;
	public void send(){
		System.out.println("第"+i+"秒:任务执行了");
		i++;
	}
}
