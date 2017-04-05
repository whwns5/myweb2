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
<% 
	String fruit[] = {"삵괅","밿","폵돓","딹기","밝낡낡"};
%>
<c:set var="f" value="<%=fruit%>"/>
<ul>
	<c:forEach var="temp" items="<%=fruit%>">
		<li>${temp}</li>
	</c:forEach>
</ul>
<c:forEach var="i" begin="1" end="10" step="1">
	${i}&nbsp;
</c:forEach>
<hr>
<c:forTokens var="i" items="거북이,토끼,당근,매실,짱아찌" delims=",">
	${i}&nbsp;
</c:forTokens>
</body>
</html>