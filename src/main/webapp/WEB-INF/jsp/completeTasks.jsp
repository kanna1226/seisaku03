<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WorkOptimizer -complete tasks-</title>
</head>
<body>
	<div class="wrapper">
    <h1>WorkOptimizer</h1>
    <h2>業務完了 お疲れさまでした！</h2>
    <p>今日の成果</p>
    <c:forEach var="entry" items="${totalTaskHandleTimeMap}">
        <h3>業務内容: <c:out value="${entry.key.taskGroupName}" /></h3>
        <p>合計: <c:out value="${entry.value}" /> 分</p>
        <c:forEach var="task" items="${todayEndTaskList}">
            <c:if test="${task.taskGroupId == entry.key.taskGroupId}">
                <p>
                詳細: <c:out value="${task.taskContent}" />/
                予定時間:<c:out value="${task.tentativeEndTime}" />分
                </p> 
            </c:if>
        </c:forEach>
    </c:forEach>
    <p>一日の合計時間:<c:out value="${todayTotalHandleTaskTime}" />分</p>
    
    <p>予定時間との差:<c:out value="${todayTotalHandleTaskTime - todayTotalSceduleTaskTime}" />分</p>
    <a href="Logout" class="btn_04">ログアウト</a>
    </div>
</body>
</html>
