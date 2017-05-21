package com.thepsi.appraisalSystem.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thepsi.appraisalSystem.dao.SchedulerDao;

import com.thepsi.appraisalSystem.model.Employee;
import com.thepsi.appraisalSystem.model.Employee_Manager;
import com.thepsi.appraisalSystem.model.User_Role;

public class GetReminderMailService {
      
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanProperties.xml");
    
	SchedulerDao schedulerDAO = context.getBean(SchedulerDao.class);
	//private SchedulerDao schedulerDAO = new SchedulerDao();
	private MailSender mail = new MailSender();
	//private MailContent mailContent = new MailContent();
	private Logger logger = Logger.getLogger(AppraisalConstants.LOG_NAME);
	PropertyReader properties = new PropertyReader();
	
	
	//method created for getting Date before 1 day
	private Date getDateAfter(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.DATE, 1); //2 weeks
	    return calendar.getTime();
	}
	
	public void sendReminderNotificationMail() 
	{
		
		String appraisalCycle=null;
		logger.info("ClassName: GetReminderMailService");
		logger.info("METHOD : sendReminderNotificationMail");
		
		logger.info("Finding details of Active Appraisal Cycle");
		
		//AppraisalCycle appraisalCycle = schedulerDAO.getEnableAppCycleId();
		if(appraisalCycle!=null)
		{
			/*logger.info("AppCycle is Enabled");
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date selfReviewDate = null;
			Date managerReviewDate = null;
			Date additionalManagerReviewDate = null;
			Date mgmtReviewDate = null;
			
			
			Date now = new Date();
			Date After = getDateAfter(now);
			
			String AfterStringDate = formatter.format(After);
			
			try {
					selfReviewDate = formatter.parse(appraisalCycle.getSelfReviewDate());
					managerReviewDate = formatter.parse(appraisalCycle.getManagerReviewDate());
					//aghReviewDate = formatter.parse(appraisalCycle.getAghReviewDate());
					//ghReviewDate = formatter.parse(appraisalCycle.getGhReviewDate());
					additionalManagerReviewDate = formatter.parse(appraisalCycle.getAdditionalReviewDate());
					//hrReviewDate = formatter.parse(appraisalCycle.getHrCommentsDate());
					mgmtReviewDate = formatter.parse(appraisalCycle.getManagementCommentsDate());
					After = formatter.parse(AfterStringDate);
			} catch (ParseException e) {
				
				logger.debug(e);
			}*/
			
			
			
		}
		else{
			logger.info("AppCycle is not enabled....So no Mail Sending");
		}
	}
	

	
}
