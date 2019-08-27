package com.lxtech.ssh.dao;

import com.lxtech.ssh.entity.Associator;
import com.lxtech.ssh.entity.ProductSales;

public interface ProductSalesDao extends BaseDao<Long, ProductSales> {

	public ProductSales findByAssociationAndTime(Associator associator, String timeTemp) throws Exception ;
}
