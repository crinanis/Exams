<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.06.2021
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <form action="${pageContext.request.contextPath}/controller">
            <input type="password" name="pass"/>
            <p>
                <input type="radio" name="role" value="user"/> user<br/>
                <input type="radio" name="role" value="admin"/> admin<br/>
            </p>
            <input type="submit" name="submit"/>
        </form>
    </div>
</body>
</html>
