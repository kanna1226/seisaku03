<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>WorkOptimizer - Register</title>
</head>
<body>
	<div class="wrapper">
	<form class="center" action="RegisterUserServlet" method="post">
	<h1>WorKOptimizer ユーザー登録</h1>
	<table class="registerForm">
	<tr>
		<th><label for="userId">ユーザーID:</label></th>
		<td><input type="text" name="userId" class="txt"></td>
	</tr>
	<tr>
		<th><label for="pass">パスワード:</label></th>
		<td><input type="password" name="pass" class="txt"></td>
	</tr>
	<tr>
		<th><label for="mail">メールアドレス:</label></th>
		<td><input type="email" name="mail" class="txt"></td>
	</tr>
	<tr>
		<th><label for="name">名前:</label></th>
		<td><input type="text" name="userName" class="txt"></td>
	</tr>
	<tr>
		<th><label for="dateValue">生年月日:</label></th>
		<td><input type="date" value="2018-02-14" name="dateOfBirth" class="txt"></td>
	</tr>
	</table>
	<p><input type="submit" value="登録確認" class="button"></p>
	</form>
	<c:if test="${not empty errorMsg}">
		<p><c:out value="${errorMsg}" /></p>
	</c:if>
	<a href="index.jsp" class="btn_04">ログイン画面へ</a>
	</div>
</body>
</html>