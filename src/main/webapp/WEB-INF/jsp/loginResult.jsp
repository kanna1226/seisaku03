<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WorkOptimizer - Login</title>
</head>
<body>
	<h1>WorKOptimizer ログイン</h1>
	<p>ようこそ<c:out value="${loginUser.userId}" />さん</p>
	<a href="RegisterTasksServlet">タスク入力へ</a>
	<a href="#">業務開始</a>
	<a href="index.jsp">トップへ</a>
</body>
</html>