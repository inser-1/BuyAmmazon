<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊 - 订单页</title>
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
<script type="text/javascript" src="scripts/shopping.js"></script>
<style type="text/css">
#oderview {
	font-size: 14px
}
</style>

</head>
<body>
	<%@ include file="index_top.jsp"%>

	<div id="position" class="wrap">
		您现在的位置：<a href="index.jsp">亚马逊</a> &gt; 最新订单
	</div>
	<div class="wrap">
		<div id="shopping">
			<form action="doBuy" method="post">
				<table id="oderview">
					<tr>
						<th>订单时间:</th>
						<th>订单号:</th>
						<th>订单总额:</th>
						<th>
						<th>
					</tr>
					<!-- 根据用户购物车生成列表 -->
					<tr id="product_id_1">
						<td class="thumb"><img style="width: 100px; height: 100px;"
							src="" /><a href=""></a></td>
						<td class="price">￥<span>单价：</span>
						</td>
						<td class="number"><span>X</span></td>
						<td class="delete">正在发货</td>

					</tr>
				</table>
			</form>
		</div>
	</div>
	<div id="footer">Copyright &copy; 2018 上海海文 All Rights Reserved.
	</div>
</body>
</html>

