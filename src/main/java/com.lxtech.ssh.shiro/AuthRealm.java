package com.lxtech.ssh.shiro;



import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxtech.ssh.entity.Manager;
import com.lxtech.ssh.entity.Permission;
import com.lxtech.ssh.entity.Role;
import com.lxtech.ssh.entity.User;
import com.lxtech.ssh.service.ManagerService;
import com.lxtech.ssh.service.UserService;
import com.lxtech.ssh.util.QueryResult;


public class AuthRealm extends AuthorizingRealm {
	@Autowired
	private UserService user;
	@Autowired
	private ManagerService mser;

	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		System.out.println("授权");
		User user = (User) pc.fromRealm(this.getName()).iterator().next();//根据realm的名字去找对应的realm
		int sign = user.getSign();
		//会员不授权
		if(sign==1){
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			info.addStringPermission("会员不涉及权限");
			//添加用户的模块（权限）
			
			return info;
		}
		List<String> permissions = new ArrayList<String>();
		Manager manager = mser.findById(user.getManager().getId());
		Set<Role > roles = manager.getRoles();
		if(null == roles||roles.size()==0){
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
				
			return info;
		}
	
		for(Role role :roles){
			//遍历每个角色 
			Set<Permission> listPermission = role.getPermissions();//得到每个角色下的权限列表
			if(null !=listPermission&&listPermission.size()>0){
				for(Permission p :listPermission){
					permissions.add(p.getName());
				}
			}
			
		}
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(permissions);
		return info;
	}
	//认证   token 代表用户在界面输入的用户名和密码
	
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("认证");
		
		//1.向下转型
		UsernamePasswordToken upToken  = (UsernamePasswordToken) token;
		
		//2.调用业务方法，实现根据用户名查询
		String hql = "o.username=?";
		QueryResult<User> result = user.getScrollData(-1, -1, hql, new String[]{upToken.getUsername()});
		List<User> list = result.getDatas();
		
		if(list!=null && list.size()>0){
			User user = list.get(0);
			AuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
			return info;  
		}
		
		return null;
	}
	
}
