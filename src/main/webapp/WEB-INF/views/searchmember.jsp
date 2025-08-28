<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 찾기</title>
</head>
<body>
<h2>회원 찾기</h2>
	<hr>
	<form action="searchOk" >
	아이디: <input type="text" name="memberid"><br><br>
	<input type="submit" value="회원 찾기">
	</form>
	<hr>
	<c:if test="${not empty result }">
		<h2 style="color:blue;">
			검색된 회원: ${mDto.membername } 님
		</h2>
	</c:if>
</body>
</html>