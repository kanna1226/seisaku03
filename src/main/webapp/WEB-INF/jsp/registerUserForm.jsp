<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WorkOptimizer - Register</title>
</head>
<body>
	<form action="RegisterUserServlet" method="post">
	<h1>WorKOptimizer ユーザー登録</h1>
	<h2>入力</h2>
	<p>ユーザーID:<input type="text" name="userId"></p>
	<p>パスワード:<input type="password" name="pass"></p>
	<p>メールアドレス:<input type="text" name="mail"></p>
	<p>名前:<input type="text" name="userName"></p>
	<p>生年月日:<input type="date" value="2018-02-14" name="dateOfBirth"></p>
	<p><input type="submit" value="登録確認"></p>
	</form>
</body>
</html>