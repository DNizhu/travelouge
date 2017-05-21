package com.thepsi.appraisalSystem.model;

public class Employee_Manager implements java.io.Serializable {
     
	private int employees_Id;
	private int manager;
	private String employee_name;
	
	public int getEmployees_Id() {
		return employees_Id;
	}
	public void setEmployees_Id(int employees_Id) {
		this.employees_Id = employees_Id;
	}
	public int getManager() {
		return manager;
	}
	public void setManager(int manager) {
		this.manager = manager;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	
}
