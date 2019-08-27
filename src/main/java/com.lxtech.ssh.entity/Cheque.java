package com.lxtech.ssh.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 支票实体类
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_cheque",uniqueConstraints = {@UniqueConstraint(columnNames={"chequeNum"})})
public class Cheque {
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	@JoinColumn(name="associator_id")
	private Associator associator ;
	/**
	 * 支票号   唯一约束
	 * 
	 */
	private String chequeNum;
	
	/**
	 * 开票银行
	 */
	//private Bank bank;
	
	/**
	 * 支票状态 
	 * 未使用支票:未给客户生成支票号
	 * 已使用未兑现支票：已经被医院记录，但是未送支票到医院
	 * 已兑现未结账支票：已经送票到医院，医院操作完成，未通知翼支付
	 * 已申请未使用支票：生成支票号，未被医院记录
	 * 已申请未使用过期支票：生成支票号，未被医院记录，在规定时间内未使用，视为过期，可重新被申请
	 */
	private String status;
	
	/**
	 * 出票日期
	 */
	private Date openDate;
	
	/**
	 * 金额
	 */
	private BigDecimal amount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getChequeNum() {
		return chequeNum;
	}

	public void setChequeNum(String chequeNum) {
		this.chequeNum = chequeNum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Associator getAssociator() {
		return associator;
	}

	public void setAssociator(Associator associator) {
		this.associator = associator;
	}
	
	
	
}
