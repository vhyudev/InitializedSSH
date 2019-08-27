package com.lxtech.ssh.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_Product_sale")
/**
 * 一条卖出去的商品记录
 * 会员购买的产品  与会员表多对一， 与产品表单向多对1
 * @author Administrator
 *
 */
public class ProductSales implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	
	/**
	 * 会员买入金额
	 */
	private BigDecimal amount;
	
	@ManyToOne(optional=true)  
	@JoinColumn(name="product_id",  nullable = false) 
	private Product product ;
	
	@ManyToOne
	@JoinColumn(name="associator_id")
	private Associator associator ;
	
	/**
	 * 购买产品的时间戳，和会员id确保一条数据的唯一性
	 */
	private String timeTemp;

	/**
	 * 购买时间
	 */
	private Date saleDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Associator getAssociator() {
		return associator;
	}

	public void setAssociator(Associator associator) {
		this.associator = associator;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public String getTimeTemp() {
		return timeTemp;
	}

	public void setTimeTemp(String timeTemp) {
		this.timeTemp = timeTemp;
	}

	
	
	
}
