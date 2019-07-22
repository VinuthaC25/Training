<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
<style>
		a{
			text-decoration : none;
			color:green;
		}
		td{
			text-align:center;
		}
		th{
			background-color:blue;
		}
</style>

</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="menu.html" %>
	Logged in as ${sessionScope.sname}
	<table border = "1" bgcolor="rgb(125,180,196)" align="center">
	
			<tr bgcolor="violet" color="white">
					<th>Pid</th>
					<th>Pname</th>
					<th>Cost</th>
					<th>Quantity</th>
					<th>Action</th>
			</tr>
			
			<c:forEach items="${sessionScope.pro}" var="p">
				<tr>
						<td>${p.pid}</td>
						<td>${p.pname}</td>
						<td>${p.cost}</td>
						<td>${p.quantity}</td>
						<td>
							<a href="AddProductServlet?pid=${p.pid}">Edit</a>
							<a href="DeleteProductServlet?pid=${p.pid}">Delete</a>
						</td>
				</tr>		
			</c:forEach>
	</table>
	<a href="UpdateProduct.jsp">Add Product</a>	
</body>
</html>