<%@page import="meetbothmember.model.UserLoginData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	String redirect = request.getContextPath();
	String redirectPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + redirect
		+ "/html/MeetBothMember/Login.jsp";
	UserLoginData user = (UserLoginData)session.getAttribute("user");
	if(user == null )
	{
	  response.sendRedirect(redirectPath);
	return;
	} 
%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
		+ "/html/assets/css/main.css";
System.out.println(basePath);
%>
<%
String pathimg = request.getContextPath();
String basePathimg = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + pathimg
		+ "/html/images/meatball-icon.png";
%>
<%
String basePathimg2 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
		+ "/html/images/meatball-200.png";
%>
<! DOCTYPE HTML>
<!--
	Editorial by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>

<head>
	<title>會員管理</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="<%=basePath%>" />
	<link rel="shortcut icon" href="<%=basePathimg%>" />
	<script src="https://kit.fontawesome.com/2688683da7.js" crossorigin="anonymous"></script>
</head>

<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<!-- Header -->
				<header id="header">
					<a href="index.html" class="logo"><strong>會員管理</strong></a>
<!-- 					<ul class="icons"> -->
<!-- 						<li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li> -->
<!-- 						<li><a href="#" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li> -->
<!-- 						<li><a href="#" class="icon brands fa-snapchat-ghost"><span class="label">Snapchat</span></a> -->
<!-- 						</li> -->
<!-- 						<li><a href="#" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li> -->
<!-- 						<li><a href="#" class="icon brands fa-medium-m"><span class="label">Medium</span></a></li> -->
<!-- 					</ul> -->
				</header>

				<!-- Content -->
				<section>
					<header class="main">
						<h3>會員管理列表</h3>
						</header>
						<form method="post" style="width:80%" action="<c:url value='/meetbothmember/SeachMem.do' />">
						<input type="text" name="value" value="${value}" required>
						<input type="submit" name="selectByAccount" value="以帳號查詢"/>
						<input type="submit" name="selectByName" value="以姓名查詢"/>
						</form>
						
						<form method="post" action="<c:url value='/meetbothmember/AdminMember.do' />">
						<button name="register">新增會員</button>
						<button name="selectAll" value="getAllMember">取得所有會員資料</button>
						</form>
						
						<div class="table-wrapper">
								<table class="alt" style="table-layout:fixed;word-wrap:break-word; word-break;break-all;">
									<thead>
										<tr>
											<th>會員編號</th>
											<th>帳號</th>
											<th>密碼</th>
											<th>身分證字號</th>
											<th>姓名</th>
											<th>年齡</th>
											<th>生日</th>
											<th>性別</th>
											<th>電子郵件</th>
											<th>電話號碼</th>
											<th>地址</th>
											<th>註冊時間</th>
											<th>修改</th>
											<th>移除</th>
										</tr>
									</thead>
								<c:forEach var="Member" items="${Member}">
									<tbody>
										<tr>
											<td>${Member.memberID}</td>
     										<td>${Member.account}</td>
         									<td>${Member.password}</td>
         									<td>${Member.idNumber}</td>
     										<td>${Member.memName}</td>
     										<td>${Member.memOld}</td>
     										<td>${Member.memBirth}</td>
     										<td>${Member.memGender}</td>
     										<td>${Member.eMail}</td>
     										<td>${Member.phone}</td>
     										<td>${Member.address}</td>
     										<td>${Member.registime}</td>
     										<td><form method="post" action="<c:url value='/meetbothmember/AdminMember.do' />"><button name="preupdate" value="${Member.memberID}"><i class="fa-solid fa-user"></i></button></form></td>
     										<td><form method="post" action="<c:url value='/meetbothmember/AdminMember.do' />"><button name="delete" value="${Member.memberID}"><i class="fa-solid fa-xmark"></i></button></form></td>
										</tr>
									</tbody>
									</c:forEach>
									</table>
							</div>
					

					


				</section>

			</div>
		</div>

		<!-- Sidebar -->
		<div id="sidebar">
			<div class="inner">

<!-- 				Search -->
<!-- 				<section id="search" class="alt"> -->
<!-- 					<form method="post" action="#"> -->
<!-- 						<input type="text" name="query" id="query" placeholder="Search" /> -->
<!-- 					</form> -->
<!-- 				</section> -->

				<!-- Menu -->
				<nav id="menu">
					<header class="major">
						<h2>
							<img src="<%=basePathimg2%>" alt="" />
						</h2>
					</header>
					<ul>
						<li><a href="<c:url value='/html/index.jsp' />">首頁 <i class="fa-solid fa-house"></i></a></li>
						<li><a href="<c:url value='/html/backIndex.jsp' />">後台管理 <i
								class="fa-solid fa-gears"></i></a></li>
						<li><a href="<c:url value='/html/MeetBothMember/admin.jsp' />">會員資料 <i
								class="fa-solid fa-users-viewfinder"></i></a></li>
						<li><span class="opener">科目地區資料 <i
								class="fa-solid fa-magnifying-glass-location"></i></span>
							<ul>
								<li><a href="<c:url value='/Servlet/subjectSearch' />">科目搜尋</a>
								<li><a href="<c:url value='/locServlet/locationSearch' />">地點搜尋</a>
							</ul></li>
						<li><a href="<c:url value='/web/searchingProd'/>">商品資料 <i
								class="fa-solid fa-store"></i></a></li>
						<li><a
							href="<c:url value='/_04_ShoppingCart/searchAllServlet' />">訂單資料
								<i class="fa-solid fa-cart-shopping"></i>
						</a></li>
						<li><span class="opener">老師學生資料 <i
								class="fa-solid fa-users"></i></span>
							<ul>
								<li><a href="<c:url value='/Servlet/searchAllTeacServlet' />">老師貼文資料</a></li>
								<li><a href="<c:url value='/Servlet/searchAllStudServlet' />">學生貼文資料</a></li>
							</ul></li>
						<li><span class="opener">哈拉區 <i
								class="fa-solid fa-comments"></i></span>
							<ul>
								<li><a href="<c:url value='/halaservlet/crudservlet' />">討論公告區</a></li>
								<li><a href="<c:url value='/qaservlet/qacrud' />">Q&A解答區</a></li>
							</ul></li>
					</ul>
				</nav>
				

				<!-- Section -->
				<section>
					<header class="major">
						<h2>聯絡我們</h2>
					</header>
					<p>肉丸家教網是一個希望不管是學生還是老師，都能在這裡精進自己，花最少的時間，找到最棒的老師/學生。</p>
					<ul class="contact">
						<li class="icon solid fa-envelope"><a href="#">information@untitled.tld</a>
						</li>
						<li class="icon solid fa-phone">(000) 000-0000</li>
						<li class="icon solid fa-home">1234 Somewhere Road #8254<br />
							Nashville, TN 00000-0000
						</li>
					</ul>
				</section>

				<!-- Footer -->
				<footer id="footer">
					<p class="copyright">&copy; Untitled. All rights reserved. Demo Images: <a
							href="https://unsplash.com">Unsplash</a>. Design: <a href="https://html5up.net">HTML5
							UP</a>.</p>
				</footer>

			</div>
		</div>

	</div>

	<!-- Scripts -->

	<%
	String basePath6 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
			+ "/html/assets/js/app.js";
	%>
	
	<%
	String basePath1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
			+ "/html/assets/js/jquery.min.js";
	log(basePath1);
	%>

	<%
	String basePath2 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
			+ "/html/assets/js/browser.min.js";
	%>

	<%
	String basePath3 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
			+ "/html/assets/js/breakpoints.min.js";
	%>

	<%
	String basePath4 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
			+ "/html/assets/js/util.js";
	%>

	<%
	String basePath5 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
			+ "/html/assets/js/main.js";
	%>
	<script src=<%=basePath6%>></script>
	<script src=<%=basePath1%>></script>
	<script src=<%=basePath2%>></script>
	<script src=<%=basePath3%>></script>
	<script src=<%=basePath4%>></script>
	<script src=<%=basePath5%>></script>
	<script src="https://kit.fontawesome.com/25590258af.js"
		crossorigin="anonymous"></script>

</body>

</html>