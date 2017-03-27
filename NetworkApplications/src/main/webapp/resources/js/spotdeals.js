function ConvertFormToJSON(form){
			var array = jQuery(form).serializeArray();
			var json = JSON.stringify({
					 "materialNo" : $("#material-number").val(),
					 "quantity": $("#quantity").val(),
					 "unitOfMeasure": $("#unitofmeasure").val(),
					 "priceUnit": $("#priceunit").val(),
					 "plant": $("#plant").val(), 
					 "stockLocation": $("#stocklocation").val(),
					 "bpName": $("#bpname").val(),
					 "endDate": $("#enddate").val(),
					 "documentNo":$("#getDocNum").val()
					
			});
			
			/*jQuery.each(array, function() {
				json[this.name] = this.value || '';
			});*/
			
			return json;
		}
		
		jQuery(document).on('ready', function() {			
			jQuery('form#add-new-task').bind('submit', function(event){/*
				event.preventDefault();				
								
				random Number
				var chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz";
				var string_length = 8;
				var randomstring = '';
				for (var i=0; i<string_length; i++) {
					var rnum = Math.floor(Math.random() * chars.length);
					randomstring += chars.substring(rnum,rnum+1);
				}
				document.pocappform.randomfield.value = randomstring;
				
				var form = this;
				var saveSpotDeal = ConvertFormToJSON(form);				
				alert("saveSpotDeal==>"+saveSpotDeal);
				$.ajax({
					type : 'POST',			
					 url : 'https://restapisc5251932trial.hanatrial.ondemand.com/NetworkApplications/saveDeal',
				//	 url : 'https://networkapplications.cfapps.sap.hana.ondemand.com/saveDeal',
					//url : 'http://localhost:8080/SpringMVCRestWithHDB/saveCompany',
					data: saveSpotDeal,
			        contentType: "application/json; charset=utf-8",
			        dataType: "json",
					success : function(resp) { 
						alert("resp"+resp);
					//	getAllSpotDeals();
							
					},
					error : function(e) {
						alert("An error has occured");
					},
				});
				

				return true;
			*/});
					
			
		});
		
		
		
		function getAllSpotDeals(){

			$.ajax({
				type : 'GET',
			url : 'https://restapisc5251932trial.hanatrial.ondemand.com/NetworkApplications/getAllSpotDeals',
			//	url :'https://networkapplications.cfapps.sap.hana.ondemand.com/getAllSpotDeals',
				dataType:"json", 
			success : function(data) { 
					
				$("#spotvalues").replaceWith("<table id='spotvalues'></table>");
				//alert("data ==> "+data);
				
				var hrow = $("<tr><th>Material No</th>" +
                		"<th>Quantity</th>" +
                		"<th>Unit of Measure</th>" +
                		"<th>Price Unit</th>" +
                		"<th>Plant</th>" +
                		"<th>Stock Location</th>" +
                		"<th>BP Name</th>" +
                		"<th>End Date</th>" +
                		"<th>Document No</th>" +
                		"</tr>");
				$("#spotvalues").append(hrow);
				
				if(data.length>0){
					$.each(data, function( index, value ) {
	                    var row = $("<tr><td>" + value.materialNo + "</td>" +
	                    		"<td>" + value.quantity + "</td>" +
	                    		"<td>" + value.unitOfMeasure + "</td>" +
	                    		"<td>" + value.priceUnit + "</td>" +
	                    		"<td>" + value.plant + "</td>" +
	                    		"<td>" + value.stockLocation + "</td>" +
	                    		"<td>" + value.bpName + "</td>" +
	                    		"<td>" + value.endDate + "</td>" +
	                    		"<td>" + value.documentNo + "</td>" +
	                    		"</tr>");
	                    $("#spotvalues").append(row);
	                 });
				}else{
					var row = $("<tr><td>No data to show.... Thank you..  :)</td></tr>"); 
					$("#spotvalues").append(row);
				}
                		
               
                /*	var vlength=data.length;
                	alert("vlength===>"+vlength);
                	if(vlength>0){
                		
                		for(var i=0; i<data.length; i++){                			
                		
                				var row= $("<tr><td>" + data[i].materialNo+ "</td>"+
                            		"<td>" + data[i].quantity + "</td>" +
                            		"<td>" + data[i].unitOfMeasure + "</td>" +
                            		"<td>" + data[i].priceUnit + "</td>" +
                            		"<td>" + data[i].plant + "</td>" +
                            		"<td>" + data[i].stockLocation + "</td>" +
                            		"<td>" + data[i].bpName + "</td>" +
                            		"<td>" + data[i].endDate + "</td>" +
                            		"<td>" + data[i].documentNo + "</td>" +
                					"</tr>");
                				$("#spotvalues").append(row);
                			                			
                		}
                	}  */
               
                
				},
				error : function(e) {
					alert("An error has occured");
				},
			});
		}
		
		

	