<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Logged in as ${sessionScope.sname}
<br/>
	${sessionScope.sname}
	<c:forEach items="${sessionScope.pro}" var="p">
	
		<table>
			<tr>
				<td>${sessionScope.pro.pid}</td>
				<td>${sessionScope.pro.pname}</td>
				<td>${sessionScope.pro.cost}</td>
				<td><a href="Custom.html">Confirm</a></td>
			</tr>
		</table>
	</c:forEach>
		<a href="customerProduct.jsp">Go Back</a>
</body>
</html>