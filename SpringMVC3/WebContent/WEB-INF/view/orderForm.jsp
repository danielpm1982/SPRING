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
		<form:form action="orderFormResult" method="GET" modelAttribute="order">
			<div class="table">
				<div class="tableRow">
					<div class="tableCellLeft">
						<form:label path="clientName">Client Name:</form:label>
					</div>
					<div class="tableCellRight">
						<form:input path="clientName" title="Type your name!" id="clientName" placeholder="Type your name!" autofocus="true"/>
						<br>
						<form:errors path="clientName" cssClass="errors" />
					</div>
				</div>
				<div class="tableRow">
					<div class="tableCellLeft">
						<form:label path="SSN">SSN Card Number:</form:label>
					</div>
					<div class="tableCellRight">
						<form:input path="SSN" title="Type your SSN!" id="SSN" placeholder="Type your SSN!" />
						<br>
						<form:errors path="SSN" cssClass="errors" />
					</div>
				</div>
				<div class="tableRow">
					<div class="tableCellLeft">
						<form:label id="sandwichName" path="sandwichName">Sandwich Name:</form:label>
					</div>
					<div class="tableCellRight">
						<form:select path="sandwichName" title="Select your sandwich name!" id="sandwichName">
							<form:option value="" label="<SELECT>" />
							<form:options items="${sandwichNames}" />
						</form:select>
						<br>
						<form:errors path="sandwichName" cssClass="errors" />
					</div>
				</div>
				<div class="tableRow">
					<div class="tableCellLeft">
						<form:label path="comboSize">Combo Size: </form:label>
					</div>
					<div class="tableCellRight">
						<form:select path="comboSize"  title="Select your sandwich combo size!" id="comboSize">
							<form:option value="" label="<SELECT>" />
							<form:options items="${sizeNames}" />
						</form:select>
						<br>
						<form:errors path="comboSize" cssClass="errors" />
					</div>
				</div>
				<div class="tableRow">
					<div class="tableCellLeft">
						<form:label path="drink">Drink:</form:label>
					</div>
					<div class="tableCellRight">
						<form:select path="drink" title="Select your drink name !" id="drink">
							<form:option value="" label="<SELECT>" />
							<form:options items="${drinkNames}" itemValue="drinkValue" itemLabel="drinkLabel" />
						</form:select>
						<br>
						<form:errors path="drink" cssClass="errors" />
					</div>
				</div>
				<div class="tableRow">
					<div class="tableCellLeft">
						<form:label id="sauceAddings" path="sauceAddings">Sauce Addings:</form:label>
					</div>
					<div class="tableCellRight">
						<form:checkbox path="sauceAddings" value="NONE!" label="No!" title="Choose your sauce adding!" multiple="true" id="sauceAddings" />
						<form:checkboxes path="sauceAddings" items="${sauceNames}" title="Choose your sauce adding!" multiple="true" id="sauceAddings" />
						<br>
						<form:errors path="sauceAddings" cssClass="errors" />
					</div>
				</div>
				<div class="tableRow">
					<div class="tableCellLeft">
						<form:label id="frenchFries" path="frenchFries">French Fries:</form:label>
					</div>
					<div class="tableCellRight">
						<fieldset class="radiobutton">
							<legend>FrenchFries</legend>
							<form:radiobutton path="frenchFries" value="NO!" label="No!" title="Choose your french fries !" id="frenchFries" />
							<form:radiobutton path="frenchFries" value="YES" label="Yes!" title="Choose your french fries !" id="frenchFries" />
						</fieldset>
						<form:errors path="frenchFries" cssClass="errors" />
					</div>
				</div>
				<div class="tableRow">
					<div class="tableCellLeft">
						<form:label id="payment" path="payment">Payment:</form:label>
					</div>
					<div class="tableCellRight">
						<form:select path="payment" id="payment" title="Choose your payment type:" multiple="true" size="2">
							<form:option path="payment" value="FREE" label="FREE" />
							<form:options path="payment" items="${paymentNames}" />
						</form:select>
						<br>
						<form:errors path="payment" cssClass="errors" />
					</div>
				</div>
				<div class="tableRow">
					<div class="tableCellLeft">
						<form:label path="discountCode">Discount Code:</form:label>
					</div>
					<div class="tableCellRight">
						<form:input path="discountCode" title="Type your discount code!" id="discountCode" placeholder="Type your discount code!" />
						<br>
						<form:errors path="discountCode" cssClass="errors" />
					</div>
				</div>
			</div>
			<input type="submit" value="SUBMIT">
		</form:form>
		<div id="lastChosen"><p>Last chosen:<br>client: ${order.clientName} SSNCardNo: ${order.SSN} sandwichName: ${order.sandwichName} comboSize: ${order.comboSize} totalPrice: $${order.totalPrice} payment: ${order.paymentStringified} sauceAddings: ${order.sauceAddingsStringified} frenchFries: ${order.frenchFries} drink: ${order.drink}.<br>Composition: ${order.sandwichComposition}.</p></div>
	</body>
</html>
