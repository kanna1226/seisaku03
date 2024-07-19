<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>WorkOptimizer -register tasks-</title>
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

    //モーダルウィンドウ
    function openModal(taskId, taskGroupId, taskContent, tentativeStartDate, tentativeEndTime) {
        //モーダルウィンドウを表示
        document.getElementById('editModal').style.display = "block";
        //タスクIDをフォームにセット
        document.getElementById('taskId').value = taskId;
        //他のフィールドも適切にセット
        document.getElementById('editTaskGroup').value = taskGroupId;
        document.getElementById('editTaskContent').value = taskContent;
        document.getElementById('editTaskStartDate').value = tentativeStartDate;
        document.getElementById('editEndTime').value = tentativeEndTime;
        }
    function closeModal() {
		document.getElementById('editModal').style.display = 'none';
        }
</script>
</head>
<body>
	<div class="wrapper">
		<h1>WorkOptimizer</h1>
		<p><c:out value="${loginUser.userId}"/>さんログイン中</p>
		<div class="registerTask">
		<h2 class="taskRegister">タスク登録</h2>
		<form class="center" action="RegisterTasksServlet" method="post" onsubmit="saveScrollPosition()">
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
		<h2>未完了タスク一覧</h2>
		<div class="table-scroll">
		<table class="table_design10">
		<tbody>
			<tr>
				<th>業務内容</th>
				<th>詳細</th>
				<th>期限</th>
				<th>予定時間</th>
				<th>変更</th>
			</tr>
			<c:forEach var="task" items="${incompleteTaskList}">
				<tr>
					<c:forEach var="taskGroup" items="${taskGroupList}">
						<c:if test="${task.taskGroupId == taskGroup.taskGroupId}">
							<td><c:out value="${taskGroup.taskGroupName}" /></td>
						</c:if>
					</c:forEach>
						<td><c:out value="${task.taskContent}"/></td>
						<td><c:out value="${task.tentativeStartDate}" /></td>
						<td><c:out value="${task.tentativeEndTime}" />分</td>
						<td><button type="button" onclick="openModal('${fn:escapeXml(task.taskId)}', 
                                                           '${fn:escapeXml(task.taskGroupId)}', 
                                                           '${fn:escapeXml(task.taskContent)}', 
                                                           '${fn:escapeXml(task.tentativeStartDate)}', 
                                                           '${fn:escapeXml(task.tentativeEndTime)}')"  class="button">変更</button></td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
		</div>
		<div id="editModal" class="modal">
			<div class="modal-content">
				<span class="close" onclick="closeModal()">&times;</span>
				<h2>タスクの変更</h2>
				<form id="editForm" action="EditTaskServlet" method="post">
					<input type="hidden" name="taskId" id="taskId">
					<label for="editTaskGroup">業務内容:</label>
					<select name="taskGroupId"  class="txt" required>
						<option value="" selected disabled>選択してください</option>
						<c:forEach var="taskGroup" items="${taskGroupList}">
							<option value="${taskGroup.taskGroupId}"><c:out value="${taskGroup.taskGroupName}" /></option>
						</c:forEach>
					</select>
					<label for="editTaskContent">詳細:</label>
					<input type="text" name="taskContent" id="editTaskContent" class="txt">
					<label for="editStartDate">期限:</label>
					<input type="date" name="tentativeStartDateString" id="editStartDate" class="txt">
					<label for="editEndTime">予定時間:</label>
					<input type="number" name="tentativeEndTimeString" id="editEndTime" class="txt">分
					<input type="submit" value="保存"> 
				</form>
			</div>
		</div>
		<p><a href="HandleTasksServlet" class="btn_04">業務開始</a></p>
		<a href="Logout" class="btn_04">ログアウト</a>
	</div>
</body>
</html>