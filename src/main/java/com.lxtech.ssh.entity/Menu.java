package com.lxtech.ssh.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

@Entity
@Table(name = "t_Menu")
public class Menu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	private String name;//菜单名称
	private String page; // 访问路径
	private String description;//菜单描述
	
	
	@ManyToMany(mappedBy = "memus")
	@JSONField(serialize=false)  
	private Set<Permission> permissions = new HashSet<Permission>(0);

	 
	@OneToMany(targetEntity = Menu.class ,mappedBy = "parentMenu")
	@JSONField(serialize=false) 
	private Set<Menu> childrenMenus = new HashSet<Menu>(0);

	@ManyToOne
	@JoinColumn(name = "pid")
	@JSONField(serialize=false)  
	private Menu parentMenu;//自关联多对一

	
	
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

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@JSONField(serialize=false)  
	public Set<Permission> getPermissions() {
		return permissions;
	}
	@JSONField(serialize=false)  
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
	@JSONField(serialize=false)  
	public Set<Menu> getChildrenMenus() {
		return childrenMenus;
	}
	@JSONField(serialize=false)  
	public void setChildrenMenus(Set<Menu> childrenMenus) {
		this.childrenMenus = childrenMenus;
	}
	@JSONField(serialize=false)  
	public Menu getParentMenu() {
		return parentMenu;
	}
	@JSONField(serialize=false)  
	public void setParentMenu(Menu parentMenu) {
		this.parentMenu = parentMenu;
	}

}
