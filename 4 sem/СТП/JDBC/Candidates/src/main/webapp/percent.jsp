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
</head>
<body>
<form action="result.jsp">
    <c:forEach items="${resultArr}" var="item">
        ${item}<br>
    </c:forEach>
    <input type="submit" value="Назад">
</form>
</body>
</html>
