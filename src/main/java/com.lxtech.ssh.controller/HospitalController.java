package com.lxtech.ssh.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.lxtech.ssh.entity.Hospital;
import com.lxtech.ssh.service.HospitalService;
import com.lxtech.ssh.util.QueryResult;

@Controller
public class HospitalController {
	
	@Autowired
	private HospitalService hospitalService;
	/**
	 * 
	 * @return 跳转到医院信息列表
	 */
	@RequestMapping(value = "hospitalList", method = RequestMethod.GET)
	public String hospitalList(Model model,String page,String name,String rank) {
		if(null==page||"".equals(page)){
			page="1";
		}
		if(null==name||"".equals(page)){
			name="";
		}
		if(null==rank||"".equals(rank)){
			rank="0";
		}
		 
		List<Hospital> datas=hospitalService.getPgeListBydecitiion(page,name.trim(),rank);
		int totalCount = hospitalService.findcountByDecitidion(name.trim(),rank);
		int totalpage=totalCount%5==0?totalCount/5:totalCount/5+1;
		System.out.println(totalpage);
		model.addAttribute("curr",page);
		model.addAttribute("name",name);
		model.addAttribute("rank",rank);
		model.addAttribute("hp",datas);
		model.addAttribute("totalpage", totalpage);
		
		
		return "hospital/hospitalList";
	}
	/*
	 * 添加医院信息
	 */
	@RequestMapping(value = "addHospital", method = RequestMethod.GET)
	public String addHospital(HttpServletRequest request, Model model) throws Exception {
		return "hospital/addHospital";
	}
	
	/*
	 * 修改医院信息
	 */
	@RequestMapping("edithospital")
	public String EditHospital(HttpServletRequest request, Model model,Long id) throws Exception {
		Hospital hospital = hospitalService.findById(id);
		model.addAttribute("h",hospital);
		return "hospital/hospitalEdit";
	}

	/*
	 * 保存医院信息
	 */
	@RequestMapping("savehospital")
	@ResponseBody
	public String addorupdataHospital(Hospital hospital) throws Exception {
		hospitalService.saveOrUpdate(hospital);
		 return "ok";
	}
	
@RequestMapping("deletehospital")
	
	public String deleteHospital(Long id) throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(Hospital.class);
		hospitalService.deleteById(id);
		  return "redirect:/hospitalList"; 
	}
	
	/*
	 * 删除医院信息
	 
	@RequestMapping("deleteHospital.delete")
	@ResponseBody
	public ResponseEntity<String> deleteftp(HttpServletRequest request) throws Exception {
		JSONObject jsonObject = 
		return ;
	}
*/}
