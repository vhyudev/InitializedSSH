package com.lxtech.ssh.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 会员等级
 * @author Administrator
 *
 */
@Entity
@Table(name = "T_Associator_Grade",uniqueConstraints = {@UniqueConstraint(columnNames={"associator_Grade"})})
public class AssociatorGrade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	
	/**
	 * 会员等级
	 */
	@Column(name = "associator_Grade", nullable = false)
	private String associatorGrade;
	
	/**
	 * remark说明
	 */
	private String remark;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAssociatorGrade() {
		return associatorGrade;
	}

	public void setAssociatorGrade(String associatorGrade) {
		this.associatorGrade = associatorGrade;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
