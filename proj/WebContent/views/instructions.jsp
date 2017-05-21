<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Appraisal System</title>

    
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
    
    <!-- Morris Charts CSS 
    <link href="components/morrisjs/morris.css" rel="stylesheet">-->
</head>

<body>

    <div id="wrapper">

         <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Appraisal System</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
               
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <!--<li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>-->
                        <li><a href="login.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                       
                       <li>
                            <a href="appraisalStartCycle.jsp"><i class="fa fa-edit fa-fw"></i>Start Appraisal</a>
                        </li>
                        
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Guidelines<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="instructions.jsp">Instructions</a>
                                </li>
                                <li>
                                    <a href="sampleForm.jsp">Sample Appraisal Form</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="reviewForm.jsp"><i class="fa fa-edit fa-fw"></i>Self Review Form</a>
                        </li>
                        
						
                        <li>
                            <a href="#"><i class="fa fa-edit fa-fw"></i> Review Form<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="listForm.jsp"> Manager Review</a>
                                </li>
                                <li>
                                    <a href="listForm.jsp"> Additional Review</a>
                                </li>
								<li>
                                    <a href="listForm.jsp"> Second Level Review</a>
                                </li>
                                <li>
                                    <a href="listForm.jsp"> Final Review</a>
                                </li>
                                <li>
                                    <a href="listFormGroupWise.jsp"> HR Review</a>
                                </li>
                                <li>
                                    <a href="listFormGroupWise.jsp"> Management Review</a>
                                </li>
                                
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                       
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

		
		
        <!-- Page Content -->
        <div id="page-wrapper">
             <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Performance Appraisal</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- row -->
            
            <div class="row">
                <div class="col-lg-5">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Your Appraisal is divided into 3 questions
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="alert alert-success">
                                <a href="#" class="alert-link">"What did I do well?"</a> - Here is your chance to showcase all that was important and you did well. Whatever you are proud of. Be it your technical field, or in other areas. Go ahead – add personal achievements too!. 
                            </div>
                            <div class="alert alert-info">
                                <a href="#" class="alert-link"> “What could I improve upon?”</a> – Give your performance a thorough thought and THINK which were the areas that you thought you could have done better. Think what could have held you back. Think what was the reason? Think how can Pratham and its people help you overcome that!.
                            </div>
                            
                            <div class="alert alert-danger">
                                 <a href="#" class="alert-link">“How do I rate myself?”</a> – The ratings have changed. Go through them carefully, understand them clearly and rate yourself honestly. 
                            </div>
                        </div>
                        <!-- .panel-body -->
                    </div>
                    <!-- /.panel -->
                    
                    <div class="panel panel-red">
                        <div class="panel-heading">
                            Please make sure that
                        </div>
                        <div class="panel-body">
                            <p>1. You don't forget to rate yourself</p>
                            <p>2. You use the Formatting options (bullets, bold, italics, color etc.) in the text boxes by right clicking to make you response more effective</p>
                            <p>3. You refer the Sample Appraisal form</p>
                            
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                    
                </div>
                <!-- /.col-lg-6 -->
                <div class="col-lg-7">
                   <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-clock-o fa-fw"></i> Ratings
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <ul class="timeline">
							
                                <li>
                                    
                                    <div class="timeline-panel">
                                        <div class="timeline-heading">
                                            <h4 class="timeline-title">Exceptional</h4>
                                           
                                        </div>
                                        <div class="timeline-body">
                                            <p>Choose this, if your work is much beyond what is required from you – ALL THE TIME.</p>
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
                                            <p>Choose this, if you think that you were able to work as expected ALL the time. Without fail – even once.</p>
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
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->
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

</html>
