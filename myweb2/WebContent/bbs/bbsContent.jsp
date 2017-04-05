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
<script>
function goBbsList(cp) {
	location.href = 'bbsListForm.yong?cp=' + cp;	
}
function goBbsReWrite(cp, ref, lev, sunbun) {
	location.href = 'bbsReWriteForm.yong?cp=' + cp + '&ref=' + ref + '&lev=' + lev + '&sunbun=' + sunbun;	
}
function goBbsUpdate(cp, idx) {
	location.href = 'bbsUpdateForm.yong?cp=' + cp + '&idx=' + idx;
}
function goBbsDelete(cp, idx) {
	location.href = 'bbsDelete.yong?cp=' + cp + '&idx=' + idx;
}
</script>
</head>
<body>
	<c:set var="bdto" value="${requestScope.bdto}"/>
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
			<td colspan="3">${bdto.subject}</td>
		</tr>
		<tr style="height: 400px">
			<td colspan="4">${bdto.content}</td>
		</tr>
		<tr>
			<td colspan="4" align="left">
				<input type="button" value="수정" onclick="goBbsUpdate(${requestScope.cp},${bdto.idx});">
				<input type="button" value="삭제" onclick="goBbsDelete(${requestScope.cp},${bdto.idx});">
			</td>
		</tr>
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="댓글달기" onclick="goBbsReWrite(${requestScope.cp},${bdto.ref},${bdto.lev},${bdto.sunbun});">
				<input type="button" value="나가기" onclick="goBbsList(${requestScope.cp});">
			</td>
		</tr>
	</table>
</body>
</html>