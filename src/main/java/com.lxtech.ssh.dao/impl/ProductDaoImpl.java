package com.lxtech.ssh.dao.impl;

import org.springframework.stereotype.Repository;

import com.lxtech.ssh.dao.ProductDao;
import com.lxtech.ssh.entity.Product;
@Repository("productDao")
public class ProductDaoImpl extends BaseDaoImpl<Long, Product> implements ProductDao {

	public ProductDaoImpl() {
		super(Product.class);
		// TODO Auto-generated constructor stub
	}

}
