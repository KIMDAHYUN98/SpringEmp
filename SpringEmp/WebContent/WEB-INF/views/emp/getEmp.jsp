<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp/getEmp.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function() {
		$('#btnUpd').on('click', function() {
			location.href = "updateEmp?employee_id=${emp.employee_id }";
			//location.assing("updateEmp?employee_id=${emp.employee_id }");
		});
	});
</script>
</head>
<body>
파라미터 ${employee} <!-- 클래스 이름의 첫글자만 소문자로 변경해서 기입한다 -->
<hr>
<h2>상세 사원</h2>
사번 : ${emp.employee_id } <br>
이름 : ${emp.first_name } ${emp.last_name } <br>
이메일 : ${emp.email } <br>
급여 : ${emp.salary } <br>
부서 : ${emp.department_id } <br>


<button id="btnUpd">수정</button>
<a href="deleteEmp?employee_id=${emp.employee_id }">삭제</a>
<a href="getSearchEmp">목록으로</a>

</body>
</html>