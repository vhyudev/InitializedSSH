package com.lxtech.ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxtech.ssh.dao.ProductSalesDao;
import com.lxtech.ssh.entity.Associator;
import com.lxtech.ssh.entity.ProductSales;
import com.lxtech.ssh.service.AssociatorService;
import com.lxtech.ssh.service.ProductSalesService;
@Service("productSalesService")
public class ProductSalesServiceImpl extends BaseServiceImpl<Long, ProductSales> implements ProductSalesService{
	
	@Autowired
	private ProductSalesDao productSalesDao;
	
	@Autowired
	private AssociatorService associatorService;
	
	public ProductSales findByAssociationAndTime(String associatorId, String timeTemp) throws Exception {
		Associator associator = associatorService.findById(Long.parseLong(associatorId));
		productSalesDao.findByAssociationAndTime(associator,timeTemp);
		return null;
	}
	
}
