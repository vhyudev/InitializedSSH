package com.lxtech.ssh.service.business.impl;

import org.springframework.stereotype.Service;

import com.lxtech.ssh.dao.BaseDao;
import com.lxtech.ssh.service.business.GetGoodsListService;

@Service("getGoodsListService")
public class GetGoodsListServiceImpl implements GetGoodsListService{
	
	//private BaseDao<K, T> baseDao;
	@Override
	public String getGoodsList() {
		//模拟翼支付查询商品列表接口
		String goods = this.YipayGetGoodList();
		return goods;
	}
	
	//翼支付查询商品列表方法
	public String YipayGetGoodList(){
		
		return null;
	}

}
