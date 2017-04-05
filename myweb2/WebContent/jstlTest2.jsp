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
<h3>if 태그 테스트</h3>
<form name="f">
이름 : <input type="text" name="name">
<input type="submit" value="전달">
</form>
<hr>
<h4>사용자 이름 : ${param.name}</h4>
<c:if test="${empty param.name}">
	<h4> 이름을 입력하지 않으셨습니다 ! </h4>
</c:if>
<c:if test="${param.name == '둘리'}">
	<h4 style="color:blue;">둘리는 천재!</h4>
</c:if>
<hr>
<c:choose>
	<c:when test="${param.name == 'killer'}">
		<h4 style="color:red">킬러는 접속이 불가합니다.</h4>
	</c:when>
	<c:when test="${param.name eq '홍길동'}">
		<h4 style="color:red">홍길동도 접속이 불가합니다.</h4>
	</c:when>
	<c:otherwise>
		<h4 style="color:blue">모두 환영합니다.</h4>
	</c:otherwise>
</c:choose>
</body>
</html>