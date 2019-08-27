package com.lxtech.ssh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lxtech.ssh.sms.IndustrySMS;

@Controller
public class AssociatorController {
	/**
	 * 跳转到 会员管理界面
	 * @return
	 */
	@RequestMapping("associatorlist")
	
		public String associatorlist(String page,Model model){
	    	if(null == page || "".equals(page) ){
	    		page="1";
	    	}
	    	model.addAttribute("curr",page);
	    	return "associatorList";
	    }
	
	/**
	 * 跳转到 会员详情界面
	 * @return
	 */
	@RequestMapping("associatorInfo")
	public String associatorInfo(){
    
    	return "associatorInfo";
    }

}

