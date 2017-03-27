<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<spring:url value="/resources/js/jquery-1.8.0.min.js" var="minJs" />
<spring:url value="/resources/css/file.css" var="fileCss" />
<spring:url value="/resources/js/createSpotdeal.js"	var="createSpotDealJs" />
<spring:url value="/resources/js/viewSpotDeal.js" var="viewspotdealsJs" />
<spring:url value="/resources/js/login.js" var="loginJs" />

<link href="${fileCss}" rel="stylesheet" />
<script src="${minJs}"></script>
<script src="${createSpotDealJs}"></script>
<script src="${viewspotdealsJs}"></script>
<%-- <script src="${loginJs}"></script> --%>

<script type="text/javascript">
	$(document).ready(function() {
		$('#conversionBtn').click(function(){
			
			var transactionQty = $.trim($("#tqty").val());
			var transactionUnit =$.trim($("#bblv").val());
		//	alert(transactionQty);
			getConversion(transactionQty,transactionUnit);
		});
	});
	
	
	
	function getConversion(transactionQty,transactionUnit){	
		
		//	alert("kgn"+transactionQty);
			$.ajax({
				type : 'GET',
				url :'https://networkapplications.cfapps.sap.hana.ondemand.com/getConversion?transactionQty='+transactionQty+'&transactionUnit='+transactionUnit,
				dataType:"json",
				success : function(data) {				
					if(data.length>0){
						var json_obj = JSON.stringify(data);
					//	alert("Conversion Data ==> "+json_obj);
						console.log(JSON.stringify(data)); 
						$("#convshow").replaceWith('<textarea rows="5" cols="100"   style="background-color:black;color:yellow" name="conversion" id="convshow">'+json_obj+'</textarea>');
						}				
				},
				error : function(e) {
					//alert("An error has occured");
				}
			});
		
			}
</script>
</head>
<body>	
		<br>
		<div class="buttonDiv">
			<!-- <input type="submit" class="aigbutton btnCountries"	value="CreateSpotDeal" onclick="createSpotDeals()"></input><p>create spotdeal - admin user can create a spotdeal</p> <br/><br/>
			<a href="/NetworkApplications/getAllSpotDeals">ViewSpotDeal</a>
			<input type="submit" class="aigbutton btnCountries" value="ViewSpotDeal" onclick="adminViewSpotdeals()"></input> <p>view spotdeal - admin can able to see all the bidded information </p> <br/><br/>
			<input type="submit" class="aigbutton btnCountries"	value="ConfirmRequest" onclick="confirmRequest()"></input> <p>selected user can get email notification, after that once user can click on accept, that spotdeal document information should be updated into Bidspotdeal table of particular user</p><br/><br/>
			<input type="submit" class="aigbutton btnCountries"	value="ViewUserSpotDeal" onclick="userViewSpotdeals()"></input> <p>user can able to see all the accepted spotdeal information</p> <br/><br/>
			<input type="submit" class="aigbutton btnCountries"	value="GetBidSpotDeal" onclick="getBidSpotdeal()"></input> <p>get spotdeal detaials on clicking of a documentno of particular user</p><br/><br/>
			<input type="submit" class="aigbutton btnCountries"	value="Bid & Confirm SpotDeal" onclick="bidConfirmSpotdeal()"></input><p>user can bid the spotdeal and confirm the bid</p> <br/><br/>			
			<input type="submit" class="aigbutton btnCountries"	value="Sync S4 Hana Data" onclick="syncData()"></input><p>Sync Data from S4 Hana</p> <br/><br/>			
			<input type="submit" class="aigbutton btnCountries"	value="Get Sync Data" onclick="getSyncData()"></input><p>Get Sync Data from CF</p> <br/><br/>	
		 -->	
		
  <label class="width40 labelCust">Material Number</label> <input type="text" id="matno" width="40%"  name="matno"><br/><br/>
  <label class="width40 labelCust">Quantity</label>  <input type="text" id="tqty" width="40%"  name="tqty"><br/><br/>
  <label class="width40 labelCust">Unit Of Measure </label> <input type="text" id="bblv" width="40%" value ="BBL" name="bbl"><br/><br/><br/>
  <input type="submit" id="conversionBtn" class="aigbutton btnCountries"	value="Conversion" ></input><p>Get Conversion Data</p> <br/><br/>	
  <h6 style="color:blue">Conversion Data</h6>
	<textarea rows="0" cols="100" name="conversion" id="convshow"></textarea>	

			
			<!-- <a href="/NetworkApplications/getAllSpotDeals">ViewSpotDeal</a> -->
		</div>
		
	<div><table class='default' id='conversionTable' cellpadding='0' cellspacing='0' border='0' width='100%'></table></div>

	


</body>
</html>