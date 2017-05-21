$(document).ready( function() {
	$(".rich-text-area").summernote({
		height: 300,
		toolbar: [
	              ['style', ['bold', 'italic', 'underline', 'clear']],
	              ['para', ['ul', 'ol']],
	              ['fontsize', ['fontsize']], 
	              ['fontname', ['fontname']]  
	          ],
	          
	          
	   onKeydown: function(e) {
		    var num = $('.rich-text-area').code().replace(/(<([^>]+)>)/ig,"").length;
		    var key = e.keyCode;
		            allowed_keys = [8, 37, 38, 39, 40, 46]
            if($.inArray(key, allowed_keys) != -1)
                { 
            	return true
                }
            else if(e.target.innerHTML.length > 7800){
                e.preventDefault();
                e.stopPropagation()
              }
	    }
	});
	
	
	$(".rich-text-area-promotion").summernote({
		width:330,
		height: 150,
		toolbar: [
	              ['style', ['bold', 'italic', 'underline', 'clear']],
	              ['para', ['ul', 'ol']],
	              ['fontsize', ['fontsize']], 
	              ['fontname', ['fontname']]  
	          ],
	          
	          
	   onKeydown: function(e) {
		    var num = $('.rich-text-area-promotion').code().replace(/(<([^>]+)>)/ig,"").length;
		    var key = e.keyCode;
		            allowed_keys = [8, 37, 38, 39, 40, 46]
            if($.inArray(key, allowed_keys) != -1)
                { 
            	return true
                }
            else if(e.target.innerHTML.length > 7800){
                e.preventDefault();
                e.stopPropagation()
              }
	    }
	});
	
	
});

/*function updateModalDetails(ele){
	
	var empName = $(ele).attr("data-empName");
	var srRating = $(ele).attr("data-srRating");
	var srComm1 = $(ele).attr("data-srComm1");
	var srComm2 = $(ele).attr("data-srComm2");
	var manName = $(ele).attr("data-manName");
	var manRating = $(ele).attr("data-manRating");
	var manComm1 = $(ele).attr("data-manComm1");
	var manComm2 = $(ele).attr("data-manComm2");
	var trainingRequirements = $(ele).attr("data-trainingRequirements");
	
	
	
	
	var ar1Rating = $(ele).attr("data-ar1Rating");
	var ar1Comm1 = $(ele).attr("data-ar1Comm1");
	var ar1Comm2 = $(ele).attr("data-ar1Comm2");
	var ar2Rating = $(ele).attr("data-ar2Rating");
	var ar2Comm1 = $(ele).attr("data-ar2Comm1");
	var ar2Comm2 = $(ele).attr("data-ar2Comm2");
	
	var slName = $(ele).attr("data-slName");
	var slRating = $(ele).attr("data-slRating");
	var slComm = $(ele).attr("data-slComm");

	var hrName = $(ele).attr("data-hrName");
	var hrComm = $(ele).attr("data-hrComm");
	
	
	
	
	$("#empName").text(getValidValue(empName));
	$("#SR_Comnt1").text(getValidValue(srComm1));
	$("#SR_Comnt2").text(getValidValue(srComm2));
	$("#selfRating").text(getValidValue(srRating));
	
	$("#manName").text(getValidValue(manName));
	$("#MR_Comnt1").html(getValidValue(manComm1));
	$("#MR_Comnt2").html(getValidValue(manComm2));
	$("#manRating").text(getValidValue(manRating));
	$("#trainingRequirements").html(getValidValue(trainingRequirements));
	
	$("#ar2Comm1").html(getValidValue(ar2Comm1));
	$("#ar2Comm2").html(getValidValue(ar2Comm2));
	$("#ar2Rating").html(getValidValue(ar2Rating));
	
	$("#ar1Comm1").html(getValidValue(ar1Comm1));
	$("#ar1Comm2").html(getValidValue(ar1Comm2));
	$("#ar1Rating").html(getValidValue(ar1Rating));
	
	
	$("#hrName").text(getValidValue(hrName));
	$("#hrComm").html(getValidValue(hrComm));
	$("#slName").text(getValidValue(slName));
	$("#slRating").text(getValidValue(slRating));
	$("#slComm").html(getValidValue(slComm));
}*/

function getValidValue(value){
	
	if(value===undefined||value===null||value==="null"){
		value = "Not Available";
	}
	return value;
}
function disableSummerNote(id){
	$('#'+id).destroy();
	$('#'+id).prop('disabled', true);
	$("#"+id).summernote({
		height: 300,
		toolbar: []
	});
}

function disableSummerNotePromotion(id){
	$('#'+id).destroy();
	$('#'+id).prop('disabled', true);
	$("#"+id).summernote({
		width:330,
		height: 150,
		toolbar: []
	});
}