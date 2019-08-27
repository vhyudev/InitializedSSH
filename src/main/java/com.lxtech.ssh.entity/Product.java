package com.lxtech.ssh.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 产品表
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_product")
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	/**
	 * 翼支付产品在本系统的id
	 */
	private long id;
	
	/**
	 * 翼支付产品id
	 */
	private String yiID;
	
	/**
	 * 产品名称
	 */
	private String productName;
	
	/**
	 * 产品代码
	 */
	private String productCode;
	
	/**
	 * 产品种类
	 */
	private String productType;
	
	/**
	 * 发行机构
	 */
	private String issuer;
	
	/**
	 * 发行地区
	 */
	private String distributionArea;
	
	/**
	 * 保本比率
	 */
	private BigDecimal premiumRatio;
	
	/**
	 * 预期最高年化净收益率（%
	 */
	private BigDecimal maxIncomeRate;
	
	/**
	 * 可投资起始日期
	 */
	private Date startDate;
	
	/**
	 * 可投资终止日期
	 */
	private Date endDate;
	
	/**
	 * 产品介绍
	 */
	private String productProduce;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getYiID() {
		return yiID;
	}

	public void setYiID(String yiID) {
		this.yiID = yiID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public String getDistributionArea() {
		return distributionArea;
	}

	public void setDistributionArea(String distributionArea) {
		this.distributionArea = distributionArea;
	}

	public BigDecimal getPremiumRatio() {
		return premiumRatio;
	}

	public void setPremiumRatio(BigDecimal premiumRatio) {
		this.premiumRatio = premiumRatio;
	}

	public BigDecimal getMaxIncomeRate() {
		return maxIncomeRate;
	}

	public void setMaxIncomeRate(BigDecimal maxIncomeRate) {
		this.maxIncomeRate = maxIncomeRate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getProductProduce() {
		return productProduce;
	}

	public void setProductProduce(String productProduce) {
		this.productProduce = productProduce;
	}
	
	
}
