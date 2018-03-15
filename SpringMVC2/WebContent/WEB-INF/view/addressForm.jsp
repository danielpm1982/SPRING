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
		<div class="mediumText">This is the address formulary ! <img id="springIcon2" src="${pageContext.request.contextPath}/resources/img/spring.png" title="springIcon" /></div>
		<form:form action="addressFormResult" method="GET" modelAttribute="address">
			<div class="table">
				<div class="tableRow">
					<div class="tableCellLeft">
						<form:label path="street">Street: </form:label>
					</div>
					<div class="tableCellRight">
						<form:input path="street" title="Type your street name!" id="street" required="required"/>
					</div>
				</div>
				<div class="tableRow">
					<div class="tableCellLeft">
						<form:label path="number">Number: </form:label>
					</div>
					<div class="tableCellRight">
						<form:input path="number" title="Type your street name!" id="number" required="required"/>
					</div>
				</div>
				<div class="tableRow">
					<div class="tableCellLeft">
						<form:label path="city">City: </form:label>
					</div>
					<div class="tableCellRight">
						<form:input path="city" title="Type your street name!" id="city" required="required"/>
					</div>
				</div>
				<div class="tableRow">
					<div class="tableCellLeft">
						<form:label path="state">State: </form:label>
					</div>
					<div class="tableCellRight">
						<form:input path="state" title="Type your street name!" id="state" required="required"/>
					</div>
				</div>
				<div class="tableRow">
					<div class="tableCellLeft">
						<form:label path="country">Country: </form:label>
					</div>
					<div class="tableCellRight">
						<form:input path="country" title="Type your street name!" id="country" required="required"/>
					</div>
				</div>
			</div>
			<input type="submit" value="SUBMIT">
		</form:form>
	</body>
</html>
