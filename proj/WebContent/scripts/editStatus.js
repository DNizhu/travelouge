var myApp;
 myApp = myApp || (function () {
     var pleaseWaitDiv = $('<div class="modal show" id="pleaseWaitDialog" data-backdrop="static" data-keyboard="false"><div class="modal-body"><font color="#FFFFFF"><center><h1>Please wait...</h1></center></font></div></div>');
     return {
         showPleaseWait: function() {
             pleaseWaitDiv.modal();
         },
         hidePleaseWait: function () {
             pleaseWaitDiv.modal('hide');
         },
 
     };
 })();
 function btn_go_onclick(){
		var flag = true;
	 	var empId = document.getElementById("empId").value;
	 	
	 	if(empId==""){
	 		document.getElementById("invalidId").style.color = "red";
		    document.getElementById("invalidId").style.display="block";
		    document.getElementById("invalidId").scrollIntoView();
		    document.getElementById("invalidId").innerHTML = "Please enter correct Employee Id";
		    
			flag =  false;
			return flag;
	 	}
	 	else{
	 		var length = parseInt(empId);
	 		if(length<0||length>65535){
	 			document.getElementById("invalidId").style.color = "red";
			    document.getElementById("invalidId").style.display="block";
			    document.getElementById("invalidId").scrollIntoView();
			    document.getElementById("invalidId").innerHTML = "Please enter employee Id between 0 and 65535";
			    
				flag =  false;
				return flag;
	 		}
	 	}
	    myApp.showPleaseWait();
		document.forms[0].action = 'getDetail.apr';
		document.forms[0].submit();
	
}
 
 