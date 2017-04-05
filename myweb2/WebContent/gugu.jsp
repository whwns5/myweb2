<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<c:forEach var="i" begin="1" end="9">
	<tr>
	<c:forEach var="j" begin="2" end="9">
		<td>${j} x ${i} = ${i*j}</td>
	</c:forEach>
	</tr>
</c:forEach>
</table>
</body>
</html>