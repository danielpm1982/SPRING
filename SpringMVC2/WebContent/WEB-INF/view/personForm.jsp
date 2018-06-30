<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Spring MVC Web</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/css.css" />
	</head>
	<body>
		<div class="mediumText">This is the person formulary ! <img id="springIcon2" src="${pageContext.request.contextPath}/resources/img/spring.png" title="springIcon" /></div>
		<form:form action="personFormResult" method="GET" modelAttribute="person">
			<div class="table">
				<div class="tableRow">
					<div class="tableCellLeft">
						<form:label path="name">Name: </form:label>
					</div>
					<div class="tableCellRight">
						<form:input path="name" title="Type your name!" id="name" required="required"/>
					</div>
				</div>
				<div class="tableRow">	
					<div class="tableCellLeft">
						<form:label path="birthDate">BirthDate (yyyy-mm-dd): </form:label>
					</div>
					<div class="tableCellRight">
						<form:input path="birthDate" title="Type your birthDate! yyyy-mm-dd" id="birthDate" required="required"/>
					</div>
				</div>
				<div class="tableRow">
					<div class="tableCellLeft">
						<label for="addressString">Address (optional):</label>
					</div>
					<div class="tableCellRight">
						<h5>${addressSession}</h5>
						<a href="addressForm" title="go to the address formulary"><img id="formIcon2" src="${pageContext.request.contextPath}/resources/img/form.png" title="formIcon" /> Address formulary</a>
					</div>
				</div>
			</div>
			<input type="submit" value="SUBMIT">
		</form:form>
	</body>
</html>
