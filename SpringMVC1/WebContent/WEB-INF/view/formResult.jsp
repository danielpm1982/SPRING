<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Spring MVC Web</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/css.css" />
	</head>
	<body>
		<div class="mediumText">This is the FormResultPage of this WebApp !</div>
		<div><img id="bornIcon" src="${pageContext.request.contextPath}/resources/img/born.png" title="bornIcon" /></div>
		<div class="mediumText"><p>Hello Mr(s). ${name} !!</p></div>
		<div class="mediumText"><p>You were born in:<br>${birthDate}</p></div>
	</body>
</html>
	