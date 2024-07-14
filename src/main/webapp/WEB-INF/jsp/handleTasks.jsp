<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>WorkOptimizer -handle tasks-</title>
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
    <h1>WorkOptimizer</h1>
    <p><c:out value="${loginUser.userId}"/>さんログイン中</p>
    <a href="RegisterTasksServlet" class="btn_04">タスク入力へ</a>
    <h2>タスク一覧</h2>
    <form action="HandleTasksServlet" method="post"	onsubmit="saveScrollPosition()">
    <div class="table-scroll">
    <table class="table_design10">
    <tbody>
    	<tr>
        	<th>業務内容</th>
        	<th>詳細</th>
        	<th>期限</th>
        	<th>予定時間</th>
        	<th>開始</th>
        	<th>終了</th>
        	<th>時間</th>
        	<th>予定との差</th>
        </tr>
    <c:forEach var="task" items="${todayHandleTaskList}">
    	<tr>
        	<c:forEach var="taskGroup" items="${taskGroupList}">
            	<c:if test="${task.taskGroupId == taskGroup.taskGroupId}">
              	  <td class="${not empty sessionScope['startDateTime' += task.taskId] && empty sessionScope['endDateTime' += task.taskId] ? 'highlight' : ''}">
              	  	<c:out value="${taskGroup.taskGroupName}" />
              	  </td>
           		</c:if>
        	</c:forEach>
        	<td class="${not empty sessionScope['startDateTime' += task.taskId] && empty sessionScope['endDateTime' += task.taskId] ? 'highlight' : ''}">
        		<c:out  value="${task.taskContent}"/>
        	</td>
        	<td class="${not empty sessionScope['startDateTime' += task.taskId] && empty sessionScope['endDateTime' += task.taskId] ? 'highlight' : ''}">
        		<c:out value="${task.tentativeStartDate}" />
        	</td>
        	<td class="${not empty sessionScope['startDateTime' += task.taskId] && empty sessionScope['endDateTime' += task.taskId] ? 'highlight' : ''}">
        		<c:out value="${task.tentativeEndTime}" />分
        	</td>
        	<td class="${not empty sessionScope['startDateTime' += task.taskId] && empty sessionScope['endDateTime' += task.taskId] ? 'highlight' : ''}">
        		<input type="submit" name="${'action' += task.taskId}" value="start" class="button"><br>
        		<span><c:out value="${sessionScope['startDateTime' += task.taskId]}" /></span>
        	</td>
        	<td class="${not empty sessionScope['startDateTime' += task.taskId] && empty sessionScope['endDateTime' += task.taskId] ? 'highlight' : ''}">
        		<input type="submit" name="${'action' += task.taskId}" value="end" class="button"><br>
        		<span><c:out value="${sessionScope['endDateTime' += task.taskId]}" /></span>
        	</td>
        	<%--input type="submit" id="start_${task.taskId}" name="${'action' += task.taskId}" value="start" onclick="handleStartClick('${task.taskId}');"--%>
        	<%--input type="submit" id="end_${task.taskId}" name="${'action' += task.taskId}" value="end" onclick="handleEndClick('${task.taskId}');"--%>
       		<td class="${not empty sessionScope['startDateTime' += task.taskId] && empty sessionScope['endDateTime' += task.taskId] ? 'highlight' : ''}"><c:out value="${sessionScope['taskHandleDuration' += task.taskId]}" />分</td>
        	<td class="${not empty sessionScope['startDateTime' += task.taskId] && empty sessionScope['endDateTime' += task.taskId] ? 'highlight' : ''}"><c:out value="${sessionScope['difference' += task.taskId]}" />分</td>
        </tr>
    </c:forEach>
    </tbody>
    </table>
    </div>
    </form>
    <a href="CompleteTasksServlet" class="btn_04">業務終了</a>
    <a href="Logout" class="btn_04">ログアウト</a>
    </div>
</body>
</html>
