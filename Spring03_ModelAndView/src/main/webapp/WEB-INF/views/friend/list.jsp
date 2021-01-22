<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/friend/list.jsp</title>
<link rel="stylesheet" href="../resources/css/bootstrap.css" />
</head>
<body>
<div class="container">
	<h1>친구목록 입니다.</h1>
	<ul>
		<c:forEach var="tmp" items="${list}">
			<li>${tmp}</li>
		</c:forEach>
	</ul>
	<a href="../home.do">인덱스로 가기</a>
	<a href="${pageContext.request.contextPath}/">인덱스로 가기</a>
</div>
</body>
</html>