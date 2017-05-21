package com.thepsi.appraisalSystem.controller;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;


import com.thepsi.appraisalSystem.model.Employee;
import com.thepsi.appraisalSystem.model.Employee_Manager;
import com.thepsi.appraisalSystem.model.User_Role;
import com.thepsi.appraisalSystem.services.AppraisalCycleManager;
import com.thepsi.appraisalSystem.util.AppraisalConstants;
import com.thepsi.appraisalSystem.util.MailSender;
import com.thepsi.appraisalSystem.util.PropertyReader;

@Controller
public class AppraisalController extends MultiActionController {
	
	@Autowired
	private AppraisalCycleManager appCycleManager;
	
	

	private Logger logger = Logger.getLogger(AppraisalConstants.LOG_NAME);
	public Logger getLogger() {
		return logger;
	}


	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	
	/*To get inputs for login*/
	@RequestMapping(value = AppraisalConstants.INSTRUCTIONS_URL, method = RequestMethod.GET)
	public ModelAndView instructions(HttpServletRequest request, HttpServletResponse response) 
	{
		logger.info("ClassName: AppraisalController");
		logger.info("MethodName:instructions");
		ModelAndView mav = new ModelAndView(AppraisalConstants.INSTRUCTIONS_PAGE);
		
		return mav;	

	}
	
	/*To get inputs for login*/
	@RequestMapping(value = AppraisalConstants.UNAUTHORIZED_URL, method = RequestMethod.GET)
	public ModelAndView authorized(HttpServletRequest request, HttpServletResponse response) 
	{
		logger.info("ClassName: AppraisalController");
		logger.info("MethodName:authorized");
		ModelAndView mav = new ModelAndView(AppraisalConstants.AUTHORIZED_PAGE);
		return mav;	

	}
	
	/*To get inputs for login*/
	@RequestMapping(value = AppraisalConstants.SAMPLE_FORM_URL, method = RequestMethod.GET)
	public ModelAndView sampleForm(HttpServletRequest request, HttpServletResponse response) 
	{
		logger.info("ClassName: AppraisalController");
		logger.info("MethodName:sampleForm");
		ModelAndView mav = new ModelAndView(AppraisalConstants.SAMPLE_FORM_PAGE);
		
		return mav;	

	}
	
	/*Added by Ankush */
	/*To get error page*/
	@RequestMapping(value = AppraisalConstants.ERROR, method = RequestMethod.GET)
	public ModelAndView error() 
	{
		ModelAndView mav = new ModelAndView(AppraisalConstants.ERROR_PAGE);
		return mav;	

	}
	
	@ExceptionHandler(Throwable.class)
    public ModelAndView handleException(Throwable error) {
		
		//logger.debug("Error Stacktrace- ", error);
		return new ModelAndView(AppraisalConstants.ERROR_PAGE);
    }


	
	

		
	

}
