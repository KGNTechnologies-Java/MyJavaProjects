sap.ui.define([
	"sap/ui/core/mvc/Controller"
	
], function(Controller) {
	"use strict";

	return Controller.extend("testProjectxsjs.controller.View1", {

		databutton: function() {
		//	var oModel = new sap.ui.model.odata.ODataModel("/sap/opu/odata/sap/ZMARA_EXPOSE_SRV/ZtablemaraSet?$format=json", true);
		//	alert(oModel);
	
		var jsonDataInput;
			var aUrl = '/sap/opu/odata/sap/ZMARA_EXPOSE_SRV/ZtablemaraSet?$format=json';
			var oJSON;
			jQuery.ajax({
				url: aUrl,
				method: 'GET',
				async: false,
				dataType: 'json',
				success: function(data) {
					alert('Successful in json call '+data.d.results[0].Matnr);
					jsonDataInput = data.d;
					//oJSON = JSON.parse(response.body);
				},
				error: function() {
					alert('Error in json call ');
				}
			});

			/*var oMeta = oModel.getServiceMetadata();
         alert(oMeta);*/
			/*$.post("https://networkdbc5251932trial.hanatrial.ondemand.com/sfourhana/MyFirstSourceFile.xsjs", 
			                  { JSON_DATA: {"Name": "Test"} } 
			)
			.done(function(data){
			     alert(data);
			 });*/

		/*	var jsonData = {
				"inputData": [{
					"MATNR": "1030",
					"MBRSH": "11",
					"MATKL": "223",
					"MTART": "324",
					"AENAM": "Test"
				}, {
					"MATNR": "1031",
					"MBRSH": "11",
					"MATKL": "223",
					"MTART": "324",
					"AENAM": "Test"
				}, {
					"MATNR": "1042",
					"MBRSH": "11",
					"MATKL": "223",
					"MTART": "324",
					"AENAM": "Test"
				}]
			};*/
			var jsonLength = jsonDataInput.results.length;
			alert(jsonLength);

				$.ajax({
					type: 'POST',
					url: "https://networkdbc5251932trial.hanatrial.ondemand.com/sfourhana/MyFirstSourceFile.xsjs?jsonDataLength="+jsonLength,
					callback: 'false',
					data:jsonDataInput,
					contentType: 'application/json', 
					dataType: 'jsonp',
					headers: {
						"Access-Control-Allow-Origin": "*"
					},
					crossDomain: true,
					success: function(result) {
						console.log(result);
					},
					error: function() {
						console.log('Failed!');
					}
				});
		}

	});
});