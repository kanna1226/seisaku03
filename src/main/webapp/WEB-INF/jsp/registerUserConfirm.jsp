<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WorkOptimizer - Register</title>
</head>
<body>
	<div class="wrapper">
	<h1>WorKOptimizer ユーザー登録</h1>
	<h2>確認</h2>
	<p>下記ユーザーを登録します</p>
	<p>
	ログインID:<c:out value="${registerUser.userId}" />
	メールアドレス:<c:out value="${registerUser.mail}" />
	名前:<c:out value="${registerUser.userName}" />
	生年月日:<c:out value="${registerUser.dateOfBirth}" />
	</p>
	<a href="RegisterUserServlet" class="btn_04">戻る</a>
	<a href="RegisterUserServlet?action=done" class="btn_04">登録</a>
	</div>
</body>
</html>