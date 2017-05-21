package com.thepsi.appraisalSystem.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 ***********************************************************************
 * Copyright (c) 2015 PSI, All Rights Reserved.
 *
 ** Source:com.thepsi.appraisalSystem.model::User_Role.java
 ** Application Name:AppraisalSystem
 ** Application SIC Code:
 *
 *
 ** Author:aayushi.agarwal
 *
 ** Date Created: Sep 8, 2015::1:30:13 PM
 *
 ** General Description(Purpose):
 *
 ** Usage Examples:
 *
 ** Known Issues/Possible Points of Failure:
 *
 ** Update History:
 *
 *
 ***********************************************************************
 */

@Entity
@Table(name = "USER_ROLE")
public class User_Role implements java.io.Serializable {
    
	@Id
	@Column(name="ID",nullable=false)@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "EmpID",nullable=false)
	private int empId;
	
	@Column(name = "RoleID",nullable=false)
	private int roleId;
	
	@Column(name = "[Group]",nullable=true)
	private String group;
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	
	
}
