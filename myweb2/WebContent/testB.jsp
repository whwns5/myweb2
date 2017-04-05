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

	// response.sendRedirect("testC.jsp");
	// 사용자의 요청에따라 직접적으로 접근 
%>
<jsp:forward page="testC.jsp"></jsp:forward>
</body>
</html>