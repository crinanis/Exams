<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 20.06.2021
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <form action="${pageContext.request.contextPath}/action">
            <input type="text" name="value"/>
            <input type="hidden" name="id" value="${id}">
            <input type="hidden" name="sum" value="${sum}">
            <input type="submit" name="action" value="getinfo"/>
            <input type="submit" name="action" value="add"/>
            <input type="submit" name="action" value="pay"/>
        </form>
    </div>
</body>
</html>
