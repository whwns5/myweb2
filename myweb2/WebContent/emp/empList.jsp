<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>사원 내역 보기</h2>
<table border="1" cellspacing="0" width="450">
	<thead>
		<tr>
			<th>사원번호</th>
			<th>사원이름</th>
			<th>E-MAIL</th>
			<th>부서이름</th>
		</tr>
	</thead>
	<tbody>
	<c:set var="arry_edto" value="${requestScope.arry_edto}"/> <!-- controller로 부터 넘어온 ArrayList 받기 -->
	<c:if test="${empty arry_edto}"> <!-- 비었는지 요소 검사 null or 0 -->
		<tr>
			<td colspan="4" align="center">등록된 사원이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="edto" items="${arry_edto}"> <!-- 요소 만큼 반복한다. -->
		<tr>
			<td>${edto.idx}</td> <!-- idx를 기입시 내부적으로 해당 맴버변수에 해당되는 getter를 호출한다. -->
			<td>${edto.name}</td>
			<td>${edto.email}</td>
			<td>${edto.dept}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>