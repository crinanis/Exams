
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="hello-servlet">
<input type="text" name="weight" placeholder="weight"/>
<input type="text" name="rost" placeholder="rost"/>
    <input type="submit"  value="Расчитать"/>
    <p>${IMT}</p>
    <p>${result}</p>
</form>
</body>
</html>