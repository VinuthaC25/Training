<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>

<c:set var="employees">
	<employees>
				<employee>
						<eid>123</eid>
						<ename>Hema</ename>
						<salary>44566</salary>
				</employee>
					
				<employee>
						<eid>456</eid>
						<ename>Chandana</ename>
						<salary>78523</salary>
				</employee>
					
				<employee>
						<eid>789</eid>
						<ename>Impana</ename>
						<salary>854236</salary>
				</employee>
	</employees>
</c:set>

<x:parse xml="${employees}" var="emps"></x:parse>

<x:choose>
	<x:when select="$emps//employee/ename = 'Manasa'"> Manasa is a good employee</x:when>
	<x:when select="$emps//employee/ename = 'Chandana'"> Chandana is a good employee</x:when>
	<x:when select="$emps//employee/ename = 'Hema'"> Hema is a good employee</x:when>
	
	<x:otherwise>Employee not available</x:otherwise>
</x:choose>

<x:forEach select="$emps//employee/ename" var="n">
	<li><x:out select="$n" /></li>	
</x:forEach>
</body>
</html>