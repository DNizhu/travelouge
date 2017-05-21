package com.thepsi.appraisalSystem.services;

import java.io.FileReader;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thepsi.appraisalSystem.dao.AppraisalDAOImpl;


import com.thepsi.appraisalSystem.model.Employee;
import com.thepsi.appraisalSystem.model.Employee_Manager;
import com.thepsi.appraisalSystem.model.ManagerDetails;

import com.thepsi.appraisalSystem.model.RoleMaster;
import com.thepsi.appraisalSystem.model.TELPP_IMPACT_DETAILS;
import com.thepsi.appraisalSystem.model.User_Role;
import com.thepsi.appraisalSystem.util.AppraisalConstants;
import com.thepsi.appraisalSystem.util.MailSender;
import com.thepsi.appraisalSystem.util.PropertyReader;
@Service
public class AppraisalCycleManager {
	
	@Autowired
	private AppraisalDAOImpl dao;
	@Autowired
	private MailSender mail;
	private PropertyReader pr = new PropertyReader();
	/*Ankush*/
	private Logger logger = Logger.getLogger(AppraisalConstants.LOG_NAME);
	/*end*/
	

	/*public void submitAppraisalCycle(AppraisalCycle appraisalCycle,HttpServletRequest request){
		String fromMonth = request.getParameter("fromMonth");
		String fromYear = request.getParameter("fromYear");
		String toMonth = request.getParameter("toMonth");
		String toYear = request.getParameter("toYear");
		String appraisalDuration = fromMonth+"/"+fromYear+" To "+toMonth+"/"+toYear;
		
		appraisalCycle.setStatus(AppraisalConstants.ENABLE);
		dao.submitAppraisalCycle(appraisalCycle);
	}*/
	
	//Added by Aayushi Agarwal
	public Employee findEmployeeByMailId(String EmailId)
	{
		Employee emp =dao.findEmployeeByMailId(EmailId);
		return emp;
	}
	
	/* Added by Aayushi
	 * getTELPP Imapact Info from TELP Master
	 */
	@SuppressWarnings("unchecked")
	public TELPP_IMPACT_DETAILS getTELPPImapactInfo(int empId)
	{  
		TELPP_IMPACT_DETAILS telpList = dao.getTELPPImapactInfo(empId);
		return telpList;
	}
	
	//Added by Aayushi Agarwal
	public List<User_Role> getUserRoleByEmpId(int EmpId){
		
		List<User_Role> userList = dao.getUserRoleByEmpId(EmpId);
		
		return userList;
	}
	
	/* Added by Aayushi
	 * Find employee under manager  by mangerId
	 */
	@SuppressWarnings("unchecked")
	public List findEmployeeUnderManagerDirect(int manager)
	{ 
		List empList = dao.findEmployeeUnderManagerDirect(manager);
		return empList;
	}
	
	/* Added by Aayushi Agarwal
	 * to update Normalized Rating
	 * Used when Normalized Rating is set */
	public void updateNormalizedRating(int EmpId,int AppCycleId,String normalizedRating)
	{   
		dao.updateNormalizedRating(EmpId, AppCycleId, normalizedRating);
	}
	
	/* Added by Aayushi
	 * Find employee by groupName
	 */
	@SuppressWarnings("unchecked")
	public List findEmployeeBygroupName(String groupName)
	{  
		List empList = dao.findEmployeeBygroupName(groupName);
		return empList;
	}
	
	/* Added by Aayushi
	 * Find employee by EmpId
	 */
	@SuppressWarnings("unchecked")
	public String getEmployeeNameByEmpId(int EmpId)
	{
		String empName= dao.getEmployeeNameByEmpId(EmpId);
		return empName;
	}
	

	//Added by Aayushi Agarwal
	public Employee findManagerByEmpId(int empId){
		Employee emp =dao.findManagerByEmpId(empId);
		return emp;
	}

	
	
	
	
	/* Added by Aayushi
	 * getRoleFrom Role Master
	 */
	@SuppressWarnings("unchecked")
	public RoleMaster getRoleFromRoleMaster(String role)
	{   
	      RoleMaster roleMaster = dao.getRoleFromRoleMaster(role);
	      return roleMaster;
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> findEmployeeByManagerID(int empId)
	{     
	    List<Employee> empList = dao.findEmployeeByManagerID(empId);
	    return empList;
	}
	
	/* Added by Aayushi Agarwal
	 * to Enable Self AppraisalForm
	 * Used when SendBack by user */
	public void enableSelfAppraisalForm(int EmpId,int AppCycleId)
	{     
		dao.enableSelfAppraisalForm(EmpId, AppCycleId);
	}
	
	/* Added by Aayushi
	 * Find EmployeeDetails by EmpId
	 */
	@SuppressWarnings("unchecked")
	public Employee findEmployeeByEmpID(int empId)
	{  
		Employee emp = dao.findEmployeeByEmpID(empId);
		return emp;
	}
	
	/* Added by Aayushi
	 * Find employee under manager  by mangerId
	 */
	@SuppressWarnings("unchecked")
	public List<Employee_Manager> findEmployeeUnderManagerByEmpID(int empId)
	{  
		List<Employee_Manager> empList = dao.findEmployeeUnderManagerByEmpID(empId);
		return empList;
	}
	
	
	@SuppressWarnings("unchecked")
	public void createUserRoleTable(User_Role userRole)
	{ 
		dao.createUserRoleTable(userRole);
	}
	
	/* Added by Aayushi
	 * Find employee under manager  by mangerId
	 */
	@SuppressWarnings("unchecked")
	public List<ManagerDetails> getAllManagerList(int manager)
	{  
		List<ManagerDetails> managerDetails = dao.getAllManagerList(manager);
		return managerDetails;
	}
	
	
	/* Added by Aayushi
	 * Find employee by groupName
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeByGroupName(String groupName)
	{
		List<Employee> empList = dao.getEmployeeByGroupName(groupName);
		return empList;
	}
	
	/*public Employee getEmployeeAGH(Employee appraisee){
		Employee emp = dao.getEmployeeAGH(appraisee);
		return emp;
	}*/

	
	/*To get list of status */
	public ArrayList<String>getListOfStatus(){
		return dao.getListOfStatus();
	}
	
	
	
	/*To get all employees */
	public ArrayList<Employee>getEmployees(){
		return dao.getAllEmployees();
				
	}

	public ArrayList<String> getListOfGroups(){
		return dao.getListOfGroups();
	}
	
	/*To get employee details by id */
	public Employee getEmployeeByID(int empId){
		return dao.getEmployeeByID(empId);
	}
	/*Added by ankush */
	public ArrayList<Employee> getAppraiseeList(int appCycleId){
		return dao.getAppraiseeList(appCycleId);
	}

	/*To get AGH or GH of an employee 
	public Employee getEmployeeReporter(Employee appraisee){
		return dao.getEmployeeReporter(appraisee);
	}*/
	
	
	/*To get GH of employee */
	public Employee getEmployeeGH(Employee appraisee){
		return dao.getEmployeeGH(appraisee);
	}
	/*To get COO */
	public Employee getFirstEmployeeByDesignation(String designation){
		return dao.getFirstEmployeeByDesignation(designation);
	}

	/*Get formated date */
	public String getFormatedDate(String dateStr){
		
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
		Date date= null;
		try {
			date = format1.parse(dateStr);
		} catch (ParseException e1) {
			logger.info("ClassName: AppraisalCycleManager");
			logger.info("MethodName: getFormatedDate");
			logger.info(e1);
		}
		String input = null;
		DateFormat fmt = new SimpleDateFormat("dd/MMM/yyyy");
		input = fmt.format(date);
		return input;
	}
	

	
	/* Added by Shubhi */
	public String getSubmitTargetMailContent(int empId, int managerId){
		String fileContent = "";
		PropertyReader propReader = new PropertyReader();
		try{
		FileReader fileReader = new FileReader(propReader.getTARGET_SUBMIT_CONTENT());
    	
	     int i ;
		 while((i =  fileReader.read())!=-1){
		   char ch = (char)i;
		   fileContent = fileContent + ch; 
		  }
		 
		 fileContent = fileContent.replace("#empName",getEmployeeNameByEmpId(empId));
		 fileContent = fileContent.replace("#managerName",getEmployeeNameByEmpId(managerId));
		 fileContent = fileContent.replace("#appraisalLink",propReader.getAPPRAISAL_SYSTEM_LINK());
		 fileContent = fileContent.replace("#appraisalMail",propReader.getAPPRAISAL_MAIL_ADDRESS());

		} catch (Exception e) {
			logger.info("ClassName: AppraisalCycleManager");
			logger.info("MethodName:getSubmitTargetMailContent");
			logger.info("Mail not sent");
			logger.info(e);
		}
		 return fileContent;
	}
	
	/* Added by Shubhi */
	public String getSubmitTargetByEmployeeMailContent(String targetId, String targetAchieved, int empId, int managerId){
		String fileContent = "";
		PropertyReader propReader = new PropertyReader();
		FileReader fileReader;
		try{
			if(targetAchieved.equals("1"))
			{
				fileReader = new FileReader(propReader.getTARGET_ACHIEVED_CONTENT());
			}
			else{
				fileReader = new FileReader(propReader.getTARGET_UNACHIEVED_CONTENT());
			}
    	
	     int i ;
		 while((i =  fileReader.read())!=-1){
		   char ch = (char)i;
		   fileContent = fileContent + ch; 
		  }
		 
		 fileContent = fileContent.replace("#id",targetId);
		 fileContent = fileContent.replace("#empName",getEmployeeNameByEmpId(empId));
		 fileContent = fileContent.replace("#managerName",getEmployeeNameByEmpId(managerId));
		 fileContent = fileContent.replace("#appraisalLink",propReader.getAPPRAISAL_SYSTEM_LINK());
		 fileContent = fileContent.replace("#appraisalMail",propReader.getAPPRAISAL_MAIL_ADDRESS());

		} catch (Exception e) {
			logger.info("ClassName: AppraisalCycleManager");
			logger.info("MethodName:getSubmitTargetMailContent");
			logger.info("Mail not sent");
			logger.info(e);
		}
		 return fileContent;
	}
	
	
	public String getARSubmitMailContent(String managerName,String arName){
		String fileContent = "";
		PropertyReader propReader = new PropertyReader();
		try{
		FileReader fileReader = new FileReader(propReader.getAR_COMPLETED_CONTENT());
    	
	     int i ;
		 while((i =  fileReader.read())!=-1){
		   char ch = (char)i;
		   fileContent = fileContent + ch; 
		  }
		 
		 
		 fileContent = fileContent.replace("#appraisalMail",propReader.getAPPRAISAL_MAIL_ADDRESS());
		 fileContent = fileContent.replace("#managerName",managerName);
	     fileContent = fileContent.replace("#arName",arName);
	     fileContent = fileContent.replace("#appraisalLink", propReader.getAPPRAISAL_SYSTEM_LINK());
	     
		} catch (Exception e) {
			logger.info("ClassName: AppraisalCycleManager");
			logger.info("MethodName:getARSubmitMailContent");
			logger.info("Mail not sent");
			logger.info(e);
		}
		 return fileContent;
	}
	
	public String getSLCompletedMailContent(String empName){
		String fileContent = "";
		PropertyReader propReader = new PropertyReader();
		try{
		FileReader fileReader = new FileReader(propReader.getSL_COMPLETED_CONTENT());
    	
	     int i ;
		 while((i =  fileReader.read())!=-1){
		   char ch = (char)i;
		   fileContent = fileContent + ch; 
		  }
		 
		 
		 fileContent = fileContent.replace("#appraisalMail",propReader.getAPPRAISAL_MAIL_ADDRESS());
		 fileContent = fileContent.replace("#empName",empName);
	     fileContent = fileContent.replace("#appraisalLink", propReader.getAPPRAISAL_SYSTEM_LINK());
	     
		} catch (Exception e) {
			logger.info("ClassName: AppraisalCycleManager");
			logger.info("MethodName:getARSubmitMailContent");
			logger.info("Mail not sent");
			logger.info(e);
		}
		 return fileContent;
	}
	
	
	public String getHRCompletedContent(String cooName){
		String fileContent = "";
		PropertyReader propReader = new PropertyReader();
		try{
		FileReader fileReader = new FileReader(propReader.getHR_COMPLETED_CONTENT());
    	
	     int i ;
		 while((i =  fileReader.read())!=-1){
		   char ch = (char)i;
		   fileContent = fileContent + ch; 
		  }
		 
		 
		 fileContent = fileContent.replace("#appraisalMail",propReader.getAPPRAISAL_MAIL_ADDRESS());
	     fileContent = fileContent.replace("#appraisalLink", propReader.getAPPRAISAL_SYSTEM_LINK());
	     fileContent = fileContent.replace("#cooName",cooName);
	     
		} catch (Exception e) {
			logger.info("ClassName: AppraisalCycleManager");
			logger.info("MethodName:getARSubmitMailContent");
			logger.info("Mail not sent");
			logger.info(e);
		}
		 return fileContent;
	}
	public String getManagerAdditionalReviewMailContent(String managerName,String arName){
		String fileContent = "";
		PropertyReader propReader = new PropertyReader();
		try{
		FileReader fileReader = new FileReader(propReader.getMR_TO_ADD_REVIEW_CONTENT());
    	
	     int i ;
		 while((i =  fileReader.read())!=-1){
		   char ch = (char)i;
		   fileContent = fileContent + ch; 
		  }
		 
		 
		 fileContent = fileContent.replace("#appraisalMail",propReader.getAPPRAISAL_MAIL_ADDRESS());
	     fileContent = fileContent.replace("#appraisalLink", propReader.getAPPRAISAL_SYSTEM_LINK());
	     fileContent = fileContent.replace("#managerName",managerName);
	     fileContent = fileContent.replace("#arName",arName);
	     
		} catch (Exception e) {
			logger.info("ClassName: AppraisalCycleManager");
			logger.info("MethodName:getARSubmitMailContent");
			logger.info("Mail not sent");
			logger.info(e);
		}
		 return fileContent;
	}
	


	public void changeStatus(int empId,int statusId, int appCycleId){
		String status = dao.getStatusByStatusId(statusId);
		dao.changeStatus(empId,status,appCycleId);
	}

	public ArrayList<String>getRole(int empId){
		return dao.getRole(empId);
	}
	public ArrayList<Employee_Manager>getAllEmpListByAppCycleId(List<Integer> idList,int appCycleIdInt){
		return dao.getAllEmpListByAppCycleId(idList,appCycleIdInt);
	}
	/*Added by saurabh */
	public String getMSPSLink()
	{
		String mspsLink = pr.getMSPS_LINK();
		return mspsLink;
	}
	
	/* Added by Saurabh for Dashboard*/
	

	
	
	
	public ArrayList<Employee> getAppraiseeListGrpWise(HttpServletRequest request, ArrayList<String> listOfGroups){
		
		String Id = request.getParameter(AppraisalConstants.APP_CYCLE);
		String groupName = request.getParameter(AppraisalConstants.GROUP_NAME);
		
		int appCycleId;
		String group;
	
		if(Id==null){
			appCycleId = -1;
		}
		else if(Id.equals("")){
			appCycleId = -1;
		}
		else{
			appCycleId = Integer.parseInt(Id);
		}
		if(groupName==null){
			group="-1";
		}
		else{
			group = groupName;
		}
		
		return dao.getAppraiseeListGrpWise(appCycleId, groupName,listOfGroups);
	}


	
	public List<Employee> findManagerReviewerByEmpId(int empId) {
		return dao.findManagerReviewerByEmpId(empId);
	}

	
	
	public ArrayList<Employee> getAppraiseeListByGroups(int appCycleId, List<String> listOfGroups) {
		return dao.getAppraiseeListByGroups(appCycleId,listOfGroups);
	}

	public boolean isSubordinate(String empId, int manager) {
		return dao.isSubordinates(empId,manager);
	}

	public String updateTargetByEmployee(String id, Employee emp, String targetAchieved,
			String empRemarks) {
		String result;
		String subject;
		Employee manager = findEmployeeByEmpID(emp.getManager());
		if(targetAchieved.equals("1"))
			subject = AppraisalConstants.TARGET_IS_ACHIEVED;
		else
			subject = AppraisalConstants.TARGET_UNACHIEVED;
		
		 try
         {  result = dao.updateTargetByEmployee(id,targetAchieved,empRemarks);
			 mail.sendMail(manager.getEmail_ID(),emp.getEmail_ID(),
					null, subject, getSubmitTargetByEmployeeMailContent(id, targetAchieved, emp.getEmployeeId(), manager.getEmployeeId()));
         }
		 catch (Exception e) {
			logger.info("ClassName:TargetController");
			logger.info("MethodName:submitTargets");
			logger.info("Mail Not Sent");		
			result = AppraisalConstants.FAILURE;
		}
		 return result;
	}

	
	public List<String> getDistinctDesignationByGroup(String group)
	{
		return dao.getDistinctDesignationByGroup(group);
	}
	public List <String> getEmployeeListByDesignation(String design, String group)
	{
		return dao.getEmployeeListByDesignation(design,group);
	}

	public List<String> getEmployeeList() {
		
		return dao.getEmployeeList();
	}
}