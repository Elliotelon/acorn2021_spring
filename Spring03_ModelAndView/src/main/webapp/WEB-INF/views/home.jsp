<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/home.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
<div class="container">
	<h1>인덱스 페이지 입니다.</h1>
	<ul>
		<li><a href="test/play.html">놀러가기(DispatcherServlet을 거치지 않음)</a></li>
		<li><a href="test/study.jsp">공부하러가기(DispatcherServlet을 거치지 않음)</a></li>
	</ul>
	<h2>공지 사항 입니다.</h2>
	<ul>
		<c:forEach var="tmp" items="${noticeList}">
			<li>${tmp}</li>
		</c:forEach>
	
	</ul>
</div>
</body>
</html>