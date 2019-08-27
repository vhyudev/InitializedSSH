package com.lxtech.ssh.service.business.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxtech.ssh.entity.Associator;
import com.lxtech.ssh.entity.Product;
import com.lxtech.ssh.entity.ProductSales;
import com.lxtech.ssh.service.AssociatorService;
import com.lxtech.ssh.service.ProductSalesService;
import com.lxtech.ssh.service.ProductService;
import com.lxtech.ssh.service.business.BuyGoodsService;
import com.lxtech.ssh.vo.ProductSaleInfo;

@Service("buyGoodsService")
public class BuyGoodsServiceImpl implements BuyGoodsService{
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductSalesService productSalesService;
	
	@Autowired
	AssociatorService associatorService;


	public String buyGoods(String goodsId, Long associatorId,BigDecimal count) {
		// TODO Auto-generated method stub
		//模拟调用翼支付接口接收返回信息
		ProductSaleInfo productSaleInfo = getSaleInfo( goodsId, associatorId);
		//保存翼支付返回的信息   此处要不要进行非空校验？   此处也可用书写sql实现，
		Associator associator = associatorService.findById(Long.parseLong(productSaleInfo.getAssociatorId()));
		Product product = productService.findById(Long.parseLong(productSaleInfo.getProductId()));
		ProductSales productSales = new ProductSales();
		productSales.setAmount(new BigDecimal(productSaleInfo.getAmmount()==null||"".equals(productSaleInfo.getAmmount())?"0.00":productSaleInfo.getAmmount()));
		productSales.setAssociator(associator);
		productSales.setProduct(product);
		productSales.setSaleDate(new Date());
		//购买产品时的时间戳   联合会员id 确保一条购买记录的唯一性,目前商量让翼支付传回一个唯一性标志字段id
		productSales.setTimeTemp(productSaleInfo.getTimeTemp());
		productSalesService.save(productSales);
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public ProductSaleInfo getSaleInfo(String goodsId, Long associatorId){
		return null;
	}

	
	
}
