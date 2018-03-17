<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>e-Meal Web App</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/css.css" />
	</head>
	<body>
		<div class="mediumText">Sandwich Order Formulary ! <img id="sandwichIcon" src="${pageContext.request.contextPath}/resources/img/sandwich.png" title="sandwichIcon" /></div>
		<form:form action="sandwichFormResult" method="GET" modelAttribute="sandwich">
			<div class="table">
				<div class="tableRow">
					<div class="tableCellLeft">
						<form:label path="name">Name:</form:label>
					</div>
					<div class="tableCellRight">
						<form:select path="name" title="Select your sandwich name!" id="sandwich">
							<form:option value="NONE!" label="NONE!" />
							<form:options items="${sandwichNames}" />
						</form:select>
					</div>
				</div>
				<div class="tableRow">
					<div class="tableCellLeft">
						<form:label path="size">Size: </form:label>
					</div>
					<div class="tableCellRight">
<%-- 						<form:select path="size"  title="Select your sandwich size!" id="size"> --%>
<%-- 							<form:option value="NONE!" label="NONE!" /> --%>
<%-- 							<form:option value="SMALL" label="SMALL" /> --%>
<%-- 							<form:option value="MEDIUM" label="MEDIUM" /> --%>
<%-- 							<form:option value="BIG" label="BIG" /> --%>
<%-- 							<form:option value="ULTRA">ULTRA</form:option> --%>
<%-- 						</form:select> --%>
						<form:select path="size"  title="Select your sandwich size!" id="size">
							<form:option value="NONE!" label="NONE!" />
							<form:options items="${sizeNames}" />
						</form:select>
					</div>
				</div>
				<div class="tableRow">
					<div class="tableCellLeft">
						<form:label path="drink">Drink:</form:label>
					</div>
					<div class="tableCellRight">
						<form:select path="drink" title="Select your drink name !" id="drink">
							<form:option value="NONE!" label="NONE!" />
							<form:options items="${drinkNames}" itemValue="drinkValue" itemLabel="drinkLabel" />
						</form:select>
					</div>
				</div>
				<div class="tableRow">
					<div class="tableCellLeft">
						<form:label id="sauceAddings" path="sauceAddings">Sauce Addings:</form:label>
					</div>
					<div class="tableCellRight">
						<form:select path="sauceAddings" title="Add your source !" id="sauceAddings" multiple="true" >
							<form:option value="NONE!" label="NONE!" />
							<form:options items="${sauceNames}" />
						</form:select>
					</div>
				</div>
				<div class="tableRow">
					<div class="tableCellLeft">
						<form:label path="frenchFries">French Fries:</form:label>
					</div>
					<div class="tableCellRight">
						<form:radiobutton path="frenchFries" value="NO!" label="no!" title="Choose your french fries !" id="frenchFries" />
						<form:radiobutton path="frenchFries" value="YES" label="yes!" title="Choose your french fries !" id="frenchFries" />
					</div>
				</div>
				<div class="tableRow">
					<div class="tableCellLeft">
						<form:label path="payment">Payment:</form:label>
					</div>
					<div class="tableCellRight">
						<form:checkbox path="payment" value="FREE" label="FREE" title="Choose your payment type:" id="payment" multiple="true" />
						<form:checkboxes path="payment" items="${paymentNames}" title="Choose your payment type:" id="payment" multiple="true" />
					</div>
				</div>
			</div>
			<input type="submit" value="SUBMIT">
		</form:form>
		<div id="lastChosen"><p>Last chosen:<br>name: ${sandwich.name} size: ${sandwich.size} price: $${sandwich.price} payment: ${sandwich.paymentStringified} sauceAddings: ${sandwich.sauceAddingsStringified} frenchFries: ${sandwich.frenchFries} drink: ${sandwich.drink}.<br>Composition: ${sandwich.composition}.</p></div>
	</body>
</html>
	