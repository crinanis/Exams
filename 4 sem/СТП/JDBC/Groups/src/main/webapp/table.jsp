<%--
  Created by IntelliJ IDEA.
  User: budan
  Date: 26.06.2022
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        form {
            display: inline-block;
            margin-right: 70px;
        }
        table {
            border: 1px solid black;
            border-collapse: collapse;
            min-width: 300px;
            background: #92eeff;
            text-align: center;
        }
    </style>
</head>
<body>
<table border="1">
    <tr>
        <th>Group</th><th>Name</th>
    </tr>
    <c:set var="CommonSum" value="${0}" />
    <c:set var="show" value="${0}" />
    <c:forEach var="table" items="${tables}">
        <tr>
            <td>${table.groups}</td>
            <td>${table.fullname}</td>
            <c:set var="CommonSum" value="${CommonSum+1}"/>
        </tr>
    </c:forEach>
</table>
${CommonSum}
</body>
</html>
