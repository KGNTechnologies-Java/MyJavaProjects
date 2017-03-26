
	function getAllCompany() {
		$.ajax({
			type : 'GET',			
		//	url : 'https://helloworldappp1942294513trial.hanatrial.ondemand.com/MyRestPrograms/rest/EmployeeService/employees',
		//	url : 'https://myrestprogramshcpcf.cfapps.us10.hana.ondemand.com/rest/EmployeeService/employees',
		//	url : 'https://jdbchdbp1942294513trial.hanatrial.ondemand.com/SpringMVCRestWithHDB/companies',
			url : 'http://localhost:8080/SpringMVCRestWithHDB/companies',
			//	url : 'http://services.odata.org/TripPinRESTierService/People',
			contentType: 'application/json',
			dataType : 'json',
			success : function(data) { 
				
				//$('#compdetails').append("data ==>" + data);
				
					var len = data.length;
					if(len > 0){
						
						var txt = "";
	                    for(var i=0;i<len;i++){
	                    //	if(data[i].companyId && data[i].companyName){
	                            txt += "<tr><td>"+data[i].companyId+"</td><td>"+data[i].companyName+"</td></tr>";
	                      //  }
	                    }
	                    if(txt != ""){
	                        $("#ctable").append(txt).removeClass("hidden");
	                    }
					}
				
			},
			error : function(e) {
				alert("An error has occured");
			},
		});
	}
	
	function saveCompany() {
		
		
		var saveComp =JSON.stringify({
				"companyId" : $("#cmpId").val(),
				"companyName" : $("#cmpName").val()
		});
		
		alert("JSON Data ==> "+saveComp);
		
		$.ajax({
			type : 'POST',			
			// url : 'https://jdbchdbp1942294513trial.hanatrial.ondemand.com/SpringMVCRestWithHDB/saveCompany',
			url : 'http://localhost:8080/SpringMVCRestWithHDB/saveCompany',
			data: saveComp,
	        contentType: "application/json; charset=utf-8",
	        dataType: "json",
			success : function(resp) { 
				
				/* empId = $(resp).find('empId').text(),
				 empName = $(resp).find('empName').text(),
				 profession = $(resp).find('profession').text();
				 $('#empdetails').append("Emp Id : " + empId);
				 $('#empdetails').append("Emp Name : " + empName);
				 $('#empdetails').append("Profession : " + profession); */
				$('#compdetails').append("save" + resp);
			},
			error : function(e) {
				alert("An error has occured");
			},
		});
	}
	
