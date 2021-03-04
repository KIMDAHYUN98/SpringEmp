<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp/UpdateEmp.jsp</title>
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
</head>
<body>
<h3 id="top">사원수정</h3>
<form:form modelAttribute="empVO" action="updateEmp" method="post" name="frm">
	employee_id <form:input path="employee_id"/><br>
	first_name  <form:input path="first_name"/><br>
	last_name   <form:input path="last_name"/><br>
	email       <form:input path="email"/>
				<form:button type="button" id="btnEmail">중복체크</form:button>
				<span id="emailResult"></span><br>
	phone_number<form:input path="phone_number"/><br>
	hire_date   <form:input path="hire_date" /><br>
	department_id<br>
			<form:radiobuttons path="department_id"
							   items="${deptList }" itemLabel="department_name" itemValue="department_id" /><br>
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