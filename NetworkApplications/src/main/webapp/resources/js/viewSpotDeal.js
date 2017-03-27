/*Admin View Spotdeal*/
		
	function adminViewSpotdeals(){		
		$.ajax({
			type : 'GET',
	//		url : 'https://ldcieop.wdf.sap.corp:44311/sap/opu/odata/sap/TSW_REGIONAL_INVENTORY_SRV_01/?$format=json&sap-client=005&sap-language=EN',
		//	url : 'https://restapisc5251932trial.hanatrial.ondemand.com/NetworkApplications/getAllSpotDeals',
			url :'https://networkapplications.cfapps.sap.hana.ondemand.com/getAllSpotDeals',		
			dataType:"json", 
		//	async: false,
			success : function(data) {
				alert("View SpotDeal==>"+JSON.stringify(data));
			},
			error : function(e) {
				alert("An error has occured view spotdeal");
			}
		});
	}
	
	
/*User View SpotDeal */	
	
	
	function userViewSpotdeals(){
		var userId = "hp@sap.com";
		$.ajax({
			type : 'GET',
		//	url : 'https://restapisc5251932trial.hanatrial.ondemand.com/NetworkApplications/userViewSpotDeals?userId='+userId,
			url :'https://networkapplications.cfapps.sap.hana.ondemand.com/userViewSpotDeals?userId='+userId,
			dataType:"json", 
		//	async: false,
			success : function(data) {
				
				alert("User View SpotDeal ==> "+JSON.stringify(data));
				/* 
				
			$("#userviewspotdeal").replaceWith("<table class='default' id='userviewspotdeal' cellpadding='0' cellspacing='0' border='0' width='100%'></table>");
			//alert("data ==> "+data);
			
			var hrow = $("<thead><th data-sort='int' data-sort-default='asc' align='left' valign='top' width='15%'>Document Number <img class='sort_icon' src='resources/images/sortDefault.png' title='' alt='' /></th>" +
            		"<th data-sort='string' data-sort-default='asc' align='left' valign='top' width='15%'>Material Number <img class='sort_icon' src='resources/images/sortDefault.png' title='' alt='' /></th>" +
            		"<th data-sort='int' data-sort-default='asc' align='left' valign='top' width='10%'>Quantity <img class='sort_icon' src='resources/images/sortDefault.png' title='' alt='' /></th>" +    	
            		"<th data-sort='int' data-sort-default='asc' align='left' valign='top' width='10%'>UOM <img class='sort_icon' src='resources/images/sortDefault.png' title='' alt='' /></th>" +
                	"<th data-sort='string' data-sort-default='asc' align='left' valign='top' width='10%'>Price Unit<img class='sort_icon' src='resources/images/sortDefault.png' title='' alt='' /></th>" +
            		"<th data-sort='string' data-sort-default='asc' align='left' valign='top' width='10%'>Plant <img class='sort_icon' src='resources/images/sortDefault.png' title='' alt='' /></th>" +
            		"<th data-sort='int' data-sort-default='asc' align='left' valign='top' width='15%'>Stock Location<img class='sort_icon' src='resources/images/sortDefault.png' title='' alt='' /></th>" +
            		"<th data-sort='int' data-sort-default='asc' align='left' valign='top' width='15%'>BP Name<img class='sort_icon' src='resources/images/sortDefault.png' title='' alt='' /></th>" +
            		"<th data-sort='int' data-sort-default='asc' align='left' valign='top' width='15%'>End Date<img class='sort_icon' src='resources/images/sortDefault.png' title='' alt='' /></th>" +
            		"<th data-sort='int' data-sort-default='asc' align='left' valign='top' width='15%'>Status<img class='sort_icon' src='resources/images/sortDefault.png' title='' alt='' /></th>" +
            		"</tr><thead>");
			$("#userviewspotdeal").append(hrow);
			
			if(data.length>0){
				$.each(data, function( index, value ) {
                    var row = $("<tr  class='page'><td align='left' valign='middle' height='30'><a  id='bsd' documentNo='"+value.documentNo+"' userId='"+value.email+"'onClick=getBidSpd('"+value.documentNo+"','"+value.email+"')>" + value.documentNo + "</a></td>" +
                    		
					var row = $("<tr  class='page'><td align='left' valign='middle' height='30'><a  href='bidSpotDeals/"+value.documentNo+"/"+value.email+"'>" + value.documentNo + "</a></td>" +
                    	
					          
                    		"<td align='left' valign='middle'>" + value.materialNo + "</td>" +
                    		"<td align='left' valign='middle'>" + value.quantity + "</td>" +
                    		"<td align='left' valign='middle'>" + value.unitOfMeasure + "</td>" +
                    		"<td align='left' valign='middle'>" + value.priceUnit + "</td>" +
                    		"<td align='left' valign='middle'>" + value.plant + "</td>" +
                    		"<td align='left' valign='middle'>" + value.stockLocation + "</td>" +
                    		"<td align='left' valign='middle'>" + value.bpName + "</td>" +
                    		"<td align='left' valign='middle'>" + value.endDate + "</td>" +  
                    		"<td align='left' valign='middle'>" + value.status + "</td>" +  
                    		"</tr>");
                    $("#userviewspotdeal").append(row);
                 });
			}else{
				var row = $("<tr><td>No data to show.... Thank you..  :)</td></tr>"); 
				$("#userviewspotdeal").append(row);
			}
            		
                    
            
			*/},
			error : function(e) {
				alert("An error has occured");
			}
		});
	}
	

	/* get Bid Spot Deal based on documentNo */	
	
	function getBidSpotdeal(){
		var userId = "hp@sap.com";
		var documentNo = "DOC3JRS5TJ";
		
	//	alert("kgn"+userId);
		$.ajax({
			type : 'GET',
		//	url : 'https://restapisc5251932trial.hanatrial.ondemand.com/NetworkApplications/getBidSpotDeals?userId='+userId+'&documentNo='+documentNo,
			url :'https://networkapplications.cfapps.sap.hana.ondemand.com/getBidSpotDeals?userId='+userId+'&documentNo='+documentNo,
			dataType:"json", 
			success : function(data) {
				alert("Get BidSpotDeal based on selected documentno==>"+JSON.stringify(data));
									
			},
			error : function(e) {
				//alert("An error has occured");
			}
		});
	}
	
	
/* Bid And Confirm Spot Deal */	
	
	function bidConfirmSpotdeal(){
	
		var jsonData = JSON.stringify({
			 "documentNo" : "DOC3JRS5TJ",
			 "email": "hp@sap.com",
			 "unitOfMeasure": "Pound",
			 "biddedQuantity": "20",
			 "priceUnit": "EURO"
		});			
	
		var confirmBid = jsonData;
		alert("confirmBidSpotDeal==>"+confirmBid);
		$.ajax({
			 type: "POST",
             contentType: "application/json",	
		//	 url : 'https://restapisc5251932trial.hanatrial.ondemand.com/NetworkApplications/bidConfirmSpotDeal',
			 url : 'https://networkapplications.cfapps.sap.hana.ondemand.com/bidConfirmSpotDeal',
			data: confirmBid,	       
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
	
	function getBidSpd(document,userid){
	//	alert(document);
		getBidSpotdeal(userid,document,'false');		
		window.location="bidSpotDeals";
		return false;
	}
	
	
	function getBidSpotDealDoc(documentNo,userId){
		getBidSpotdeal(userId,documentNo,'true');
	}
	
	
	/*Get  data from  Hana Cloud Platform*/
	
	function syncData(){		
		$.ajax({
			type : 'GET',			
			url : 'https://restapisc5251932trial.hanatrial.ondemand.com/NetworkApplications/getSfourData',
		//	url :'https://networkapplications.cfapps.sap.hana.ondemand.com/getAllSpotDeals',		
			dataType:"json",		
			success : function(data) {
		//		alert("View SpotDeal==>"+data);
				saveSyncData(data);
			},
			error : function(e) {
				alert("An error has occured view spotdeal");
			}
		});
	}
	
	/*Save data to CF*/
	function saveSyncData(syncData){	
		var syncDataJson = JSON.stringify(syncData);		
		
	//	alert("save sync data ==> "+syncDataJson);	
		
				$.ajax({						
					 type: "POST",
		            contentType: "application/json",	
				//	 url : 'https://restapisc5251932trial.hanatrial.ondemand.com/NetworkApplications/saveSyncData',
					 url : 'https://networkapplications.cfapps.sap.hana.ondemand.com/saveSyncData',	
					data: syncDataJson,	       
					dataType: 'json',
		           timeout: 600000,
					success : function(resp) { 
						
							alert("success "+resp);
					},
					error : function(e) {
						alert("error sync save data");
					}
				});
			
	
	}
	
	
/*Get  data from CF*/
	
	function getSyncData(){		
		$.ajax({
			type : 'GET',			
		//	url : 'https://restapisc5251932trial.hanatrial.ondemand.com/NetworkApplications/getSyncData',
			url :'https://networkapplications.cfapps.sap.hana.ondemand.com/getSyncData',		
			dataType:"json",
			async: false,
			success : function(data) {
				alert("View SyncData==>"+JSON.stringify(data));				
			},
			error : function(e) {
				alert("An error has occured view sync data");
			}
		});
	}
	
	/* Get Conversion */
	

	