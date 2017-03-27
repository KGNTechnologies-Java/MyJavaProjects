// JavaScript Document
$(document).ready(function(){

   loginObj.loginBtnFn();
   
   $('#login_btnsubmit').click(function(){
		validateForm("submitForm");   
	});
   
    
   
})

var loginObj = {
	loginBtnFn : function(){
	
	//$("#serMemtb").attr("placeholder", "Type a Location").val("").focus().blur();
	
		$("form[name='submitForm']").submit(function(){		
		
			
			var userVal = $.trim($("#userIdtxt").val());
			var validationres =	validateForm();
		
			if(validationres == true) {
				
				var userLoginData = JSON.stringify({
					 "email" : $.trim($('#userIdtxt').val()),
					 "password": $.trim($('#pwdtxt').val())					
			});
		//	userLogin(userLoginData);
				
				/*	if(userVal == "exon@sap.com")
					 {
						window.location  ="adminCreateSpotDeal.html";
						return false;
					 }
					 else if(userVal == "bp@sap.com")
					 {
						 window.location.href  ="viewSpotDeal.html";
						 return false;
						 
					 }
					  else if(userVal == "shell@sap.com")
					 {
						 window.location="viewSpotDeal.html";
						 return false;
						 
					 }
					 else{
					return false;
					}*/
			}
			else { return false; }
		
		});
	}

}

function validateForm(){

	var nameReg = /^[A-Za-z]+$/;
	var numberReg =  /^[0-9]+$/;
	var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
	
	var email = $('#userIdtxt').val();
  var password = $('#pwdtxt').val();
	//  var message = $('#messageInput').val();
	
	var inputVal = new Array(email, password);
	
	var flag = true;
	
	$('.errorMessage').hide();
	
		if( inputVal[0] == "" || !emailReg.test(email) ){
		
		$('#userIdtxt').after('<div class="errorMessage paddingErrorTop"> Please enter a valid email address </div>');
		return false;
		} 
		if (inputVal[1] == "" ) {
			$('#pwdtxt').after('<div id="" class="errorMessage paddingErrorTop"> Password is incorrect</div>');
			return false;
		}
		
		
		return flag;
       
} 


function userLogin(userLoginData){
	 alert("userLoginData ==> "+userLoginData);
	
	var userId = $('#userIdtxt').val();
	var pwd = $('#pwdtxt').val();
	
	$.ajax({
		 type : 'POST',		
		 url : 'https://restapisc5251932trial.hanatrial.ondemand.com/NetworkApplications/loginUser',
	//	 url : 'https://networkapplications.cfapps.sap.hana.ondemand.com/loginUser',	
		 data: userLoginData,
	        contentType: "application/json; charset=utf-8",
	        dataType: "json",
		success : function(data) {			
			if(data.length>0){
				$.each(data, function( index, value ) {
					alert(value.userid);
					alert(value.password);
					alert(value.role);
					
				});
				
			}else{
				
			} 
			
		},
		error : function(e) {
		//	alert("An error has occured");
		}
	})
	
}




 

