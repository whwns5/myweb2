<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setAttribute("id", "hong");
	request.setAttribute("addr", "서울");
%>
<jsp:forward page="testC2.jsp"/>
</body>
</html>	