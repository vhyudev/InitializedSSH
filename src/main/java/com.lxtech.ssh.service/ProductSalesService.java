package com.lxtech.ssh.service;

import com.lxtech.ssh.entity.ProductSales;

public interface ProductSalesService extends BaseService<Long, ProductSales>{
	
	public ProductSales findByAssociationAndTime(String associatorId, String timeTemp) throws Exception;
}
