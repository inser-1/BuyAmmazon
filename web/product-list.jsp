<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊 - 产品列表</title>
	<link href="${pageContext.request.contextPath}/css/index.css"
		  rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/css/style.css"
		  rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/css/adv.css"
		  rel="stylesheet" type="text/css" />
	<script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js"
			type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/scripts/adv.js"
			type="text/javascript"></script>
	<script type="text/javascript"
			src="${pageContext.request.contextPath}/scripts/function.js"></script>
	<script type="text/javascript"
			src="${pageContext.request.contextPath}/scripts/index.js"></script>

</head>
<body>
	<%@ include file="index_top.jsp"%>

	<div id="main" class="wrap">
		<div class="lefter">
			<%@ include file="index_product_sort.jsp"%>
			<div class="spacer"></div>
			<div class="last-view">
				<h2>最近浏览</h2>
				<dl class="clearfix">

					<dt>
						<img style="width: 54px; height: 54px;" src="images/product/0.jpg" />
					</dt>
					<dd>
						<a href="#">商品名称</a>
					</dd>

					
						<%--<c:forEach items="" var="p">
							<dt>
								<img style="width: 54px; height: 54px;" src="" />
							</dt>
							<dd>
								<a href=""></a>
							</dd>
						</c:forEach>--%>
				

				</dl>
			</div>
		</div>
		<div class="main">
			<div class="product-list">
				<h2>全部商品</h2>
				<div class="clear"></div>
				<p id="a"></p>
				<ul class="product clearfix" id="product" >
					<%--<c:forEach items="${ProductList}" var="p">
						<li>
						<dl><dt>
								<a href="${pageContext.request.contextPath}/ProductViewServlet?method=findProductById&pid=${p.id}"><img style="width: 170px; height: 170px;" src="${p.imgSource}" /></a>
							</dt>
							<dd>
								<a href=${pageContext.request.contextPath}/ProductViewServlet?method=findProductById&pid=${p.id}">${p.name}</a>
							</dd>
							<dd>
								<a href="${pageContext.request.contextPath}/ProductViewServlet?method=findProductById&pid=${p.id}">￥${p.price}</a>
							</dd></dl></li>
					</c:forEach>--%>
					<c:if test="${empty page.list}">
						<li>
							<dl><dt>
								<h1>无商品</h1>
							</dt>
							 	</dl></li>
					</c:if>
					<c:if test="${not empty page.list}">
						<c:forEach items="${page.list}" var="p">
							<li>
								<dl><dt>
									<a href="${pageContext.request.contextPath}/ProductViewServlet?method=findProductById&pid=${p.id}"><img style="width: 170px; height: 170px;" src="${p.imgSource}" /></a>
								</dt>
									<dd>
										<a href=${pageContext.request.contextPath}/ProductViewServlet?method=findProductById&pid=${p.id}">${p.name}</a>
									</dd>
									<dd>
										<a href="${pageContext.request.contextPath}/ProductViewServlet?method=findProductById&pid=${p.id}">￥${p.price}</a>
									</dd></dl></li>
						</c:forEach>
					</c:if>
				</ul>
				<div class="clear"></div>
				<div style="text-align:center">
					共${page.totalPageNum}页/第${page.currentPageNum}页


					<!-- <a href="/store_v5/ProductServlet?method=findProductsByCidWithPage&cid=1&num=1">首页</a> -->

					<a href="${pageContext.request.contextPath}/${page.url}&num=1">首页</a>
					<a href="${pageContext.request.contextPath}/${page.url}&num=${page.prePageNum}">上一页</a>
					<%--显示的页码，使用forEach遍历显示的页面 --%>
					<c:forEach begin="${page.startPage}" end="${page.endPage}" var="pagenum">
						<a href="${pageContext.request.contextPath}/${page.url}&num=${pagenum}">${pagenum}</a>
					</c:forEach>

					<a href="${pageContext.request.contextPath}/${page.url}&num=${page.nextPageNum}">下一页</a>
					<a href="${pageContext.request.contextPath}/${page.url}&num=${page.totalPageNum}">末页</a>
					<input type="text" id="pagenum" name="pagenum" size="1"/><input type="button" value="前往" onclick="jump()" />
					<script type="text/javascript">
                        function jump(){
                            var totalpage = ${page.totalPageNum};
                            var pagenum = document.getElementById("pagenum").value;
                            //判断输入的是一个数字
                            var reg =/^[1-9][0-9]{0,1}$/;
                            if(!reg.test(pagenum)){
                                //不是一个有效数字
                                alert("请输入符合规定的数字");
                                return ;
                            }
                            //判断输入的数字不能大于总页数
                            if(parseInt(pagenum)>parseInt(totalpage)){
                                //超过了总页数
                                alert("不能大于总页数");
                                return;
                            }
                            //转向分页显示的Servlet
                            window.location.href="${pageContext.request.contextPath}/${page.url}&num="+pagenum;
                        }
					</script>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2018 上海海文 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>

