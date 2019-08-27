package com.lxtech.ssh.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.lxtech.ssh.entity.Associator;
import com.lxtech.ssh.entity.YipayAssociator;
import com.lxtech.ssh.service.AssociatorService;
import com.lxtech.ssh.service.YipayAssociatorService;
import com.lxtech.ssh.service.business.CheckOpenYipayService;
import com.lxtech.ssh.vo.CheckOpenYipayInfo;
import com.lxtech.ssh.vo.YipayAssociatorInfo;
@Service("checkOpenYipayService")
public class CheckOpenYipayServiceImpl implements CheckOpenYipayService{
	
	@Autowired
	private YipayAssociatorService yipayAssociatorService;
	
	@Autowired
	private AssociatorService associatorService;
	
	@Override
	public boolean checkOpenYipay(String associatoreInfo) {
		// TODO Auto-generated method 
		YipayAssociatorInfo yipayAssociatorInfo = null;
		//模拟调用翼支付接口 并解析完毕
		CheckOpenYipayInfo checkOpenYipayInfo = getCheckInfo(associatoreInfo);
		if("0".equals(checkOpenYipayInfo.getStatus())){//已开通
			yipayAssociatorInfo = checkOpenYipayInfo.getYipayAssociatorInfo();//翼支付返回的翼支付会员信息
			
			String yiId = yipayAssociatorInfo.getYiId();
			YipayAssociator yipayAssociator = null;
			long nativeId = yipayAssociatorInfo.getId();
			Associator associator = associatorService.findById(nativeId);
			try {
				yipayAssociator = yipayAssociatorService.findByYiId(yiId);
				if(yipayAssociator == null){//之前未保存过，必须保存
					yipayAssociator = new YipayAssociator();
					yipayAssociator.setAge(yipayAssociatorInfo.getAge());
					yipayAssociator.setIdCardNo(yipayAssociatorInfo.getIdCardNo());
					yipayAssociator.setMobile(yipayAssociatorInfo.getMobile());
					yipayAssociator.setYiId(yiId);
					yipayAssociator.setAssociator(associator);
					yipayAssociatorService.save(yipayAssociator);
					
				}else{//问题一：之前有保存过这个会员信息  此时要不要更新本地数据库？待商议  。问题二:如果国本会员和翼支付会员信息不完全匹配，要不要更改国本本地会员信息？
					
				}
			} catch (Exception e) {
				
			}
			//之后导入翼支付的信息到前端界面
			
			
		}else if("1".equals(checkOpenYipayInfo.getStatus())){//未开通
			System.out.println("尚未开通翼支付");
		}
		return false;
	}
	
	public CheckOpenYipayInfo getCheckInfo(String associatoreInfo){
		return null;
	}
}

