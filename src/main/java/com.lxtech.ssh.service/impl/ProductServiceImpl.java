package com.lxtech.ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lxtech.ssh.dao.ProductDao;
import com.lxtech.ssh.entity.Product;
import com.lxtech.ssh.service.ProductService;
@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Long, Product> implements ProductService{
	@Autowired
	private ProductDao productDao;
}
