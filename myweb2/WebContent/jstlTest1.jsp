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
<c:set var="num1" value="100"></c:set>
<c:set var="num2">200</c:set>
<h4> num1 : ${num1}</h4>
<h4> num2 : ${num2}</h4>
<h4> num1 + num2 = ${num1+num2}</h4>
<%
	HashMap map = new HashMap();
%>
<c:set var="m" value="<%=map %>"> </c:set>
<!-- set 태그에는 기본데이터 뿐만 아니라 객체도 저장이 가능하다 -->
<c:set target="${m}" property="name" value="홍길동"></c:set>
<c:set target="${m}" property="addr">서울시 강남구</c:set>
<c:set target="${m}" property="user-id" value="hong"></c:set>
<c:remove var="m"/>
<ul>
	<li>이름 : ${m.name}</li>
	<li>주소 : ${m.addr}</li>
	<li>유저아이디 : ${m['user-id']}</li>
</ul>
</body>
</html>