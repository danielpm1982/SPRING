<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Spring MVC Web</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/css.css" />
	</head>
	<body>
		<div class="mediumText">This is the request formulary of this WebApp ! <img id="springIcon2" src="${pageContext.request.contextPath}/resources/img/spring.png" title="springIcon" /></div>
		<form method="get" action="formResult">
			<input type="text" class="text" name="name" title="type your name" placeholder="type your name" required/><br>
			<input type="date" class="date" name="birthDate" title="type your birthDate" required/><br>
			<input type="submit" class="submit" value="SUBMIT"  title="click to submit" />
		</form>		
	</body>
</html>
