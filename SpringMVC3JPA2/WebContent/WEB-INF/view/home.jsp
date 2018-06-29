<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>e-Meal Web App</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/css.css" />
	</head>
	<body>
		<header class="bigText"><p>Welcome to the<br>e-Meal Web App !!</p></header>
		<header class="mediumText"><p>Choose your taste !</p></header>
		<div id="meal"><img id="meal" src="${pageContext.request.contextPath}/resources/img/meal.png" title="meal" /></div>	
		<c:if test="${homeFormType eq 1}">
			<div id="formList">
				<div><a href="mealController/orderForm" title="go to the Sandwich Order Formulary"><img id="sandwichIcon" src="${pageContext.request.contextPath}/resources/img/sandwich.png" title="sandwichIcon" /> Go to the Sandwich Order Formulary !</a></div>
				<div><a href="mealController/underConstruction" title="go to the Pizza Order Formulary"><img id="pizzaIcon" src="${pageContext.request.contextPath}/resources/img/pizza.png" title="pizzaIcon" /> Go to the Pizza Order Formulary !</a></div>
				<div><a href="mealController/underConstruction" title="go to the Brownie Order Formulary"><img id="brownieIcon" src="${pageContext.request.contextPath}/resources/img/brownie.png" title="brownieIcon" /> Go to the Brownie Order Formulary !</a></div>
				<div><a href="mealController/managementForm" title="go to the Management Formulary"><img id="dssIcon" src="${pageContext.request.contextPath}/resources/img/dss.png" title="dssIcon" /> Go to the DSS Management Formulary !</a></div>
			</div>
		</c:if>
		<c:if test="${homeFormType eq 2}">
			<div id="formList">
				<div><a href="orderForm" title="go to the Sandwich Order Formulary"><img id="sandwichIcon" src="${pageContext.request.contextPath}/resources/img/sandwich.png" title="sandwichIcon" /> Go to the Sandwich Order Formulary !</a></div>
				<div><a href="underConstruction" title="go to the Pizza Order Formulary"><img id="pizzaIcon" src="${pageContext.request.contextPath}/resources/img/pizza.png" title="pizzaIcon" /> Go to the Pizza Order Formulary !</a></div>
				<div><a href="underConstruction" title="go to the Brownie Order Formulary"><img id="brownieIcon" src="${pageContext.request.contextPath}/resources/img/brownie.png" title="brownieIcon" /> Go to the Brownie Order Formulary !</a></div>
				<div><a href="managementForm" title="go to the Management Formulary"><img id="dssIcon" src="${pageContext.request.contextPath}/resources/img/dss.png" title="dssIcon" /> Go to the DSS Management Formulary !</a></div>
			</div>
		</c:if>
	</body>
</html>
