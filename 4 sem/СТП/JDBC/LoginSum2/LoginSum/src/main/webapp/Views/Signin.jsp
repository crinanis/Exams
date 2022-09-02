<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 20.06.2021
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <form action="${pageContext.request.contextPath}/signin">
            <input type="text" name="login"/>
            <input type="submit" value="SIGNIN"/>
        </form>
    </div>
</body>
</html>
