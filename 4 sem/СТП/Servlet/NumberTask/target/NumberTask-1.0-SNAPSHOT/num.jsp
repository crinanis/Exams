<%--
  Created by IntelliJ IDEA.
  User: budan
  Date: 25.06.2022
  Time: 01:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Work</title>
</head>
<body>
<div>
  <h3>${number}</h3>
  <h3>${error}</h3>
  <div>

    <div>
      <form method="get" ACTION="number">
        <input type="submit" name="command" value="<">
        <input type="submit" name="command" value="=">
        <input type="submit" name="command" value=">">
      </form>
    </div>
  </div>
  Количество попыток ${ count }
  <br>
  <c:choose>
    <c:when test="${ oldcount > 0 }" >
      <c:out value="Количество попыток в прошлой игре ${ oldcount} "/>
    </c:when>
  </c:choose>
</div>
</body>
</html>

