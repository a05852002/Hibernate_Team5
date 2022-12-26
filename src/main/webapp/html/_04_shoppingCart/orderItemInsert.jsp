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

<!-- 引入共同的頁首 -->
<%-- <%@ include file="/html/backMVC.jsp" %> --%>
<%-- <jsp:include page="/html/backMVC.jsp" flush="true" /> --%>
<!-- <meta charset="UTF-8"> -->
<!-- <title>Insert title here</title> -->
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
<script type="text/javascript">
	function itemTotalChange() {
		itemTotal.value = qty.value * prodPrice.value;
	}
</script>
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
					<header class="main">
						<h2>訂單項目-新增</h2>
					</header>
					<!-- Search -->
					<!-- 					<section id="search" class="alt"> -->
					<!-- 						<form method="post" action="#"> -->
					<!-- 							<input type="text" name="query" id="query" placeholder="Search" /> -->
					<!-- 						</form> -->
					<!-- 					</section> -->
					<!-- Table -->
					<div class="table-wrapper">
						<div id='main'>
							<c:forEach var="bean" items="${classList}">
								<form method="post"
									action="<c:url value='/_04_shoppingCart/InsertOrderItemCheck.do'/>" >
									<label>訂單編號:</label> <input type="text" name="orderNo"
										value="${bean.orderNo}" readonly> <label>產品編號:</label>
									<input type="text" name="prodId" value=""
										placeholder="請填寫編號" required> <label>產品名稱:</label> <input
										type="text" name="prodName" value="" placeholder="請填寫產品名稱"
										required> <label>數量:</label> <input id="qty"
										onblur="itemTotalChange()" type="number" name="qty" value=""
										placeholder="請輸入數量"> <label>單價:</label> <input
										id="prodPrice" onblur="itemTotalChange()" type="number"
										name="prodPrice" value="" placeholder="請填寫金額單價" required>
									<label>優惠折扣</label> <input id="discount" type="text"
										name="discount" value="0" readonly>
									<label>總金額</label> <input id="itemTotal" type="text"
										name="totalAmount" value="0" readonly><label>備註:</label>
									<input type="text" name="remark" value=""
										placeholder="請填寫產品描述" required>

									<div style="display: flex; justify-content: center">
										<!--<a href="<c:url value='/halaservlet/addservlet'/>"><input type="button" value="確定"></a>
							  -->
										<br> <input type="submit" name="submit" id="submit"
											style="margin-right: 10px" value="儲存" /> <input type="reset"
											name="cancel" id="cancel" value="重填">
									</div>
									<div style="display: flex; justify-content: center">
										<a href="<c:url value='/_04_shoppingCart/SelectAll.do' />">
											返回<i class="fa-solid fa-left-long"></i>
										</a>
									</div>
								</form>
							</c:forEach>
						</div>
					</div>

					<!-- 				<form method="post" -->
					<%-- 					action="<c:url value='/_04_ShoppingCart/OrderUpdate.do' />"> --%>
					<%-- 					<button name="orderNo" value="${bean.orderNo}"> --%>
					<!-- 						<i class="fa-solid fa-xmark"></i> -->
					<!-- 					</button> -->
					<!-- 				</form> -->
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
						<li><a href="<c:url value='/html/index.jsp' />">首頁 <i
								class="fa-solid fa-house"></i></a></li>
						<li><a href="<c:url value='/html/backIndex.jsp' />">後台管理
								<i class="fa-solid fa-gears"></i>
						</a></li>
						<li><a
							href="<c:url value='/html/MeetBothMember/admin.jsp' />">會員資料
								<i class="fa-solid fa-users-viewfinder"></i>
						</a></li>
						<li><span class="opener">科目地區資料 <i
								class="fa-solid fa-magnifying-glass-location"></i></span>
							<ul>
								<li><a href="<c:url value='/Servlet/subjectSearch' />">科目搜尋</a>
								<li><a href="<c:url value='/locServlet/locationSearch' />">地點搜尋</a>
							</ul></li>
						<li><a href="<c:url value='/web/searchingProd'/>">商品資料 <i
								class="fa-solid fa-store"></i></a></li>
						<li><a
							href="<c:url value='/_04_shoppingCart/SelectAll.do' />">訂單資料
								<i class="fa-solid fa-cart-shopping"></i>
						</a></li>
						<li><span class="opener">老師學生資料 <i
								class="fa-solid fa-users"></i></span>
							<ul>
								<li><a
									href="<c:url value='/Servlet/searchAllTeacServlet' />">老師貼文資料</a></li>
								<li><a
									href="<c:url value='/Servlet/searchAllStudServlet' />">學生貼文資料</a></li>
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