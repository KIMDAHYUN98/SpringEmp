<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp/getSearchEmp.jsp</title>
<style>
	li {display: inline-block; margin: 5px }
</style>
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
	<form action="getSearchEmp" name="searchFrm">
		<input type="hidden" name="page" value="1">
		부서 : <input name="department_id" value="${empSearchVO.department_id }">
		JOB : <input name="job_id" value="${empSearchVO.job_id }">
		NAME : <input name="first_name" value="${empSearchVO.first_name }">
		<button>검색</button>
	</form>
	
		<c:forEach var="emp" items="${list }">
			<a href="getEmp?employee_id=${emp.employee_id }">${emp.first_name }</a> ${emp.last_name }
			${emp.salary }
			${emp.department_name} ${emp.job_title}<br>
		</c:forEach>
	
	<my:paging paging="${paging }" jsFunc="goPage"/>
		<script type="text/javascript">
			function goPage(p) {
				//location.href="getSearchEmp?page=" + p;
				searchFrm.page.value = p;
				searchFrm.submit();
			}
		</script>
	
	<button id="btnUpd">등록</button>
</body>
</html>