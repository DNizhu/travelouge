package com.thepsi.appraisalSystem.util;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import com.thepsi.appraisalSystem.util.ProbationReminderMailSender;;

public class SchedularForProbationEmails extends QuartzJobBean  {
	
	/*@Autowired 
	private ProbationManager probationManager;
	@Autowired
	private MailSender mail;
	@Autowired 
	private PropertyReader properties;
	private Logger logger = Logger.getLogger(SchedularForProbationEmails.class);
*/
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {

		System.out.println("inside probation reminder mail schedular");
		Logger logger = Logger.getLogger(AppraisalConstants.LOG_NAME);
		logger.info("ProbationReminderNotificationMailSender Running");
		
		//ProbationReminderMailSender obj= new ProbationReminderMailSender();
		try{
			ProbationReminderMailSender obj= new ProbationReminderMailSender();
		    obj.sendProbationReminderMails();
		}catch(Exception e)
		{
			e.printStackTrace();
			logger.debug("Error", e);
		}
		logger.info("ProbationReminderNotificationMailSender Stopped");
	}
}