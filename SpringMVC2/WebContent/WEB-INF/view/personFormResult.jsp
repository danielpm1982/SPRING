<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Spring MVC Web</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/css.css" />
	</head>
	<body>
		<div class="mediumText">This is the resultPage for the person formulary ! <img id="springIcon2" src="${pageContext.request.contextPath}/resources/img/spring.png" title="springIcon" /></div>
		<div><img id="bornIcon" src="${pageContext.request.contextPath}/resources/img/born.png" title="bornIcon" /></div>
		<div class="mediumText"><p>Hello Mr(s). ${person.name} !!</p></div>
		<div class="mediumText"><p>You were born in:<br><span>${person.birthDate}</span>.</p></div>
		<div class="mediumText"><p>Your age is:<br><span>${person.age}</span>.</p></div>
		<div class="mediumText"><p>Your address is:<br><span>${addressSession}</span>.</p></div>
<%-- 		<div class="mediumText"><p>Your address is:<br><span>${addressApplication}</span>.</p></div> --%>
		<br>
		<div>
			<a href="/SpringMVC2/" title="Click to go to the homePage"><img id="homeIcon" src="${pageContext.request.contextPath}/resources/img/home.png" title="Click to go to the homePage" /><br>Home</a>
		</div>
	</body>
</html>
