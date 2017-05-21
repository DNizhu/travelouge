package com.thepsi.appraisalSystem.util;

import java.util.Date;

import java.util.List;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class MailSender {
	
	private Logger logger = Logger.getLogger(AppraisalConstants.LOG_NAME);
	private javax.mail.Session session;
	private PropertyReader pr = new PropertyReader();
	Properties mailProps;

	
	public boolean sendMail(String mailTo,String mailFrom,String mailCC, String mailSub, String mailContent)throws Exception
	{
		
/*		logger.debug("####### Inside sendHTMLMail Method...#########");
		String contentType = "text/html";
		
		Properties props = setMailProperties(mailTo,mailFrom,mailCC, mailSub, mailContent);
		
		session = Session.getInstance(props, null);
	
		try {

			Message msg = new MimeMessage(session);

			msg.setFrom(new InternetAddress(props.getProperty("mail.from")));

			String to = props.getProperty("mail.to");
			if (to != null && to.trim().length() > 0) {
				String[] toAddress = to.split(",");
				for (int i = 0; i < toAddress.length; i++) {
					msg.addRecipient(RecipientType.TO, new InternetAddress(
							toAddress[i]));
				}
			}
			String cc = props.getProperty("mail.cc");
			if (cc != null && cc.trim().length() > 0) {
				String[] ccAddress = cc.split(",");
				for (int i = 0; i < ccAddress.length; i++) {
					msg.addRecipient(RecipientType.CC, new InternetAddress(
							ccAddress[i]));
				}
			}
				
			
			msg.setSubject(props.getProperty("mail.subject"));
			msg.setSentDate(new Date());

			Multipart multipart = new MimeMultipart();
			BodyPart messageBodyPart = new MimeBodyPart();
			
			messageBodyPart.setContent(props.getProperty("mail.message"),
					contentType);
			multipart.addBodyPart(messageBodyPart);

			msg.setContent(multipart);
			msg.saveChanges();
			String host = props.getProperty("mail.smtp.host");
	
		
			Transport.send(msg,msg.getAllRecipients());
			
			logger.debug("####### Mail Send Successfully...#########");
			
			return true;
		} catch (Exception e) {
			logger.debug(e);
			//throw e;
		}*/
		
		return true;
		
	}

	public Properties setMailProperties(String mailTo,String mailFrom,String mailCC, String mailSub, String mailContent) throws Exception
	{
		logger.debug("####### Inside setMailProperties Method...#########");
		mailProps = new Properties();
		try {
				
			mailProps.put("mail.smtp.host", pr.getMAIL_SMTP_HOST());
			mailProps.put("mail.from", mailFrom);
			mailProps.put("mail.to", mailTo);
			if(mailCC!=null&&(!mailCC.isEmpty())){
				mailProps.put("mail.cc", mailCC);
			}
			mailProps.put("mail.subject", mailSub);
			mailProps.put("mail.message", mailContent);
						
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return mailProps;
	}

}
