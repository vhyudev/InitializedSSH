package com.lxtech.ssh.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 性别字典表
 * @author Administrator
 *
 */
@Entity
@Table(name = "T_GENDER",uniqueConstraints = {@UniqueConstraint(columnNames={"gender_code", "gender_name"})})
public class Gender implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	
	/**
	 * 性别代码 0代表男，1代表女，2代表未知
	 */
	@Column(name = "gender_code")
	private String genderCode;
	
	/**
	 * 性别
	 */
	@Column(name = "gender_name")
	private String genderName;
	
//	@OneToMany(targetEntity = Associator.class ,mappedBy = "gender")
//	private Set<Associator> associatorSet = new HashSet<Associator>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGenderCode() {
		return genderCode;
	}

	public void setGenderCode(String genderCode) {
		this.genderCode = genderCode;
	}

	public String getGenderName() {
		return genderName;
	}

	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

//	public Set<Associator> getAssociatorSet() {
//		return associatorSet;
//	}
//
//	public void setAssociatorSet(Set<Associator> associatorSet) {
//		this.associatorSet = associatorSet;
//	}
	
	
	
}
