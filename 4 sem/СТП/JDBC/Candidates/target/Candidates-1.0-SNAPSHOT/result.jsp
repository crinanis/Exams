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
    <title>Result jsp</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/go" method="get">
    <c:forEach items="${Candidates}" var="item">
        <input type="radio" name="checkboxes" value="${item.last_name}">${item.last_name}<br>
    </c:forEach>
    <input type="submit" value="Go">
</form>
</body>
</html>

