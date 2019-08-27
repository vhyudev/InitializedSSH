package com.lxtech.ssh.test;





import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.lxtech.ssh.entity.User;
import com.lxtech.ssh.service.UserService;
import com.lxtech.ssh.util.QueryResult;


public class SSHTest {
	
    ApplicationContext ac = null;
	
    @Before
	public void init(){
		ac = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	}
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test1(){
		UserService ser = (UserService)ac.getBean("userService");
		QueryResult<User> queryResult = ser.loadAll();
		for (Object object : queryResult.getDatas()) {
			System.out.println(object);
		}
		System.out.println(queryResult.getTotalCount());
		
	}
    
    @Test
    public void function(){
    	Logger.getRootLogger().info("heheda");
    }
    
}
