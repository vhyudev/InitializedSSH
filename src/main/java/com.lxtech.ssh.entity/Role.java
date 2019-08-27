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
import javax.persistence.Table;

;

/**
 * @description:角色
 */
@Entity
@Table(name = "t_roles")
public class Role implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name; 


	private String description;

	@ManyToMany(mappedBy = "roles")
	private Set<Manager> managers = new HashSet<Manager>(0);

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "T_ROLE_Permission", joinColumns = {
			@JoinColumn(name = "ROLE_ID", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "Permission_ID", referencedColumnName = "id") })

	private Set<Permission> permissions = new HashSet<Permission>(0);

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

	public Set<Manager> getManagers() {
		return managers;
	}

	public void setManagers(Set<Manager> managers) {
		this.managers = managers;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}


	
	

	

}
