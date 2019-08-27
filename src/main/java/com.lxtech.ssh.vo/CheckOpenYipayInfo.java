package com.lxtech.ssh.vo;

/**
 * 校验国本会员是否开通翼支付会员接口 返回的 信息
 * @author Administrator
 *
 */
public class CheckOpenYipayInfo {
	
	/**
	 * 开通翼支付标记 0代表已开通，1代表未开通
	 */
	private String status;
	
	private YipayAssociatorInfo yipayAssociatorInfo;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public YipayAssociatorInfo getYipayAssociatorInfo() {
		return yipayAssociatorInfo;
	}

	public void setYipayAssociatorInfo(YipayAssociatorInfo yipayAssociatorInfo) {
		this.yipayAssociatorInfo = yipayAssociatorInfo;
	}
	
	
	
	
}
