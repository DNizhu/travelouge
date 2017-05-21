package com.thepsi.appraisalSystem.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.thepsi.appraisalSystem.model.Employee;
import com.thepsi.appraisalSystem.model.ProbationData;
import com.thepsi.appraisalSystem.services.AppraisalCycleManager;
import com.thepsi.appraisalSystem.services.ProbationManager;
import com.thepsi.appraisalSystem.util.AppraisalConstants;

@Controller
public class SubordinateProbationReviewController {

	private Logger logger = Logger.getLogger(AppraisalConstants.VIEW_SUBORDINATE_PROBATIONERS);
	@Autowired 
	private ProbationManager probationManager;

	@Autowired
	private AppraisalCycleManager appCycleManager;
	
	@RequestMapping(value = AppraisalConstants.VIEW_SUBORDINATE_PROBATIONERS, method = RequestMethod.GET)
	public ModelAndView subordinateProbationReview(HttpServletRequest request, HttpServletResponse response) {
		Employee employee = (Employee)request.getSession().getAttribute("employeeDetails");
		int empId = employee.getEmployeeId(),i;
		logger.info("ClassName: SubordinateProbationReviewController");
		logger.info("MethodName:subordinateProbationReview");
		ArrayList<String> roles = appCycleManager.getRole(empId);
		List<Employee> probationersList = new ArrayList<Employee>();
		List<Employee> probationCompletedList = new ArrayList<Employee>();
		List<Employee> pendingOnMeList = new ArrayList<Employee>();
		
		List<String> groupNames = new ArrayList<String>();
		// For HR, Management, Admin
		  if(roles!=null && (roles.contains(AppraisalConstants.MGMT_ROLE)||roles.contains(AppraisalConstants.HR_ROLE)||roles.contains(AppraisalConstants.ADMIN_ROLE) || roles.contains(AppraisalConstants.AVP_ROLE))){
			  probationersList = probationManager.getProbationersList();
			  probationCompletedList = probationManager.getProbationCompletedList();
		  }
		  else if(roles!=null && roles.contains(AppraisalConstants.GH_ROLE)){
			  groupNames = probationManager.getGroupNamesUnderGH(empId);
			  for(i=0; i<groupNames.size();i++){
				  if(groupNames.get(i)!=null)
					  probationersList.addAll(probationManager.getProbationersListForGroup(groupNames.get(i)));
				  	  probationCompletedList.addAll(probationManager.getProbationCompletedListForGroup(groupNames.get(i)));
			  } 
		  }
		  else{ // For managers and delegated mangers
			  probationersList = probationManager.getProbationersListForManagers(empId);
			  probationCompletedList = probationManager.getProbationCompletedListForManagers(empId);
		  }
		  
		List allProbationersDataList = new ArrayList<>();
		for(i=0;i<probationersList.size();i++){
			List<ProbationData> probationDataList = probationManager.getProbationData(probationersList.get(i).getEmployeeId());
			allProbationersDataList.add(probationDataList);	
		}	
		
		List allProbationCompletedDataList = new ArrayList<>();
		for(i=0;i<probationCompletedList.size();i++){
			List<ProbationData> probationCompletedDataList = probationManager.getProbationData(probationCompletedList.get(i).getEmployeeId());
			allProbationCompletedDataList.add(probationCompletedDataList);
		}
		
		/* For List Of Decisions Pending on the Employee logged In*/
		if(roles!=null && roles.contains(AppraisalConstants.MGMT_ROLE)){								// pending decisions as Management
			pendingOnMeList.addAll(probationManager.getPendingDecisionsListForManagement());
		}
		if(roles!=null && roles.contains(AppraisalConstants.HR_ROLE)){									// pending decisions as HR
			pendingOnMeList.addAll(probationManager.getPendingDecisionsListForHR());
		}
		if(roles!=null && roles.contains(AppraisalConstants.GH_ROLE)){									// pending decisions as GH
			 groupNames = probationManager.getGroupNamesUnderGH(empId);
			  for(i=0; i<groupNames.size();i++){
				  if(groupNames.get(i)!=null)
					  pendingOnMeList.addAll(probationManager.getPendingDecisionsListForGH(groupNames.get(i)));
			  } 
		}
		pendingOnMeList.addAll(probationManager.getPendingDecisionsForManager(empId));					// pending decisions as manager
		
		Set<Employee> s= new HashSet<Employee>();														// for removing duplicates if any 
	    s.addAll(pendingOnMeList);         
	    pendingOnMeList = new ArrayList<Employee>();
	    pendingOnMeList.addAll(s);  
		
		List allPendingOnMeDataList = new ArrayList<>();
		for(i=0;i<pendingOnMeList.size();i++){
			List<ProbationData> pendingOnMeDataList = probationManager.getProbationData(pendingOnMeList.get(i).getEmployeeId());
			allPendingOnMeDataList.add(pendingOnMeDataList);
		}
		
		ModelAndView mav = new ModelAndView(AppraisalConstants.SUBORDINATE_PROBATIONERS);
		mav.addObject("probationersList", probationersList);
		mav.addObject("allProbationersDataList", allProbationersDataList);
		mav.addObject("probationCompletedList", probationCompletedList);
		mav.addObject("allProbationCompletedDataList", allProbationCompletedDataList);
		mav.addObject("pendingOnMeList",pendingOnMeList);
		mav.addObject("allPendingOnMeDataList", allPendingOnMeDataList);
		return mav;
	}
}
