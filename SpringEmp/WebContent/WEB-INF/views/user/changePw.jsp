<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user/changePw.jsp</title>
</head>
<body>
<h1>패스워드 변경</h1>
<form action="changePw" method="post">
	현재	비밀번호	: <input name="oldpassword" type="text"><br>
	변경 비밀번호	: <input name="password" type="password"><br>
	변경 비밀번호 확인 : <input name="newpassword" type="password"><br>
	<button>변경</button>
</form>
</body>
</html>