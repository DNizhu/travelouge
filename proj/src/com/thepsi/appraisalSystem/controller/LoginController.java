package com.thepsi.appraisalSystem.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.thepsi.appraisalSystem.model.Employee;
import com.thepsi.appraisalSystem.model.RoleMaster;
import com.thepsi.appraisalSystem.model.User_Role;
import com.thepsi.appraisalSystem.services.AppraisalCycleManager;

import com.thepsi.appraisalSystem.util.AppraisalConstants;

@Controller
public class LoginController {

	@Autowired
	private AppraisalCycleManager appCycleManager;
	
	private Logger logger = Logger.getLogger(AppraisalConstants.LOG_NAME);
	
	/*To get inputs for login*/
	@RequestMapping(value = AppraisalConstants.LOGIN, method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) 
	{
		logger.info("ClassName: AppraisalController");
		logger.info("MethodName:login");
		ModelAndView mav = new ModelAndView(AppraisalConstants.LOGIN_PAGE);
		logger.info("Login page display successfully" );
		return mav;	

	}
	
	/*Added by Aayushi 
	 * To validate the credentials */
	@RequestMapping(value = AppraisalConstants.HANDLE_LOGIN, method = RequestMethod.POST)
	public ModelAndView handleLogin(HttpServletRequest request, HttpServletResponse response) 
	{
		logger.info("ClassName: AppraisalController");
		logger.info("MethodName: handleLogin");
		ModelAndView mav = new ModelAndView();
		
		String uname = request.getParameter("email");
		String passwd = request.getParameter("password");

		String msg = "sfg";
		
		if(msg == "" || msg == null)
		{
			mav = new ModelAndView(AppraisalConstants.LOGIN_PAGE);
			mav.addObject("errMsg","Please provide the correct Username/Password");
	
		}
		else {
			
			mav = new ModelAndView(AppraisalConstants.INSTRUCTION_PAGE);
			
			String EmailId = uname+AppraisalConstants.USERNAME_SUFFIX;
			
			
			//To get Employee Details
			Employee emp = appCycleManager.findEmployeeByMailId(EmailId);
			int EmpId =0;
			
		    if(emp != null)
		    {	logger.info(emp.getEmployeeName());   
		    	//Setting Employee Details
		    	request.getSession().setAttribute("employeeDetails", emp);
		    	request.getSession().setAttribute("mspsLink",appCycleManager.getMSPSLink());
		    	EmpId = emp.getEmployeeId();
		    	RoleMaster adminId = appCycleManager.getRoleFromRoleMaster(AppraisalConstants.ADMIN_ROLE);
		    	RoleMaster hrId = appCycleManager.getRoleFromRoleMaster(AppraisalConstants.HR_ROLE);
		    	RoleMaster avpId = appCycleManager.getRoleFromRoleMaster(AppraisalConstants.AVP_ROLE);
		    	RoleMaster ghId = appCycleManager.getRoleFromRoleMaster(AppraisalConstants.GH_ROLE);
		    	RoleMaster mgmtId = appCycleManager.getRoleFromRoleMaster(AppraisalConstants.MGMT_ROLE);
		    	List<User_Role> userRoleInfo =  appCycleManager.getUserRoleByEmpId(EmpId);
		    	
		    	
		    	if(userRoleInfo != null)
		    	 {   
		    		logger.info("Getting UserRole:");
		    		//To set User role
		    		for(User_Role userRole:userRoleInfo ){
		    			logger.info(" UserRole:"+ userRole.getRoleId());
		    			if(adminId.getRoleID()!=null){
		    		     if(userRole.getRoleId()==adminId.getRoleID()){
		    			    request.getSession().setAttribute("admin",AppraisalConstants.YES);
		    		     }
		    			}
		    			
		    			if(hrId.getRoleID()!=null){
		    		if(userRole.getRoleId()== hrId.getRoleID())
		    		{
		    			request.getSession().setAttribute("HR", AppraisalConstants.YES);
		    		}
		    			}
		    			if(mgmtId.getRoleID()!=null){
		    		if(userRole.getRoleId()==mgmtId.getRoleID())
		    		{  
		    			request.getSession().setAttribute("mgmt",AppraisalConstants.YES);
		    		}
		    			}
		    			if(ghId.getRoleID()!=null){
		    		if(userRole.getRoleId()== ghId.getRoleID())
		    		{
		    			request.getSession().setAttribute("GH", AppraisalConstants.YES);
		    		}
		    			}
		    			if(avpId.getRoleID()!=null){
		    		if(userRole.getRoleId()== avpId.getRoleID())
		    		{
		    			request.getSession().setAttribute("AVP",AppraisalConstants.YES);
		    		}
		    			}
		    	 }
		    	}
		            
		    	//To get Employee Role from manager role
		    	Employee manager = appCycleManager.findManagerByEmpId(EmpId);
		    	
		    	List<Employee> managerReviwer = appCycleManager.findManagerReviewerByEmpId(EmpId);
		    	
		    	if(manager!= null)
		    	{   logger.info("Manager Found");
		    		request.getSession().setAttribute("Manager", AppraisalConstants.YES);
		    	}
		    	else
		    	{
		    		request.getSession().setAttribute("Manager", AppraisalConstants.NO);
		    	}
		    	if(managerReviwer!=null && managerReviwer.size()>0){
		    		logger.info("Manager Reviewer Found");
		    		request.getSession().setAttribute("SecondLevelReviewer", AppraisalConstants.YES);
		    	}
		    	else{
		    		request.getSession().setAttribute("SecondLevelReviewer", AppraisalConstants.NO);
		    	}
		    	
		    	
		    
		   
		    }
		}
		return mav;
	}
	
	/* Added by Aayushi 
	 * For logout */
	@RequestMapping(value = AppraisalConstants.LOGOUT_PAGE_URL, method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response){
		logger.info("ClassName: AppraisalController");
		logger.info("MethodName: logout");
		HttpSession session = request.getSession(true);
		if(session!= null)
		{
		ModelAndView mav = new ModelAndView(AppraisalConstants.LOGIN_PAGE);
		session.invalidate();
		return mav;
		}
		else
		{
			ModelAndView mav = new ModelAndView(AppraisalConstants.LOGIN_PAGE);
			return mav;
		}
	}
}
