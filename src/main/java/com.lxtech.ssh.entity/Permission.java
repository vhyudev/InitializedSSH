package com.lxtech.ssh.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "t_Permission")
public class Permission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	

	private String description;

	@ManyToMany(mappedBy = "permissions")
	private Set<Role> roles = new HashSet<Role>(0);

	@ManyToMany(fetch=FetchType.EAGER)
	@OrderBy("id asc")
	@JoinTable(name = "T_Permission_MENU", joinColumns = {
			@JoinColumn(name = "Permission_ID", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "MENU_ID", referencedColumnName = "id") })
	private Set<Menu> memus = new HashSet<Menu>(0);

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Menu> getMemus() {
		return memus;
	}

	public void setMemus(Set<Menu> memus) {
		this.memus = memus;
	}

}
