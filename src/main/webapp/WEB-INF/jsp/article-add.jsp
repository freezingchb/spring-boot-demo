<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加文章</title>
    <meta charset="UTF-8">
    <script src="http://th.e-lagou.com/js/vendor/jquery.min.js"></script>
</head>
<body>
<form id="data-form" action="" onsubmit="return false;">
    标题：<input type="text" name="title"><br>
    内容：<textarea name="content" cols="30" rows="10"></textarea><br>
    <input type="button" id="save" value="保存">
</form>
<script>
    $('#save').click(function () {
        $.post('/article/addData', $('#data-form').serialize(), function (res) {
            alert(res.info);
            if (res.status === 1) {
                location.href='/article/index';
            }
        }, 'json');
    });
</script>
</body>
</html>