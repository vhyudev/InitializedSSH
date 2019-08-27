package com.lxtech.ssh.vo;

/**
 * 购买产品接口翼支付返回的 
 * @author Administrator
 *
 */
public class ProductSaleInfo {
	
	/**
	 * 购买会员id
	 */
	private String associatorId;
	
	/**
	 * 购买金额
	 */
	private String ammount;
	
	/**
	 * 购买产品时的时间戳   联合会员id 确保一条购买记录的唯一性
	 */
	private String timeTemp;
	
	/**
	 * 产品id
	 */
	private String productId;

	public String getAssociatorId() {
		return associatorId;
	}

	public void setAssociatorId(String associatorId) {
		this.associatorId = associatorId;
	}

	public String getAmmount() {
		return ammount;
	}

	public void setAmmount(String ammount) {
		this.ammount = ammount;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getTimeTemp() {
		return timeTemp;
	}

	public void setTimeTemp(String timeTemp) {
		this.timeTemp = timeTemp;
	}
	
	
}
