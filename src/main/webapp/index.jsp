<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WorkOptimizer - top -</title>
</head>
<body>
	<div class="wrapper">
		<form action="LoginServlet" method="post">
		<h1>WorkOptimizer</h1>
		<p>ユーザーID:<input type="text" name="userId"></p>
		<p>パスワード:<input type="password" name="pass"></p>
		<p><input type="submit" value="ログイン"></p>
		</form>
		<c:if test="${not empty errorMsg}">
			<p><c:out value="${errorMsg}" /></p>
		</c:if>
		<a href="RegisterUserServlet">ユーザー登録はこちら</a>
	</div>
</body>
</html>