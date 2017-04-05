<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function showIdCheck() {
	window.open('memberAdd_IdCheckForm.yong','memberAdd_IdCheckForm','width=370,height=230,left=600,top=400');
}
</script>
</head>
<body>
<h2>회원가입 페이지</h2>
<fieldset>
	<legend>회원가입</legend>
	<form name="memberAddProc" action="memberAddProc.yong">
	<table style="width: 600px">
		<colgroup>
			<col width="20%">
			<col width="80%">
		</colgroup>
		<tbody>
			<tr>
				<th>아이디 *</th>
				<td>
					<input type="text" name="id" readonly="readonly">
					<input type="button" value="중복확인" onclick="showIdCheck();">
				</td>
			</tr>
			<tr>
				<th>비밀번호 *</th>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<th>이름 *</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>번호</th>
				<td><input type="text" name="tel"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="addr"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="가입하기">
					<input type="reset" value="다시작성">
				</td>
			</tr>
		</tbody>
	</table>
	</form>
</fieldset>
</body>
</html>