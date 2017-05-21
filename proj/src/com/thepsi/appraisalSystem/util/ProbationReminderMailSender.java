package com.thepsi.appraisalSystem.util;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.sun.xml.internal.fastinfoset.sax.Properties;
import com.thepsi.appraisalSystem.dao.ProbationDAO;
import com.thepsi.appraisalSystem.model.Employee;
import com.thepsi.appraisalSystem.model.ProbationData;
import com.thepsi.appraisalSystem.services.ProbationManager;

public class ProbationReminderMailSender {
		
	/*@Autowired
	private ProbationManager probationManager;*/
/*	@Autowired*/
	private MailSender mail = new MailSender();
/*	@Autowired*/
	PropertyReader properties = new PropertyReader() ;
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanProperties.xml");
	ProbationDAO probationDAO = context.getBean(ProbationDAO.class);
	
	//ProbationDAO probationDAO = new ProbationDAO();
	//ProbationDAO probationDao = new ProbationDAO();
	
	private Logger logger = Logger.getLogger(SchedularForProbationEmails.class);
	
		public void sendProbationReminderMails(){
			
			
			System.out.println("inside sendProbationReminderMails");
		try {
			
				List<Employee> probationersList = probationDAO.getProbationersList();
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
				List<ProbationData> probationDataList = new ArrayList<ProbationData>();
				int i;
				Date date1;
				Date generalComments_1, generalComments_2, generalComments_3, month1_1, month1_2, month1_3, month2_1, month2_2, month2_3, month3_1, month3_2, month3_3,
				midTerm_1, midTerm_2, midTerm_3, month4_1, month4_2, month4_3, month5_1, month5_2, month5_3, extnMonth1_1, extnMonth1_2, extnMonth1_3, extnMonth2_1, extnMonth2_2, extnMonth2_3,
				extnOrEval;
				String mailTo="", mailCC="";
				String mailFrom = properties.getPROBATION_MAIL_FROM();
				String mailSub = "", mailContent = "";
				String mgmtEmail = properties.getMGMT_MAIL_ADDRESS();
				String HRTeamEmail = properties.getHR_TEAM_MAIL_ADDRESS();
				String probationerName = "", managerName = "", groupHeadName="";
				
				for(i=0;i<probationersList.size();i++){	
					try {
						mailTo = ""; mailCC = "";
						mailSub = ""; mailContent = "";
						
						Employee probationer = probationersList.get(i);
						probationerName = probationer.getEmployeeName();
						probationDataList = probationDAO.getProbationData(probationer.getEmployeeId()); 
						
						String generalCommentsFormStatus=null, month1Status=null, month2Status=null, month3Status=null, month4Status=null, month5Status=null, midTermStatus=null, extensionStatus=null,
								  evaluationStatus=null, extnMonth1Status=null, extnMonth2Status=null;
						  if(probationDataList!=null){
							  for(int k=0;k<probationDataList.size();k++){
									ProbationData probationData = probationDataList.get(k);
									if(probationData.getForm().equals(AppraisalConstants.PROBATION_GENERAL_COMMENTS_FORM)){
										generalCommentsFormStatus = probationData.getStatus();
									}	
									if(probationData.getForm().equals(AppraisalConstants.PROBATION_MONTH1_FORM)){
										month1Status = probationData.getStatus();
									}	
									if(probationData.getForm().equals(AppraisalConstants.PROBATION_MONTH2_FORM)){
										month2Status = probationData.getStatus();
									}		
									if(probationData.getForm().equals(AppraisalConstants.PROBATION_MONTH3_FORM)){
										month3Status = probationData.getStatus();
									}	
									if(probationData.getForm().equals(AppraisalConstants.PROBATION_MONTH4_FORM)){
										month4Status = probationData.getStatus();
									}	
									if(probationData.getForm().equals(AppraisalConstants.PROBATION_MONTH5_FORM)){
										month5Status = probationData.getStatus();
									}	
									if(probationData.getForm().equals(AppraisalConstants.PROBATION_MID_TERM_FORM)){
										midTermStatus = probationData.getStatus();
									}	
									if(probationData.getForm().equals(AppraisalConstants.PROBATION_EXTENSION_FORM)){
										extensionStatus = probationData.getStatus();
									}	
									if(probationData.getForm().equals(AppraisalConstants.PROBATION_EXTENTION_MONTH1_FORM)){
										extnMonth1Status = probationData.getStatus();
									}	
									if(probationData.getForm().equals(AppraisalConstants.PROBATION_EXTENTION_MONTH2_FORM)){
										extnMonth2Status = probationData.getStatus();
									}	
									if(probationData.getForm().equals(AppraisalConstants.PROBATION_EVALUATION_FORM)){
										evaluationStatus = probationData.getStatus();
									}		
								}
						     }
						String probationerEmail = probationer.getEmail_ID();
						int manager = probationer.getManager();
						Employee managerEmployee = probationDAO.getEmployeeFromId(manager);
						String managerEmail = null;
						if(managerEmployee!=null){
							managerEmail = managerEmployee.getEmail_ID();
							managerName = managerEmployee.getEmployeeName();
						}
							
						int goupHeadId = probationDAO.getGroupHead(probationer);
						Employee groupHead = null;
						String groupHeadEmail = null;
						
						if(goupHeadId!=0){
							groupHead = probationDAO.getEmployeeFromId(goupHeadId);
							groupHeadEmail = groupHead.getEmail_ID();
							groupHeadName = groupHead.getEmployeeName();
						}
							
						String doj = probationer.getDate_of_joining();
						String currentDate = formatter.format(new Date());
						date1 = (Date)formatter.parse(doj);
						
						generalComments_1 = DateUtils.addDays(date1, 7);
						generalComments_2 = DateUtils.addDays(date1, 12);
						generalComments_3 = DateUtils.addDays(date1, 14);
						month1_1 = DateUtils.addDays(DateUtils.addMonths(date1, 1), -7);
						month1_2 = DateUtils.addDays(DateUtils.addMonths(date1, 1), -3);
						month1_3 = DateUtils.addDays(DateUtils.addMonths(date1, 1), -1);
						month2_1 = DateUtils.addDays(DateUtils.addMonths(date1, 2), -7);
						month2_2 = DateUtils.addDays(DateUtils.addMonths(date1, 2), -3);
						month2_3 = DateUtils.addDays(DateUtils.addMonths(date1, 2), -1);
						month3_1 = DateUtils.addDays(DateUtils.addMonths(date1, 3), -7);
						month3_2 = DateUtils.addDays(DateUtils.addMonths(date1, 3), -3);
						month3_3 = DateUtils.addDays(DateUtils.addMonths(date1, 3), -1);
						month4_1 = DateUtils.addDays(DateUtils.addMonths(date1, 4), -7);
						month4_2 = DateUtils.addDays(DateUtils.addMonths(date1, 4), -3);
						month4_3 = DateUtils.addDays(DateUtils.addMonths(date1, 4), -1);
						month5_1 = DateUtils.addDays(DateUtils.addMonths(date1, 5), -7);
						month5_2 = DateUtils.addDays(DateUtils.addMonths(date1, 5), -3);
						month5_3 = DateUtils.addDays(DateUtils.addMonths(date1, 5), -1);
						midTerm_1 = DateUtils.addDays(DateUtils.addMonths(date1, 3), -7);
						midTerm_2 = DateUtils.addDays(DateUtils.addMonths(date1, 3), -3);
						midTerm_3 = DateUtils.addDays(DateUtils.addMonths(date1, 3), -1);
						extnMonth1_1 = DateUtils.addDays(DateUtils.addMonths(date1, 7), -7);
						extnMonth1_2 = DateUtils.addDays(DateUtils.addMonths(date1, 7), -3);
						extnMonth1_3 = DateUtils.addDays(DateUtils.addMonths(date1, 7), -1);
						extnMonth2_1 = DateUtils.addDays(DateUtils.addMonths(date1, 8), -7);
						extnMonth2_2 = DateUtils.addDays(DateUtils.addMonths(date1, 8), -3);
						extnMonth2_3 = DateUtils.addDays(DateUtils.addMonths(date1, 8), -1);
						extnOrEval = DateUtils.addDays(DateUtils.addMonths(date1, 5), -1);   // date for sending email to take a decision on Probation Evaluation/Extension
						
						// reminders for General Comments Form
						// reminder 1 week before for general comments
						if(formatter.format(generalComments_1).equals(currentDate))	{				
							mailTo = probationerEmail;
							mailCC = managerEmail + "," +groupHeadEmail + "," + HRTeamEmail+ "," + mgmtEmail;
							mailSub = "Probation Evaluation for "+ probationerName + "for General Comments Form - DOJ: "+doj;
							mailContent = probationDAO.getProbationReminderMailContent(probationerName, "General Comments" , null);
							if(mailTo!=null && (!mailTo.isEmpty()))
								mail.sendMail(mailTo, mailFrom, mailCC, mailSub, mailContent);
						}// reminder before 3,1 day
						else if(formatter.format(generalComments_2).equals(currentDate) || formatter.format(generalComments_3).equals(currentDate)){         // reminder 3,1 days before for general comments
							if(generalCommentsFormStatus==null || (generalCommentsFormStatus!=null && !generalCommentsFormStatus.equalsIgnoreCase(AppraisalConstants.STATUS_SELF_COMPLETED))){
								mailTo = probationerEmail;
								mailCC = managerEmail + "," +groupHeadEmail + "," + HRTeamEmail+ "," + mgmtEmail;
								mailSub = "Probation Evaluation for "+ probationerName + "for General Comments Form - DOJ: "+doj;
								mailContent = probationDAO.getProbationReminderMailContent(probationerName, "General Comments" , null);
								if(mailTo!=null && (!mailTo.isEmpty()))
									mail.sendMail(mailTo, mailFrom, mailCC, mailSub, mailContent);
							}
						}
						// reminders for monthly forms
						// reminder 1 week before for monthly forms
						else if(formatter.format(month1_1).equals(currentDate) || formatter.format(month2_1).equals(currentDate) || formatter.format(month3_1).equals(currentDate) || formatter.format(month4_1).equals(currentDate) || formatter.format(month5_1).equals(currentDate)){				
							mailTo = probationerEmail;
							mailCC = managerEmail + "," +groupHeadEmail + "," + HRTeamEmail+ "," + mgmtEmail;
							mailSub = "Probation Evaluation for "+ probationerName + "for Month Form - DOJ: "+doj;
							mailContent = probationDAO.getProbationReminderMailContent(probationerName, "Month" , null);
							if(mailTo!=null && (!mailTo.isEmpty()))
								mail.sendMail(mailTo, mailFrom, mailCC, mailSub, mailContent);
						}  // reminder before 3,1 day
						else if(formatter.format(month1_2).equals(currentDate) || formatter.format(month1_3).equals(currentDate)){
							if(month1Status==null || (month1Status!=null && month1Status.equals(AppraisalConstants.STATUS_NOT_STARTED))){
								mailTo = probationerEmail;
								mailCC = managerEmail + "," +groupHeadEmail + "," + HRTeamEmail+ "," + mgmtEmail;
								mailSub = "Probation Evaluation for "+ probationerName + "for Month Form - DOJ: "+doj;
								mailContent = probationDAO.getProbationReminderMailContent(probationerName, "Month" , null);
								if(mailTo!=null && (!mailTo.isEmpty()))
									mail.sendMail(mailTo, mailFrom, mailCC, mailSub, mailContent);
							}
							if(month1Status!=null && month1Status.equals(AppraisalConstants.STATUS_SELF_COMPLETED)){
								mailTo = managerEmail;
								mailCC = groupHeadEmail + "," + HRTeamEmail+ "," + mgmtEmail;
								mailSub = "Probation Evaluation for "+ probationerName + "for Month Form - DOJ: "+doj;
								mailContent = probationDAO.getProbationReminderMailContent(managerName, "Month" , probationerName);
								if(mailTo!=null && (!mailTo.isEmpty()))
									mail.sendMail(mailTo, mailFrom, mailCC, mailSub, mailContent);
							}
						}
						else if( formatter.format(month2_2).equals(currentDate) || formatter.format(month2_3).equals(currentDate)){
							if(month2Status==null || (month2Status!=null && month2Status.equals(AppraisalConstants.STATUS_NOT_STARTED))){
								mailTo = probationerEmail;
								mailCC = managerEmail + "," +groupHeadEmail + "," + HRTeamEmail+ "," + mgmtEmail;
								mailSub = "Probation Evaluation for "+ probationerName + "for Month Form - DOJ: "+doj;
								mailContent = probationDAO.getProbationReminderMailContent(probationerName, "Month" , null);
								if(mailTo!=null && (!mailTo.isEmpty()))
									mail.sendMail(mailTo, mailFrom, mailCC, mailSub, mailContent);
							}
							if(month2Status!=null && month2Status.equals(AppraisalConstants.STATUS_SELF_COMPLETED)){
								mailTo = managerEmail;
								mailCC = groupHeadEmail + "," + HRTeamEmail+ "," + mgmtEmail;
								mailSub = "Probation Evaluation for "+ probationerName + "for Month Form - DOJ: "+doj;
								mailContent = probationDAO.getProbationReminderMailContent(managerName, "Month" , probationerName);
								if(mailTo!=null && (!mailTo.isEmpty()))
									mail.sendMail(mailTo, mailFrom, mailCC, mailSub, mailContent);
							}
						}
						else if(formatter.format(month3_2).equals(currentDate) || formatter.format(month3_3).equals(currentDate)){
							if(month3Status==null || (month3Status!=null && month3Status.equals(AppraisalConstants.STATUS_NOT_STARTED))){
								mailTo = probationerEmail;
								mailCC = managerEmail + "," +groupHeadEmail + "," + HRTeamEmail+ "," + mgmtEmail;
								mailSub = "Probation Evaluation for "+ probationerName + "for Month Form - DOJ: "+doj;
								mailContent = probationDAO.getProbationReminderMailContent(probationerName, "Month" , null);
								if(mailTo!=null && (!mailTo.isEmpty()))
									mail.sendMail(mailTo, mailFrom, mailCC, mailSub, mailContent);
							}
							if(month3Status!=null && month3Status.equals(AppraisalConstants.STATUS_SELF_COMPLETED)){
								mailTo = managerEmail;
								mailCC = groupHeadEmail + "," + HRTeamEmail+ "," + mgmtEmail;
								mailSub = "Probation Evaluation for "+ probationerName + "for Month Form - DOJ: "+doj;
								mailContent = probationDAO.getProbationReminderMailContent(managerName, "Month" , probationerName);
								if(mailTo!=null && (!mailTo.isEmpty()))
									mail.sendMail(mailTo, mailFrom, mailCC, mailSub, mailContent);
							}
						}
						else if(formatter.format(month4_2).equals(currentDate) || formatter.format(month4_3).equals(currentDate)){
							if(month4Status==null || (month4Status!=null && month4Status.equals(AppraisalConstants.STATUS_NOT_STARTED))){
								mailTo = probationerEmail;
								mailCC = managerEmail + "," +groupHeadEmail + "," + HRTeamEmail+ "," + mgmtEmail;
								mailSub = "Probation Evaluation for "+ probationerName + "for Month Form - DOJ: "+doj;
								mailContent = probationDAO.getProbationReminderMailContent(probationerName, "Month" , null);
								if(mailTo!=null && (!mailTo.isEmpty()))
									mail.sendMail(mailTo, mailFrom, mailCC, mailSub, mailContent);
							}
							if(month4Status!=null && month4Status.equals(AppraisalConstants.STATUS_SELF_COMPLETED)){
								mailTo = managerEmail;
								mailCC = groupHeadEmail + "," + HRTeamEmail+ "," + mgmtEmail;
								mailSub = "Probation Evaluation for "+ probationerName + "for Month Form - DOJ: "+doj;
								mailContent = probationDAO.getProbationReminderMailContent(managerName, "Month" , probationerName);
								if(mailTo!=null && (!mailTo.isEmpty()))
									mail.sendMail(mailTo, mailFrom, mailCC, mailSub, mailContent);
							}
						}
						else if(formatter.format(month5_2).equals(currentDate) || formatter.format(month5_3).equals(currentDate)){
							if(month5Status==null || (month5Status!=null && month5Status.equals(AppraisalConstants.STATUS_NOT_STARTED))){
								mailTo = probationerEmail;
								mailCC = managerEmail + "," +groupHeadEmail + "," + HRTeamEmail+ "," + mgmtEmail;
								mailSub = "Probation Evaluation for "+ probationerName + "for Month Form - DOJ: "+doj;
								mailContent = probationDAO.getProbationReminderMailContent(probationerName, "Month" , null);
								if(mailTo!=null && (!mailTo.isEmpty()))
									mail.sendMail(mailTo, mailFrom, mailCC, mailSub, mailContent);
							}
							if(month5Status!=null && month5Status.equals(AppraisalConstants.STATUS_SELF_COMPLETED)){
								mailTo = managerEmail;
								mailCC = groupHeadEmail + "," + HRTeamEmail+ "," + mgmtEmail;
								mailSub = "Probation Evaluation for "+ probationerName + "for Month Form - DOJ: "+doj;
								mailContent = probationDAO.getProbationReminderMailContent(managerName, "Month" , probationerName);
								if(mailTo!=null && (!mailTo.isEmpty()))
									mail.sendMail(mailTo, mailFrom, mailCC, mailSub, mailContent);
							}
						}
						if(formatter.format(midTerm_1).equals(currentDate)){
							mailTo = managerEmail;
							mailCC = groupHeadEmail + "," + HRTeamEmail+ "," + mgmtEmail;
							mailSub = "Probation Evaluation for "+ probationerName + "for Mid Term Form - DOJ: "+doj;
							mailContent = probationDAO.getProbationReminderMailContent(managerName, "Mid Term" , probationerName);
							if(mailTo!=null && (!mailTo.isEmpty()))
								mail.sendMail(mailTo, mailFrom, mailCC, mailSub, mailContent);
						}
						if(formatter.format(midTerm_2).equals(currentDate) || formatter.format(midTerm_3).equals(currentDate)){
							if(midTermStatus==null || (midTermStatus!=null && midTermStatus.equals(AppraisalConstants.STATUS_NOT_STARTED))){
								mailTo = managerEmail;
								mailCC = groupHeadEmail + "," + HRTeamEmail+ "," + mgmtEmail;
								mailSub = "Probation Evaluation for "+ probationerName + "for Mid Term Form - DOJ: "+doj;
								mailContent = probationDAO.getProbationReminderMailContent(managerName, "Mid Term" , probationerName);
								if(mailTo!=null && (!mailTo.isEmpty()))
									mail.sendMail(mailTo, mailFrom, mailCC, mailSub, mailContent);
							}
							if(midTermStatus!=null && midTermStatus.equals(AppraisalConstants.STATUS_MANAGER_COMPLETED)){
								mailTo = groupHeadEmail;
								mailCC = HRTeamEmail+ "," + mgmtEmail;
								mailSub = "Probation Evaluation for "+ probationerName + "for Mid Term Form - DOJ: "+doj;
								mailContent = probationDAO.getProbationReminderMailContent(groupHeadName, "Mid Term" , probationerName);
								if(mailTo!=null && (!mailTo.isEmpty()))
									mail.sendMail(mailTo, mailFrom, mailCC, mailSub, mailContent);
							}
						}
						if(formatter.format(extnOrEval).equals(currentDate)){
							mailTo = managerEmail;
							mailCC = groupHeadEmail + "," + HRTeamEmail + "," + mgmtEmail;
							mailSub = "Probation Evaluation for "+ probationerName + "for Evaluation/Extension - DOJ: "+doj;
							mailContent = probationDAO.getProbationReminderMailContent(managerName, "Evaluation or Extension Form" , probationerName);
							if(mailTo!=null && (!mailTo.isEmpty()))
								mail.sendMail(mailTo, mailFrom, mailCC, mailSub, mailContent);
						}
						// for evaluation form
						if(evaluationStatus!=null){
							if(evaluationStatus.equals(AppraisalConstants.STATUS_MANAGER_COMPLETED))
							{
								mailTo = groupHeadEmail;
								mailCC = HRTeamEmail + "," + mgmtEmail;
								mailSub = "Probation Evaluation for "+ probationerName + "for Evaluation form - DOJ: "+doj;
								mailContent = probationDAO.getProbationReminderMailContent(groupHeadName, "Evaluation" , probationerName);
								if(mailTo!=null && (!mailTo.isEmpty()))
									mail.sendMail(mailTo, mailFrom, mailCC, mailSub, mailContent);
							}
							if(evaluationStatus.equals(AppraisalConstants.STATUS_GH_COMPLETED))
							{
								mailTo = HRTeamEmail;
								mailCC = mgmtEmail;
								mailSub = "Probation Evaluation for "+ probationerName + "for Evaluation form - DOJ: "+doj;
								mailContent = probationDAO.getProbationReminderMailContent("HR Team", "Evaluation" , probationerName);
								if(mailTo!=null && (!mailTo.isEmpty()))
									mail.sendMail(mailTo, mailFrom, mailCC, mailSub, mailContent);
							}
							if(evaluationStatus.equals(AppraisalConstants.STATUS_HR_COMPLETED))
							{
								mailTo = mgmtEmail;
								mailCC = "";
								mailSub = "Probation Evaluation for "+ probationerName + "for Evaluation form - DOJ: "+doj;
								mailContent = probationDAO.getProbationReminderMailContent("Management", "Evaluation" , probationerName);
								if(mailTo!=null && (!mailTo.isEmpty()))
									mail.sendMail(mailTo, mailFrom, mailCC, mailSub, mailContent);
							}
						}
						// for extension form
						if(extensionStatus!=null){
							if(extensionStatus.equals(AppraisalConstants.STATUS_MANAGER_COMPLETED)){
								mailTo = groupHeadEmail;
								mailCC = mgmtEmail;
								mailSub = "Probation Evaluation for "+ probationerName + "for Extension Form - DOJ: "+doj;
								mailContent = probationDAO.getProbationReminderMailContent(groupHeadName, "Extension" , probationerName);
								if(mailTo!=null && (!mailTo.isEmpty()))
									mail.sendMail(mailTo, mailFrom, mailCC, mailSub, mailContent);
							}
							if(extensionStatus.equals(AppraisalConstants.STATUS_GH_COMPLETED)){
								mailTo = mgmtEmail;
								mailCC = "";
								mailSub = "Probation Evaluation for "+ probationerName + "for Extension Form - DOJ: "+doj;
								mailContent = probationDAO.getProbationReminderMailContent("Management", "Extension" , probationerName);
								if(mailTo!=null && (!mailTo.isEmpty()))
									mail.sendMail(mailTo, mailFrom, mailCC, mailSub, mailContent);
							}
						}
						// for extension monthly forms
						if(extensionStatus!=null){
							if(formatter.format(extnMonth1_1).equals(currentDate) || formatter.format(extnMonth2_1).equals(currentDate)){
								mailTo = probationerEmail;
								mailCC = managerEmail + "," + groupHeadEmail + "," + HRTeamEmail+ "," + mgmtEmail;
								mailSub = "Probation Evaluation for "+ probationerName + "for Extension Month Form - DOJ: "+doj;
								mailContent = probationDAO.getProbationReminderMailContent(probationerName, "Extension Month" , null);
								if(mailTo!=null && (!mailTo.isEmpty()))
									mail.sendMail(mailTo, mailFrom, mailCC, mailSub, mailContent);
							}
							else if(formatter.format(extnMonth1_2).equals(currentDate) || formatter.format(extnMonth1_3).equals(currentDate)){
								if(extnMonth1Status==null || (extnMonth1Status!=null && extnMonth1Status.equals(AppraisalConstants.STATUS_NOT_STARTED))){
									mailTo = probationerEmail;
									mailCC = managerEmail + "," +groupHeadEmail + "," + HRTeamEmail+ "," + mgmtEmail;
									mailSub = "Probation Evaluation for "+ probationerName + "for Extension Month Form - DOJ: "+doj;
									mailContent = probationDAO.getProbationReminderMailContent(probationerName, "Extension Month" , null);
									if(mailTo!=null && (!mailTo.isEmpty()))
										mail.sendMail(mailTo, mailFrom, mailCC, mailSub, mailContent);
								}
								if(extnMonth1Status!=null && extnMonth1Status.equals(AppraisalConstants.STATUS_SELF_COMPLETED)){
									mailTo = managerEmail;
									mailCC = groupHeadEmail + "," + HRTeamEmail+ "," + mgmtEmail;
									mailSub = "Probation Evaluation for "+ probationerName + "for Extension Month Form - DOJ: "+doj;
									mailContent = probationDAO.getProbationReminderMailContent(probationerName, "Extension Month" , null);
									if(mailTo!=null && (!mailTo.isEmpty()))
										mail.sendMail(mailTo, mailFrom, mailCC, mailSub, mailContent);
								}
							}
						if(formatter.format(extnMonth2_2).equals(currentDate) || formatter.format(extnMonth2_3).equals(currentDate)){
								if(extnMonth2Status==null || (extnMonth2Status!=null && extnMonth2Status.equals(AppraisalConstants.STATUS_NOT_STARTED))){
									mailTo = probationerEmail;
									mailCC = managerEmail + "," +groupHeadEmail + "," + HRTeamEmail+ "," + mgmtEmail;
									mailSub = "Probation Evaluation for "+ probationerName + "for Extension Month Form - DOJ: "+doj;
									mailContent = probationDAO.getProbationReminderMailContent(probationerName, "Extension Month" , null);
									if(mailTo!=null && (!mailTo.isEmpty()))
										mail.sendMail(mailTo, mailFrom, mailCC, mailSub, mailContent);
								}
								if(extnMonth2Status!=null && extnMonth2Status.equals(AppraisalConstants.STATUS_SELF_COMPLETED)){
									mailTo = managerEmail;
									mailCC = groupHeadEmail + "," + HRTeamEmail+ "," + mgmtEmail;
									mailSub = "Probation Evaluation for "+ probationerName + "for Extension Month Form - DOJ: "+doj;
									mailContent = probationDAO.getProbationReminderMailContent(probationerName, "Extension Month" , null);
									if(mailTo!=null && (!mailTo.isEmpty()))
										mail.sendMail(mailTo, mailFrom, mailCC, mailSub, mailContent);
								}
							}
						}
					} catch (Exception e) {
						logger.info("Inside reminder mail sending for probation");
						logger.info(e);
					}
				}
			} 
			catch (Exception e) {
				logger.info("Class Name:ScheduarForProbationEmails");
				logger.info("Method Name:executeInternal");
				logger.info(e);
				e.printStackTrace();
				
			} 
		}
  }
