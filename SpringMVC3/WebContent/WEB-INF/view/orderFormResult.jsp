<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>e-Meal Web App</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/css.css" />
	</head>
	<body>
		<div class="mediumText">This is the resultPage for the order formulary ! <img id="sandwichIcon" src="${pageContext.request.contextPath}/resources/img/sandwich.png" title="sandwichIcon" /></div>
		<div><img id="sandwich" src="${pageContext.request.contextPath}/resources/img/sandwich.png" title="sandwich" /></div>
		<div class="mediumText"><p>Your chosen sandwich is:</p></div>
		<div class="mediumText"><p>Client Name: <span>${order.clientName}</span>. Sandwich Name: <span>${orderSession.sandwichName}</span>. Combo Size: <span>${orderSession.comboSize}</span>. Total Price: <span>$${orderSession.totalPrice}</span>. Payment: <span>${orderSession.paymentStringified}</span>. SauceAddings: <span>${orderSession.sauceAddingsStringified}</span>. FrenchFries: <span>${orderSession.frenchFries}</span>. Drink: <span>${orderSession.drink}</span>.</p></div>
		<div class="mediumText"><p>Sandwich Composition:<br><span>${orderSession.sandwichComposition}</span>.</p></div>
		<br>
		<div>
			<a href="/SpringMVC3/" title="Click to go to the homePage"><img id="homeIcon" src="${pageContext.request.contextPath}/resources/img/home.png" title="Click to go to the homePage" /><br>Home</a>
		</div>
	</body>
</html>
