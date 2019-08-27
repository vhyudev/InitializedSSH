package com.lxtech.ssh.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "t_manager",uniqueConstraints = {@UniqueConstraint(columnNames={"idCardNo"})})
public class Manager implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private long id;
	
	private String name;//姓名
	
	@ManyToOne(cascade=CascadeType.ALL,optional=true)  
	@JoinColumn(name="gender_id",  nullable = false) 
	private Gender gender;//性别
	
	private int age;
	private String idCardNo;//身份证号
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "T_MANAGER_ROLE", joinColumns = {
			@JoinColumn(name = "MANAGER_ID", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "ROLE_ID", referencedColumnName = "id") })

	private Set<Role> roles = new HashSet<Role>(0);//管理员所对应角色 双向多对多 由管理员方 维护.
	
	@OneToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name = "user_id")
	private User user;//外键一对一 uers中记录基本的登录信息
	
	private Time createTime;
	private Time updateTime;

	private String remark;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int  getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Time getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Time createTime) {
		this.createTime = createTime;
	}
	public Time getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Time updateTime) {
		this.updateTime = updateTime;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	
	
}
