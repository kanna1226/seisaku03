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
<script>
    function saveScrollPosition() {
        var scrollPos = window.scrollY || document.documentElement.scrollTop;
        document.cookie = "scrollPos=" + scrollPos;
    }

    function loadScrollPosition() {
        var cookieArr = document.cookie.split(";");
        for (var i = 0; i < cookieArr.length; i++) {
            var cookiePair = cookieArr[i].split("=");
            if (cookiePair[0].trim() === "scrollPos") {
                window.scrollTo(0, parseInt(cookiePair[1]));
                break;
            }
        }
    }

    window.onload = function() {
        loadScrollPosition();
    }
</script>
</head>
<body>
	<div class="wrapper">
	<form class="center" action="RegisterUserServlet" method="post" onsubmit="saveScrollPosition()">
	<h1>WorKOptimizer ユーザー登録</h1>
	<table class="registerForm">
	<tr>
		<th><label for="userId">ユーザーID:</label></th>
		<td><input type="text" name="userId" class="txt" value="${userId}"></td>
	</tr>
	<tr>
		<th><label for="pass">パスワード:</label></th>
		<td><input type="password" name="pass" class="txt" value="${pass}"></td>
	</tr>
	<tr>
		<th><label for="mail">メールアドレス:</label></th>
		<td><input type="email" name="mail" class="txt" value="${mail}"></td>
	</tr>
	<tr>
		<th><label for="name">名前:</label></th>
		<td><input type="text" name="userName" class="txt" value="${userName}"></td>
	</tr>
	<tr>
		<th><label for="dateValue">生年月日:</label></th>
		<td><input type="date" value="2018-02-14" name="dateOfBirth" class="txt" value="${dateValue}"></td>
	</tr>
	</table>
	<p><input type="submit" value="登録確認" class="button"></p>
	</form>
	<c:if test="${not empty errorMsg}">
		<p><c:out value="${errorMsg}" escapeXml="false" /></p>
	</c:if>
	<a href="index.jsp" class="btn_04">ログイン画面へ</a>
	</div>
</body>
</html>