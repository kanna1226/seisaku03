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
	<form action="RegisterUserServlet" method="post">
	<h1>WorKOptimizer ユーザー登録</h1>
	<p>ユーザーID:<input type="text" name="userId" class="txt"></p>
	<p>パスワード:<input type="password" name="pass" class="txt"></p>
	<p>メールアドレス:<input type="text" name="mail" class="txt"></p>
	<p>名前:<input type="text" name="userName" class="txt"></p>
	<p>生年月日:<input type="date" value="2018-02-14" name="dateOfBirth" class="txt"></p>
	<p><input type="submit" value="登録確認" class="button"></p>
	</form>
	<c:if test="${not empty errorMsg}">
		<p><c:out value="${errorMsg}" /></p>
	</c:if>
	<a href="index.jsp" class="btn_04">ログイン画面へ</a>
	</div>
</body>
</html>