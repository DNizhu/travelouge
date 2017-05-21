package com.thepsi.appraisalSystem.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.thepsi.appraisalSystem.model.TelppImpactList;
import com.thepsi.appraisalSystem.model.TelppImpactReportVO;
import com.thepsi.appraisalSystem.services.AppraisalCycleManager;
import com.thepsi.appraisalSystem.services.TelppImpactManager;
import com.thepsi.appraisalSystem.util.AppraisalConstants;

@Controller
public class TelppImpactController {
	@Autowired
	private TelppImpactManager telppImpactManager;
	
	@Autowired
	private AppraisalCycleManager appCycleManager;
	
	private Logger logger = Logger.getLogger(AppraisalConstants.LOG_NAME);
	
	@RequestMapping(value = AppraisalConstants.TELPP_IMPACT_REPORT, method = RequestMethod.GET)
	public ModelAndView getTelppImpact(@ModelAttribute TelppImpactList telppList,HttpSession session,
			HttpServletResponse response, HttpServletRequest request) {
		logger.info("ClassName:TelppImpactController");
		logger.info("MethodName:getTelppImpactList");
		ModelAndView mav = new ModelAndView("TelppImpactReport");
		List<String> listOfGroups = appCycleManager.getListOfGroups();
		List<String> employeeList = appCycleManager.getEmployeeList();
		List<String> designation = appCycleManager.getDistinctDesignationByGroup("");
		
		List<TelppImpactReportVO> employeeTelppList = telppImpactManager.getEmployeeTelpp();

		mav.addObject(AppraisalConstants.LIST_OF_GROUPS, listOfGroups);
		mav.addObject("employeeList", employeeList);
		mav.addObject("designation", designation);
		mav.addObject("employeeTelppList", employeeTelppList);
		return mav;
	}
	
	
	@RequestMapping(value = AppraisalConstants.GET_BASIC_SEARCH_TELPP, method = RequestMethod.POST)
	public ModelAndView basicSearch(HttpSession session,
			HttpServletResponse response, HttpServletRequest request) {
		logger.info("ClassName:TelppImpactController");
		logger.info("MethodName:basicSearch");
		
		String group = request.getParameter("group");
		String desig = request.getParameter("designation");
		String empName = request.getParameter("empName");
		
		List<String> searchCriteria = new ArrayList<String>();
		searchCriteria.add(desig);
		searchCriteria.add(group);
		searchCriteria.add(empName);
		
		List<TelppImpactReportVO> employeeTelppList = telppImpactManager.doBasicSearch(
				group,desig, empName);
	

		ModelAndView mav = new ModelAndView("TelppImpactReport");
		List<String> listOfGroups = appCycleManager.getListOfGroups();
		List<String> employeeList = appCycleManager.getEmployeeList();
		List<String> designation = appCycleManager
				.getDistinctDesignationByGroup("");

		mav.addObject(AppraisalConstants.LIST_OF_GROUPS, listOfGroups);
		mav.addObject("employeeList", employeeList);
		mav.addObject("designation", designation);
		mav.addObject("employeeSkillList", employeeTelppList);
		mav.addObject("advEmployeeList", employeeList);
		mav.addObject("searchCriteria", searchCriteria);
	
		return mav;
	}

}
