package com.lxtech.ssh.service.business;
/**
 *会员点击绑定翼支付后,检测到没有开通翼支付,会跳到翼支付界面注册
 *注册完成后,翼支付通过消息队列 给应急平台推送 会员注册的相关信息;
 * 应急平台获取翼支付推送的信息,可以根据相关信息(比如手机号)进行后续操作;
 */
public interface ReceiveYipayRegistInfoService {
	public void receiveYipayRegistInfo();
}
