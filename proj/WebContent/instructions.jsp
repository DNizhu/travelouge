<!DOCTYPE html>
<html lang="en">
<%@ page errorPage="error.jsp" %>
<%@ page import="java.util.*, java.lang.*, com.thepsi.appraisalSystem.model.*"  %>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Travel Desk</title>

    
    <!-- Bootstrap Core CSS -->
    <link href="components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <!-- Timeline CSS -->
    <link href="dist/css/timeline.css" rel="stylesheet">
    
    <!-- Footer CSS -->
    <link href="css/footer.css" rel="stylesheet">
    
    <!-- Custom CSS -->
    <link href="css/theme.css" rel="stylesheet">
</head>

<body>
   <% String admin = (String)session.getAttribute("admin");
      String Manager = (String)session.getAttribute("Manager");
      String HR = (String)session.getAttribute("HR");
      String SLR = (String)session.getAttribute("SLR");
      String mgmt = (String)session.getAttribute("mgnt");
      String GH = (String)session.getAttribute("GH");
    //Employee emp=(Employee)request.getAttribute("employeeDetails");
    Employee emp = (Employee) session.getAttribute("employeeDetails");%>
    <div id="wrapper" class = "wrapper">
        <!-- Navigation -->                 
        <jsp:include page="sideMenu.jsp"/>
	<!-- Page Content -->
        <div id="page-wrapper">
             <div class="row">
                <div class="col-lg-12">
                    <h2 class="page-header"><img src="images/icons/Performance.png"  style="width:50px;height:50px;"> Performance Appraisal</h2>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- row -->
            
            <div class="row">
                <div class="col-lg-5">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            Your Appraisal is divided into 3 questions
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="alert alert-success">
                                <div class="alert-link">What did I do well?</div><font color="#000000"> Here is your chance to showcase all that was important and you did well. Whatever you are proud of. Be it your technical field, or in other areas. Go ahead - add personal achievements too!.</font> 
                            </div>
                            <div class="alert alert-success">
                                <div class="alert-link">What could I improve upon?</div><font color="#000000"> Give your performance a thorough thought and THINK which were the areas that you thought you could have done better. Think what could have held you back. Think what was the reason? Think how can Pratham and its people help you overcome that!.</font>
                            </div>
                            
                            <div class="alert alert-success">
                                 <div class="alert-link">How do I rate myself?</div><font color="#000000"> The ratings have changed. Go through them carefully, understand them clearly and rate yourself honestly.</font> 
                            </div>
							
							 <div class="panel panel-yellow">
                        <div class="panel-heading">
                            Please make sure that
                        </div>
                        <div class="panel-body">
                            <p>1. You don't forget to rate yourself</p>
                            <p> <b>2. You use the Project Information Link to see your project & time sheet details</b></p>
                            <p>3. You refer the Sample Appraisal form</p>
                            <p>4. Please only use the provided editor to fill reviews. Do not paste content from any external editor.</p>
                            
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    
                     <div class="panel panel-yellow">
                        <div class="panel-heading">
                          Appraisal Notes
                        </div>
                        <div class="panel-body">
                            <p> <b> You can use Appraisal Notes to save a record of helpful notes/dates etc.</b> </p>
							<p>These notes can serve as a reminder to self and data can be used at time of filling appraisal form. </p>
                          
                            
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
							
                        </div>
                        <!-- .panel-body -->
                    </div>
                    <!-- /.panel -->
                    
                   
                    
                </div>
                <!-- /.col-lg-6 -->
                <div class="col-lg-4">
				    
					 <div class="panel panel-primary">
                        <div class="panel-heading">
                            Ratings
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="alert alert-info">
                                <div class="alert-link">Exceptional</div><font color="#000000"> Exceptional performance in all areas of responsibility. Planned objectives were always achieved well above the established standards and accomplishments were made in unexpected areas.</font>
                            </div>
                            <div class="alert alert-info">
                                <div class="alert-link">Very Good</div><font color="#000000"> Consistently exceeds established standards in most areas of responsibility. All requirements were met and objectives were achieved above the established standards.</font>
                            </div>
                            
                            <div class="alert alert-info">
                                 <div class="alert-link">Good</div><font color="#000000"> All job requirements were met and planned objectives were accomplished within established standards. There were no areas where accomplishments were less than planned.</font>
                            </div>
							
							<div class="alert alert-info">
                                <div class="alert-link">Effort Needed</div><font color="#000000">Performance in one or more critical areas did not meet expectations. Not all planned objectives were accomplished within the established standards and responsibilities were not completely met. Definate effort require for improvement.</font>
                            </div>
							
							<div class="alert alert-info">
                                <div class="alert-link">Unacceptable</div><font color="#000000">Does not meet minimum job requirements. Performance is unacceptable. Responsibilities are not being met and important objectives have not been accomplished. Reasonable Potential for improvement not seen.</font>
                            </div>
                        </div>
                        <!-- .panel-body -->
                    </div>
					
				
				
                   <!--<div class="panel panel-info">
                        <div class="panel-heading">
                            <i class="fa fa-clock-o fa-fw"></i> Ratings
                        </div>
                        <!-- /.panel-heading -->
                        <!--<div class="panel-body">
                            <ul class="timeline">
							
                                <li>
                                    
                                    <div class="timeline-panel">
                                        <div class="timeline-heading">
                                            <h4 class="timeline-title">Exceptional</h4>
                                           
                                        </div>
                                        <div class="timeline-body">
                                            <p>Choose this, if your work is much beyond what is required from you - ALL THE TIME.</p>
                                        </div>
                                    </div>
                                </li>
                                <li class="timeline-inverted">
                                    
                                    <div class="timeline-panel">
                                        <div class="timeline-heading">
                                            <h4 class="timeline-title">Very Good</h4>
                                        </div>
                                        <div class="timeline-body">
                                            <p>Choose this, if you think you have worked beyond what was required. You worked better than your own expectations! Even you are surprised that you could work so well!</p>
                                            
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    
                                    <div class="timeline-panel">
                                        <div class="timeline-heading">
                                            <h4 class="timeline-title">Good</h4>
                                        </div>
                                        <div class="timeline-body">
                                            <p>Choose this, if you think that you were able to work as expected ALL the time. Without fail - even once.</p>
                                        </div>
                                    </div>
                                </li>
                                <li class="timeline-inverted">
                                    <div class="timeline-panel">
                                        <div class="timeline-heading">
                                            <h4 class="timeline-title">Effort Needed</h4>
                                        </div>
                                        <div class="timeline-body">
                                            <p>Choose this, if you think you have worked as good as you were expected to work. You have completed all your work on time, and your work was bug free / fault free within expected limits.</p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                   
                                    <div class="timeline-panel">
                                        <div class="timeline-heading">
                                            <h4 class="timeline-title"> Unacceptable</h4>
                                        </div>
                                        <div class="timeline-body">
                                            <p>Choose this, if you think you are working at a lower level than expected from you.</p>
                                            
                                            
                                        </div>
                                    </div>
                                </li>
                                
                            </ul>
                        </div>
                        <!-- /.panel-body -->
                    <!--</div>-->
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->
				<div class="col-lg-3">
				  <div class="row">
				  <div class="panel panel-red">
                        <div class="panel-heading">
                            TELPP & IMPACT
                        </div>
                        <div class="panel-body">
                            <div class="alert alert-danger">
                                <div class="alert-link">TELPP</div><font color="#000000"> As per the TELPP Policy an employee is required to clear the TELPP and achieve the desired Band Level according to his /her designation. In case you have achieved One Band  Lower Score or not able to clear are advised to clear and achieve the desired band before 31st March 2016. </font> <a href="Documents/Language Proficiency Policy Ver2_3.docx">Details</a> 
                            </div>
							<div class="alert alert-danger">
                                <div class="alert-link">IMPACT</div><font color="#000000"> Under the IMPACT program, every employee needs to deliver minimum one session in a six months duration. In case you have not delivered the Impact Session, you are requested to kinldy deliver the session.</font> <a href="Documents/Impact Program_ver3.docx">Details</a>
                            </div>
							<div class="alert alert-danger">
                                <div class="alert-link">Note</div><font color="#000000"> Please remember that, for those who are not able to achieve the required levels,  while the appraisal will be completed, salary reviews, if any, other benefits and promotion etc. will become applicable as soon as the above requirements are fulfilled.</font>
                            </div>
                            
                        </div>
                        <!-- /.panel-body -->
                  </div>
                    <!-- /.panel -->
				 </div>
				 
			 </div>
				
            </div>
            <!-- /.row -->
           
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    
    <!-- jQuery -->
    <script src="components/jquery/dist/jquery.min.js"></script>
    <!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>-->
    <!-- Bootstrap Core JavaScript -->
    <script src="components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>
    
    <!-- Morris Charts JavaScript 
    <script src="components/raphael/raphael-min.js"></script>
    <script src="components/morrisjs/morris.min.js"></script>
    <script src="js/morris-data.js"></script>-->
    
</body>
<!-- <br><br>
  <footer class="footer">
      <div class="container">
        <p class="text-muted">&copy; 2000-2015 Pratham Software (PSI). All Rights Reserved.</p>
      </div>
    </footer>-->
    
</html>
