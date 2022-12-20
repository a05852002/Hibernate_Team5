<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<! DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab02_01</title>
</head>
<body>
<h1>訂單 ${ orderBean.orderNo } 的資料新增成功</h1>
<h1>訂單 會員編號<c:out value='${ orderBean.memberId}'/> 的資料新增成功</h1>
會員編號: ${ orderBean.memberId }<br>
訂單地址: ${ orderBean.shippingAddress}<br>
訂單日期: ${ orderBean.orderDate }<br>
金額: ${  orderBean.totalAmount }<br>
<p>
<hr>
==>> ${Case3.mapkey1} <br>
==>> ${errorMSG.NameError}
<h1>訂單 ${ orderBean.orderNo } 的資料新增成功</h1>
<h1>訂單 會員編號<c:out value='${ orderBean.memberId}'/> 的資料新增成功</h1>
會員編號: ${ orderBean.memberId }<br>
訂單地址: ${ orderBean.shippingAddress}<br>
訂單日期: ${ orderBean.orderDate }<br>
金額: ${  orderBean.totalAmount }<br>
<p>
<hr>

<hr>
<h1>會員-3 ${errorMSG.mapkey2.name} 的資料新增成功</h1>
編號: ${errorMSG.mapkey2.memberId}  <br>
手機: ${errorMSG.mapkey2.phone}  <br>
生日: ${errorMSG.mapkey2.birthday}  <br>
註冊時間: ${errorMSG.mapkey2.registerDate}  <br>
體重: ${errorMSG.mapkey2.weight}  <br>
<p>
<a href="<c:url value='/' />" >回首頁</a>
</body>
</html>