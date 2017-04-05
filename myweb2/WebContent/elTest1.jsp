<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${true}<br>
${10}/${12.2}<br>
${'안녕하세요'}/${"반갑습니다."}<br>
${null}<br>
<h4>4+5=${4+5}</h4>
<h4>"4"+5=${"4"+5}</h4> <!-- el에서는 연결연산자를 제공해주지 않는다. -->
<%-- <h4>"사"+5=${"사"+5}</h4> --%>
<h4>null+5=${null+5}</h4> <!-- null 과 산술연산자를 만들었을 경우 0 으로 인식 -->
<h4>3/2=${3/2}</h4>
<h4>3 div 2=${3 div 2}</h4>
<h4>3%2=${3 % 2}</h4>
<h4>3 mod 2=${3 mod 2}</h4>
<h4>3==4=${3 eq 4}</h4>
<h4>3!=4=${3 ne 4}</h4>
</body>
</html>