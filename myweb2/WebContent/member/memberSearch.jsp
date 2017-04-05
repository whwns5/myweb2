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
	<h2>회원 검색 화면</h2>
	<form name="memberSearch" action="memberSearch.yong" method="post">
		<fieldset>
			<legend>회원 검색</legend>
			<select name="fkey">
				<option value="idx">회원 번호</option>
				<option value="id">아이디</option>
				<option value="name">이름</option>
			</select> <input type="text" name="fvalue" required="required"> <input
				type="submit" value="검색">
		</fieldset>
	</form>
	<c:choose>
		<c:when test="${requestScope.method == 'GET'}">
			<h3>위 검색 란에 정보를 입력하여 주세요.</h3>
		</c:when>
		<c:otherwise>
			<table>
				<thead>
					<tr>
						<th>IDX</th>
						<th>ID</th>
						<th>PWD</th>
						<th>NAME</th>
						<th>TEL</th>
						<th>ADDR</th>
						<th>JOINDATE</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty requestScope.arry_mdto}">
							<tr>
								<td colspan="7">해당 회원이 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="mdto" items="${requestScope.arry_mdto}">
								<tr>
									<td>${mdto.idx}</td>
									<td>${mdto.id}</td>
									<td>${mdto.pwd}</td>
									<td>${mdto.name}</td>
									<td>${mdto.tel}</td>
									<td>${mdto.addr}</td>
									<td>${mdto.joindate}</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>