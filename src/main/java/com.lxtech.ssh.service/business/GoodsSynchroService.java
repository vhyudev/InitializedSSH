package com.lxtech.ssh.service.business;
/**
 *每天(或者每一段时间)翼支付通过消息队列和平台同步商品信息;
 *平台订阅消息,得到数据后,进行业务比对;
 */
public interface GoodsSynchroService {
	public void goodsSynchroService();
}
