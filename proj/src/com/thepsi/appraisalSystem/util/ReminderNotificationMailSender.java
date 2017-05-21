package com.thepsi.appraisalSystem.util;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ReminderNotificationMailSender extends QuartzJobBean {
    
	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		
		Logger logger = Logger.getLogger(AppraisalConstants.LOG_NAME);
		
		logger.info("ReminderNotificationMailSender Running");
		
		GetReminderMailService obj= new GetReminderMailService();
		try{
		       obj.sendReminderNotificationMail();
		}catch(Exception e)
		{
			logger.debug("Error", e);
		}
		logger.info("ReminderNotificationMailSender Stopped");
		
	}
}
