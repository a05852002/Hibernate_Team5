<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<h1>登入</h1>

<form method="post" action="MemberLoginServlet">
	<label for="uname">帳號</label>
	<input type="text" id="uname" name="uname">
	<label for="uname" >密碼</label>
	<input type="text" id="pwd" name="pwd">
	<p>${errorMsgMap.LoginError}</p>
	<input type="submit" value="Submit">



</form>




</body>
</html>