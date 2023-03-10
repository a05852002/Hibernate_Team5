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
<%
String basePathimg3 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
		+ "/html/index.jsp";
%>
<%
String basePathimg4 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
		+ "/html/backIndex.jsp";
%>
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
<%
String basePath6 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
		+ "/html/addhala.jsp";
%>
<%
String basePath8 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
		+ "/html/updateHala.jsp";
%>
<!-- ????????????????????? -->
<%-- <%@ include file="/html/backMVC.jsp" %> --%>
<%-- <jsp:include page="/html/backMVC.jsp" flush="true" /> --%>
<!-- <meta charset="UTF-8"> -->
<!-- <title>Insert title here</title> -->
<title>??????????????? MEET BOTH</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />

<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="robots" content="index,follow" />
<meta name="description" content="??????????????????????????????????????????" />
<meta name="author" content="EEIT56-MEETBOTH" />
<meta name="keywords" content="???????????????????????????" />
<meta name="copyright" content="???????????????" />
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
					<h1 class="logo">
						<strong>???????????????</strong>
					</h1>
				</header>

				<!-- Content -->
				<section>
					<header class="main">
						<h1>????????????</h1>
						<div>
							<input type="button" value="????????????"
								onclick="location.href='<%=basePath6%>'">
						</div>
					</header>
					<header>
						<h4>????????????</h4>
						<form action="<c:url value='/findNameServlet'/>" method="post">
							<select name="halaclassname" style="width: 40%">
								<option value="??????">??????</option>
								<option value="????????????">????????????</option>
								<option value="????????????">????????????</option>
								<option value="????????????">????????????</option>
								<option value="????????????">????????????</option>
								<option value="??????">??????</option>
							</select> <br> <input type="submit">
						</form>
					</header>
					<br>
					<div class="table-wrapper">
						<table class="alt">
							<thead>
								<tr>
									<th>????????????</th>
									<th>????????????</th>
									<th>????????????</th>
									<th>????????????</th>
									<th>????????????</th>
									<th>????????????</th>
									<th width=80px>??????</th>
									<th width=80xp>??????</th>
								</tr>
							</thead>
							<c:forEach var="bean" items="${classList}">
								<tbody>
									<tr>
										<td>${bean.halaID}</td>
										<td>${bean.halaClassName}</td>
										<td>${bean.memberId}</td>
										<td>${bean.title}</td>
										<td>${bean.postDate}</td>
										<td>${bean.halaContent}</td>
										<td>
											<form method="post"
												action="<c:url value='/save?halaID=${bean.halaID}'/>">
												<input type="submit" value="??????">
											</form>
										</td>
										<td><form method="post"
												action="<c:url value='/deleteServlet'/>">
												<button name="halaID" value="${bean.halaID}">??????</button>
											</form></td>
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
						<li><a href="<c:url value='/html/index.jsp' />">?????? <i class="fa-solid fa-house"></i></a></li>
						<li><a href="<c:url value='/html/backIndex.jsp' />">???????????? <i
								class="fa-solid fa-gears"></i></a></li>
						<li><a href="<c:url value='/html/MeetBothMember/admin.jsp' />">???????????? <i
								class="fa-solid fa-users-viewfinder"></i></a></li>
						<li><span class="opener">?????????????????? <i
								class="fa-solid fa-magnifying-glass-location"></i></span>
							<ul>
								<li><a href="<c:url value='/Servlet/subjectSearch' />">????????????</a>
								<li><a href="<c:url value='/locServlet/locationSearch' />">????????????</a>
							</ul></li>
						<li><a href="<c:url value='/web/searchingProd'/>">???????????? <i
								class="fa-solid fa-store"></i></a></li>
						<li><a
							href="<c:url value='/_04_ShoppingCart/searchAllServlet' />">????????????
								<i class="fa-solid fa-cart-shopping"></i>
						</a></li>
						<li><span class="opener">?????????????????? <i
								class="fa-solid fa-users"></i></span>
							<ul>
								<li><a href="<c:url value='/Servlet/searchAllTeacServlet' />">??????????????????</a></li>
								<li><a href="<c:url value='/Servlet/searchAllStudServlet' />">??????????????????</a></li>
							</ul></li>
						<li><span class="opener">????????? <i
								class="fa-solid fa-comments"></i></span>
							<ul>
								<li><a href="<c:url value='/halaservlet/crudservlet' />">???????????????</a></li>
								<li><a href="<c:url value='/qaservlet/qacrud' />">Q&A?????????</a></li>
							</ul></li>
					</ul>
				</nav>


				<!-- Section -->
				<section>
					<header class="major">
						<h2>????????????</h2>
					</header>
					<p>????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????/?????????</p>
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

	<script src=<%=basePath1%>></script>
	<script src=<%=basePath2%>></script>
	<script src=<%=basePath3%>></script>
	<script src=<%=basePath4%>></script>
	<script src=<%=basePath5%>></script>
	<script src="https://kit.fontawesome.com/25590258af.js"
		crossorigin="anonymous"></script>
</body>
</html>