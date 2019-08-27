package com.lxtech.ssh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoodsController {
	 //商品管理跳转
    @RequestMapping("/goodlist")
    public String goodlist(String page,Model model){
    	if(null == page || "".equals(page) ){
    		page="1";
    		//一下进行分页的业务逻辑
    	}
    	model.addAttribute("curr",page);
    	return "goodsList";
    }
    
    //商品详情跳转
    @RequestMapping("/goodsInfo")
    public String goodsInfo(){
    	
    	//业务逻辑处理
    	return "goodsInfo";
    }
    
    //商品编辑跳转 
    @RequestMapping("/goodsEdit")
    public String goodsEdit(){
    	
    	//业务逻辑处理
    	return "goodsEdit";
    }
}
