<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WorkOptimizer -handle tasks-</title>
</head>
<body>
    <h1>WorkOptimizer</h1>
    <h2>タスク一覧</h2>
    <p><c:out value="${loginUser.userName}"/>さんログイン中</p>
    <a href="Logout">ログアウト</a>
    <form action="HandleTasksServlet" method="post">
    <c:forEach var="task" items="${todayHandleTaskList}">
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
        <p>
        <input type="submit" name="${'action' += task.taskId}" value="start">
        <input type="submit" name="${'action' += task.taskId}" value="end">
        </p>
        <p>
        開始時間:<c:out value="${requestScope['startDateTime' += task.taskId]}" />
        終了時間:<c:out value="${requestScope['endDateTime' += task.taskId]}" />
        </p>    
    </c:forEach>
    </form>
    <a href="CompleteTasksServlet">業務終了</a>
</body>
</html>
