<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
table tr, td{
	border: 1px solid black;
}
</style>
</head>
<body>
<h2>글작성</h2>
<form name="bbsReWrite" action="bbsReWrite.yong">
<input type="hidden" name="cp" value="${requestScope.cp}">
<input type="hidden" name="ref" value="${requestScope.ref}">
<input type="hidden" name="lev" value="${requestScope.lev}">
<input type="hidden" name="sunbun" value="${requestScope.sunbun}">
<table>
	<colgroup>
		<col width="100px">
		<col width="300px">
		<col width="100px">
		<col width="300px">
	</colgroup>
	<tr>
		<th>작성자</th>
		<td><input type="text" name="writer"></td>
		<th>비밀번호</th>
		<td><input type="password" name="pwd"></td>
	</tr>
	<tr>
		<th>제목</th>
		<td colspan="3"><input type="text" name="subject"></td>
	</tr>
	<tr>
		<td colspan="4">
			<textarea rows="16" cols="110" name="content"></textarea>
		</td>
	</tr>
	<tr>
		<td colspan="4" align="right">
			<input type="submit" value="작성하기">
			<input type="reset" value="다시작성">
		</td>
	</tr>
</table>
</form>
</body>
</html>