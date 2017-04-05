<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

</script>
</head>
<body>
<form name="memberLogin" action="memberLogin.yong" method="post">
<fieldset>
	<legend>로그인</legend>
	<table>
		<tr>
			<th>아이디<th>
			<td><input type="text" name="id" value="${cookie.saveId.value}"></td>
		</tr>
		<tr>
			<th>비밀번호<th>
			<td><input type="text" name="pwd"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="checkbox" name="cbSaveId" ${empty cookie.saveId ? "":"checked"}>아이디 기억하기
				<input type="submit" value="로그인">
			</td>
		</tr>
	</table>
</fieldset>
</form>
</body>
</html>