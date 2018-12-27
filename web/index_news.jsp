<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
.news-list ul li {
	list-style:none;
}
</style>
<div class="newsList">
	<h2>新闻动态</h2>
	<ul id="getNews">
	</ul>
</div>
<script>
    $(function () {
        var url="/NewsServlet";
        var obj = {"method":"getNews"}
        $.post(url,obj,function (data){
            $.each(data,function (i,obj) {
                var li =  "<li><a href='#'>"+obj.title+"</a><li>";
                $("#getNews").append(li);
            })
        },"json");
    })
</script>
