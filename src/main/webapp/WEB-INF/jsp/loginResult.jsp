<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WorkOptimizer - Login</title>
</head>
<body>
	<div class="wrapper">
	<h1>WorKOptimizer ログイン</h1>
	<c:if test="${not empty errorMsg}">
		<p><c:out value="${errorMsg}" /></p>
	</c:if>
	<p>ようこそ<c:out value="${loginUser.userId}" />さん</p>
	<a href="RegisterTasksServlet">タスク入力へ</a>
	<a href="HandleTasksServlet">業務開始</a>
	<a href="index.jsp">トップへ</a>
	</div>
</body>
</html>