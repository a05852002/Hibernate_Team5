<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<! DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="<c:url value='/meetbothmember/AdminMember.do' />" >
<input type="text" name="showPhoto" value="${param.account}" required>
<input type="submit" name="submit" id="submit" value="提交"/>
</form>
</body>
</html>