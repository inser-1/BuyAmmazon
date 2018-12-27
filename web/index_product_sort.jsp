<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="p_category">
    <h2>商品分类</h2>
    <dl id="cateul2">

    </dl>
</div>
<script>
    $(function () {
        var url="/CategoryServlet";
        var obj = {"method":"findAllCates"}
        $.post(url,obj,function (data){
            var id = null;
            $.each(data,function (i,obj) {
                if (obj.id == obj.parent_id){
                    id = obj.id;
                    var li =  "<dt><a href='${pageContext.request.contextPath}/ProductSortServlet?method=findAllProductByIdPage&num=1&pid="+obj.id+"'>"+obj.name+"</a><dt>";
                    $("#cateul2").append(li);
                $.each(data,function (i,obj){
                    if (id == obj.parent_id && obj.id != obj.parent_id) {
                        var li =  "<dd><a href='${pageContext.request.contextPath}/ProductSortServlet?method=findAllProductByIdPage&num=1&pid="+obj.id+"'>"+obj.name+"</a><dd>";
                        $("#cateul2").append(li);
                    }
                })}
            })
        },"json");
    })
</script>
