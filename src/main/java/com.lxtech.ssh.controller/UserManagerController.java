package com.lxtech.ssh.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.alibaba.fastjson.JSONArray;
import com.lxtech.ssh.entity.Associator;
import com.lxtech.ssh.entity.Manager;
import com.lxtech.ssh.entity.Menu;
import com.lxtech.ssh.entity.Permission;
import com.lxtech.ssh.entity.Role;
import com.lxtech.ssh.entity.User;
import com.lxtech.ssh.service.AssociatorService;
import com.lxtech.ssh.service.ManagerService;
import com.lxtech.ssh.service.UserService;
import com.lxtech.ssh.util.Encrypt;
import com.lxtech.ssh.vo.MessegeDto;
import com.lxtech.ssh.vo.RegistDto;
import java.io.*;
@Controller
public class UserManagerController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private ManagerService manService;
	
	@Autowired
	private AssociatorService associatorService;
	
	@RequestMapping(value = "regist1")
	@ResponseBody
	public String regist( RegistDto registDto){
		
		//String username = request.getParameter("userName");
		//System.out.println(userName);
		return "test";
	}
	/**
	 * 注册
	 * @param registDto
	 * @return
	 */
	@RequestMapping(value = "regist")
	@ResponseBody
	public MessegeDto regist2(RegistDto registDto){
		MessegeDto mt = new MessegeDto();
		if(registDto == null){
			mt.setStatus("1");
			mt.setMessage("注册信息为空！请检查");
			return mt;
		}
		mt = userService.regist(registDto);
		return mt;
		
	}
//	@RequestMapping(value = "regist12")
//	public String regist1(HttpServletRequest request,RedirectAttributes attr){
//		String username = request.getParameter("username");
//		String idCardNo = request.getParameter("idCardNo");
//		String mobile = request.getParameter("mobile");
//		String sex = request.getParameter("sex");
//		String password = request.getParameter("password");
//		RegistDto registDto = new RegistDto();
//		registDto.setIdCardNo(idCardNo);
//		registDto.setUserName(username);
//		registDto.setMobile(mobile);
//		registDto.setPassword(password);
//		registDto.setSex(sex);
//		MessegeDto result = userService.regist(registDto);
//		if("0".equals(result.getStatus())){
//			return "redirect:testmvc";
//		}
//		return "error";
//	}
	/**
	 * 用户名验重
	 * @param registDto
	 * @return
	 */
	@RequestMapping(value = "userRepeat")
	@ResponseBody
	public MessegeDto  userRepeat(RegistDto registDto){	
		boolean result = userService.checkUser(registDto.getUserName(),0);
		MessegeDto mDto = new MessegeDto();
		if(result){
			mDto.setMessage("此用户名可以应用");
			mDto.setStatus("0");
			
		}else{
			mDto.setMessage("此用户名已被使用");
			mDto.setStatus("1");
		}
//		if(false){
//			ModelAndView ModelAndView = new ModelAndView(new MappingJackson2JsonView());
//			ModelAndView.addObject("aaa","{\"aaa\":\"bbb\"}");
//			return ModelAndView;
//		}
		//ModelAndView ModelAndView = new ModelAndView("login");	
		return mDto;
	}
	
	/**
	 * 
	 * @return 跳转到登录页面
	 */
	@RequestMapping(value = "toLoginView", method = RequestMethod.GET)
	public String main() {
		return "login";
	}

	/**
	 * 查询当前管理员下的菜单,以json格式返回
	 * 
	 * @return json格式的菜单
	 */
	@RequestMapping(value = "findMenus")
	
	public void findMenus(HttpServletResponse response) {
		// 用于存放菜单数据的集合
		List<Menu> list = new ArrayList<>();
		Subject subject = SecurityUtils.getSubject();
		User u = (User) subject.getPrincipal();
		Manager manager = u.getManager();
		Set<Role> roles = manager.getRoles();
		for (Role role : roles) {
			for (Permission p : role.getPermissions()) {
				for (Menu m : p.getMemus()) {
					list.add(m);
				}
			}
		}
		String menuJson = JSONArray.toJSON(list).toString();
		try {
			response.getWriter().write(menuJson);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * 
	 * @param sign 是 标记会员登录 或者  管理员登录
	 * @param model
	 * @param username
	 * @param password
	 * @param session
	 * @param res
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "login")
	
	public String login(String sign ,Model model, String username, String password, HttpSession session,HttpServletResponse res,HttpServletRequest req) {
		// System.out.println(username);
		// System.out.println(password);

		Subject subject = SecurityUtils.getSubject(); // 当前对象

		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		if(null == sign||"".equals(sign)){
			sign="back";//后台登录标记
		}
		// 登录
		try {
			subject.login(token); // 它会自动执行配置的realm中的doGetAuthenticationInfo

			// 将当前用户信息存放到session中；subject.getPrincipal()从shiro中获取查询到的用户对象
			session.setAttribute("userInfo", subject.getPrincipal());
			if("app".equals(sign)){//app 是前台登录标记
				req.setAttribute("success", "yes");
				return "forward:/app";
			}else{
			return "backManagement";
			}
		} catch (Exception e) {
			e.printStackTrace();
			if("app".equals(sign)){
				req.setAttribute("success", "no");
				return "forward:/app";
			}else{
				return "login";
			}
			
		}

	}
	//请求转发返回json
	@RequestMapping("/app")
	@ResponseBody
	public String aaa(HttpServletRequest req){
		Object attribute = req.getAttribute("success");
		return (String)attribute;
	}
	
}
