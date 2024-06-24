<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>WorkOptimizer -register tasks-</title>
</head>
<body>
	<div class="wrapper">
		<h1>WorkOptimizer</h1>
		<p><c:out value="${loginUser.userId}"/>さんログイン中</p>
		<div class="registerTask">
		<h2 class="taskRegister">タスク登録</h2>
		<form class="center" action="RegisterTasksServlet" method="post">
		<table class="registerForm">
			<tr>
				<th><label for="taskGroup">業務内容:</label></th>
				<td>
					<select name="taskGroupId"  class="txt" required>
						<option value="" selected disabled>選択してください</option>
						<c:forEach var="taskGroup" items="${taskGroupList}">
							<option value="${taskGroup.taskGroupId}"><c:out value="${taskGroup.taskGroupName}"/></option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th><label for="taskContent">詳細:</label></th>
				<td><input type="text" name="taskContent" class="txt"></td>
			</tr>
			<tr>
				<th><label for="tentativeStartDateString">期限:</label></th>
				<td>
					<fmt:formatDate value="${currentDate}" pattern="yyyy-MM-dd" var="todayDate" />
					<input type="date" value="${todayDate}" name="tentativeStartDateString" class="txt">
				</td>
			</tr>
			<tr>
				<th><label for="tentativeEndTimeString">予定時間:</label></th>
				<td><input type="number" name="tentativeEndTimeString" class="txt">分</td>
			</tr>
		</table>
		<input type="submit" value="登録" class="button">
		</form>
		<c:if test="${not empty errorMsg}">
			<p style="color:red"><c:out value="${errorMsg}"/></p>
		</c:if>
		</div>
		<h2>登録一覧（本日登録未完了分）</h2>
		<div class="table-scroll">
		<table class="table_design10">
		<tbody>
			<tr>
				<th>業務内容</th>
				<th>詳細</th>
				<th>期限</th>
				<th>予定時間</th>
			</tr>
			<c:forEach var="task" items="${todayRegisterTaskList}">
				<tr>
					<c:forEach var="taskGroup" items="${taskGroupList}">
						<c:if test="${task.taskGroupId == taskGroup.taskGroupId}">
							<td><c:out value="${taskGroup.taskGroupName}" /></td>
						</c:if>
					</c:forEach>
						<td><c:out value="${task.taskContent}"/></td>
						<td><c:out value="${task.tentativeStartDate}" /></td>
						<td><c:out value="${task.tentativeEndTime}" />分</td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
		</div>
		<p><a href="HandleTasksServlet" class="btn_04">業務開始</a></p>
		<a href="Logout" class="btn_04">ログアウト</a>
	</div>
</body>
</html>