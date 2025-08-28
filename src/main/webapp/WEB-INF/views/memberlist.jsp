<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모든 회원 리스트</title>
</head>
<body>
	<h2>모든회원 리스트</h2>
	<hr>
	<c:forEach items="${mDtos }" var="mDto">
		<h3>
			${mDto.memberid } / ${mDto.membername } / ${mDto.memberage }
		</h3>
	</c:forEach>
	
	
</body>
</html>