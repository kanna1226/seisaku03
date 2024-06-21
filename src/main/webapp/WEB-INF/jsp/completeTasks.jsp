<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>WorkOptimizer -complete tasks-</title>
</head>
<body>
	<div class="wrapper">
    <h1>WorkOptimizer</h1>
    <p><c:out value="${loginUser.userId}"/>さんログイン中</p>
    <h2>業務完了 お疲れさまでした！</h2>
    <h2>今日の成果</h2>
    <c:forEach var="entry" items="${totalTaskHandleTimeMap}">
        <h3>業務内容: <c:out value="${entry.key.taskGroupName}" />合計: <c:out value="${entry.value}" /> 分</h3>
        <div class="table-scroll">
        <table class="table_design10">
        <tbody>
        	<tr>
        		<th>詳細</th>
        		<th>予定時間</th>
        		<th>かかった時間</th>
        	</tr>
        	<c:forEach var="task" items="${todayEndTaskList}">
        		<tr>
            	<c:if test="${task.taskGroupId == entry.key.taskGroupId}">
                	<td><c:out value="${task.taskContent}" /></td>
                	<td><c:out value="${task.tentativeEndTime}" />分</td>
                	<td><c:out value="${task.taskhandleDuration}" />分</td>
            	</c:if>
            	</tr>
        	</c:forEach>
        	</tbody>
        </table>
        </div>
    </c:forEach>
    <h3>一日の合計時間:<c:out value="${todayTotalHandleTaskTime}" />分</h3>
    <h3>予定時間との差:<c:out value="${todayTotalHandleTaskTime - todayTotalSceduleTaskTime}" />分</h3>
    <a href="Logout" class="btn_04">ログアウト</a>
    </div>
</body>
</html>
