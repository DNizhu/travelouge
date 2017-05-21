<!DOCTYPE html>
<%@ page errorPage="error.jsp" %>
<%@page import="com.thepsi.appraisalSystem.* " %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>PSI-The Travel Desk</title>

    <!-- Bootstrap Core CSS -->
    <link href="components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
</head>

<body>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-info">
                    <div class="panel-heading">
                     <img src = "images/login_logo.png">&nbsp;&nbsp;<span style = "color: #428bca">  Welcome to PSI-Travel Desk </span>
                    </div>
                    <div class="panel-body">
                        <form role="form" method="post" action="handleLogin.apr">
                            <fieldset>
                                <div class="form-group">
                                     <input class="form-control" placeholder="UserName" name="email" type="text" required data-toggle="tooltip" title="Enter username without @thepsi.com">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" value="" required>
                                </div>
                              
                                <!-- Change this to a button or input when using this as a form -->
                                <!--  <a href="instructions.jsp" class="btn btn-lg btn-success btn-block">Login</a>-->
                                <input type ="submit"  class="btn btn-lg btn-success btn-block" value="Login" name="login" id="btnLogin"/>
                            </fieldset>
                        </form>
                        <%
if (request.getAttribute("errMsg")!= null && !request.getAttribute("errMsg").equals(""))
{
	
%>

  <div class="panel-heading">
                        <span style = "color: red"> <%=request.getAttribute("errMsg") %></span>
                    </div>
      
<%
}
%>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>



    <!-- jQuery--> 
    <script src="components/jquery/dist/jquery.min.js"></script>
    <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>-->
    <!-- Bootstrap Core JavaScript -->
    <script src="components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>
    <script>
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip(); 
});
</script>
    

</body>

</html>
