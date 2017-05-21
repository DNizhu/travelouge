package com.thepsi.appraisalSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROLE_MASTER")
public class Role_Master {
	@Id
	@Column(name="RoleID",nullable=false)
	int roleId;
	@Column(name="Role",nullable=true)
	String role;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
