<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Number Calculator" %>
</h1>
<br/>
<%--post method is used to send data to server--%>
<%--it will not put your data in url--%>

<form action="add" method="get">
    Enter 1st Number: <input type="text" name="num1">
    Enter 2nd Number: <input type="text" name="num2">
    <input type="submit">
</form>

</body>
</html>