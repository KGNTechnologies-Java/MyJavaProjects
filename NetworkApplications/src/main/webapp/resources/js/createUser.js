// JavaScript Document
$(document).ready(function(){

   loginObj.loginBtnFn();
   
   $('#createuser_btnsubmit').click(function(){
		validateForm("tcuser");   
	});
   
    
   
})

var loginObj = {
	loginBtnFn : function(){
	
	//$("#serMemtb").attr("placeholder", "Type a Location").val("").focus().blur();
	
		$("form[name='tcuser']").submit(function(){		
		
			
			var userVal = $.trim($("#userIdtxt").val());
			var validationres =	validateForm();
		
			if(validationres == true) {
				
				var userData = JSON.stringify({
					 "email" : $.trim($('#userIdtxt').val()),
					 "password": $.trim($('#pwdtxt').val()),
					 "username": $.trim($('#usernm').val()),
					 "role":$.trim($('#role').val())
			});
				createUser(userData);				
				
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


function createUser(userData){
	alert("userData ==> "+userData);
	$.ajax({

		type : 'POST',			
		 url : 'https://restapisc5251932trial.hanatrial.ondemand.com/NetworkApplications/createUser',
	//	 url : 'https://networkapplications.cfapps.sap.hana.ondemand.com/createUser',
	
		data: userData,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
		success : function(data) {
		alert("data==>"+data);
		},
		error : function(e) {
			alert("An error has occured");
		}
	})
	
}



 

/**
 * 
 */