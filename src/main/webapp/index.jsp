<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>WorkOptimizer - top -</title>
</head>
<body>
	<div class="wrapper">
		<form action="LoginServlet" method="post">
		<h1>WorkOptimizer</h1>
		<p>ユーザーID:<input type="text" name="userId" class="txt"></p>
		<p>パスワード:<input type="password" name="pass" class="txt"></p>
		<input type="submit" value="ログイン" class="button">
		</form>
		<c:if test="${not empty errorMsg}">
			<p><c:out value="${errorMsg}" /></p>
		</c:if>
		<a href="RegisterUserServlet" class="btn_04">ユーザー登録はこちら</a>
	</div>
</body>
</html>