package com.thepsi.appraisalSystem.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="probation_delegation_data")
public class ProbationDelegationData {


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id",nullable=false,unique=true)
	private int id;
	
	@Column(name = "emp_code")
	private int empCode;
	@Column(name = "delegated_by")
	private int delagatedBy;
	@Column(name = "delegated_to")
	private int delegatedTo;
	@Column(name = "form")
	private String form;
	@Column(name = "last_updated_by")
	private String lastUpdatedBy;
	@Column(name = "last_updated_on")
	private Date lastUpdatedOn;
	
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
	public int getDelagatedBy() {
		return delagatedBy;
	}
	public void setDelagatedBy(int delagatedBy) {
		this.delagatedBy = delagatedBy;
	}
	public int getDelegatedTo() {
		return delegatedTo;
	}
	public void setDelegatedTo(int delegatedTo) {
		this.delegatedTo = delegatedTo;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public Date getLastUpdatedOn() {
		return lastUpdatedOn;
	}
	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}
}
