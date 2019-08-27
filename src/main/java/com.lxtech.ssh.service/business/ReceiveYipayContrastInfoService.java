package com.lxtech.ssh.service.business;
/**
 *通过消息队列订阅翼支付发布的对账信息后,应急平台做处理;
 */
public interface ReceiveYipayContrastInfoService {
	public void receiveYipayContrastInfo();
	
}
