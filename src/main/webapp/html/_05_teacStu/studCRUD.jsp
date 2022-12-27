<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<! DOCTYPE html>
<html>
<head>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
		+ "/html/assets/css/main.css";
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
<title>肉丸家教網 MEET BOTH</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />

<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="robots" content="index,follow" />
<meta name="description" content="全台最優質最快速方便的家教網" />
<meta name="author" content="EEIT56-MEETBOTH" />
<meta name="keywords" content="最棒最優質的家教網" />
<meta name="copyright" content="肉丸家教網" />
<link rel="shortcut icon" href="<%=basePathimg%>" />
<link rel="bookmark" href="<%=basePathimg%>" />
<link rel="stylesheet" href="<%=basePath%>" />
</head>
<body class="is-preload">
	<!-- Wrapper -->
	<div id="wrapper">

		<div id="main">
			<div class="inner">
				<!-- Header -->
				<header id="header">
					<a href="/html/backIndex.jsp" class="logo"><strong>後台管理系統</strong></a>
				</header>


				<!-- Content -->
				<section>
					<header class="main">
						<h1 style="font-size:30px">學生貼文CRUD</h1>
						<input type="button" value="新增" onclick="location.href='http://localhost:8080/Hibernate_Team5/html/_05_teacStu/insertpagestud.jsp'">
					</header>
						<form method="post" action="<c:url value='/_05_teacStu/searchLikeStud' />">
							<input type="text" name="search" id="search" placeholder="Search" style="width:80%" />
						</form>
						<br>
						<div>
						<form method="post" action="<c:url value='/_05_teacStu/switchsequenceStud' />">
						<h3>請選擇排列方式</h3>
						<select name="case"  onchange="this.form.submit()" style="width:80%">
						<option value="">--請選擇排序方式--</option>
						<option value="1">依會員編號排序</option>
						<option value="2">依日期排序</option>
						<option value="3">依價格排序</option>
						</select>
						</form>
						</div>
						<div>
						<form method="post" action="<c:url value='/_05_teacStu/searchallStudbyprice' />">
						<table style="width:80%">
						<thead>
						<tr>
						<th>請輸入查詢的時薪區間:</th>
						<th><input name="low" type="text" value="最低時薪" onfocus="javascript:if(this.value=='最低時薪')this.value='';"></th>
						<th>至</th>
						<th><input name="high" type="text" value="最高時薪" onfocus="javascript:if(this.value=='最高時薪')this.value='';"></th>
						<th><input type="submit" value="搜尋"></th>
						</tr>
						</thead>
						</table>
						</form>
						</div>
							<div class="table-wrapper">
								<table class="alt" style="width:80%">
									<thead>
										<tr>
											<th>學生貼文編號</th>
											<th>會員編號</th>
											<th>貼文標題</th>
											<th>貼文日期</th>
											<th>文章內容</th>
											<th>希望聘請時薪</th>
											<th>科目</th>
											<th>學習地點</th>
											<th>圖片</th>
											<th>修改</th>
											<th>刪除</th>
										</tr>
									</thead>
								<c:forEach var="bean" items="${classList}">
									<tbody>
										<tr>
											<td>${bean.studno}</td>
     										<td>${bean.memberId}</td>
         									<td>${bean.title}</td>
         									<td>${bean.postDate}</td>
     										<td>${bean.detail}</td>
     										<td>${bean.price}</td>
     										<td>${bean.subjectItem}</td>
     										<td>${bean.learnLoc}</td>
     										<td><img height='100' width='80'src="<c:url value='/_05_teacStu/picsaveStud?id=${bean.studno}' />"></td>
     										<td><input type="button" value="修改" onclick="location.href='http://localhost:8080/Hibernate_Team5/_05_teacStu/datasaveStud?studno=${bean.studno}'"></td>
     										<td><form method="post" action="<c:url value='/_05_teacStu/deletedataStud'/>"> <button name="studno" value="${bean.studno}">刪除</button></form></td>
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

				<!-- Search -->
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
					<p class="copyright">
						&copy; Untitled. All rights reserved. Demo Images: <a
							href="https://unsplash.com">Unsplash</a>. Design: <a
							href="https://html5up.net">HTML5 UP</a>.
					</p>
				</footer>
			</div>
		</div>
	</div>

	<!-- Scripts -->

	<%
	String basePath1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
			+ "/html/assets/js/jquery.min.js";
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
	<script src=<%=basePath1%>></script>
	<script src=<%=basePath2%>></script>
	<script src=<%=basePath3%>></script>
	<script src=<%=basePath4%>></script>
	<script src=<%=basePath5%>></script>
	<script src="https://kit.fontawesome.com/25590258af.js"
		crossorigin="anonymous"></script>
</body>
</html>