<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>e-Meal Web App</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/css.css" />
	</head>
	<body>
		<div class="mediumText">Management Formulary ! <img id="dssIcon" src="${pageContext.request.contextPath}/resources/img/dss.png" title="dssIcon" /></div>
		<div class=searchField>
			<p>Search for all Orders:</p>
			<a href="managementFormQueryAllResult" title="query all Orders">Query all orders</a>
		</div>
		<div>
			<form action="managementFormQueryOrderIdResult" method="get">
				<p>Search for specific Order:</p>
				<label for="orderId">OrderId:</label>
				<input type="text" name="orderId" id="orderId" placeholder="Type the Id for the Order"/>
				<input type="submit" value="OK" />
			</form>
		</div>
		<div>
			<form action="managementFormQuerySSNResult" method="get">
				<p>Search for Orders for a specific Client SSN:</p>
				<label for="SSN">SSN:</label>
				<input type="text" name="SSN" id="SSN" placeholder="Type the Client SSN"/>
				<input type="submit" value="OK" />
			</form>
		</div>
		<div>
			<form action="managementFormDeleteOrderResult" method="get">
				<p>Delete Order for a specific Id:</p>
				<label for="orderId">OrderId:</label>
				<input type="text" name="orderId" id="orderId" placeholder="Type the Order Id"/>
				<input type="submit" value="OK" />
			</form>
		</div>
	</body>
</html>
