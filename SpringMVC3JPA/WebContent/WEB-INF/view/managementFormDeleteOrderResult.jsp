<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
		<div class="mediumText">Deleting Order for a specific Id = "${orderId}":</div> 
       	<div class="smallText">
	       	<c:choose>
	       		<c:when test="${not empty deletingOrder}">
	       			<p>orderId: ${orderId} ${deletingOrder} ${deletingOrder.dateTime}</p>
	       			<c:if test="${deleted}">
	       				<p>Order found and deleted !</p>
	       			</c:if>
	       			<c:if test="${empty deletingOrder}">
	       				<p>Order found and NOT deleted !</p>
	       			</c:if>
	       		</c:when>
	       		<c:otherwise>
	       			<p>Order NOT found ! And NOT deleted !</p>
	       		</c:otherwise>
	       	</c:choose>
       	</div>
	</body>
</html>
