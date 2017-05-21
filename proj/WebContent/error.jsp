<%@ page isErrorPage="true" %>
<html lang="en-US">
<%@ page import="com.thepsi.appraisalSystem.util.PropertyReader,org.apache.log4j.Logger,com.thepsi.appraisalSystem.util.AppraisalConstants"%>
<head>
<meta charset="UTF-8" />
<title>PS Global IT Solutions</title>
</head>

<body>
<div style="text-align: center;">
<img src="images/error_logo.png" alt=""><br />
<img src="images/message_Page.jpg" alt="">
<% PropertyReader property = new PropertyReader();
   Logger logger = Logger.getLogger(AppraisalConstants.LOG_NAME);
   if(exception!=null)
   		logger.debug("Error Stacktrace- ", exception);
   else
	    logger.info("404 Error!!!");
%>
<div id="home-message">
	<a class="without-hover" href="<%=property.getAPPRAISAL_SYSTEM_LINK()%>">
	<img src="images/go-home.png"></a>
</div>



</div>



</body>

<style type="text/css">
	body {
font-family: Verdana, Geneva, Sans-Serif;
color: #231f20;
font-size: 13px;
font-size: 13px;
background: url("images/expertise-services-back.jpg") center top;
}
	</style>
