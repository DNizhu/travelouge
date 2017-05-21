package com.thepsi.appraisalSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thepsi.appraisalSystem.dao.TelppImpactDaoImpl;

import com.thepsi.appraisalSystem.model.TelppImpactReportVO;

@Service
public class TelppImpactManager {

	@Autowired
	private TelppImpactDaoImpl telppDaoImpl;
	
	public List getEmployeeTelpp() {
		return telppDaoImpl.getEmployeeTelpp();
	}
	
	public List<TelppImpactReportVO> doBasicSearch(String group,String desig, String empName) {
		return telppDaoImpl.doBasicSearch(group,desig, empName);
		
	}
}
