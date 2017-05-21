package com.thepsi.appraisalSystem.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;

import org.apache.log4j.Logger;

public class SessionFilter implements Filter {

	private Logger logger = Logger.getLogger(AppraisalConstants.LOG_NAME);

    private FilterConfig config;

    /** Creates new SessionFilter */

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		   
		HttpSession session = ((HttpServletRequest) request).getSession();
		      ServletContext context = config.getServletContext();
		      /*
		       * use the ServletContext.log method to log filter messages
		       */
		      logger.info("doFilter called in: " + config.getFilterName() + " on "
		          + (new java.util.Date()));

		      // log the session ID
		      logger.info("session ID: " + session.getId());

		      // Find out whether the logged-in session attribute is set
		     Object u= session.getAttribute(AppraisalConstants.USER_ATTR);
		     String path = ((HttpServletRequest) request).getRequestURI();
		     
		     
		    /* if(((HttpServletRequest) request).getHeader("accept")!=null && ((HttpServletRequest) request).getHeader("accept").contains("css")){
		            ((HttpServletResponse) response).setHeader("Content-Type", "text/html");
		        }*/
		     
		      if (u != null || path.startsWith(AppraisalConstants.AVOID_URL)){
		    	  
		        chain.doFilter(request, response);
		      }
		      else{
		          
		          ((HttpServletResponse) response).sendRedirect(((HttpServletResponse) response).encodeRedirectURL(AppraisalConstants.FILTER_REDIRECT_URL));
		      }
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		  logger.info("Instance created of " + getClass().getName());
		      this.config = filterConfig;
		
	}
	
	   public void destroy() {
		   
		 

	    }
  }
