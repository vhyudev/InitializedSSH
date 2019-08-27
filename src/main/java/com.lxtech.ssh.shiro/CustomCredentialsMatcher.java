package com.lxtech.ssh.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import com.lxtech.ssh.util.Encrypt;

/*
 * 密码比较器
 */
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {


	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
	
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		
		//密码比对
		//前台输入的密码
		Object pwd = Encrypt.md5(new String(upToken.getPassword()), upToken.getUsername());
		
		//数据库中的密码
		Object dbPwd = info.getCredentials();
		
		return this.equals(pwd, dbPwd);
	}

	
}
