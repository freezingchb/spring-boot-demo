<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <a href="/article/add">+添加</a>
</div>
    <table>
        <tr>
            <th>ID</th>
            <th>uid</th>
            <th>图片</th>
            <th>标题</th>
            <th>内容</th>
            <th>创建时间</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${articles}" var="row">
            <tr>
                <td>${row.id}</td>
                <td>${row.uid}</td>
                <td>
                    <c:if test="${row.pic != null && row.pic != ''}">
                        <img src=${row.pic} alt="配图">
                    </c:if>
                </td>
                <td>${row.title}</td>
                <td>${row.content}</td>
                <td>${row.created_at}</td>
                <td>
                    <a href="/article/edit?id=${row.id}">修改</a>
                    <a href="/article/del?id=${row.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>