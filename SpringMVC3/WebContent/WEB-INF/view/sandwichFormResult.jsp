<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>e-Meal Web App</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/css.css" />
	</head>
	<body>
		<div class="mediumText">This is the resultPage for the sandwich formulary ! <img id="sandwichIcon" src="${pageContext.request.contextPath}/resources/img/sandwich.png" title="sandwichIcon" /></div>
		<div><img id="sandwich" src="${pageContext.request.contextPath}/resources/img/sandwich.png" title="sandwich" /></div>
		<div class="mediumText"><p>Your chosen sandwich is:</p></div>
		<div class="mediumText"><p>Name: <span>${sandwichSession.name}</span>. Size: <span>${sandwichSession.size}</span>. Price: <span>$${sandwichSession.price}</span>. Payment: <span>${sandwichSession.paymentStringified}</span>. SauceAddings: <span>${sandwichSession.sauceAddingsStringified}</span>. FrenchFries: <span>${sandwichSession.frenchFries}</span>. Drink: <span>${sandwichSession.drink}</span></span>.</p></div>
		<div class="mediumText"><p>Composition:<br><span>${sandwichSession.composition}</span>.</p></div>
		<br>
		<div>
			<a href="/SpringMVC3/" title="Click to go to the homePage"><img id="homeIcon" src="${pageContext.request.contextPath}/resources/img/home.png" title="Click to go to the homePage" /><br>Home</a>
		</div>
	</body>
</html>
