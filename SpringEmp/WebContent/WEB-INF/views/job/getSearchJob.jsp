<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>job/getSearchJob.jsp</title>
</head>
<body>
<h2>직업 목록</h2>
	<c:forEach var="job" items="${list }">
		${job.job_id } ${job.job_title }
		${job.min_salary } ${job.max_salary }<br>
	</c:forEach>
	<button id="btnUpd">등록</button>
</body>
</html>