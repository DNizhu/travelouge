<%@page import="com.sun.org.apache.xml.internal.security.utils.Base64"%>
<%@ page errorPage="error.jsp" %>
<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="com.thepsi.appraisalSystem.util.AppraisalConstants,java.text.SimpleDateFormat"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ page import="java.util.*, java.lang.* , com.thepsi.appraisalSystem.model.*,java.text.SimpleDateFormat " %>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

  <!-- Bootstrap Core CSS -->
      <link href="components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
      <!-- MetisMenu CSS -->
      <link href="components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
      <!-- Custom CSS -->
      <link href="dist/css/sb-admin-2.css" rel="stylesheet">
      <!-- Custom Fonts -->
      <link href="components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
      <!-- DataTables CSS -->
      <!-- <link href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" rel="stylesheet"> -->
      <link href="components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet">
      <!--  <link href="https://cdn.datatables.net/select/1.2.1/css/select.dataTables.min.css" rel="stylesheet">
       <link href="https://cdn.datatables.net/buttons/1.2.2/css/buttons.dataTables.min.css" rel="stylesheet"> -->
      
      <!-- DataTables Responsive CSS -->
      <link href="components/datatables-responsive/css/dataTables.responsive.css" rel="stylesheet">
     
     
      <!-- Footer CSS -->
      <link href="css/footer.css" rel="stylesheet">
    
<title>Appraisal System</title>
      <%  List <String> employeeList = (List <String>) request.getAttribute("employeeList");
          List <String> groups = (List <String>)request.getAttribute("listOfGroups");
          List <String> designations = (List <String>)request.getAttribute("designation");
          List <TelppImpactReportVO> employeeTelppList = (List <TelppImpactReportVO>)request.getAttribute("employeeTelppList");
          List <String> searchCriteria = (List <String>) request.getAttribute("searchCriteria");
        %>
</head>
<body>
  <div id="wrapper">
         <!-- Navigation -->                 
         <jsp:include page="sideMenu.jsp" />
         <!-- Page Content -->
         <div id="page-wrapper">
            <div class="row">
               <div class="col-lg-12">
                  <h2> <img src="images/icons/skill_report_icon.png"  style="width:50px;height:50px;"> Telpp Impact Report</h2>
               </div>
               <!-- /.col-md-12 -->
            </div>
            <br>
            
              <form action="getBasicSearchTelpp.apr" method="post"  name="basicSearchForm" id="basicSearchForm">
               <div class="panel panel-info">
                  <div class="panel-heading">
                     Search Criteria
                  </div>
                  <div class="panel-body">
                     <div class="row">
                               <div class="col-md-3">
                                    <div class="form-group input-group">
                                       <span  class="input-group-addon">Designation</span>
                                       <select class="form-control" name="designation" id="designation">
                                          <option value="">All Designation</option>
					                                 <c:forEach items="${designations}" var="designation">
			                                             <option value="${designation}">${designation}</option>
			                                          </c:forEach>
                                       </select>
                                    </div>
                                 </div>
                        
                        
                                 <div class="col-md-3">
                                    <div class="form-group input-group">
                                       <span  class="input-group-addon">Group</span>
                                       <select class="form-control" name="group" id="groups">
                                          <option value="">All Groups</option>
					                                 <c:forEach items="${listOfGroups}" var="group">
			                                             <option value="${group}">${group}</option>
			                                          </c:forEach>
                                       </select>
                                    </div>
                                 </div>
                        <div class="col-md-3" >
                           <div class="form-group input-group">
                              <span  class="input-group-addon">Employee Name</span>
                              <select class="form-control" name="empName" id = "empName">
                                 <option value="">All Employees</option>
                                 <c:forEach items="${employeeList}" var="employee">
                                    <option value="${employee}">${employee}</option>
                                 </c:forEach>
                              </select>
                           </div>
                        </div>
                        <div class="col-md-2" >
                        <div class="row">
                        	<div class="col-md-2" ></div>
                        	<div class="col-md-2" >
                        	<button type="button" class="btn btn-primary" id = "basicSearchBtn" title = "Search">
     							 <span class="glyphicon glyphicon-search"></span>
    						</button>
                           </div>
                           <div class="col-md-2" >
                           <button type="button" class="btn btn-default" id = "basicResetBtn" title = "Reset">
     							 <span class="glyphicon glyphicon-repeat"></span>
    						</button>
                           </div>
                           <div class="col-md-2" >
                            <button type="button" class="btn btn-default exportToExcel" title = "Export To Excel">
     							 <span class="glyphicon glyphicon-export"></span>
    						</button>
                           </div>
                        </div>
                        </div>
                     </div>
                  </div>
               </div>
            </form>
            
              <div class="row">
                  <div class="col-md-12">
                     <div class="panel panel-info">
                        <div class="panel-heading">
                           Result
                        </div>
                        <div class="panel-body">
                           <div class="dataTable_wrapper">
                              <div class="table-responsive">
                                 <table class="table table-striped table-bordered table-hover" id="tableID" >
                                    <thead>
                                       <tr>
                                          <th>S.No.</th>
                                          <th>Emp Code</th>
                                          <th >Employee Name</th>
                                           <th>DOJ</th>
                                          <th >Designation</th>
                                          <th>Impact 1</th>
                                          <th>Impact 2</th>
                                          <th>Telpp</th>
                                       </tr>
                                   
                                    </thead>
                                    <tbody>
                                       <% int index = 1;
                                          if(employeeTelppList != null){
                                        	  for( TelppImpactReportVO employeeTelpp : employeeTelppList) { %>
                                              <tr>
                                                 <td><%=index++%></td>
                                                 <td><%=employeeTelpp.getEmpCode()%></td>
                                                 <td><%=employeeTelpp.getEmployeeName() %></td>
                                                 <td><%=employeeTelpp.getDoj() %></td>
                                                 <td><%=employeeTelpp.getDesignation() %></td>
                                                 <% if(employeeTelpp.getImpact().equals("1")){ %>
                                                  <td> <button type="button" class="btn btn-success btn-circle"><i class="fa fa-check"></i> </button></td>
                                                 <%}else{ %>
                                                  <td><button type="button" class="btn btn-danger btn-circle"><i class="fa fa-times"></i> </button></td>
                                                  <%} %>
                                                  <% if(employeeTelpp.getImpact2().equals("1")){ %>
                                                  <td><button type="button" class="btn btn-success btn-circle"><i class="fa fa-check"></i> </button></td>
                                                 <%}else{ %>
                                                  <td><button type="button" class="btn btn-danger btn-circle"><i class="fa fa-times"></i> </button></td>
                                                  <%} %>
                                                  <% if(employeeTelpp.getTelpp().equals("1")){ %>
                                                 <td><button type="button" class="btn btn-success btn-circle"><i class="fa fa-check"></i> </button></td>
                                                 <%}else{ %>
                                                  <td> <button type="button" class="btn btn-danger btn-circle"><i class="fa fa-times"></i> </button></td>
                                                  <%} %>
                                              </tr>
                                              <%} 
                                          }%>
                                    </tbody> 
                                 </table>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
       </div>
       </div> 
</body>
 <script src="components/jquery/dist/jquery.min.js"></script>
      <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
      <!-- Bootstrap Core JavaScript -->
      <script src="components/bootstrap/dist/js/bootstrap.min.js"></script>
      <!-- Metis Menu Plugin JavaScript -->
      <script src="components/metisMenu/dist/metisMenu.min.js"></script>
      <!-- Custom Theme JavaScript -->
      <script src="dist/js/sb-admin-2.js"></script>
      <!-- DataTables JavaScript -->
      <script src="components/datatables/media/js/jquery.dataTables.min.js"></script>
      <script src="components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>
      <script type="text/javascript" src="dist/js/fnGetHiddenNodes.js"></script>
      <!-- Custom Scripts JavaScript -->
      <script src="scripts/common.js"></script>
      <script src="dist/js/table2excel.js"></script>
      <script src="dist/js/summernote.min.js"></script> 
       <script src="scripts/telppImpact.js"></script>
</html>