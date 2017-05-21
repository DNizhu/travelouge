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
 
function formatDate(input) {
  var datePart = input.match(/\d+/g),
  year = datePart[2], 
  month = datePart[1], day = datePart[0];

  return month+'/'+day+'/'+year;
}
function validateSubmitAppraisal(){
	
	var fromMonth = document.getElementById("fromMonth").value;
	var fromYear = document.getElementById("fromYear").value;
	var toMonth = document.getElementById("toMonth").value;
	var toYear = document.getElementById("toYear").value;
	var flag = true;
	
	var q = new Date();
	var mq = q.getMonth();
	var dq = q.getDate();
	var yq = q.getFullYear();
	mq = mq+1;
	var date = new Date(yq,mq,dq);

	r = new Date(formatDate(document.getElementById("fromDate").value));
	
	mf = r.getMonth();
	df = r.getDate();
	yf = r.getFullYear();
	
	mf = mf+1;
	var fromDate = new Date(yf,mf,df);
	
	r = new Date(formatDate(document.getElementById("toDate").value));
	mt = r.getMonth();
	dt = r.getDate();
	yt = r.getFullYear();
	mt = mt+1;
	var toDate = new Date(yt,mt,dt);
	
	
	r = new Date(formatDate(document.getElementById("selfReviewDate").value));
	m = r.getMonth();
	d = r.getDate();
	y = r.getFullYear();
	m = m+1;
	var selfReviewDate = new Date(y,m,d);
	
	r = new Date(formatDate(document.getElementById("managerReviewDate").value));
	m = r.getMonth();
	d = r.getDate();
	y = r.getFullYear();
	m = m+1;
	var managerReviewDate = new Date(y,m,d);
	
	r = new Date(formatDate(document.getElementById("additionalReviewDate").value));
	m = r.getMonth();
	d = r.getDate();
	y = r.getFullYear();
	m = m+1;
	var additionalReviewDate = new Date(y,m,d);
	
	r = new Date(formatDate(document.getElementById("secondLevelReviewDate").value));
	m = r.getMonth();
	d = r.getDate();
	y = r.getFullYear();
	m = m+1;
	var secondLevelReviewDate = new Date(y,m,d);
	
	/*r = new Date(formatDate(document.getElementById("ghReviewDate").value));
	m = r.getMonth();
	d = r.getDate();
	y = r.getFullYear();
	m = m+1;
	var ghReviewDate = new Date(y,m,d);
	
	r = new Date(formatDate(document.getElementById("hrCommentsDate").value));
	m = r.getMonth();
	d = r.getDate();
	y = r.getFullYear();
	m = m+1;
	var hrCommentsDate = new Date(y,m,d);*/
	
	r = new Date(formatDate(document.getElementById("managementCommentsDate").value));
	m = r.getMonth();
	d = r.getDate();
	y = r.getFullYear();
	m = m+1;
	var managementCommentsDate = new Date(y,m,d);
    
	if(toYear<yq){
		document.getElementById("invalidDate").style.color = "red";
	    document.getElementById("invalidDate").style.display="block";
	    document.getElementById("invalidDate").scrollIntoView();
	    document.getElementById("invalidDate").innerHTML = "Invalid appraisal end";
	    
		flag =  false;
	}
	else if(toMonth<mq&&toYear==yq){
		document.getElementById("invalidDate").style.color = "red";
	    document.getElementById("invalidDate").style.display="block";
	    document.getElementById("invalidDate").scrollIntoView();
	    document.getElementById("invalidDate").innerHTML = "Invalid appraisal end";
	    
		flag =  false;
	}
	
	else if(fromYear>toYear){
		document.getElementById("invalidDate").style.color = "red";
	    document.getElementById("invalidDate").style.display="block";
	    document.getElementById("invalidDate").scrollIntoView();
	    document.getElementById("invalidDate").innerHTML = "Invalid duration of appraisal cycle";
	    
		flag =  false;
	}
	else if(fromMonth>toMonth&&fromYear==toYear){
		document.getElementById("invalidDate").style.color = "red";
	    document.getElementById("invalidDate").style.display="block";
	    document.getElementById("invalidDate").scrollIntoView();
	    document.getElementById("invalidDate").innerHTML = "Invalid duration of appraisal cycle";
	    
		flag =  false;
	}
	
	/* Added*/
	else if(yf<fromYear){
		document.getElementById("invalidDate").style.color = "red";
	    document.getElementById("invalidDate").style.display="block";
	    document.getElementById("invalidDate").scrollIntoView();
	    document.getElementById("invalidDate").innerHTML = "From date should be in between apraisal cycle";
	    
		flag =  false;	
	}
	else if(mf<fromMonth&&yf==fromYear){
		document.getElementById("invalidDate").style.color = "red";
	    document.getElementById("invalidDate").style.display="block";
	    document.getElementById("invalidDate").scrollIntoView();
	    document.getElementById("invalidDate").innerHTML = "From date should be in between apraisal cycle";
		flag =  false;
	}

	
	
	
	else if(date>fromDate)
	{   
		document.getElementById("invalidDate").style.color = "red";
	    document.getElementById("invalidDate").style.display="block";
	    document.getElementById("invalidDate").scrollIntoView();
	    document.getElementById("invalidDate").innerHTML = "Start date cannot be less than current date";
		flag = false;
	}
	else if(date>toDate){
		document.getElementById("invalidDate").style.color = "red";
	    document.getElementById("invalidDate").style.display="block";
	    document.getElementById("invalidDate").scrollIntoView();
	    document.getElementById("invalidDate").innerHTML = "End date cannot be less than current date";
		flag =  false;
	}
	else if(fromDate>toDate){
		document.getElementById("invalidDate").style.color = "red";
	    document.getElementById("invalidDate").style.display="block";
	    document.getElementById("invalidDate").scrollIntoView();
	    document.getElementById("invalidDate").innerHTML = "Start date cannot be greater than end date";
		flag =  false;
	}
	else if(managementCommentsDate>toDate){
		document.getElementById("invalidDate").style.color = "red";
	    document.getElementById("invalidDate").style.display="block";
	    document.getElementById("invalidDate").scrollIntoView();
	    document.getElementById("invalidDate").innerHTML = " Managment comments date cannot be greater than end date";
		flag =  false;
	}
	else if(managementCommentsDate<fromDate){
		document.getElementById("invalidDate").style.color = "red";
	    document.getElementById("invalidDate").style.display="block";
	    document.getElementById("invalidDate").scrollIntoView();
	    document.getElementById("invalidDate").innerHTML = "Management comments date cannot be less than start date";
		flag =  false;
	}
	/*else if(hrCommentsDate>managementCommentsDate){
		document.getElementById("invalidDate").style.color = "red";
	    document.getElementById("invalidDate").style.display="block";
	    document.getElementById("invalidDate").scrollIntoView();
	    document.getElementById("invalidDate").innerHTML = "HR comments date cannot be greater than managment comments date";
		flag =  false;
		
	}
	else if(hrCommentsDate<fromDate){
		document.getElementById("invalidDate").style.color = "red";
	    document.getElementById("invalidDate").style.display="block";
	    document.getElementById("invalidDate").scrollIntoView();
	    document.getElementById("invalidDate").innerHTML = "HR comments date cannot be less than start date";
		flag =  false;
	}
	else if(hrCommentsDate>toDate){
		document.getElementById("invalidDate").style.color = "red";
	    document.getElementById("invalidDate").style.display="block";
	    document.getElementById("invalidDate").scrollIntoView();
	    document.getElementById("invalidDate").innerHTML = "HR comments date cannot be greater than end date";
		flag =  false;
	
	}
	else if(ghReviewDate>hrCommentsDate){
		document.getElementById("invalidDate").style.color = "red";
	    document.getElementById("invalidDate").style.display="block";
	    document.getElementById("invalidDate").scrollIntoView();
	    document.getElementById("invalidDate").innerHTML = "GH review date cannot be greater than hr comment date";
		flag =  false;
		
	}
	else if(ghReviewDate<fromDate){
		document.getElementById("invalidDate").style.color = "red";
	    document.getElementById("invalidDate").style.display="block";
	    document.getElementById("invalidDate").scrollIntoView();
	    document.getElementById("invalidDate").innerHTML = "GH review date cannot be less than start date";
		flag =  false;
	}
	else if(ghReviewDate>toDate){
		document.getElementById("invalidDate").style.color = "red";
	    document.getElementById("invalidDate").style.display="block";
	    document.getElementById("invalidDate").scrollIntoView();
	    document.getElementById("invalidDate").innerHTML = "GH review date cannot be greater than end date";
		flag =  false;
	
	}*/
	else if(secondLevelReviewDate>managementCommentsDate){
		document.getElementById("invalidDate").style.color = "red";
	    document.getElementById("invalidDate").style.display="block";
	    document.getElementById("invalidDate").scrollIntoView();
	    document.getElementById("invalidDate").innerHTML = "Second level review date cannot be greater than Management comments date";
		flag =  false;
		
	}
	else if(secondLevelReviewDate<fromDate){
		document.getElementById("invalidDate").style.color = "red";
	    document.getElementById("invalidDate").style.display="block";
	    document.getElementById("invalidDate").scrollIntoView();
	    document.getElementById("invalidDate").innerHTML = "Second level review date cannot be less than start date";
		flag =  false;
	}
	else if(secondLevelReviewDate>toDate){
		document.getElementById("invalidDate").style.color = "red";
	    document.getElementById("invalidDate").style.display="block";
	    document.getElementById("invalidDate").scrollIntoView();
	    document.getElementById("invalidDate").innerHTML = "Second level review date cannot be greater than end date";
		flag =  false;
	
	}
	else if(additionalReviewDate>secondLevelReviewDate){
		document.getElementById("invalidDate").style.color = "red";
	    document.getElementById("invalidDate").style.display="block";
	    document.getElementById("invalidDate").scrollIntoView();
	    document.getElementById("invalidDate").innerHTML = "Additional review date cannot be greater than second level review date";
		flag =  false;
		
	}
	else if(additionalReviewDate<fromDate){
		document.getElementById("invalidDate").style.color = "red";
	    document.getElementById("invalidDate").style.display="block";
	    document.getElementById("invalidDate").scrollIntoView();
	    document.getElementById("invalidDate").innerHTML = "Additional review date cannot be less than start date";
		flag =  false;
	}
	else if(additionalReviewDate>toDate){
		document.getElementById("invalidDate").style.color = "red";
	    document.getElementById("invalidDate").style.display="block";
	    document.getElementById("invalidDate").scrollIntoView();
	    document.getElementById("invalidDate").innerHTML = "Additional review date cannot be greater than end date";
		flag =  false;
	
	}
	else if(managerReviewDate>additionalReviewDate){
		document.getElementById("invalidDate").style.color = "red";
	    document.getElementById("invalidDate").style.display="block";
	    document.getElementById("invalidDate").scrollIntoView();
	    document.getElementById("invalidDate").innerHTML = "Manager review date cannot be greater than Additional review date";
		flag =  false;
		
	}
	else if(managerReviewDate<fromDate){
		document.getElementById("invalidDate").style.color = "red";
	    document.getElementById("invalidDate").style.display="block";
	    document.getElementById("invalidDate").scrollIntoView();
	    document.getElementById("invalidDate").innerHTML = "Manager review date cannot be less than start date";
		flag =  false;
	}
	else if(managerReviewDate>toDate){
		document.getElementById("invalidDate").style.color = "red";
	    document.getElementById("invalidDate").style.display="block";
	    document.getElementById("invalidDate").scrollIntoView();
	    document.getElementById("invalidDate").innerHTML = "Manager review date cannot be greater than end date";
		flag =  false;
	
	}
	else if(selfReviewDate>managerReviewDate){
		document.getElementById("invalidDate").style.color = "red";
	    document.getElementById("invalidDate").style.display="block";
	    document.getElementById("invalidDate").scrollIntoView();
	    document.getElementById("invalidDate").innerHTML = "Self review date cannot be greater than Manager review date";
		flag =  false;
		
	}
	else if(selfReviewDate<fromDate){
		document.getElementById("invalidDate").style.color = "red";
	    document.getElementById("invalidDate").style.display="block";
	    document.getElementById("invalidDate").scrollIntoView();
	    document.getElementById("invalidDate").innerHTML = "Self review date cannot be less than start date";
		flag =  false;
	}
	else if(selfReviewDate>toDate){
		document.getElementById("invalidDate").style.color = "red";
	    document.getElementById("invalidDate").style.display="block";
	    document.getElementById("invalidDate").scrollIntoView();
	    document.getElementById("invalidDate").innerHTML = "Self review date cannot be greater than end date";
		flag =  false;
	
	}
	if(flag==true)
		myApp.showPleaseWait();
	return flag;
}
