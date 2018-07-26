<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Spring MVC Web</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/css.css" />
	</head>
	<body>
		<div class="bigText"><p>Welcome to the<br>Spring MVC Web App !!</p></div>
		<div class="mediumText"><p>This is the HomePage of this WebApp !</div>
		<div><img id="springIcon" src="${pageContext.request.contextPath}/resources/img/spring.png" title="springIcon" /></div>
		<div class="mediumText"><a href="appController/form" title="go to the request formulary">Go to the<br>request formulary !</a></div>		
	</body>
</html>
