package com.lxtech.ssh.service.business;

import java.math.BigDecimal;

/**
 *发生押金垫付后,应急平台把被服务对象的相关信息(比如 会员id 商品id 垫付金额等)通过消息队列发布出去;
 *翼支付订阅后作出相应的业务处理
 */
public interface PayForSbNoticeService {
	public void  payForSbNotice(Long associatorId, String orderid, BigDecimal amount);
		//推送给翼支付
}
