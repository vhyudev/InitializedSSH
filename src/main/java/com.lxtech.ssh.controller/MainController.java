package com.lxtech.ssh.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxtech.ssh.dao.BaseDao;
import com.lxtech.ssh.entity.Menu;
import com.lxtech.ssh.entity.User;
import com.lxtech.ssh.service.BaseService;
import com.lxtech.ssh.service.TestService;
import com.lxtech.ssh.service.UserService;


@Controller
public class MainController {
	
	@Autowired
    private TestService testService;
	@Autowired
	private BaseDao<Integer, Menu> mservice;
	
    @RequestMapping(value = "testmvc", method = RequestMethod.GET)
    public String test(){
       //实际返回的是views/test.jsp ,spring-mvc.xml中配置过前后缀
    	return "forward:/login";
       // return "test";
    }
    
    @RequestMapping(value = "testspring", method = RequestMethod.GET)
    public void testSpring(){
    	Menu findById = mservice.findById(28);
    	System.out.println(findById.getName());
       // return testService.test();
    }
    
    @RequestMapping(value = "main1", method = RequestMethod.GET)
    public String main(){
        return "main";
    }
    
   @RequestMapping(value = "toRegist", method = RequestMethod.GET)
    public String regist(){
        return "regist";
    }
    
    @RequestMapping(value = "testssh", method = RequestMethod.GET)
    public String testSSH(){
//    	System.out.println("yes it is");
//    	ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
//        UserService ser = (UserService)ac.getBean("userService");
//    	User user = ser.findById(1);
//    	System.out.println(user.getUsername());
    	return "testSSH";
    }
    
    //跳转到系统首页面--个人工作平台
    @RequestMapping("/guid")
    public String sss(){
    	
    	return "guid";
    }
    
    @RequestMapping("/weichart")
    @ResponseBody
    public String weichart(String x,String y,HttpServletResponse res){
    	res.setContentType("text/html;charset=utf-8");
    	return x+y;
    }
    
    @RequestMapping("/abcd")
    
   public void function1(HttpServletResponse rs) throws IOException{
    	//rs.setHeader("Access-Control-Allow-Origin", "*"); 
	   rs.getWriter().write("1");
   }
}
