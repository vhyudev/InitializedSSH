package com.lxtech.ssh.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lxtech.ssh.entity.Gender;
import com.lxtech.ssh.entity.Manager;
import com.lxtech.ssh.entity.Menu;
import com.lxtech.ssh.entity.Permission;
import com.lxtech.ssh.entity.Role;
import com.lxtech.ssh.entity.User;
import com.lxtech.ssh.service.ManagerService;
import com.lxtech.ssh.service.MenuService;
import com.lxtech.ssh.service.PermissionService;
import com.lxtech.ssh.service.RoleService;
import com.lxtech.ssh.service.UserService;
import com.lxtech.ssh.util.Encrypt;
import com.lxtech.ssh.util.QueryResult;

public class ShrioTest {

	ApplicationContext ac = null;

	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	//添加两个管理员 admin1 和  admin2
	public void test1() {
	
		ManagerService mser = (ManagerService) ac.getBean("managerService");
		
		//添加两个管理员 admin1 和  admin2
		Manager admin1 = new  Manager();
		admin1.setName("小红");
		
		
		User userAdmin1= new User();
		Gender gender = new Gender();
		
		gender.setGenderName("女");
		gender.setGenderCode("0");
		
		
		userAdmin1.setUsername("admin2");
		userAdmin1.setPassword(Encrypt.md5("123", "admin2"));
		
		admin1.setUser(userAdmin1);
		admin1.setGender(gender);
		mser.saveOrUpdate(admin1);
		
		
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	//添加两个权限 permission1 和  permission2
	public void test2() {
	
		PermissionService pser = (PermissionService) ac.getBean("permissionService");

		Permission perm1= new Permission();
		perm1.setName("读权限读读读");

		
		Permission perm2= new Permission();
		perm2.setName("写权限写写写");
	
		pser.save(perm1);
		pser.save(perm2);
		
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	//添加两个角色 role1 和  role2
	public void test3() {
	
		RoleService rser= (RoleService) ac.getBean("roleService");
		
		Role role1 = new Role();
		role1.setName("角色11111");
		
		Role role2 = new Role();
		role2.setName("角色22222");
		
		rser.save(role1);
		rser.save(role2);
		
		
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	//添加四个菜单  menu1,menu2,menu3,meun4
	public void test4() {
	
		MenuService mser= (MenuService) ac.getBean("menuService");
		Menu menu1= new Menu();
		Menu menu2= new Menu();
		Menu menu3= new Menu();
		Menu menu4= new Menu();
		
		menu1.setName("菜单1");
		menu2.setName("菜单2");
		menu3.setName("菜单3");
		menu4.setName("菜单4");
	
		mser.save(menu1);
		mser.save(menu2);
		mser.save(menu3);
		mser.save(menu4);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	//给管理员制定角色---------------------------
	public void test5() {
		ManagerService mser = (ManagerService) ac.getBean("managerService");
		RoleService rser= (RoleService) ac.getBean("roleService");
		List<Role> roles = rser.loadAll().getDatas();
		
		QueryResult<Manager> results = mser.loadAll();
		List<Manager> managers = results.getDatas();
		Set<Role> set1 = new HashSet<>();
		set1.add(roles.get(0));
		
		Set<Role> set2 = new HashSet<>();
		set2.add(roles.get(1));
		managers.get(0).setRoles(set1);
		managers.get(1).setRoles(set2);
		
		
		//mser.save(managers.get(0));
		//mser.save(managers.get(1));
		mser.saveOrUpdate(managers.get(0));
		mser.saveOrUpdate(managers.get(1));
		
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	//给角色制定权限
	public void test6() {
		PermissionService pser = (PermissionService) ac.getBean("permissionService");
		RoleService rser= (RoleService) ac.getBean("roleService");
		List<Role> roles = rser.loadAll().getDatas();
		List<Permission> permissions = pser.loadAll().getDatas();
		
	
		Set<Permission> set1 = new HashSet<>();
		set1.add(permissions.get(0));
		
		Set<Permission> set2 = new HashSet<>();
		set2.add(permissions.get(1));
		roles.get(0).setPermissions(set1);
		roles.get(1).setPermissions(set2);
		
		
		//mser.save(managers.get(0));
		//mser.save(managers.get(1));
		rser.saveOrUpdate(roles.get(0));
		rser.saveOrUpdate(roles.get(1));
		
		
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	//权限分配菜单
	public void test7() {
		PermissionService pser = (PermissionService) ac.getBean("permissionService");
		List<Permission> permissions = pser.loadAll().getDatas();
		MenuService mser= (MenuService) ac.getBean("menuService");
		List<Menu> menus = mser.loadAll().getDatas();
		 Menu menu1=menus.get(0);
		 Menu  menu2=menus.get(1);
		 Menu  menu3=menus.get(2);
		 Menu  menu4=menus.get(3);
	
		Set<Menu> set1 = new HashSet<>();
		set1.add(menu1);
		set1.add(menu2);
		set1.add(menu3);
		
		Set<Menu> set2 = new HashSet<>();
		set2.add(menu4);
		
		permissions.get(0).setMemus(set1);
		permissions.get(1).setMemus(set2);
		
		pser.saveOrUpdate(permissions.get(0));
		pser.saveOrUpdate(permissions.get(1));
		
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	//测试通过管理员id查询出该用户需要显示的菜单
	public void test8() {
		ManagerService mser = (ManagerService) ac.getBean("managerService");
		Manager manager = mser.findById(32l);
		Set<Role> roles = manager.getRoles();
		for(Role role : roles){
			for(Permission p:role.getPermissions()){
				for(Menu m:p.getMemus()){
					System.out.println(m.getName());
				}
			}
		}
		
	}
	@Test
	public void test9(){
		UserService ser = (UserService)ac.getBean("userService");
		QueryResult<User> result = ser.getScrollData(-1, -1,"o.username=?", new String[]{"admin1"});
		User user = result.getDatas().get(0);
		System.out.println(user);
	}
}
