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
		<div class="mediumText">Querying Orders for Client SSN = ${SSN} :</div> 
		<c:if test="${not empty orderList}">
			<c:forEach var="order" items="${orderList}">
        		<div class="listResult">
        			<p>orderId: ${order.id} ${order} ${order.dateTime}</p>
       			</div>
  			</c:forEach>
		</c:if>
		<c:if test="${empty orderList}">
    		<div class="smallText">No Results !</div>
		</c:if>
	</body>
</html>
