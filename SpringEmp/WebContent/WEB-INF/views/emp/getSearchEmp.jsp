<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp/getSearchEmp.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function() {
		$('#btnUpd').on('click', function() {
			location.href = "insertEmp?employee_id=${emp.employee_id }";
			//location.assing("updateEmp?employee_id=${emp.employee_id }");
		});
	});
</script>
</head>
<body>
	<h2>사원 목록</h2>
	<div id="row">
		<c:forEach var="emp" items="${list }">
			<a href="getEmp?employee_id=${emp.employee_id }">${emp.first_name }</a> ${emp.last_name }
			${emp.salary }
			${emp.department_name} ${emp.job_title}<br>
		</c:forEach>
	</div>
	
	<button id="btnUpd">등록</button>
</body>
</html>