package com.thepsi.appraisalSystem.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "probation_data")
public class ProbationData {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id",nullable=false,unique=true)
	private int id;
	
	@Column(name="emp_code")
	private int empCode;
	
	@Column(name = "form")
	private String form;

	@Column(name = "status")
	String status;
	
	@Column(name = "rating")
	private int rating;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getEmpCode() {
		return empCode;
	}
	public void setEmpCode(int empCode) {
		this.empCode = empCode;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
}
