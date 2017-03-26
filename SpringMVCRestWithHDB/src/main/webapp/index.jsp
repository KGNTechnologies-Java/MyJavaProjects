<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
	
	<link href="<c:url value="/resources/css/company.css" />" rel="stylesheet" />
    <script src="<c:url value="/resources/js/company.js" />"></script>
    
   
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

</head>
<body>
	<form id="form1" method="GET">
	
		<h6>Company Id :</h6> <input type="text" id="cmpId" name="cmpId"><br>
		<h6>Company Name :</h6> <input type="text" id="cmpName" name="cmpName"><br>
		
		<input type="button" Value="SUBMIT" onclick="getAllCompany();"><br/>
		
		<input type="button" Value="Save" onclick="saveCompany();">
		<div id="compdetails">
		<table id="ctable" class="hidden">
    	<tr>
       		 <th>Company Id</th>
       		 <th>Company Name</th>
    	</tr>
		</table>
		
		</div>
	</form>
</body>
</html>