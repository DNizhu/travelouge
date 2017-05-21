<!-- Navigation -->
<%@page import="com.thepsi.appraisalSystem.util.AppraisalConstants"%>
<%@ page errorPage="error.jsp" %>
<%@ page import="java.util.*, java.lang.*, com.thepsi.appraisalSystem.model.*"  %>

<%  
   String admin = (String)session.getAttribute("admin");
   Employee employee = (Employee)session.getAttribute("employeeDetails");
   String gender = (String)employee.getSex();

   if(admin == null )
   {  admin = "N";
       //System.out.println("Admin"+admin);
   }
   else
   {
	   //System.out.println("Admin"+admin);
   }
      String Manager = (String)session.getAttribute("Manager");
      if(Manager == null )
      {  Manager = "N";
         //System.out.println("Manager"+Manager);
      }
      else
      {
   	   //System.out.println("Manager"+Manager);
      }
      
      String HR = (String)session.getAttribute("HR");
      if(HR == null )
      {  HR = "N";
         //System.out.println("HR"+HR);
      }
      else
      {
   	    //System.out.println("HR"+HR);
      }
       String managerReviewer = (String)session.getAttribute("SecondLevelReviewer");
      if(managerReviewer == null )
      {  managerReviewer = "N";
         //System.out.println("AGH"+AGH);
      }
      
      String mgmt = (String)session.getAttribute("mgmt");
      if(mgmt == null )
      {  mgmt = "N";
         //System.out.println("mgmt"+mgmt);
      }
      else
      {
   	    System.out.println("mgmt"+mgmt);
      }
       String GH = (String)session.getAttribute("GH");
      if(GH == null )
      {  GH = "N";
        
      }
      else
      {
   	    System.out.println("GH"+GH);
      } 
      String AdditionalManager = (String)session.getAttribute("AdditionalManager");
      if(AdditionalManager == null )
      {  AdditionalManager = "N";
         //System.out.println("AdditionalManager"+AdditionalManager);
      }
      else
      {
   	    //System.out.println("AdditionalManager"+AdditionalManager);
      }
      
      String AVP = (String)session.getAttribute("AVP");
      if(AVP == null )
      {  AVP = "N";
        
      }
      else
      {
   	    System.out.println("AVP"+AVP);
      } 
      
   Employee emp = (Employee) session.getAttribute("employeeDetails");%>
   <script>
   
   function viewProbationReview(){
	   document.getElementById("probationForm").action='viewProbationReview.apr';
	   document.getElementById("probationForm").submit();
   }
   
   </script>
   <form id="probationForm" action="" method="post"></form>
        <nav class="navbar navbar-default navbar-static-top wrapper" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href = "instructions.jsp"><img src = "images/login_logo.png"> <!--<span style = "color: #428bca"> <b>Travel Desk </b> </span>--></img><img src = "images/travel-desk-logo.png" class="img-thumbnail" width="100" height="100"></a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                 <li>
            	<a href="<%=(String)session.getAttribute("mspsLink")%>" target="_blank"> <span style = "color: #d9534f"> <b><i class="fa fa-external-link fa-fw"></i>Project Information</b></span></a>
               </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <%= emp.getEmployeeName() %>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="logout.apr"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar wrapper" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                       
                       <% if ( admin.equals("Y") ){ %>
                        <li>
                        	<a href="#"><img src="images/icons/Admin.png"  style="width:30px;height:30px;"> Admin<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="#"><img src="images/icons/Appraisal Cycle.png"  style="width:30px;height:30px;"> Appraisal Cycle</a>
                                </li>
                                
                                <li>
                                    <a href="#"><img src="images/icons/Archive.png"  style="width:30px;height:30px;"> Records</a>
                                </li>
                                
                                <li>
                                    <a href="#"><img src="images/icons/Edit.png"  style="width:30px;height:30px;"> Change Employee Status</a>
                                </li> 
                                
                            </ul>
                        </li>
                        <%} %>
                        
                       
                        <li>
                            <a href="#"><img src="images/icons/Guidelines.png"  style="width:30px;height:30px;"> Guidelines<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="#"><img src="images/icons/Instruction.png"  style="width:30px;height:30px;"> Instructions</a>
                                </li>
                                <li>
                                    <a href="#"><img src="images/icons/Sample.png"  style="width:30px;height:30px;"> Sample Appraisal Form</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                         <li>
                            <a href="#"><img src="images/icons/skill_icon.png"  style="width:30px;height:30px;"> My Skills</a>
                        </li>
                        <li>
                       <%if(admin.equals("Y") || HR.equals("Y") || mgmt.equals("Y")||GH.equals("Y")||AVP.equals("Y") || Manager.equals("Y")){ %>
                       		<a href="viewSubordinateProbationers.apr"><img src="images/icons/probation.jpg"  style="width:30px;height:30px;"> Probation Evaluation </a>
                       <%} else if(employee.getIsProbationer()==1){%>
                       		<a href="#"><img src="images/icons/probation.jpg"  style="width:30px;height:30px;"> Probation Evaluation </a>
                       <% } %>
                       </li> 
                        <li>
                            <a href="#"><img src="images/icons/Self.png"  style="width:30px;height:30px;"> Self Appraisal</a>
                        </li>
                        <li>

                     

                             <ul class="nav nav-second-level">
                                <li>
                                    <a href="#"><img src="images/icons/Notes.png"  style="width:30px;height:30px;"> Appraisal Notes</a>
                                </li>
                                <li>
                                	
                                    	<a href="#"><img src="images/icons/Goal-48.png"  style="width:30px;height:30px;"> My Targets</a>
                                    
                                </li>
                        <% if(Manager.equals("Y")){ %>
                         <li> 
                            <a href="#"><img src="images/icons/Target.png"  style="width:30px;height:30px;"> Team Targets</a>
                        </li>
						<%} %>
                  
                            </ul>
                         </li>
   
						<% if(AdditionalManager.equals("Y")|| Manager.equals("Y")||mgmt.equals("Y")||HR.equals("Y")){ %>
                        <li>
                            <a href="#"><img src="images/icons/Team.png"  style="width:30px;height:30px;"> Team Appraisals<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                 <% if(Manager.equals("Y")  ){ %>
								<li>
									<%if(gender.equals("M")){%>
                                    	<a href="#"><img src="images/icons/Manager Male.png"  style="width:30px;height:30px;"> Manager Review</a>
                                    <%}else{%>
                                    	<a href="#"><img src="images/icons/Manager Female.png"  style="width:30px;height:30px;"> Manager Review</a>
                                    <%}%>	
                                </li>
                                <% } %>
                                <% if(AdditionalManager.equals("Y")  ){ %>
                                <li>
                                    <a href="#"><img src="images/icons/Add Man.png"  style="width:30px;height:30px;"> Additional Review</a>
                                </li>
                                
								 <% } %>
                                 <% if(managerReviewer.equals("Y")){ %>
								<li>
                                    <a href="#"><img src="images/icons/Second Level.png"  style="width:30px;height:30px;"> Second Level Review</a>
                                </li>
                                <%} %>
                        
                                
                                <% if(HR.equals("Y") ){ %>
                                <li>
                                	<%if(gender.equals("M")){%>
                                    	<a href="#"><img src="images/icons/HR Male.png"  style="width:30px;height:30px;"> HR Review</a>
                                    <%}else{%>
                                    	<a href="#"><img src="images/icons/HR Female.png"  style="width:30px;height:30px;"> HR Review</a>
                                   	<%}%>
                                </li>
                                 <%} %>
                                 
                                 <% if(mgmt.equals("Y")  ){ %>
                                <li>
                                    <a href="#"><img src="images/icons/Management.png"  style="width:30px;height:30px;"> Management Review</a>
                                </li>
								<li>
                                    <a href="#"><img src="images/icons/Add Man.png"  style="width:30px;height:30px;"> Additional Management</a>
                                </li>
                                <%} %>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <%} %>

						 <% if(mgmt.equals("Y")||GH.equals("Y")||AVP.equals("Y")){ %>
                        <li>
                       	  <a href="#"><img src="images/icons/Normalize.png"  style="width:30px;height:30px;"> Normalize Rating</a>
                       	  </li>
                       <% }%>
                       
                       
						 <% if( admin.equals("Y") || HR.equals("Y")||mgmt.equals("Y")||AVP.equals("Y")){ %>
                        <li>
                       	  <a href="#"><img src="images/icons/Bar Chart.png"  style="width:30px;height:30px;"> Dashboard</a>
                       	  </li>
                       <% }%>
                       <li>
                       	<a href="#"><img src="images/icons/Report.png"  style="width:30px;height:30px;"> Appraisals Report<span class="fa arrow"></span></a>
	                       	<ul class="nav nav-second-level">
	                       		<li>
	                       			<%if(gender.equals("M")){%>
                                    	<a href="#"><img src="images/icons/Boy.png"  style="width:30px;height:30px;"> My Report</a>
                                    <%}else{%>
                                    	<a href="#"><img src="images/icons/Girl.png"  style="width:30px;height:30px;"> My Report</a>
                                    <%}%>
                                </li>
                                <li>
                                	<a href="#"><img src="images/icons/skill_report_icon.png"  style="width:30px;height:30px;"> Skill Report</a>
                                </li>
                                
                                <% if(mgmt.equals("Y")||HR.equals("Y")||Manager.equals("Y")||GH.equals("Y")||AVP.equals("Y")){%>
                                <li>
                                    <a href="#"><img src="images/icons/Team Report.png"  style="width:35px;height:35px;"> Team Report</a>
                                </li>
                                
								<% } %>
								<!-- <li>
									<a href=""><img src="images/icons/probationer's report.png"  style="width:35px;height:35px;">Probationer's Report</a>
								</li>-->
								  <% if(HR.equals("Y")){%>
								   <li>
                                    <a href="getTelppImpact.apr"><img src="images/icons/skill_report_icon.png"  style="width:35px;height:35px;">Impact & Telpp</a>
                                </li>
								  <% } %>
	                       	</ul>
                       </li> 
                       
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
		