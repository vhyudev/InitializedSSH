package com.lxtech.ssh.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 翼支付的会员信息  理论上和本地会员的信息一致  每次翼支付操作应使用翼支付会员信息
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_yipayassociator",uniqueConstraints = {@UniqueConstraint(columnNames={"idCardNo","yiId"})})
public class YipayAssociator implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String yiId;
	
	@OneToOne( optional = true)
	@JoinColumn(name = "associator_id")
	private Associator associator;
	
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

	public Associator getAssociator() {
		return associator;
	}

	public void setAssociator(Associator associator) {
		this.associator = associator;
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
