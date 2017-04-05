<%@page import="yong.emp.model.EmpDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<EmpDTO> arry_edto = (ArrayList<EmpDTO>) request.getAttribute("arry_edto");
	
	if(arry_edto == null || arry_edto.size() == 0){
%>
	<script>
		window.alert('해당 사원이 없습니다.');
		location.href = 'emp.yong';0
	</script>
<%
	} else {
%>
	<form name="empUpdate" action="empUpdate.yong">
	<table>
		<tr>
			<th>사원번호 : </th>
			<td><input type="text" name="idx" value="<%=arry_edto.get(0).getIdx()%>" readonly="readonly"></td>
		</tr>
		<tr>
			<th>사원이름 : </th>
			<td><input type="text" name="name" value="<%=arry_edto.get(0).getName()%>"></td>
		</tr>
		<tr>
			<th>E-MAIL : </th>
			<td><input type="text" name="email" value="<%=arry_edto.get(0).getEmail()%>"></td>
		</tr>
		<tr>
			<th>부서이름 : </th>
			<td><input type="text" name="dept" value="<%=arry_edto.get(0).getDept()%>"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정">
				<input type="button" value="나가기" onclick="location.href='emp.yong';">
			</td>
		</tr>
	</table>
	</form>
<%
	}
%>
</body>
</html>