package com.lxtech.ssh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "T_Associator_Type",uniqueConstraints = {@UniqueConstraint(columnNames={"associator_Type"})})
public class AssociatorType {
	
	@Id
	@GeneratedValue
	private long id;
	
	/**
	 * 会员类型
	 */
	@Column(name = "associator_Type")
	private String associatorType;
	
	/**
	 * 说明
	 */
	private String remark;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAssociatorType() {
		return associatorType;
	}

	public void setAssociatorType(String associatorType) {
		this.associatorType = associatorType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
