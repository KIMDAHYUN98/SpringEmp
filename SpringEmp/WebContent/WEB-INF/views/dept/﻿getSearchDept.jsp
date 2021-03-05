<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dept/﻿getSearchDept.jsp</title>
<style>
	li {display: inline-block; margin: 5px }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function() {
		$('#btnUpd').on('click', function() {
			location.href = "insertDept?department_id=${dept.department_id }";
		});
	});
</script>
</head>
<body>
<h2>부서 목록</h2>
<form action="getSearchDept" name="searchFrm">
	<input type="hidden" name="page" value="1">
	부서명 : <input name="department_name" value="${deptSearchVO.department_name }">
	매니저 아이디 : <input name="manager_id" value="${deptSearchVO.manager_id }">
	<button>검색</button>
</form>
<c:forEach items="${list }" var="dept">
	<a href="getDept?department_id=${dept.department_id }">${dept.department_name }</a>
	${dept.manager_id } ${dept.location_id }
	
	<br>
</c:forEach>
<my:paging paging="${paging }" jsFunc="goPage"/>
	<script type="text/javascript">
		function goPage(p) {
			searchFrm.page.value = p;
			searchFrm.submit();
		}
	</script>
<button id="btnUpd">등록</button>
</body>
</html>