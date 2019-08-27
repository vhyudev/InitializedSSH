package com.lxtech.ssh.vo;

import com.lxtech.ssh.entity.Associator;

/**
 * 翼支付会员信息
 * @author Administrator
 *
 */
public class YipayAssociatorInfo {
	
	/**
	 * 国本会员id
	 */
	private long id;
	
	/**
	 * 翼支付会员id
	 */
	private String yiId;
	
	private String mobile;
	
	private String idCardNo;
	
	private String age;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getYiId() {
		return yiId;
	}

	public void setYiId(String yiId) {
		this.yiId = yiId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	
}
