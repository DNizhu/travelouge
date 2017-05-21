  var myApp;
 myApp = myApp || (function () {
     var pleaseWaitDiv = $('<div class="modal show" id="pleaseWaitDialog" data-backdrop="static" data-keyboard="false" style = "background-color: rgba(0, 0, 0, 0.4)"><div class="modal-body"><font color="#FFFFFF"><center><h1>Please wait...</h1></center></font></div></div>');
     return {
         showPleaseWait: function() {
             pleaseWaitDiv.modal();
         },
         hidePleaseWait: function () {
             pleaseWaitDiv.modal('hide');
         } 
     };
 })();

$(document).ready(function() {
			 var table =  $('#tableID').DataTable({
                       responsive: true,
                       "orderCellsTop": true
               });
               
         $("#basicResetBtn").on("click",function(){
           $('#empName').prop('selectedIndex',0);
           table.clear().draw();
         
         });

         $("#basicSearchBtn").click( function() {
             myApp.showPleaseWait();
             $("#basicSearchForm").submit();
         });  
         
   
          $(".glyphicon-search").on("click", function() {
             $(this).next("input").focus();
         });
         
     
       
             	 
           
                 
}); 
         
      