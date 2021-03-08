<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp/insertEmp.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	// 이메일 중복체크
	$('#btnEmail').on("click", function() {
		$.ajax({
			url : '../EmailCheck',
			data : "email=" + ﻿$("[name=email]").val(), // 서버에 보낼 파라미터
			dataType : "xml", 						   // 결과 타입
			success: function(response) {
				
				$('#emailResult').html($(response).find("email").text()) // jquery 함수
			},
		})
	})
})
</script>
<style type="text/css">
	.error {
		color: red;
	}
</style>
</head>
<body>
<h3 id="top">사원등록</h3>
<form:form modelAttribute="empVO" action="insertEmp" method="post" name="frm">
	employee_id <form:input path="employee_id"/>
					<form:errors path="employee_id" cssClass="error"/><br>
	first_name  <form:input path="first_name"/>
					<form:errors path="first_name" cssClass="error"/><br>
	last_name   <form:input path="last_name"/>
					<form:errors path="last_name" cssClass="error"/><br>
	email       <form:input path="email"/>
					<form:errors path="email" cssClass="error"/><br>
				<form:button type="button" id="btnEmail">중복체크</form:button>
				<span id="emailResult"></span><br>
	phone_number<form:input path="phone_number"/><br>
	hire_date   <form:input type="date" path="hire_date" />
					<form:errors path="hire_date" cssClass="error"/><br>
	department_id <form:radiobuttons path="department_id"
									 items="${deptList }" itemLabel="department_name" itemValue="department_id" />
					<form:errors path="department_id" cssClass="error"/><br>
	job_id
	<form:select path="job_id">
		<option value="">선택</option>
		<form:options items="${jobList }" itemLabel="job_title" itemValue="job_id"/>
	</form:select><br>
	manager_id 
	<form:input path="manager_id" /> <input type="text" name="name">
	<button type="button" onclick="window.open('empSearch', 'emp', 'width=400, height=400')">사원검색</button><br>	

	<button type="submit">등록</button>
	<button type="reset">초기화</button>
</form:form>
</body>
</html>