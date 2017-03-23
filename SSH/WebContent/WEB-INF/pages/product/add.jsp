<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path=request.getContextPath();
pageContext.setAttribute("path",path);
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <!-- bootstrap 不支持IE的兼容模型，让IE运行最新的渲染模式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- 控制移动端浏览器视口的大小和缩放 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签必须放在最前面，任何其他内容都必须跟随其后！ -->
    <title>添加产品</title>

    <!-- Bootstrap -->
    <link href="${path }/bootstrap/css/bootstrap.min.css" rel="stylesheet">


</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form" action="doAddProduct.action" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="productdesc">产品描述</label><input type="text" class="form-control" name="productDesc" id="productdesc" />
                </div>
                <div class="form-group">
                    <label for="price">价格</label><input type="number" class="form-control" name="price" id="price" />
                </div>
                <div class="form-group">
                    <label for="img">图片</label><input type="file" id="img" name="uploadimg" />
                </div>
                 <button type="submit" class="btn btn-primary">提交</button>
            </form>
        </div>
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