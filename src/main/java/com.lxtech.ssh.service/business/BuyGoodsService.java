package com.lxtech.ssh.service.business;

import java.math.BigDecimal;

/**
 *调用翼支付的购买服务,平台传入 商品id 和  购买的会员id;
 *翼支付后台处理完成后,返回json格式的商品详细信息和购买人的信息
 */
public interface BuyGoodsService {
	public String buyGoods(String goodsId, Long associatorId, BigDecimal count);
}
