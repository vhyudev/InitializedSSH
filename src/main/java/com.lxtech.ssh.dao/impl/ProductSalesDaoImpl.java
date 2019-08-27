package com.lxtech.ssh.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.lxtech.ssh.dao.ProductSalesDao;
import com.lxtech.ssh.entity.Associator;
import com.lxtech.ssh.entity.ProductSales;

@Repository("productSalesDao")
public class ProductSalesDaoImpl  extends BaseDaoImpl<Long, ProductSales> implements ProductSalesDao{

	public ProductSalesDaoImpl() {
		super(ProductSales.class);
		// TODO Auto-generated constructor stub
	}
	public ProductSales findByAssociationAndTime(Associator associator, String timeTemp) throws Exception {
		Session session = getSession();
		Criteria criteria = session.createCriteria(ProductSales.class);
		criteria.add(Restrictions.eq("associator", associator));
		criteria.add(Restrictions.eq("timeTemp", timeTemp));
		List<ProductSales> sales = criteria.list();
		if(sales == null || sales.size() == 0){
			return null;
		}
		return sales.get(0);
	}

}
