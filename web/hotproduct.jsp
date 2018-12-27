<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="hot_sale">
	<h2>热卖推荐</h2>
	<ul id="hot">
	</ul>
</div>
<script>
    $(function () {
        var url="/HotProductServlet";
        var obj = {"method":"getHotProduct"}
        $.post(url,obj,function (data){
            $.each(data,function (i,obj) {
                var li =  "<li><dl><dt><a href='"+"${pageContext.request.contextPath}/ProductViewServlet?method=findProductById&pid="+obj.id+ "'target='_self'><img src="+obj.imgSource+" /></a><dt>" +
					"<dd class='p_name'><a href='"+"${pageContext.request.contextPath}/ProductViewServlet?method=findProductById&pid="+obj.id+"' target='_self'>"+obj.name+"</a></dd>" +
					"<dd class='price'>￥"+obj.price+"</dd></dl></li>";
                $("#hot").append(li);

            })
        },"json");
    })
</script>
