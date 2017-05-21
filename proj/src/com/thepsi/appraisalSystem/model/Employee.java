package com.thepsi.appraisalSystem.model;

/*
 ***********************************************************************
 * Copyright (c) 2015 PSI, All Rights Reserved.
 *
 ** Source:com.thepsi.appraisalSystem.bean::Employee.java
 ** Application Name:AppraisalSystem
 ** Application SIC Code:
 *
 *
 ** Author:aayushi.agarwal
 *
 ** Date Created: Sep 7, 2015::3:59:58 PM
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

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 ***********************************************************************
 * Copyright (c) 2015 PSI, All Rights Reserved.
 *
 ** Source:com.thepsi.appraisalSystem.model::Employee.java
 ** Application Name:AppraisalSystem
 ** Application SIC Code:
 *
 *
 ** Author:aayushi.agarwal
 *
 ** Date Created: Sep 8, 2015::12:24:42 PM
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
@Table(name = "employee")

public class Employee implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1171429905326075023L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Employees_Id",nullable=false,unique=true)  
	private int employeeId;
	
	@Column(name = "Employee_name")
	private String employeeName;
	
	@Column(name = "group_name")
	private String groupName;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "Reporting_Manager_Name")
	private String Reporting_Manager_Name;
	
	@Column(name = "EMail_ID")
	private String Email_ID;
	
	@Column(name = "doj")
	private String Date_of_joining;
	
	@Column(name = "sex")
	private String sex;
	
	@Column(name = "Employee_Type")
	private String Employee_Type;
	
	@Column(name = "leftorg")
	private int leftorg;
	
	@Column(name = "manager",nullable=true)
	private Integer manager;
	
	@Column(name = "highestQualification")
	private String highestQualification;
	
	@Column(name = "Experience")
	private String experience;
	
	@Column(name = "Domain")
	private String domain;
	
	@Column(name = "Picture")
	private  byte[] picture;
	
	@Column(name = "IsWorkFromHome")
	private int wfh;
	
	@Column(name = "OnSite")
	private int onSite;
	
	@Column(name = "LWD")
	private String lwd;
	
	//added by vartika
/*	@Column(name = "eligible_for_appraisal")
	private int eligibleForAppraisal;*/

	@Column(name = "is_probationer")
	private int isProbationer;
	
	public int getIsProbationer() {
		return isProbationer;
	}
	public void setIsProbationer(int isProbationer) {
		this.isProbationer = isProbationer;
	}
	/**
	 * @param employeeId
	 * @param employeeName
	 * @param groupName
	 * @param designation
	 * @param reporting_Manager_Name
	 * @param email_ID
	 * @param date_of_joining
	 * @param sex
	 * @param employee_Type
	 * @param leftorg
	 */
	
	public int getWfh() {
		return wfh;
	}
	public void setWfh(int wfh) {
		this.wfh = wfh;
	}
	public int getOnSite() {
		return onSite;
	}
	public void setOnSite(int onSite) {
		this.onSite = onSite;
	}
	public String getLwd() {
		return lwd;
	}
	public void setLwd(String lwd) {
		this.lwd = lwd;
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	public String getHighestQualification() {
		return highestQualification;
	}
	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}
	/**
	 * @return
	 */
	public Integer getManager() {
		return manager;
	}
	public void setManager(Integer manager) {
		this.manager = manager;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String getReporting_Manager_Name() {
		return Reporting_Manager_Name;
	}
	public void setReporting_Manager_Name(String reporting_Manager_Name) {
		Reporting_Manager_Name = reporting_Manager_Name;
	}
	
	public String getEmail_ID() {
		return Email_ID;
	}
	public void setEmail_ID(String email_ID) {
		Email_ID = email_ID;
	}
	
	public String getDate_of_joining() {
		return Date_of_joining;
	}
	public void setDate_of_joining(String date_of_joining) {
		Date_of_joining = date_of_joining;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getEmployee_Type() {
		return Employee_Type;
	}
	public void setEmployee_Type(String employee_Type) {
		Employee_Type = employee_Type;
	}
	
	public int getLeftorg() {
		return leftorg;
	}
	public void setLeftorg(int leftorg) {
		this.leftorg = leftorg;
	}
	
	 /*Comparator for sorting the list by manager*/
    public static Comparator<Employee> managerId = new Comparator<Employee>() {

	public int compare(Employee e1, Employee e2) {

	   int manager1 = e1.getManager();
	   int manager2 = e2.getManager();

	   /*For ascending order*/
	   return manager1-manager2;

	   /*For descending order*/
	   //manager2-manager1;
   }};

/*	public int getEligibleForAppraisal() {
		return eligibleForAppraisal;
	}
	public void setEligibleForAppraisal(int eligibleForAppraisal) {
		this.eligibleForAppraisal = eligibleForAppraisal;
	}*/
	
}
