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
					<h1 class="logo">
						<strong>管理者介面</strong>
					</h1>
				</header>

				<!-- Content -->
				<section>
					<div>
						<a href="<c:url value='/web/searchingProd'/>"> <input
							type="button" value="查看全部商品">
						</a>
					</div>
					<hr>
					<div>
						<form action="<c:url value='/searchWithCondi'/>" method="post">
							<table>
								<thead>
									<tr>
										<th style="width: 20%"><em>排序方式 :</em></th>
										<th style="width: 15%"><em>產品類別 :</em></th>
										<th style="width: 10%"><em>最低價格:</em></th>
										<th style="width: 10%"><em>最高價格:</em></th>
										<th style="width: 35%"><em>名稱搜尋:</em></th>
										<th style="width: 10%"></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><select name="case">
												<option value="1">預設</option>
												<option value="2">依價格由大到小</option>
												<option value="3">依價格由小到大</option>
												<option value="4">依上架日期排序</option>
												<option value="5">依更新日期排序</option>
										</select></td>
										<td><select name="typecase">
												<option value="*">全部</option>
												<option value="1">文具</option>
												<option value="2">書籍資料</option>
												<option value="3">線上課程</option>
										</select></td>
										<td><input type="number" name="lowprice"
											style="width: 100px" value="0"></td>
										<td><input type="number" name="highprice"
											style="width: 100px" value="999999"></td>
										<td><input type="text" name="searchName" value=""></td>
										<td><input type="submit" value="搜尋" name="subOrder"></td>
									</tr>
								</tbody>
							</table>
						</form>
					</div>
					<br>
					<div>
						<a href="<c:url value='/_03_product/addNewProduct.jsp'/>"> <input
							type="button" value="新增商品">
						</a>
					</div>
					<br>
					<div class="table-wrapper">

						<table class="alt">
							<thead>
								<tr>
									<th>商品類別編號</th>
									<th>商品編號</th>
									<th>商品名稱</th>
									<th>商品價格</th>
									<th>賣家會員編號</th>
									<th>庫存</th>
									<th>上架日期</th>
									<th>商品上次更新時間</th>
									<th>商品照片</th>
								</tr>
							</thead>
							<c:forEach var="bean" items="${allprodlist}">
								<tbody>
									<tr>
										<td>${bean.prodtype.prodClass}</td>
										<td>${bean.prodtype.prodClassName}</td>
										<td>${bean.prodID}</td>
										<td>${bean.prodName}</td>
										<td>${bean.prodPrice}</td>
										<td>${bean.memberID}</td>
										<td>${bean.inventory}</td>
										<td>${bean.prodPost}</td>
										<td>${bean.prodUpdate}</td>
										<td><img height='100' width='80'
											src="<c:url value='/Servlet/prodpicsave?id=${bean.prodID}' />"></td>
										<td><a
											href="<c:url value='/searchProdByprodID?id=${bean.prodID} '/>"><input
												type="button" value="修改"></a> <a
											href="<c:url value='/deleteProdByID?id=${bean.prodID} '/>"><input
												type="button" value="刪除"></a></td>
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
</body>
</html>
