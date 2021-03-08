<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>﻿dept/deptinsert.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
</script>
</head>
<body>
<h3 id="top">부서등록</h3>
<form:form modelAttribute="deptVO" action="insertDept" method="post" name="frm">
	department_id    <form:input path="department_id"/><br>
	department_name   <form:input path="department_name"/><br>
	manager_id    
	<form:select path="manager_id">
			<option value="">선택</option>
			<form:options items="${empList }" itemLabel="manager_id" itemValue="manager_id"/>
	</form:select><br>
	location_id
	<form:select path="location_id">
		<option value="">선택</option>
		<form:options items="${locList}" itemLabel="location_id"  itemValue="location_id"/>
	</form:select><br>
	
	<button type="submit">등록</button>
	<button type="reset">취소</button>
</form:form>
</body>
</html>