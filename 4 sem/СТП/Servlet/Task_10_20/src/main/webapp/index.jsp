<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h3>${result}</h3><br>
<div class="form">
    <h1>Вход в систему</h1>
    <form method="post" action="adminoruser">
        <input name="login" type="text"><br><br>
        <input class="button" type="submit" value="Войти">
    </form>
</div>
</body>
</html>