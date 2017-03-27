function createSpotDeals(){
	//	alert("save");						
	
		var jsonData = JSON.stringify({
			 "materialNo" : "SAP98492",
			 "quantity": "200",
			 "unitOfMeasure": "Gram",
			 "priceUnit": "INR",
			 "plant": "SAP", 
			 "stockLocation": "BNG",
			 "bpName": "Shell",
			 "endDate": "29/02/2017",
			 "userSpotDeal":[{"serialNo":"50","email":"shell@sap.com","status":"open"},{"serialNo":"51","email":"hp@sap.com","status":"open"}]
			
	});			
	
		var saveSpotDeal = jsonData;
		//alert("saveSpotDeal==>"+saveSpotDeal);
		$.ajax({
			 type: "POST",
             contentType: "application/json",	
		//	 url : 'https://restapisc5251932trial.hanatrial.ondemand.com/NetworkApplications/createSpotdeal',
        	 url : 'https://networkapplications.cfapps.sap.hana.ondemand.com/createSpotdeal',			
			data: saveSpotDeal,	       
			dataType: 'json',
            timeout: 600000,
			success : function(resp) { 
				
					alert("success "+resp);
			},
			error : function(e) {
				
			}
		});
		
		return false;
	
	}


function confirmRequest(){
	//	alert("save");						
	
		var jsonData = JSON.stringify({
			 "documentNo" : "DOC3JRS5TJ",
			 "email": "hp@sap.com"			
		});			
	
		var confirmRequest = jsonData;
//		alert("confirmRequest==>"+confirmRequest);
		$.ajax({
			 type: "POST",
             contentType: "application/json",	
		//	 url : 'https://restapisc5251932trial.hanatrial.ondemand.com/NetworkApplications/confirmRequest',
			 url : 'https://networkapplications.cfapps.sap.hana.ondemand.com/confirmRequest',
			//url : 'http://localhost:8080/SpringMVCRestWithHDB/saveCompany',
			data: confirmRequest,	       
			dataType: 'json',
            timeout: 600000,
			success : function(resp) { 
				
					alert("success "+resp);
			},
			error : function(e) {
				
			}
		});
		
		return false;
	
	}
