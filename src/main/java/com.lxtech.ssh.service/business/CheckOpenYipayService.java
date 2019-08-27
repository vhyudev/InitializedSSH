package com.lxtech.ssh.service.business;
/**
 * 当用户点击绑定翼支付按钮时,调用翼支付的接口,传入会员相关信息后,翼支付返回开通结果
 * 
 * 如果开通了返回json格式会员信息
 * 
 * 没开通返回 notOpen;
 * 参数associatoreInfo 可以是 手机号 身份证号码等,可用于验证的信息.
 */
public interface CheckOpenYipayService {
     public boolean checkOpenYipay(String associatoreInfo);
}
