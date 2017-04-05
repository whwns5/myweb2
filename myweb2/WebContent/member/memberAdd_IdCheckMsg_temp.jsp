<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when test="${requestScope.result == true}"> <!-- 이미 아이디가 존재할 경우 -->
		<script>
			 window.alert('${requestScope.msg}');
			 location.href = '${requestScope.href}';
		</script>
	</c:when>
	<c:otherwise>
		<script>
			 window.alert('${requestScope.msg}');
			 opener.memberAddImpl.id.value = '${requestScope.id}';
			 window.self.close();
		</script>
	</c:otherwise>
</c:choose>
