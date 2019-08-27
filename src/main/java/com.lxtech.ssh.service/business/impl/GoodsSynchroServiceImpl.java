package com.lxtech.ssh.service.business.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxtech.ssh.entity.Associator;
import com.lxtech.ssh.entity.Product;
import com.lxtech.ssh.entity.ProductSales;
import com.lxtech.ssh.service.AssociatorService;
import com.lxtech.ssh.service.ProductSalesService;
import com.lxtech.ssh.service.ProductService;
import com.lxtech.ssh.service.business.GoodsSynchroService;
import com.lxtech.ssh.vo.ProductSaleInfo;

@Service("goodsSynchroService")
public class GoodsSynchroServiceImpl implements GoodsSynchroService{

	//private BaseDao<K, T> baseDao;
	@Autowired
	ProductSalesService productSaleService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	AssociatorService associatorService;
	
	@Override
	public void goodsSynchroService() {
		
		//模拟调用销售产品同步接口  并解析完毕  每一段时间内同步一次
		List<ProductSaleInfo> productSaleInfos = getSaleList();
		if(productSaleInfos == null || productSaleInfos.size()==0){//没有要同步的数据  直接结束
			
			return;
		}
		
		for(ProductSaleInfo psi : productSaleInfos){//不能直接saveAll(),因为此处是在做二次同步，如果直接saveAll()可能会保存相同数据
			String associatorId = psi.getAssociatorId();
			String timeTemp = psi.getTimeTemp();//和会员id组成 购买记录的唯一标识，推荐用翼支付数据库购买记录的id  目前用的是时间戳
			String productId = psi.getProductId();
			try {
				ProductSales ps = productSaleService.findByAssociationAndTime(associatorId,timeTemp);
				if(ps == null){//说明此条购买记录未保存  保存
					ps = new ProductSales();
					Associator associator = associatorService.findById(Long.parseLong(associatorId));
					Product product = productService.findById(Long.parseLong(productId));
					ps.setAmount(new BigDecimal(psi.getAmmount()));
					ps.setProduct(product);
					ps.setTimeTemp(psi.getTimeTemp());
					ps.setAssociator(associator);
					productSaleService.save(ps);
				}
				
			} catch (Exception e) {
				System.out.println("数据库异常");
			}
		}
		
	}
	
	public List<ProductSaleInfo> getSaleList(){
		return null;
	}
}
