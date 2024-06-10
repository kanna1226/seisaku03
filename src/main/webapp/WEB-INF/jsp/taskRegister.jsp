<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WorkOptimizer -register tasks-</title>
</head>
<body>
	<h1>WorkOptimizer</h1>
	<h2>タスク登録</h2>
	<p><c:out value="${loginUser.userName}"/>さんログイン中</p>
	<a href="Logout">ログアウト</a>
	<form action="RegisterTasksServlet" method="post">
	<p>業務内容:
	<select name="taskGroupId">
		<c:forEach var="taskGroup" items="${taskGroupList}">
			<option value="${taskGroup.taskGroupId}"><c:out value="${taskGroup.taskGroupName}"/></option>
		</c:forEach>
	</select>詳細:<input type="text" name="taskContent"></p>
	<p>
	期限:
	<fmt:formatDate value="${currentDate}" pattern="yyyy-MM-dd" var="todayDate" />
	<input type="date" value="${todayDate}" name="tentativeStartDateString">
	予定時間:<input type="number" name="tentativeEndTimeString">分
	</p>
	<p><input type="submit" value="登録"></p>
	</form>
	<c:if test="${not empty errorMsg}">
		<p style="color:red"><c:out value="${errorMsg}"/></p>
	</c:if>
	<h2>登録一覧（本日登録分）</h2>
	<c:forEach var="task" items="${todayRegisterTaskList}">
		<p>
		業務内容:
		<c:forEach var="taskGroup" items="${taskGroupList}">
			<c:if test="${task.taskGroupId == taskGroup.taskGroupId}">
				<c:out value="${taskGroup.taskGroupName}" />/
			</c:if>
		</c:forEach>
		詳細:<c:out value="${task.taskContent}"/>/
		期限:<fmt:formatDate value="${task.tentativeEndDate}" pattern="yyyy-MM-dd" />
		</p>
	</c:forEach>
	<p><a href="HandleTasksServlet">業務開始</a></p>
</body>
</html>