<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>사원관리 프로그램(MVC)</h2>
<form name="empAdd" action="empAdd.yong">
<fieldset>
	<legend>사원등록</legend>
	<ul>
		<li>사원이름 : <input type="text" name="name"></li>
		<li>E-MAIL : <input type="text" name="email"></li>
		<li>부서 : <input type="text" name="dept"></li>
	</ul>
	<p>
		<input type="submit" value="사원등록">
		<input type="reset" value="다시작성">
	</p>
</fieldset>
</form>
<form name="empDel" action="empDel.yong">
<fieldset>
	<legend>사원삭제</legend>
	<ul>
		<li>사원번호 : <input type="text" name="idx"></li>
	</ul>
	<p>
		<input type="submit" value="사원삭제">
	</p>
</fieldset>
</form>
<fieldset>
	<legend>사원목록보기</legend>
	<h4><a href="empList.yong">사원 목록 보기</a></h4>
</fieldset>
<form name="empList" action="empList.yong">
<fieldset>
	<legend>사원검색</legend>
	<select name="fkey">
		<option value="idx">사원번호</option>
		<option value="name">사원이름</option>
		<option value="email">E-MAIL</option>
		<option value="dept">부서번호</option>
	</select>
	<input type="text" name="fvalue" required="required">
	<input type="submit" value="검색">
</fieldset>
</form>
<form name="empContent" action="empContent.yong">
<fieldset>
	<legend>사원수정</legend>
	사원 번호 : <input type="text" name="idx" required="required">
	<input type="submit" value="검색">
</fieldset>
</form>
</body>
</html>