<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="myshortname" uri="http://mycompany.com" %>

<!DOCTYPE html>
<html>
<head>
    <title>FuncTag</title>
</head>
<body>
<div>
        <p><c:out value="${myshortname:check({String.valueOf(pageContext.request.remoteAddr)})}"/></p>
        <p><c:out value="${myshortname:check({String.valueOf(pageContext.servletContext.serverInfo)})}"/></p>
        <p><c:out value="${myshortname:check({String.valueOf(pageContext.request.protocol)})}"/></p>
</div>
</body>
</html>