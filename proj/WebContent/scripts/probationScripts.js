$(document)
.ready(
    function() {
    	$("#employeesOnProbationDiv").addClass("active");
   
    });

$(document)
.ready(
    function() {
        var datatable = $("#probationersTable").DataTable({
        	responsive: true,
            paging: true,
            "lengthMenu": [15,25, 50, 75, 100 ],
            "order": [[ 1, "asc" ]],
            columnDefs: [{
                    width: "5%",
                    targets: 0
                }, {
                    width: "7%",
                    targets: 1
                }, {
                    width: "7%",
                    targets: 2
                }, {
                    width: "7%",
                    targets: 3
                }, {
                    width: "7%",
                    targets: 4
                }, {
                    width: "7%",
                    targets: 5
                }, {
                    width: "6%",
                    targets: 6
                },{
                    width: "6%",
                    targets: 7
                }, {
                    width: "6%",
                    targets: 8
                }, {
                    width: "6%",
                    targets: 9
                }, {
                    width: "6%",
                    targets: 10
                }, {
                    width: "6%",
                    targets: 11
                },{
                    width: "6%",
                    targets: 12
                },{
                    width: "6%",
                    targets: 13
                },{
                    width: "6%",
                    targets: 14
                },{
                    width: "6%",
                    targets: 15
                }

            ],
            "language": {
                "emptyTable": "No probationer"
            },

            "initComplete": function() {
                $('.dataTables_scrollBody thead tr').css({
                    visibility: 'collapse'
                });
            }   
        });   
    });

function filterGlobal (flag) {
	
	if(flag==1){
		var probationCompletedDate = document.getElementById("probationCompletedDate").value;
		document.getElementById("global_filter").value = probationCompletedDate;
	}	
	else if(flag==2)
		document.getElementById("global_filter").value="hr completed";
	else if(flag==3)
		document.getElementById("global_filter").value="coe completed";
	else if(flag==4)
		document.getElementById("global_filter").value="manager completed";
	else if(flag==5){
		var midTermDate = document.getElementById("midTermDate").value;
		document.getElementById("global_filter").value=midTermDate;
	}
	else if(flag==6)
		document.getElementById("global_filter").value="self completed";
	else if(flag==7)
		document.getElementById("global_filter").value="not started";
	
    $('#probationersTable').DataTable().search( 
        $('#global_filter').val()
    ).draw();
}
function filterNormal(){
	
	document.getElementById("global_filter").value="";
	$('#probationersTable').DataTable().search( 
		$('#global_filter').val()
	 ).draw();
}
function showEmployeesOnProbation(){
	
	filterNormal();
	$("#probationFYIBtn").html("<strong>" + "Probation FYI's" + "</strong><span class='caret'></span>");
	
	$('#employeesOnProbationTab').addClass("active");
	$('#pendingOnMeTab').removeClass("active");
	$('#probationFYIBtn').removeClass("btn-primary");
	$('#probationCompletedEmployeesTab').removeClass("active");
	
	$("#employeesOnProbationDiv").addClass("active");
	$("#employeesOnProbationDiv").show();
	$('#pendingOnMeDiv').hide();
	$("#employeesWithProbationCompletedDiv").hide();
}
function showPendingOnMe(){
	
	$("#probationFYIBtn").html("<strong>" + "Probation FYI's" + "</strong><span class='caret'></span>");
	
	$('#employeesOnProbationTab').removeClass("active");
	$('#pendingOnMeTab').addClass("active");
	$('#probationFYIBtn').removeClass("btn-primary");
	$('#probationCompletedEmployeesTab').removeClass("active");
	$("#employeesOnProbationDiv").removeClass("active");
	
	$("#employeesOnProbationDiv").hide();
	$('#pendingOnMeDiv').addClass("active");
	$('#pendingOnMeDiv').show();
	$("#employeesWithProbationCompletedDiv").hide();
}

function showProbationFYI(flag){
	
	filterGlobal(flag);
	$('#employeesOnProbationTab').removeClass("active");
	$('#pendingOnMeTab').removeClass("active");
	$('#probationFYIBtn').addClass("btn-primary");
	$('#probationCompletedEmployeesTab').removeClass("active");
	$("#employeesOnProbationDiv").removeClass("active");
	$('#pendingOnMeDiv').removeClass("active");
	$("#employeesOnProbationDiv").addClass("active");
	$("#employeesOnProbationDiv").show();
	$('#pendingOnMeDiv').hide();
	$("#employeesWithProbationCompletedDiv").hide();
}

function showProbationCompleted(){
	
	$("#probationFYIBtn").html("<strong>" + "Probation FYI's" + "</strong><span class='caret'></span>");
	//tabs
	$('#employeesOnProbationTab').removeClass("active");
	$('#pendingOnMeTab').removeClass("active");
	$('#probationFYIBtn').removeClass("btn-primary");
	$('#probationCompletedEmployeesTab').addClass("active");
	//div
	$("#employeesOnProbationDiv").removeClass("active");
	$('#pendingOnMeDiv').removeClass("active");
	$("#employeesOnProbationDiv").removeClass("active");
	$("#employeesWithProbationCompletedDiv").addClass("active");
	
	$("#employeesOnProbationDiv").hide();
	$('#pendingOnMeDiv').hide();
	$("#employeesWithProbationCompletedDiv").show();
}

/*function viewEmployeeReview(){
		document.forms[0].action = 'viewProbationReview.apr';
		document.forms[0].submit();
}*/


function viewEmployeeReview(empID){
	 console.log(empID);
	 if($("#employeesOnProbationDiv").hasClass("active")){
		 console.log("employeesOnProbationDiv"+empID);
		 document.getElementById("employeesOnProbationForm").action ='viewProbationReview.apr';
		 document.getElementById("empid").value=empID;
		 console.log(document.getElementById("empid").value);
		 document.getElementById("employeesOnProbationForm").submit();
	 }
	 if($("#pendingOnMeDiv").hasClass("active")){
		 console.log("pendingOnMeDiv");
		 document.getElementById("pendingOnMeForm").action = 'viewProbationReview.apr';
		 document.getElementById("empid").value=empID;
		 document.getElementById("pendingOnMeForm").submit();
	 }
	 if($("#employeesWithProbationCompletedDiv").hasClass("active")){
		 console.log("employeesWithProbationCompletedDiv");
		 document.getElementById("employeesWithProbationCompletedForm").action = 'viewProbationReview.apr';
		 document.getElementById("empid").value=empID;
		 document.getElementById("employeesWithProbationCompletedForm").submit();
	 }
}

$(document)
.ready(
    function() {
        var datatable = $("#probationerCompletedTable").DataTable({
        	responsive: true,
            paging: true,
            "lengthMenu": [15,25, 50, 75, 100 ],
            "order": [[ 1, "asc" ]],
            columnDefs: [{
                    width: "5%",
                    targets: 0
                }, {
                    width: "7%",
                    targets: 1
                }, {
                    width: "7%",
                    targets: 2
                }, {
                    width: "7%",
                    targets: 3
                }, {
                    width: "7%",
                    targets: 4
                }, {
                    width: "7%",
                    targets: 5
                }, {
                    width: "6%",
                    targets: 6
                },{
                    width: "6%",
                    targets: 7
                }, {
                    width: "6%",
                    targets: 8
                }, {
                    width: "6%",
                    targets: 9
                }, {
                    width: "6%",
                    targets: 10
                }, {
                    width: "6%",
                    targets: 11
                },{
                    width: "6%",
                    targets: 12
                },{
                    width: "6%",
                    targets: 13
                },{
                    width: "6%",
                    targets: 14
                },{
                    width: "6%",
                    targets: 15
                }

            ],
            "language": {
                "emptyTable": "No probationer"
            },

            "initComplete": function() {
                $('.dataTables_scrollBody thead tr').css({
                    visibility: 'collapse'
                });
            }
            
        });
    });

$(document)
.ready(
    function() {
        var datatable = $("#pendingOnMeTable").DataTable({
        	responsive: true,
            paging: true,
            "lengthMenu": [15,25, 50, 75, 100 ],
            "order": [[ 1, "asc" ]],
            columnDefs: [{
                    width: "5%",
                    targets: 0
                }, {
                    width: "7%",
                    targets: 1
                }, {
                    width: "7%",
                    targets: 2
                }, {
                    width: "7%",
                    targets: 3
                }, {
                    width: "7%",
                    targets: 4
                }, {
                    width: "7%",
                    targets: 5
                }, {
                    width: "6%",
                    targets: 6
                },{
                    width: "6%",
                    targets: 7
                }, {
                    width: "6%",
                    targets: 8
                }, {
                    width: "6%",
                    targets: 9
                }, {
                    width: "6%",
                    targets: 10
                }, {
                    width: "6%",
                    targets: 11
                },{
                    width: "6%",
                    targets: 12
                },{
                    width: "6%",
                    targets: 13
                },{
                    width: "6%",
                    targets: 14
                },{
                    width: "6%",
                    targets: 15
                }

            ],
            "language": {
                "emptyTable": "No probationer"
            },

            "initComplete": function() {
                $('.dataTables_scrollBody thead tr').css({
                    visibility: 'collapse'
                });
            }
            
        });
    });

$("#probationFYIDropdown")
.delegate("#probationFYI li",
    "click",
    function() {
        $("#probationFYIBtn").html("<strong>" + $(this).text() + "</strong><span class='caret'></span>");
    	$("#probationFYIBtn").addClass("btn-primary");
    }
);

/*function changeLabel(){
	 $("#probationFYIBtn").html("<strong>" + $(this).text() + "</strong><span class='caret'></span>");
     if($(this).text=="Probation Completion")
 	   $("#CompletionFYI").addClass("active");
}
*/