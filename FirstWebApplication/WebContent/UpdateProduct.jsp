<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
		<c:set var="p2" value="${sessionScope.p}"></c:set>
		
		<c:if test="${not empty p2}">Edit Product
		
				<form action="add" method="post">
					pid:<input type="text" name="pid" value="<c:out value='${sessionScope.pid}'/>"><br/><br/>
					pname:<input type="text" name="pname" value="<c:out value='${sessionScope.pname}'/>"><br/><br/>
					cost:<input type="text" name="cost" value="<c:out value='${sessionScope.cost}'/>"><br/><br/>
					quantity:<input type="text" name="quantity" value="<c:out value='${sessionScope.quantity}'/>"><br/><br/>
					<input type="submit" value="Update Product"/>	
				</form>
		</c:if>
		
		<c:if test="${empty p2}">Add Product
		
				<form action="add1" method="post">
					pid:<input type="text" name="pid" value="<c:out value='${sessionScope.pid}'/>"><br/><br/>
					pname:<input type="text" name="pname" value="<c:out value='${sessionScope.pname}'/>"><br/><br/>
					cost:<input type="text" name="cost" value="<c:out value='${sessionScope.cost}'/>"><br/><br/>
					quantity:<input type="text" name="quantity" value="<c:out value='${sessionScope.quantity}'/>"><br/><br/>
					<input type="submit" value="Add Product"/>	
				</form>
		</c:if>
</body>
</html>