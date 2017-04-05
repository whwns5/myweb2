<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function showLogin() {
	window.open('memberLoginForm.yong','memberLoginForm','width=370,height=230,left=600,top=400');
}
function logOut() {
	location.href = 'memberLogOut.yong';
}
</script>
</head>
<body>
<h2 style="text-align: right;">
	<c:choose>
		<c:when test="${empty sessionScope.session_login_mdto}">
			<a href="javascript:showLogin();">로그인</a>
			<a href="memberAdd.yong">회원가입</a>
		</c:when>
		<c:otherwise>
			<a href="#">${sessionScope.session_login_mdto.name} 님 환영합니다.</a>
			<a href="javascript:logOut();">로그아웃</a>
		</c:otherwise>
	</c:choose>
</h2>
<h1>index 입니다.</h1>
<ul>
	<li><a href="emp.yong">사원관리 프로그램(MVC)</a></li>
	<li><a href="memberSearch.yong">회원검색</a></li>
	<li><a href="bbsListForm.yong">BBS</a></li>
</ul>
</body>
</html>