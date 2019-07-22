<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

	<style>
		font-size = 50px;
	</style>

</head>
<body>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
	<h1>Formatting number</h1>
	<c:set value="987654.34567" var="salary"/>
	<fm:formatNumber value="${salary}"></fm:formatNumber>
	<fm:formatNumber value="${salary}" type="currency"></fm:formatNumber><br/><br/>
	<fm:formatNumber value="${salary}" type="number" groupingUsed="false"></fm:formatNumber><br/><br/>
	<fm:formatNumber value="${salary}" type="percent"></fm:formatNumber><br/><br/>
	<fm:formatNumber value="${salary}" type="number" maxIntegerDigits="4"></fm:formatNumber><br/><br/>
	<fm:formatNumber value="${salary}" type="currency" currencyCode="USD"></fm:formatNumber><br/><br/>
	<fm:formatNumber value="${salary}" type="currency" currencyCode="INR"></fm:formatNumber><br/><br/>
	
	<h1>Formatting Date</h1>
	<c:set var="date" value="<%=new java.util.Date()%>"/>
	
	<fm:formatDate value="${date}" type="both"></fm:formatDate><br/><br/>
	<fm:formatDate value="${date}" type="date" dateStyle="long"></fm:formatDate><br/><br/>
	<fm:formatDate value="${date}" type="time" timeStyle="long"></fm:formatDate><br/><br/>
	<fm:formatDate value="${date}" type="date" pattern="MMM/DD/YYYY"></fm:formatDate><br/><br/>
	
</body>
</html>