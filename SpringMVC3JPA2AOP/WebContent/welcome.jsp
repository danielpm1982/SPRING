<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Welcome</title>
</head>
<body>
	<jsp:forward page="mealController/home1" />
<%-- 	<c:redirect url="mealController/home2" /> --%>
</body>
</html>


<!-- 
In the case of forwarding to the MealController, the url of the browser wont't change, thus the links of
the home.jsp page must have the complete url for the servlet requestMapping url and for each method 
requestMapping url.  

In the case of redirecting, on the other hand, as the response will return to the browser for a second
request (instead of just forwarding to the other internal resource), the browser url will change, and
the links at the home2.jsp must NOT have the url to the servlet (as it will already be at the url), only
the url to each servlet method. 

Differently from tradicional servlet api examples, this one can't just map the "/" url to the controller
servlet. First, the flux must be directed to the dispatcherServlet and to the applicationContext, and only
then the framework will turn the MealController servlet ready, as a bean (@Controller -> @Component), to
be used by Spring according to url request calls (to the servlet bean and to its methods).

Therefore, a welcome jsp file had to be used here and asked to proceed the forwarding or redirecting to
the url of the home page, using the controller bean servlet, then already set.   
-->

