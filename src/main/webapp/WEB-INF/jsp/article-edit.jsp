<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加文章</title>
    <meta charset="UTF-8">
    <script src="http://th.e-lagou.com/js/vendor/jquery.min.js"></script>
</head>
<body>
<form id="data-form" action="/article/editData" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value=${row.id}>
    标题：<input type="text" name="title" value="${row.title}"><br>
    封面图：<input type="file" name="picture"><br>
    内容：<textarea name="content" cols="30" rows="10">${row.content}</textarea><br>
    <input type="submit" id="save" value="保存">
</form>
</body>
</html>
