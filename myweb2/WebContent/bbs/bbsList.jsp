<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
	width: 700px;
	border: 1px solid black;
}
table tr, td{
	border: 1px solid black;
}
</style>
<script>
function showBbsWrite() {
	location.href = 'bbsWriteForm.yong';
}
function goPage(cp) {
	location.href = 'bbsListForm.yong?cp=' + cp;
} 
</script>
</head>
<body>
<h2>게시판</h2>
<%-- <c:set var="page_dto" value="${requestScope.page_dto}"/>
<c:set var="pageNumber" value="${page_dto.arry_pageNum}"/>
<c:set var="before" value="${page_dto.preCp}"/>
<c:set var="next" value="${page_dto.nextCp}"/> --%>
<table>
	<colgroup>
		<col width="50px">
		<col width="300px">
		<col width="100px">
		<col width="200px">
		<col width="50px">
	</colgroup>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>글쓴이</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
	<c:set var="bdtos" value="${requestScope.arry_bdto}"/>
	<c:if test="${empty bdtos}">
		<tr>
			<td colspan="5"> 게시글이 없습니다. </td>
		</tr>
	</c:if>
	<c:forEach var="bdto" items="${bdtos}">
		<tr>
			<td>${bdto.idx}</td>
			<td>
				<c:forEach begin="0" end="${bdto.lev}" varStatus="1">
					&nbsp;
				</c:forEach>
				<c:if test="${bdto.lev != 0}">
					<img alt="reply" src="/myweb2/img/bbs/ioc_reply.gif">
				</c:if>
				<c:url var="contentUrl" value="bbsContentForm.yong">
					<c:param name="idx" value="${bdto.idx}"/>
					<c:param name="cp" value="${requestScope.cp}"/>
				</c:url>
				<a href="${contentUrl}">${bdto.subject}</a>
			</td>
			<td>${bdto.writer}</td>
			<td>${bdto.writedate}</td>
			<td>${bdto.sunbun}</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="5" align="center">
			${requestScope.pageStr}
		<%--<c:if test="${!empty before}">
				<a id="before_a">이전</a>
			</c:if>
			<c:forEach var="pnum" items="${pageNumber}">
				<a class="pnum_a">${pnum}</a>
			</c:forEach>
			<c:if test="${!empty next}">
				<a id="after_a">다음</a>
			</c:if> --%>
		</td>
	</tr>
	<tr>
		<td colspan="5" align="right">
			<input type="button" value="글쓰기" onclick="showBbsWrite();">
		</td>
	</tr>
</table>
</body>
</html>