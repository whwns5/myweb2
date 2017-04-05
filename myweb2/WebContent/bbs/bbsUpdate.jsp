<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
	width: 800px;
	border: 1px solid black;
}
table th, td{
	border: 1px solid black;
}
</style>
</head>
<body>
	<c:set var="bdto" value="${requestScope.bdto}"/>
	<form name="bbsUpdate" action="bbsUpdate.yong">
	<input type="hidden" name="cp" value="${requestScope.cp}">
	<input type="hidden" name="idx" value="${bdto.idx}">
	<table>
		<colgroup>
			<col width="100px">
			<col width="300px">
			<col width="100px">
			<col width="300px">
		</colgroup>
		<tr>
			<th>번호</th>
			<td>${bdto.idx}</td>
			<th>작성일</th>
			<td>${bdto.writedate}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${bdto.writer}</td>
			<th>조회수</th>
			<td>${bdto.readnum}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><input type="text" name="subject" value="${bdto.subject}"></td>
		</tr>
		<tr style="height: 400px">
			<td colspan="4">
				<textarea rows="26" cols="110" name="content">${bdto.content}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="4" align="right">
				<input type="submit" value="수정하기">
				<input type="button" value="나가기" onclick="goBbsList(${requestScope.cp});">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>