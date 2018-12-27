
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	double num = Math.random();
%>
<script type="text/javascript">
    function tips(uid) {
		location.href="${pageContext.request.contextPath}/ShopCartServlet?method=comeMyCart&uid="+uid;
    }
</script>
<div id="header">
	<div class="login_menu">
		<div class="login_container">

			<ul class="m_left">
				<c:if test="${empty login}">
				<li><a href="${pageContext.request.contextPath}/UserServlet?method=loginView" class="c_red">请登录</a>&nbsp;&nbsp;&nbsp;</li>
				<li><a href="${pageContext.request.contextPath}/UserServlet?method=registView">请注册</a></li>
				</c:if>
				<c:if test="${not empty login}">
				<li>欢迎${login.username}</li>
				<li><a href="${pageContext.request.contextPath}/UserServlet?method=exit">退出</a></li>
				</c:if>
				</ul>

			<ul class="m_right">
				<c:if test="${not empty login}">
				<li><img src="images/icon_3.png"><a
					href="javascript:tips('${login.uid}')" class="c_red">购物车</a></li>
				<li><img src="images/icon_4.png"><a
					href="javascript:AddFavorite('我的网站',location.href)">收藏</a></li>
				</c:if>
				<li><img src="images/icon_2.png"><a href="guestbook.jsp">留言</a></li>
				<li><img src="images/icon_1.png"><a href="index.jsp">首页</a></li>
			</ul>
		</div>
	</div>
	<div class="logo_search">
		<div class="logo">
			<img src="images/LOGO.png">
		</div>
		<div class="search">
			<input type="text" placeholder="输入宝贝" id="qname" />
			<button class="query_button" onclick="">搜索</button>
		</div>
	</div>
	<div class="nav_bar">
		<div class="nav_bar_container" >
			<ul id = "cateul">
				<li><a href="index.jsp">首页</a></li>
				<%--<c:forEach items="${allCates}" var = "c">
				<li><a href="#">${c.name}</a></li>
				</c:forEach>--%>
			</ul>
		</div>
	</div>
</div>
<script>
	$(function () {
		var url="/CategoryServlet";
		var obj = {"method":"findAllCates"}
		$.post(url,obj,function (data){
		    $.each(data,function (i,obj) {
                var li =  "<li><a href='${pageContext.request.contextPath}/ProductSortServlet?method=findAllProductByIdPage&num=1&pid="+obj.id+"'>"+obj.name+"</a><li>";
            	$("#cateul").append(li);
		    })
		},"json");
    })
</script>