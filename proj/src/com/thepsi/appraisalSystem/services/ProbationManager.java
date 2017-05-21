package com.thepsi.appraisalSystem.services;

import java.io.FileReader;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thepsi.appraisalSystem.dao.ProbationDAO;
import com.thepsi.appraisalSystem.model.Employee;

import com.thepsi.appraisalSystem.model.ProbationData;

import com.thepsi.appraisalSystem.util.AppraisalConstants;
import com.thepsi.appraisalSystem.util.PropertyReader;

@Service
public class ProbationManager {

@Autowired
	private ProbationDAO probationDAO;
/** The logger. */
	private Logger logger = Logger.getLogger(AppraisalConstants.LOG_NAME);
	

	public List<Employee> getProbationersList(){
		return probationDAO.getProbationersList();
	}
	
	public List<Employee> getProbationersListForManagers(int empId){
		return probationDAO.getProbationersListForManagers(empId);
	}
	
	public List<Employee> getAllEmployees(){
		return probationDAO.getAllEmployees();
	}
	
	public List<Employee> getProbationersListForGroup(String groupName){
		return probationDAO.getProbationersListForGroup(groupName);
	}
	
	public List<Employee> getProbationCompletedList(){
		return probationDAO.getProbationCompletedList();
	}
	
	public List<Employee> getProbationCompletedListForGroup(String groupName){
		return probationDAO.getProbationCompletedListForGroup(groupName);
	}
	
	public List<Employee> getProbationCompletedListForManagers(int empId){
		return probationDAO.getProbationCompletedListForManagers(empId);
	}
	
	public List<Employee> getPendingDecisionsListForManagement(){
		return probationDAO.getPendingDecisionsListForManagement();
	}
	
	public List<Employee> getPendingDecisionsListForHR(){
		return probationDAO.getPendingDecisionsListForHR();
	}
	
	public List<Employee> getPendingDecisionsListForGH(String groupName){
		return probationDAO.getPendingDecisionsListForGH(groupName);
	}
	public List<Employee> getPendingDecisionsForManager(int empId){
		return probationDAO.getPendingDecisionsForManager(empId);
	}
	public List<String> getGroupNamesUnderGH(int empId){
		 return probationDAO.getGroupNamesUnderGH(empId);
	}
	 
	public Employee getEmployeeFromId(int empId)
	{
		return probationDAO.getEmployeeFromId(empId);
	}
	
	public void createProbationEntry(int empId,String form,String status,int rating, int flag){
		probationDAO.createProbationEntry(empId, form, status,rating, flag);
	}
	
	public List<ProbationData> getProbationData(int empId){
		return probationDAO.getProbationData(empId);
	}
	

	public String getFormStatus(int empId,String form){
		return probationDAO.getFormStatus(empId, form);
	}
	

	

	
	public int getGroupHead(Employee employee){
		return probationDAO.getGroupHead(employee);
	}
	public List getHR(){
		return probationDAO.getHR();
	}
	public List getMgmt(){
		return probationDAO.getMgmt();
	}
	

	public String getCOOEmail(){
		return probationDAO.getCOOEmail();
	}
	
	public String getProbationFormSubmitToNextLevelMailContent(String probationerName, String toName, String formName){
		String fileContent = "";
		try{
			PropertyReader propReader = new PropertyReader();
			FileReader fileReader;
			fileReader = new FileReader(propReader.getPROBATION_FORM_SUBMIT_TO_NEXT_LEVEL_MAIL_CONTENT());
		    int i ;
			while((i =  fileReader.read())!=-1){
			   char ch = (char)i;
			   fileContent = fileContent + ch; 
			  }
		 
			fileContent = fileContent.replace("#toName",toName);
			fileContent = fileContent.replace("#probationerName",probationerName);
			fileContent = fileContent.replace("#formName",formName);
			fileContent = fileContent.replace("#probationAppraisalLink",propReader.getPROBATION_APPRAISAL_LINK());

		} catch (Exception e) {
			logger.info("ClassName:ProbationManager");
			logger.info("MethodName:getProbationFormSubmitToNextLevelMailContent");
			logger.info("Mail not sent");
			logger.info(e);
		}
		 return fileContent;
	}
	
	public String getProbationFinalFormSubmitMailContent(String probationerName, String formName){
		String fileContent = "";
		try{
			PropertyReader propReader = new PropertyReader();
			FileReader fileReader;
			fileReader = new FileReader(propReader.getPROBATION_FINAL_FORM_SUBMIT_MAIL_CONTENT());
		    int i ;
			while((i =  fileReader.read())!=-1){
			   char ch = (char)i;
			   fileContent = fileContent + ch; 
			  }
		 
			fileContent = fileContent.replace("#probationerName",probationerName);
			fileContent = fileContent.replace("#formName",formName);
			fileContent = fileContent.replace("#probationAppraisalLink",propReader.getPROBATION_APPRAISAL_LINK());

		} catch (Exception e) {
			logger.info("ClassName: ProbationManager");
			logger.info("MethodName:getProbationFinalFormSubmitMailContent");
			logger.info("Mail not sent");
			logger.info(e);
		}
		 return fileContent;
	}
	
	public String getProbationFormDelegationtMailContent(String probationerName, int month, String delegatedTo, String delegatedBy){
		String fileContent = "";
		try{
			PropertyReader propReader = new PropertyReader();
			FileReader fileReader;
			fileReader = new FileReader(propReader.getPROBATION_FORM_DELEGATION_MAIL_CONTENT());
		    int i ;
			while((i =  fileReader.read())!=-1){
			   char ch = (char)i;
			   fileContent = fileContent + ch; 
			  }
		 
			fileContent = fileContent.replace("#probationerName",probationerName);
			fileContent = fileContent.replace("#delegatedTo",delegatedTo);
			fileContent = fileContent.replace("#delegatedBy",delegatedBy);
			fileContent = fileContent.replace("#month",month+"");
			fileContent = fileContent.replace("#probationAppraisalLink",propReader.getPROBATION_APPRAISAL_LINK());

		} catch (Exception e) {
			logger.info("ClassName: ProbationManager");
			logger.info("MethodName:getProbationFormDelegationtMailContent");
			logger.info("Mail not sent");
			logger.info(e);
		}
		 return fileContent;
	}
	
	public String getProbationReminderMailContent(String toName, String form, String probationerName){
		String fileContent = "";
		try{
			PropertyReader propReader = new PropertyReader();
			FileReader fileReader;
			if(probationerName!=null)
				fileReader = new FileReader(propReader.getPROBATION_REMINDER_TO_NEXT_LEVEL_MAIL_CONTENT());
			else
				fileReader = new FileReader(propReader.getPROBATION_REMINDER_MAIL_CONTENT());
		    int i ;
			while((i =  fileReader.read())!=-1){
			   char ch = (char)i;
			   fileContent = fileContent + ch; 
			  }
			fileContent = fileContent.replace("#toName",toName);
			fileContent = fileContent.replace("#form",form);
			fileContent = fileContent.replace("#probationerName", probationerName);
			fileContent = fileContent.replace("#probationAppraisalLink",propReader.getPROBATION_APPRAISAL_LINK());
		} catch (Exception e) {
			logger.info("ClassName: ProbationManager");
			logger.info("MethodName:getProbationFormDelegationtMailContent");
			logger.info("Mail not sent");
			logger.info(e);
		}
		 return fileContent;
		
	}
}
