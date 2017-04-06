<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path=request.getContextPath();
pageContext.setAttribute("path",path);
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <!-- bootstrap 不支持IE的兼容模型，让IE运行最新的渲染模式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- 控制移动端浏览器视口的大小和缩放 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签必须放在最前面，任何其他内容都必须跟随其后！ -->
    <title>产品列表</title>
    <!-- Bootstrap -->
    <link href="${path }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .product-box{
            margin-top: 20px;
            margin-bottom: 20px;
            border: 1px solid silver;
        }
        .product-border{

            margin: 20px 0px;
        }
        .product-right-border{
            border-right: 1px solid silver;
        }
        .product-desc{
            font-size: 16px;
            color: #666;
            margin-top: 10px;
        }

        .product-price{
            font-size: 18px;
            color:#c61822;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="container product-box">
    <div class="row">
    <s:iterator var="item" value="productList" status="sta">
    <s:if test="#sta.count%4==0">
       <div class="col-md-3 product-border">
    </s:if>
    <s:else>
       <div class="col-md-3 product-border product-right-border">
    </s:else>
        <div class="row">
            <div class="col-md-12">
		<img width="180" height="180" src="/image/${item.img }"><!-- 如果访问的是本地文件,那么需要虚拟一个目录出来,把资源放在image目录下,数据库就存文件名src="/image/${item.img}" -->
	    </div>
        </div>
        <div class="row">
            <div class="col-md-12 product-desc"><s:property value="#item.productDesc"/></div>
        </div>
        <div class="row">
            <div class="col-md-12 product-price">¥<s:property value="#item.price"/></div>
        </div>
    </div>
    </s:iterator>
    
    </div>
    

</div>
<!--  jQuery文件。务必在bootstrap.min.js 之前引入  -->
<script src="${path }/bootstrap/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${path }/bootstrap/js/bootstrap.min.js"></script>
</body>
<script>
    <!-- 编写脚本 -->
</script>
</html>