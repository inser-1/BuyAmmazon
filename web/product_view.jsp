<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊 - 产品显示</title>
<link href="${pageContext.request.contextPath}/css/index.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/adv.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/adv.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/function.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/index.js"></script>
<script type="text/javascript"
		src="${pageContext.request.contextPath}/scripts/product_view.js"></script>
</head>
<body>
	<%@ include file="index_top.jsp"%>
	<div id="position" class="wrap">
		您现在的位置：<a href="index.jsp">亚马逊</a> &gt; <a href=""></a> &gt; <a
			href=""></a>
	</div>
	<div id="main" class="wrap">
		<div class="lefter">
			<%@ include file="index_product_sort.jsp"%>
		</div>
		<div id="product" class="main">
			<h1>商品名称:</h1>
			<div class="infos" >
				<div class="thumb">
				<img src=${Product.imgSource}>
				</div>
				<div class="buy">
					<p>
						商城价：<span class="price">￥${Product.price}</span>
					</p>
					<c:if test="${Product.stock == 0}">
					<p>
						库 存：无货
					</p>
					</c:if>

					<c:if test="${Product.stock != 0}">
					<p>
						<%--session方法获取购物车--%>
						<%--method=addProductCart--%>
						<form id="myForm" action="${pageContext.request.contextPath}/ShopCartServlet?method=addCart" method="post">
						库 存：(有货) <span id="stock">${Product.stock}</span>
						<input type="button" id="minus" value=" - " onclick="minus()" width="3px">

						<input type="text" id="count" name="count" value="1" maxlength="5" size="1" style="text-align: center; vertical-align: middle">
						<input type="hidden" name="pid" value="${Product.id}">
						<input type="hidden" name="uid" value="${login.uid}">

						<input type="button" id="add" value=" + " onclick="add()" width="2px">
					<div class="button">
						<c:if test="${empty login}">
							<script>
                                alert("请登录")
							</script>
						</c:if>
						<c:if test="${not empty login}">
							<input type="button" id="btn" name="button" value="" style="background: url(images/buyNow.png)" />
							<input type="image" name="imageField" src="images/cartbutton.png" />
						</c:if>
					</div>
					</form>
					</c:if>
				</div>
				<div class="clear"></div>
			</div>
			<div class="introduce">
				<h2>
					<strong>商品详情</strong>
				</h2>
				<div class="text" >
					<ul id = "li1"></ul>
					商品名字：${Product.name}<br />
					商品描述：${Product.description}<br />
					商品价格：￥${Product.price}<br />
					商品库存：${Product.stock}<br />
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2018 上海海文 All Rights Reserved.
	</div>
</body>
<script>
    $(function(){
        $("#btn").click(function(){
            var formObj=document.getElementById("myForm");
            formObj.action="${pageContext.request.contextPath}/UserServlet?method=registView";
            formObj.method="post";
            formObj.submit();
        });
    });
</script>
</html>


