<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WorkOptimizer -complete tasks-</title>
</head>
<body>
	<h1>WorkOptimizar</h1>
	<h2>業務完了　お疲れさまでした！</h2>
	<p>今日の成果</p>
	<c:forEach var="task" items="${todayEndTaskList}">
		<p>
		業務内容:
		<c:forEach var="taskGroup" items="${taskGroupList}">
			<c:if test="${task.taskGroupId == taskGroup.taskGroupId}">
				<c:out value="${taskGroup.taskGroupName}" />/
			</c:if>
		</c:forEach>
		詳細:<c:out value="${task.taskContent}"/>/
		かかった時間:{後ほど}
		</p>
	</c:forEach>
	<a href="Logout">ログアウト</a>
</body>
</html>