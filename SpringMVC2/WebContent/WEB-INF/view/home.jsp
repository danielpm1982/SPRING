<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Spring MVC Web</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/css.css" />
	</head>
	<body>
		<div class="bigText"><p>Welcome to the<br>Age Calculator Web App !!</p></div>
		<div><img id="springIcon" src="${pageContext.request.contextPath}/resources/img/spring.png" title="springIcon" /></div>
		<div><a href="personController/personForm" title="go to the person formulary"><img id="formIcon" src="${pageContext.request.contextPath}/resources/img/form.png" title="formIcon" /> Go to the person formulary !</a></div>
		<div><a href="personController/addressForm" title="go to the address formulary"><img id="formIcon" src="${pageContext.request.contextPath}/resources/img/form.png" title="formIcon" /> Go to the address formulary !</a></div>
	</body>
</html>
