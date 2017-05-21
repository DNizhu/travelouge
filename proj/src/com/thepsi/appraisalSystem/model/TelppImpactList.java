package com.thepsi.appraisalSystem.model;

import java.util.List;

public class TelppImpactList {

	private List<TelppImpactReportVO> telppList = null;
	
	public TelppImpactList() {
	}

	public TelppImpactList(List<TelppImpactReportVO> telppList) {
		super();
		this.telppList = telppList;
	}

	public List<TelppImpactReportVO> getSkillList() {
		return telppList;
	}

	public void setTelppList(List<TelppImpactReportVO> telppList) {
		this.telppList = telppList;
	}
}
