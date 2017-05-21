<%@page import="com.thepsi.appraisalSystem.util.AppraisalConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@page import="com.thepsi.appraisalSystem.model.Employee,java.util.List,com.thepsi.appraisalSystem.dao.AppraisalDAOImpl" %>
       <%@page import="com.thepsi.appraisalSystem.model.ProbationData" %>
       <%@page import="java.util.Calendar"%>
       <%@page import="java.util.Date"%>
       <%@page import="java.text.DateFormat,java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="description" content="">
      <meta name="author" content="">
      <!-- Bootstrap Core CSS -->
      <link href="components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
      <!-- MetisMenu CSS -->
      <link href="components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
      <!-- Custom CSS -->
      <link href="dist/css/sb-admin-2.css" rel="stylesheet">
      <!-- Custom Fonts -->
      <link href="components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
      <!-- Footer CSS -->
      <link href="css/footer.css" rel="stylesheet">
      <!-- Jquery-->
      <link rel="stylesheet" href="css/jquery-ui.min.css">
      <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
      <!-- DateTables -->
      <link href="components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet">
      <link href="components/datatables-responsive/css/dataTables.responsive.css" rel="stylesheet"> 
      <!-- Date Picker CSS -->
   	  <link href="dist/css/jquery-ui.css" rel="stylesheet">
      <link rel="stylesheet" href="dist/css/datepicker.css">
      <link rel="stylesheet" href="dist/css/bootstrap.css">
      <!-- Custom CSS -->
      <link href="css/theme.css" rel="stylesheet">
      <!-- Custom css for Probation Review Module -->
      <link href="css/probationReview.css" rel="stylesheet">
      <style type='text/css'>
         
	button {
	   background:none; 
	   color:#337ab7;
	   /*border:none;*/ 
	   padding:9px !important;
	   /*  border-bottom:1px solid #444;  */
	   cursor: pointer;
	}

</style>

<title>Probationers</title>
</head>
<%List<Employee> probationersList = (List<Employee>)request.getAttribute("probationersList");
  List<Employee> probationCompletedList = (List<Employee>)request.getAttribute("probationCompletedList");
  List<Employee> pendingOnMeList = (List<Employee>)request.getAttribute("pendingOnMeList");
  AppraisalDAOImpl appraisalDAOImpl = new AppraisalDAOImpl();
  List allProbationersDataList = (List)request.getAttribute("allProbationersDataList");
  List allProbationCompletedDataList = (List)request.getAttribute("allProbationCompletedDataList");
  List allPendingOnMeDataList = (List)request.getAttribute("allPendingOnMeDataList");
  String day="";
  Date currentDate = new Date();
  Calendar c = Calendar.getInstance(); 
  Calendar c1 = Calendar.getInstance();System.out.print("time"+c1.getTime());
  c.setTime(currentDate); 
  c1.setTime(currentDate);
  c.add(Calendar.MONTH, -3);
  c1.add(Calendar.MONTH, -6);
  Date calDate = c.getTime();
  Date calDate1 = c1.getTime();
  DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
  String midTermDateArray[] = formatter.format(calDate).split("-");
  String probationCompletedDateArray[] = formatter.format(calDate1).split("-");
  String monthString = "";
  switch(Integer.parseInt(midTermDateArray[1])){
	case 1:monthString = "Jan";break;
	case 2:monthString ="Feb";break;
	case 3:monthString = "March";break;
	case 4:monthString = "April";break;
	case 5:monthString = "May";break;
	case 6:monthString = "June";break;
	case 7:monthString = "July";break;
	case 8:monthString = "Aug";break;
	case 9:monthString = "Sep";break;
	case 10:monthString = "Oct";break;
	case 11:monthString = "Nov";break;
	case 12:monthString = "Dec";break;
  }
  String midTermDate = monthString+", "+midTermDateArray[0];
  monthString = "";
  switch(Integer.parseInt(probationCompletedDateArray[1])){
	case 1:monthString = "Jan";break;
	case 2:monthString ="Feb";break;
	case 3:monthString = "March";break;
	case 4:monthString = "April";break;
	case 5:monthString = "May";break;
	case 6:monthString = "June";break;
	case 7:monthString = "July";break;
	case 8:monthString = "Aug";break;
	case 9:monthString = "Sep";break;
	case 10:monthString = "Oct";break;
	case 11:monthString = "Nov";break;
	case 12:monthString = "Dec";break;
}
  String probationCompletedDate = monthString+", "+probationCompletedDateArray[0];
%>
<body>
 
    
    <input type="hidden" id="midTermDate" value="<%=midTermDate%>"/>
    <input type="hidden" id="probationCompletedDate" value="<%=probationCompletedDate%>"/>
  
<div id="wrapper">	
 <!-- Navigation -->
 <jsp:include page="sideMenu.jsp" />
<div id="page-wrapper" class="table-responsive">   
<br/>
<ul class="nav nav-pills">
  <li id = "employeesOnProbationTab" class="active"><a href="javascript:showEmployeesOnProbation();">All Probationers</a></li>
  <li id = "pendingOnMeTab"><a href="javascript:showPendingOnMe();">Pending On Me</a></li>
  <li id = "probationFYITab">
   <div class="dropdown btn-group" id="probationFYIDropdown">
                              <button class="btn dropdown-toggle" type="button" data-toggle="dropdown" id="probationFYIBtn" onclick="changeLabel();">Probation FYI's<span class="caret"></span></button>
                              <ul id="probationFYI" class="dropdown-menu scrollable-menu">
                                 <li id="CompletionFYI"><a href="javascript:showProbationFYI(1)">Probation Completion</a></li>
                                 <li><a href="javascript:showProbationFYI(2)">Mgmt. Stage</a></li>
                                 <li><a href="javascript:showProbationFYI(3)">HR Stage</a></li>
                                 <li><a href="javascript:showProbationFYI(4)">CoE Pending</a></li>
                                 <li><a href="javascript:showProbationFYI(5)">Mid Term Stage</a></li>
                                 <li><a href="javascript:showProbationFYI(6)">Manager Pending</a></li>
                                 <li><a href="javascript:showProbationFYI(7)">Probationer Not Started</a></li>
                              </ul>
    </div>
 </li>
  <li id = "probationCompletedEmployeesTab"><a href="javascript:showProbationCompleted();">Probation Completed </a></li>
</ul>
<br/>
<div id="employeesOnProbationDiv" style="visibility: visible;">
 <%if(probationersList==null || probationersList.size()==0) {
    out.print("No Probationer Exist");
 }else{%>
<h4>Employees on Probation</h4><hr>
	<input class="global_filter" id="global_filter" type="text" style="display:none;">
	<form id ="employeesOnProbationForm" action="" method="post">
	 
 <table class="table table-striped table-bordered table-hover" id="probationersTable" width="100%">
 	<thead>
 	
           <tr>
                <th class="info" >Code</th>
                <th class="info" >Name</th>
                <th class="info">Manager</th>
                <th class="info" >Department</th>
                <th class="info" >Designation</th>
                <th class="info" >Joining Date</th>
                <!-- <th class="info" >General Comments</th> -->
                <th class="info" >Month-1</th>
                <th class="info" >Month-2</th>
                <th class="info" >Month-3</th>
                <th class="info" >Mid Term</th>
                <th class="info" >Month-4</th>
                <th class="info" >Month-5</th>
                <th class="info" >Probation Evaluation</th> 
               <!--<th class="info" >Extension Form</th>  --> 
                <th class="info" >Ext Month-1</th>
                <th class="info" >Ext Month-2</th>
                <th class="info" >Final Probation Evaluation</th> 
          </tr>
         </thead>
         <tbody>
         	
         	 <%
         	   for(int i=0;i<probationersList.size();i++){
         		    Employee probationer = probationersList.get(i);
	         		String doj = probationer.getDate_of_joining();
	         		if(doj!=null){
	         			int year = Integer.parseInt(doj.split("-")[0]);
						int month = Integer.parseInt(doj.split("-")[1]);
						int date =  Integer.parseInt(doj.split("-")[2]);
						String monString="";
						switch(month){
						case 1:monString = "Jan";break;
						case 2:monString ="Feb";break;
						case 3:monString = "March";break;
						case 4:monString = "April";break;
						case 5:monString = "May";break;
						case 6:monString = "June";break;
						case 7:monString = "July";break;
						case 8:monString = "Aug";break;
						case 9:monString = "Sep";break;
						case 10:monString = "Oct";break;
						case 11:monString = "Nov";break;
						case 12:monString = "Dec";break;
	         		 }	
						day =  date+" "+monString+", "+year;
				   }
         	 %>
         	 	<tr class="center">
         	 		<% List<ProbationData> probationDataList = (List<ProbationData>)allProbationersDataList.get(i);	
         	 		   int generalFormRating=0, month1Rating=0, month2Rating=0, month3Rating=0, month4Rating=0, month5Rating=0, extnMonth1Rating=0,finalEvaluationRating=0, extnMonth2Rating=0, midTermRating=0, evaluationRating=0, extensionRating=0;
         	 		   String generalFormStatus="",month1Status="", month2Status="", month3Status="", month4Status="", month5Status="", midTermStatus="",
         	 				  extensionStatus="", evaluationStatus="", extnMonth1Status="", extnMonth2Status="",finalEvaluationStatus="";
         	 		   String rating="";
         	 		   if(probationDataList!=null){
         	 			   for(int j=0;j<probationDataList.size();j++){
            	 				ProbationData probationData = probationDataList.get(j);
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_GENERAL_COMMENTS_FORM)){
            	 					generalFormRating = probationData.getRating();
            	 					generalFormStatus = probationData.getStatus();
            	 					/* generalFormStatus = generalFormStatus.replace("GH","CoE");
            	 					generalFormStatus = generalFormStatus.replace("_", " ").toLowerCase(); */
            	 				}	
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_MONTH1_FORM)){
            	 					month1Rating = probationData.getRating();
            	 					month1Status = probationData.getStatus();
            	 					/* month1Status = month1Status.replace("GH","CoE");
            	 					month1Status = month1Status.replace("_", " ").toLowerCase(); */
            	 				}	
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_MONTH2_FORM)){
            	 					month2Rating = probationData.getRating();
            	 					month2Status = probationData.getStatus();
            	 					/* month2Status = month2Status.replace("GH","CoE");
            	 					month2Status = month2Status.replace("_", " ").toLowerCase(); */
            	 				}	
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_MONTH3_FORM)){
            	 					month3Rating = probationData.getRating();
            	 					month3Status = probationData.getStatus();
            	 					/* month3Status = month3Status.replace("GH","CoE");
            	 					month3Status = month3Status.replace("_", " ").toLowerCase(); */
            	 				}	
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_MONTH4_FORM)){
            	 					month4Rating = probationData.getRating();
            	 					month4Status = probationData.getStatus();
            	 					/* month4Status = month4Status.replace("GH","CoE");
            	 					month4Status = month4Status.replace("_", " ").toLowerCase(); */
            	 				}	
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_MONTH5_FORM)){
            	 					month5Rating = probationData.getRating();
            	 					month5Status = probationData.getStatus();
            	 					/* month5Status = month5Status.replace("GH","CoE");
            	 					month5Status = month5Status.replace("_", " ").toLowerCase(); */
            	 				}	
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_MID_TERM_FORM)){
            	 					midTermRating = probationData.getRating();
            	 					midTermStatus = probationData.getStatus();
            	 					/* midTermStatus = midTermStatus.replace("GH","CoE");
            	 					midTermStatus = midTermStatus.replace("_", " ").toLowerCase(); */
            	 				}
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_EVALUATION_FORM)){
            	 					evaluationRating = probationData.getRating();
            	 					evaluationStatus = probationData.getStatus();
            	 					/* evaluationStatus = evaluationStatus.replace("GH","CoE");
            	 					evaluationStatus = evaluationStatus.replace("_", " ").toLowerCase(); */
            	 				}
            	 				/*if(probationData.getForm().equals(AppraisalConstants.PROBATION_EXTENSION_FORM)){
            	 					extensionRating = probationData.getRating();
            	 					extensionStatus = probationData.getStatus();
            	 					
            	 				}*/	
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_EXTENTION_MONTH1_FORM)){
            	 					extnMonth1Rating = probationData.getRating();
            	 					extnMonth1Status = probationData.getStatus();
            	 					/* extnMonth1Status = extnMonth1Status.replace("GH","CoE");
            	 					extnMonth1Status = extnMonth1Status.replace("_", " ").toLowerCase(); */
            	 				}	
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_EXTENTION_MONTH2_FORM)){
            	 					extnMonth2Rating = probationData.getRating();
            	 					extnMonth2Status = probationData.getStatus();
            	 					/* extnMonth2Status = extnMonth2Status.replace("GH","CoE");
            	 					extnMonth2Status = extnMonth2Status.replace("_", " ").toLowerCase(); */
            	 				}	
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_FINAL_EVALUATION_FORM)){
            	 					finalEvaluationRating = probationData.getRating();
            	 					finalEvaluationStatus = probationData.getStatus();
            	 				
            	 				}
            	 				
            	 			}
         	 		   }
         	 		 
         	 		%>
         	 		<td><input type="hidden" id="empid" name="empid" value="<%=probationer.getEmployeeId()%>"/>
         	 		<%=probationer.getEmployeeId()%>
         	 		</td>
         	 		
         	 		<%--<td><a href="viewProbationReview.apr?empId=<%=probationer.getEmployeeId()%>"><!-- <button onclick="viewEmployeeReview();"> --><%=probationer.getEmployeeName()%><!-- </button> --></a></td> --%>
         	 		
         	 		<td>
         	 		<a href="#"><!-- <button onclick="viewEmployeeReview();"> --><%=probationer.getEmployeeName()%><!-- </button> --></a></td>
         	 		<td><%=probationer.getReporting_Manager_Name()%></td>
         	 		<td><%=probationer.getGroupName() %></td>
         	 		<td><%=probationer.getDesignation()%></td>
         	 		<td nowrap><%=day%></td>
         	 		<%-- <%switch(generalFormRating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 			%>
         	 		<td class="<%=rating%>"><%=generalFormStatus%></td> --%>
         	 		
         	 		<%switch(month1Rating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 		%>
         	 		<%if(month1Status!=null && month1Status.equals(AppraisalConstants.STATUS_MANAGER_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><br><font size="1"><%=month1Status.replace("_", " ").toLowerCase().replace("gh","CoE")%></font></td>
         	 		<%} else{%>
         	 			<td><%=month1Status.replace("_", " ").toLowerCase().replace("gh","CoE")%></td>
         	 		<%} %>
         	 		
         	 		<%switch(month2Rating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 		%>
         	 		<%if(month2Status!=null && month2Status.equals(AppraisalConstants.STATUS_MANAGER_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><br><font size="1"><%=month2Status.replace("_", " ").toLowerCase().replace("gh","CoE")%></font></td>
         	 		<%} else{%>
         	 			<td><%=month2Status.replace("_", " ").toLowerCase().replace("gh","CoE")%></td>
         	 		<%} %>
         	 		
         	 		<%switch(month3Rating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 			%>
         	 		<%if(month3Status!=null && month3Status.equals(AppraisalConstants.STATUS_MANAGER_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><br><font size="1"><%=month3Status.replace("_", " ").toLowerCase().replace("gh","CoE")%></font></td>
         	 		<%} else{%>
         	 			<td><%=month3Status.replace("_", " ").toLowerCase().replace("gh","CoE")%></td>
         	 		<%} %>
         	 		
         	 		<%switch(midTermRating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 			%>
         	 		<%if(midTermStatus!=null && midTermStatus.equals(AppraisalConstants.STATUS_GH_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><br><font size="1"><%=midTermStatus.replace("_", " ").toLowerCase().replace("gh","CoE")%></font></td>
         	 		<%} else{%>
         	 			<td><%=midTermStatus.replace("_", " ").toLowerCase().replace("gh","CoE")%></td>
         	 		<%} %>
         	 		
         	 		<%switch(month4Rating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 			%>
         	 		<%if(month4Status!=null && month4Status.equals(AppraisalConstants.STATUS_MANAGER_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><br><font size="1"><%=month4Status.replace("_", " ").toLowerCase().replace("gh","CoE")%></font></td>
         	 		<%} else{%>
         	 			<td><%=month4Status.replace("_", " ").toLowerCase().replace("gh","CoE")%></td>
         	 		<%} %>
         	 		
         	 		<%switch(month5Rating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 		%>
         	 		<%if(month5Status!=null && month5Status.equals(AppraisalConstants.STATUS_MANAGER_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><br><font size="1"><%=month5Status.replace("_", " ").toLowerCase().replace("gh","CoE")%></font></td>
         	 		<%} else{%>
         	 			<td><%=month5Status.replace("_", " ").toLowerCase().replace("gh","CoE")%></td>
         	 		<%} %>
         	 		<%switch(evaluationRating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 		%>
         	 		<%if (evaluationStatus!=null && evaluationStatus.equals(AppraisalConstants.STATUS_GH_COMPLETED) || evaluationStatus.equals(AppraisalConstants.STATUS_HR_COMPLETED) || evaluationStatus.equals(AppraisalConstants.STATUS_MANAGEMENT_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><br><font size="1"><%=evaluationStatus.replace("_", " ").toLowerCase().replace("gh","CoE")%></font></td>
         	 		<%} else{%>
         	 			<td><%=evaluationStatus.replace("_", " ").toLowerCase().replace("gh","CoE")%></td>
         	 		<%} %>
         	 		
         	 		<%switch(extnMonth1Rating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 		%>
         	 		<%if (extnMonth1Status!=null && extnMonth1Status.equals(AppraisalConstants.STATUS_MANAGER_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><br><font size="1"><%=extnMonth1Status.replace("_", " ").toLowerCase().replace("gh","CoE")%></font></td>
         	 		<%} else{%>
         	 			<td><%=extnMonth1Status.replace("_", " ").toLowerCase().replace("gh","CoE")%></td>
         	 		<%} %>
         	 		
         	 		<%switch(extnMonth2Rating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 		%>
         	 		<%if (extnMonth2Status!=null && extnMonth2Status.equals(AppraisalConstants.STATUS_MANAGER_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><br><font size="1"><%=extnMonth2Status.replace("_", " ").toLowerCase().replace("gh","CoE")%></font></td>
         	 		<%} else{%>
         	 			<td><%=extnMonth2Status.replace("_", " ").toLowerCase().replace("gh","CoE")%></td>
         	 		<%} %>
         	 		
         	 		<%switch(finalEvaluationRating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 		%>
         	 		<%if (finalEvaluationStatus!=null && finalEvaluationStatus.equals(AppraisalConstants.STATUS_GH_COMPLETED) || finalEvaluationStatus.equals(AppraisalConstants.STATUS_HR_COMPLETED) || finalEvaluationStatus.equals(AppraisalConstants.STATUS_MANAGEMENT_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><br><font size="1"><%=finalEvaluationStatus.replace("_", " ").toLowerCase().replace("gh","CoE")%></font></td>
         	 		<%} else{%>
         	 			<td><%=finalEvaluationStatus.replace("_", " ").toLowerCase().replace("gh","CoE")%></td>
         	 		<%} %>
         	 			
         	 	</tr>
         	 <%} %>
         	 
         </tbody>
 </table>
 </form>
 <%} %>
</div>

<div id="pendingOnMeDiv" style="display:none;">
<%if(pendingOnMeList==null || pendingOnMeList.size()==0){%>
	<h4>No Pending Decisions</h4><hr>
<%}else{ %>
	<h4>Employees On Probation</h4><hr>
	<form id ="pendingOnMeForm" action="" method="post">
	<table class="table table-striped table-bordered table-hover" id="pendingOnMeTable" width="100%">
 	<thead>
           <tr>
                <th class="info" >Code</th>
                <th class="info" >Name</th>
                <th class="info">Manager</th>
                <th class="info" >Department</th>
                <th class="info" >Designation</th>
                <th class="info" >Joining Date</th>
                <!-- <th class="info" >General Comments</th> -->
                <th class="info" >Month-1</th>
                <th class="info" >Month-2</th>
                <th class="info" >Month-3</th>
                <th class="info" >Mid Term</th>
                <th class="info" >Month-4</th>
                <th class="info" >Month-5</th>
                <th class="info" >Probation Evaluation</th> 
                <!--<th class="info" >Extension Form</th>  -->
                <th class="info" >Ext Month-1</th>
                <th class="info" >Ext Month-2</th>
                <th class="info" >Final Probation Evaluation</th> 
                
          </tr>
         </thead>
         <tbody>
         	 <%
         	   for(int i=0;i<pendingOnMeList.size();i++){
         		    Employee probationer = pendingOnMeList.get(i);
	         		String doj = probationer.getDate_of_joining();
	         		if(doj!=null){
	         			int year = Integer.parseInt(doj.split("-")[0]);
						int month = Integer.parseInt(doj.split("-")[1]);
						int date =  Integer.parseInt(doj.split("-")[2]);
						String monString="";
						switch(month){
						case 1:monString = "Jan";break;
						case 2:monString ="Feb";break;
						case 3:monString = "March";break;
						case 4:monString = "April";break;
						case 5:monString = "May";break;
						case 6:monString = "June";break;
						case 7:monString = "July";break;
						case 8:monString = "Aug";break;
						case 9:monString = "Sep";break;
						case 10:monString = "Oct";break;
						case 11:monString = "Nov";break;
						case 12:monString = "Dec";break;
	         		 }	
						day =  date+" "+monString+", "+year;
				   }
         	 %>
         	 	<tr class="center">
         	 		<% List<ProbationData> probationDataList = (List<ProbationData>)allPendingOnMeDataList.get(i);	
         	 		   int generalFormRating=0, month1Rating=0, month2Rating=0, month3Rating=0, month4Rating=0, month5Rating=0,finalEvaluationRating=0, extnMonth1Rating=0, extnMonth2Rating=0, midTermRating=0, evaluationRating=0, extensionRating=0;
         	 		   String generalFormStatus="",month1Status="", month2Status="", month3Status="", month4Status="", month5Status="", midTermStatus="",
         	 				  extensionStatus="", evaluationStatus="", extnMonth1Status="", extnMonth2Status="",finalEvaluationStatus="";
         	 		   String rating="";
         	 		   if(probationDataList!=null){
         	 			   for(int j=0;j<probationDataList.size();j++){
            	 				ProbationData probationData = probationDataList.get(j);
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_GENERAL_COMMENTS_FORM)){
            	 					generalFormRating = probationData.getRating();
            	 					generalFormStatus = probationData.getStatus();
            	 				}	
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_MONTH1_FORM)){
            	 					month1Rating = probationData.getRating();
            	 					month1Status = probationData.getStatus();
            	 					
            	 				}	
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_MONTH2_FORM)){
            	 					month2Rating = probationData.getRating();
            	 					month2Status = probationData.getStatus();
            	 					
            	 				}	
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_MONTH3_FORM)){
            	 					month3Rating = probationData.getRating();
            	 					month3Status = probationData.getStatus();
            	 					
            	 				}	
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_MONTH4_FORM)){
            	 					month4Rating = probationData.getRating();
            	 					month4Status = probationData.getStatus();
            	 					
            	 				}	
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_MONTH5_FORM)){
            	 					month5Rating = probationData.getRating();
            	 					month5Status = probationData.getStatus();
            	 					
            	 				}	
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_MID_TERM_FORM)){
            	 					midTermRating = probationData.getRating();
            	 					midTermStatus = probationData.getStatus();
            	 					
            	 				}	
            	 				/*if(probationData.getForm().equals(AppraisalConstants.PROBATION_EXTENSION_FORM)){
            	 					extensionRating = probationData.getRating();
            	 					extensionStatus = probationData.getStatus();
            	 					
            	 				}*/
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_EVALUATION_FORM)){
            	 					evaluationRating = probationData.getRating();
            	 					evaluationStatus = probationData.getStatus();
            	 					
            	 				}
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_EXTENTION_MONTH1_FORM)){
            	 					extnMonth1Rating = probationData.getRating();
            	 					extnMonth1Status = probationData.getStatus();
            	 					
            	 				}	
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_EXTENTION_MONTH2_FORM)){
            	 					extnMonth2Rating = probationData.getRating();
            	 					extnMonth2Status = probationData.getStatus();
            	 				}
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_FINAL_EVALUATION_FORM)){
            	 					finalEvaluationRating = probationData.getRating();
            	 					finalEvaluationStatus = probationData.getStatus();
            	 					
            	 				}
            	 			}
         	 		   }
         	 		%>
         	 		<td><input type="hidden" id="empid" name="empid" value="<%=probationer.getEmployeeId()%>"/><%=probationer.getEmployeeId()%></td>
         	 		<%--<td><a href="viewProbationReview.apr?empId=<%=probationer.getEmployeeId()%>"><!-- <button onclick="viewEmployeeReview();"> --><%=probationer.getEmployeeName()%><!-- </button> --></a></td> --%>
         	 		<td><a href="#"><!-- <button onclick="viewEmployeeReview();"> --><%=probationer.getEmployeeName()%><!-- </button> --></a></td>
         	 		<td><%=probationer.getReporting_Manager_Name()%></td>
         	 		<td><%=probationer.getGroupName() %></td>
         	 		<td><%=probationer.getDesignation()%></td>
         	 		<td nowrap><%=day%></td>
         	 		<%-- <%switch(generalFormRating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 			%>
         	 		<td class="<%=rating%>"><%=generalFormStatus%></td> --%>
         	 		
         	 		<%switch(month1Rating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 		%>
         	 		<%if(month1Status!=null && month1Status.equals(AppraisalConstants.STATUS_MANAGER_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><br><font size="1"><%=month1Status.replace("_", " ").toLowerCase().replace("gh","CoE")%></font></td>
         	 		<%} else{%>
         	 			<td><%=month1Status.replace("_", " ").toLowerCase().replace("gh","CoE")%></td>
         	 		<%} %>
         	 		
         	 		<%switch(month2Rating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 		%>
         	 		<%if(month2Status!=null && month2Status.equals(AppraisalConstants.STATUS_MANAGER_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><br><font size="1"><%=month2Status.replace("_", " ").toLowerCase().replace("gh","CoE")%></font></td>
         	 		<%} else{%>
         	 			<td><%=month2Status.replace("_", " ").toLowerCase().replace("gh","CoE")%></td>
         	 		<%} %>
         	 		
         	 		<%switch(month3Rating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 			%>
         	 		<%if(month3Status!=null && month3Status.equals(AppraisalConstants.STATUS_MANAGER_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><br><font size="1"><%=month3Status.replace("_", " ").toLowerCase().replace("gh","CoE")%></font></td>
         	 		<%} else{%>
         	 			<td><%=month3Status.replace("_", " ").toLowerCase().replace("gh","CoE")%></td>
         	 		<%} %>
         	 		
         	 		<%switch(midTermRating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 			%>
         	 		<%if(midTermStatus!=null && midTermStatus.equals(AppraisalConstants.STATUS_GH_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><br><font size="1"><%=midTermStatus.replace("_", " ").toLowerCase().replace("gh","CoE")%></font></td>
         	 		<%} else{%>
         	 			<td><%=midTermStatus.replace("_", " ").toLowerCase().replace("gh","CoE")%></td>
         	 		<%} %>
         	 		
         	 		<%switch(month4Rating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 			%>
         	 		<%if(month4Status!=null && month4Status.equals(AppraisalConstants.STATUS_MANAGER_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><br><font size="1"><%=month4Status.replace("_", " ").toLowerCase().replace("gh","CoE")%></font></td>
         	 		<%} else{%>
         	 			<td><%=month4Status.replace("_", " ").toLowerCase().replace("gh","CoE")%></td>
         	 		<%} %>
         	 		
         	 		<%switch(month5Rating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 		%>
         	 		<%if(month5Status!=null && month5Status.equals(AppraisalConstants.STATUS_MANAGER_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><br><font size="1"><%=month5Status.replace("_", " ").toLowerCase().replace("gh","CoE")%></font></td>
         	 		<%} else{%>
         	 			<td><%=month5Status.replace("_", " ").toLowerCase().replace("gh","CoE")%></td>
         	 		<%} %>
         	 		<%switch(evaluationRating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 		%>
         	 		<%if (evaluationStatus!=null && evaluationStatus.equals(AppraisalConstants.STATUS_GH_COMPLETED) || evaluationStatus.equals(AppraisalConstants.STATUS_HR_COMPLETED) || evaluationStatus.equals(AppraisalConstants.STATUS_MANAGEMENT_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><br><font size="1"><%=evaluationStatus.replace("_", " ").toLowerCase().replace("gh","CoE")%></font></td>
         	 		<%} else{%>
         	 			<td><%=evaluationStatus.replace("_", " ").toLowerCase().replace("gh","CoE")%></td>
         	 		<%} %>
         	 	   <%-- <%switch(extensionRating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 		%>
         	 		<%if (extensionStatus!=null && extensionStatus.equals(AppraisalConstants.STATUS_GH_COMPLETED) || extensionStatus.equals(AppraisalConstants.STATUS_MANAGEMENT_COMPLETED) ){ %>
						 <td><img class="<%=rating%>"/><br><font size="1"><%=extensionStatus.replace("_", " ").toLowerCase().replace("gh","CoE")%></font></td>
					<%} else{%>
         	 			<td><%=extensionStatus.replace("_", " ").toLowerCase().replace("gh","CoE")%></td>
         	 		<%} %>
         	 		--%>
         	 		<%switch(extnMonth1Rating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 		%>	
         	 		
         	 		<%if (extnMonth1Status!=null && extnMonth1Status.equals(AppraisalConstants.STATUS_MANAGER_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><br><font size="1"><%=extnMonth1Status.replace("_", " ").toLowerCase().replace("gh","CoE")%></font></td>
         	 		<%} else{%>
         	 			<td><%=extnMonth1Status.replace("_", " ").toLowerCase().replace("gh","CoE")%></td>
         	 		<%} %>
         	 		
         	 		<%switch(extnMonth2Rating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 		%>
         	 		<%if (extnMonth2Status!=null && extnMonth2Status.equals(AppraisalConstants.STATUS_MANAGER_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><br><font size="1"><%=extnMonth2Status.replace("_", " ").toLowerCase().replace("gh","CoE")%></font></td>
         	 		<%} else{%>
         	 			<td><%=extnMonth2Status.replace("_", " ").toLowerCase().replace("gh","CoE")%></td>
         	 		<%} %>
         	 		
         	 		<%switch(finalEvaluationRating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 		%>
         	 		<%if (finalEvaluationStatus!=null && finalEvaluationStatus.equals(AppraisalConstants.STATUS_GH_COMPLETED) || finalEvaluationStatus.equals(AppraisalConstants.STATUS_HR_COMPLETED) || finalEvaluationStatus.equals(AppraisalConstants.STATUS_MANAGEMENT_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><br><font size="1"><%=finalEvaluationStatus.replace("_", " ").toLowerCase().replace("gh","CoE")%></font></td>
         	 		<%} else{%>
         	 			<td><%=finalEvaluationStatus.replace("_", " ").toLowerCase().replace("gh","CoE")%></td>
         	 		<%} %>	
         	 			
         	 	</tr>
         	 <%} %>
         	
         </tbody>
 </table>
  </form>
 <%} %>
</div>


<div id="employeesWithProbationCompletedDiv" style="display: none;">
<%if(probationCompletedList==null || probationCompletedList.size()==0){
	out.print("No Probationer exist");
 }else{%>
<h4>Employees with Probation Completed</h4><hr>
<form id="employeesWithProbationCompletedForm" action="" method="post">
	<table class="table table-striped table-bordered table-hover" id="probationerCompletedTable" width="100%">
 	<thead>
           <tr>
                <th class="info" >Code</th>
                <th class="info" >Name</th>
                <th class="info">Manager</th>
                <th class="info" >Department</th>
                <th class="info" >Designation</th>
                <th class="info" >Joining Date</th>
                <!-- <th class="info" >General Comments</th> -->
                <th class="info" >Month-1</th>
                <th class="info" >Month-2</th>
                <th class="info" >Month-3</th>
                <th class="info" >Mid Term</th>
                <th class="info" >Month-4</th>
                <th class="info" >Month-5</th>
                <th class="info" >Probation Evaluation</th> 
                <!-- <th class="info" >Extension Form</th> -->
                <th class="info" >Ext Month-1</th>
                <th class="info" >Ext Month-2</th>
                <th class="info" >Final Probation Evaluation</th> 
          </tr>
         </thead>
         <tbody>
         	
         	 <%
         	   for(int i=0;i<probationCompletedList.size();i++){
         		    Employee probationer = probationCompletedList.get(i);
	         		String doj = probationer.getDate_of_joining();
	         		if(doj!=null){
	         			int year = Integer.parseInt(doj.split("-")[0]);
						int month = Integer.parseInt(doj.split("-")[1]);
						int date =  Integer.parseInt(doj.split("-")[2]);
						String monString="";
						switch(month){
						case 1:monString = "Jan";break;
						case 2:monString ="Feb";break;
						case 3:monString = "March";break;
						case 4:monString = "April";break;
						case 5:monString = "May";break;
						case 6:monString = "June";break;
						case 7:monString = "July";break;
						case 8:monString = "Aug";break;
						case 9:monString = "Sep";break;
						case 10:monString = "Oct";break;
						case 11:monString = "Nov";break;
						case 12:monString = "Dec";break;
	         		 }	
						day =  date+" "+monString+", "+year;
				   }
         	 %>
         	 	<tr class="center">
         	 		<% List<ProbationData> probationDataList = (List<ProbationData>)allProbationCompletedDataList.get(i);	
         	 		   int generalFormRating=0, month1Rating=0, month2Rating=0, month3Rating=0, month4Rating=0, month5Rating=0,finalEvaluationRating=0, extnMonth1Rating=0, extnMonth2Rating=0, midTermRating=0, evaluationRating=0, extensionRating=0;
         	 		   String generalFormStatus="",month1Status="", month2Status="", month3Status="", month4Status="", month5Status="", midTermStatus="",
         	 				  extensionStatus="", evaluationStatus="", extnMonth1Status="", extnMonth2Status="",finalEvaluationStatus="";
         	 		   String rating="";
         	 		   if(probationDataList!=null){
         	 			   for(int j=0;j<probationDataList.size();j++){
            	 				ProbationData probationData = probationDataList.get(j);
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_GENERAL_COMMENTS_FORM)){
            	 					generalFormRating = probationData.getRating();
            	 					generalFormStatus = probationData.getStatus();
            	 				}	
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_MONTH1_FORM)){
            	 					month1Rating = probationData.getRating();
            	 					month1Status = probationData.getStatus();
            	 				}	
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_MONTH2_FORM)){
            	 					month2Rating = probationData.getRating();
            	 					month2Status = probationData.getStatus();
            	 				}	
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_MONTH3_FORM)){
            	 					month3Rating = probationData.getRating();
            	 					month3Status = probationData.getStatus();
            	 				}	
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_MONTH4_FORM)){
            	 					month4Rating = probationData.getRating();
            	 					month4Status = probationData.getStatus();
            	 				}	
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_MONTH5_FORM)){
            	 					month5Rating = probationData.getRating();
            	 					month5Status = probationData.getStatus();
            	 				}	
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_MID_TERM_FORM)){
            	 					midTermRating = probationData.getRating();
            	 					midTermStatus = probationData.getStatus();
            	 				}	
            	 				/*if(probationData.getForm().equals(AppraisalConstants.PROBATION_EXTENSION_FORM)){
            	 					extensionRating = probationData.getRating();
            	 					extensionStatus = probationData.getStatus();
            	 				}*/
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_EVALUATION_FORM)){
            	 					evaluationRating = probationData.getRating();
            	 					evaluationStatus = probationData.getStatus();
            	 				}
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_EXTENTION_MONTH1_FORM)){
            	 					extnMonth1Rating = probationData.getRating();
            	 					extnMonth1Status = probationData.getStatus();
            	 				}	
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_EXTENTION_MONTH2_FORM)){
            	 					extnMonth2Rating = probationData.getRating();
            	 					extnMonth2Status = probationData.getStatus();
            	 				}	
            	 			
            	 				if(probationData.getForm().equals(AppraisalConstants.PROBATION_FINAL_EVALUATION_FORM)){
            	 					finalEvaluationRating = probationData.getRating();
            	 					finalEvaluationStatus = probationData.getStatus();
            	 					
            	 				}
            	 			}
         	 		   }
         	 		%>
         	 		<td><input type="hidden" id="empid" name="empid" value="<%=probationer.getEmployeeId()%>"/><%=probationer.getEmployeeId()%></td>
         	 		<%-- <td><a href="viewProbationReview.apr?empId=<%=probationer.getEmployeeId()%>"><!-- <button onclick="viewEmployeeReview();"> --><%=probationer.getEmployeeName()%><!-- </button> --></a></td>--%>
         	 		<td><a href="#"><!-- <button onclick="viewEmployeeReview();"> --><%=probationer.getEmployeeName()%><!-- </button> --></a></td>
         	 		<td><%=probationer.getReporting_Manager_Name()%></td>
         	 		<td><%=probationer.getGroupName() %></td>
         	 		<td><%=probationer.getDesignation()%></td>
         	 		<td nowrap><%=day%></td>
         	 		<%-- <%switch(generalFormRating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 			%>
         	 		<td class="<%=rating%>"><%=generalFormStatus%></td> --%>
         	 		
         	 		<%switch(month1Rating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 		%>
         	 		<%if(month1Status!=null && month1Status.equals(AppraisalConstants.STATUS_MANAGER_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><font size="1"><%=month1Status.replace("_", " ").toLowerCase()%></font></td>
         	 		<%} else{%>
         	 			<td><%=month1Status.replace("_", " ").toLowerCase()%></td>
         	 		<%} %>
         	 		
         	 		<%switch(month2Rating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 		%>
         	 		<%if(month2Status!=null && month2Status.equals(AppraisalConstants.STATUS_MANAGER_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><font size="1"><%=month2Status.replace("_", " ").toLowerCase()%></font></td>
         	 		<%} else{%>
         	 			<td><%=month2Status.replace("_", " ").toLowerCase()%></td>
         	 		<%} %>
         	 		
         	 		<%switch(month3Rating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 			%>
         	 		<%if(month3Status!=null && month3Status.equals(AppraisalConstants.STATUS_MANAGER_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><font size="1"><%=month3Status.replace("_", " ").toLowerCase()%></font></td>
         	 		<%} else{%>
         	 			<td><%=month3Status.replace("_", " ").toLowerCase()%></td>
         	 		<%} %>
         	 		
         	 		<%switch(midTermRating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 			%>
         	 		<%if(midTermStatus!=null && midTermStatus.equals(AppraisalConstants.STATUS_GH_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><font size="1"><%=midTermStatus.replace("_", " ").toLowerCase()%></font></td>
         	 		<%} else{%>
         	 			<td><%=midTermStatus.replace("_", " ").toLowerCase()%></td>
         	 		<%} %>
         	 		
         	 		<%switch(month4Rating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 			%>
         	 		<%if(month4Status!=null && month4Status.equals(AppraisalConstants.STATUS_MANAGER_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><font size="1"><%=month4Status.replace("_", " ").toLowerCase()%></font></td>
         	 		<%} else{%>
         	 			<td><%=month4Status.replace("_", " ").toLowerCase()%></td>
         	 		<%} %>
         	 		
         	 		<%switch(month5Rating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 		%>
         	 		<%if(month5Status!=null && month5Status.equals(AppraisalConstants.STATUS_MANAGER_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><font size="1"><%=month5Status.replace("_", " ").toLowerCase()%></font></td>
         	 		<%} else{%>
         	 			<td><%=month5Status.replace("_", " ").toLowerCase()%></td>
         	 		<%} %>
         	 			
         	 		<%switch(evaluationRating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 		%>
         	 		<%if (evaluationStatus!=null && evaluationStatus.equals(AppraisalConstants.STATUS_GH_COMPLETED) || evaluationStatus.equals(AppraisalConstants.STATUS_HR_COMPLETED) || evaluationStatus.equals(AppraisalConstants.STATUS_MANAGEMENT_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><font size="1"><%=evaluationStatus.replace("_", " ").toLowerCase()%></font></td>
         	 		<%} else{%>
         	 			<td><%=evaluationStatus.replace("_", " ").toLowerCase()%></td>
         	 		<%} %>
         	 		<%switch(extnMonth1Rating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 		%>
         	 		<%if (extnMonth1Status!=null && extnMonth1Status.equals(AppraisalConstants.STATUS_MANAGER_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><font size="1"><%=extnMonth1Status.replace("_", " ").toLowerCase()%></font></td>
         	 		<%} else{%>
         	 			<td><%=extnMonth1Status.replace("_", " ").toLowerCase()%></td>
         	 		<%} %>
         	 		
         	 		<%switch(extnMonth2Rating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 		%>
         	 		<%if (extnMonth2Status!=null && extnMonth2Status.equals(AppraisalConstants.STATUS_MANAGER_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><font size="1"><%=extnMonth2Status.replace("_", " ").toLowerCase()%></font></td>
         	 		<%} else{%>
         	 			<td><%=extnMonth2Status.replace("_", " ").toLowerCase()%></td>
         	 		<%} %>
         	 		
         	 		<%switch(finalEvaluationRating){
         	 			  case 0:rating="-";break;
         	 			  case 1:rating="Exceptional";break;
         	 			  case 2:rating="Very good";break;
         	 			  case 3:rating="Good";break;
         	 			  case 4:rating="Effort Needed";break;
         	 			  case 5:rating="Unacceptable";break;
         	 			}
         	 		%>
         	 		<%if (finalEvaluationStatus!=null && finalEvaluationStatus.equals(AppraisalConstants.STATUS_GH_COMPLETED) || finalEvaluationStatus.equals(AppraisalConstants.STATUS_HR_COMPLETED) || finalEvaluationStatus.equals(AppraisalConstants.STATUS_MANAGEMENT_COMPLETED)){ %>
         	 			<td><img class="<%=rating%>"/><font size="1"><%=finalEvaluationStatus.replace("_", " ").toLowerCase()%></font></td>
         	 		<%} else{%>
         	 			<td><%=finalEvaluationStatus.replace("_", " ").toLowerCase()%></td>
         	 		<%} %>
         	 			
         	 	</tr>
         	 <%} %>
         	 
         </tbody>
 </table>
 </form>
 <%} %>
</div>
</div>
</div>
</body>
      <!-- jQuery -->
      <script src="components/jquery/dist/jquery.min.js"></script>
      <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
      <script src="js/moment.min.js"></script>
      <!-- Bootstrap Core JavaScript -->
      <script src="components/bootstrap/js/transition.js"></script>
      <script src="components/bootstrap/js/collapse.js"></script>
      <script src="components/bootstrap/dist/js/bootstrap.min.js"></script>
      <!-- Metis Menu Plugin JavaScript -->
      <script src="components/metisMenu/dist/metisMenu.min.js"></script>
      <!-- Custom Theme JavaScript -->
      <script src="dist/js/sb-admin-2.js"></script>   
      <!-- dataTables -->
      <script src="components/datatables/media/js/jquery.dataTables.min.js"></script>
      <script src="components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>
      <script type="text/javascript" src="scripts/probationScripts.js"></script>
</html>