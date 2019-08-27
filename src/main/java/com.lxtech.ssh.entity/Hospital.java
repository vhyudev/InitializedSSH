package com.lxtech.ssh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
@Entity
@Table(name = "t_hospital")
public class Hospital {
	@Id
	@GeneratedValue
	private long id;
	
	/**
	 * 医院名称
	 */
	@Column(name = "name")
	private String name; 
	
	/**
	 * 医院联系人
	 */
	private String contact;
	
	/**
	 * 联系人电话
	 */
	private String phone;
	
	/**
	 * 等级 1-甲级 0-乙级
	 */
	private  int rank;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
