<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>MYBootstrapApp</title>
    <link href="CSS/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>Hello, User!</h1>
<div class="alert alert-info" role="alert">
    This Test..
</div>
<div>
    <form action="${pageContext.request.contextPath}/hello" method="post">
            <h1>Please enter your e-mail</h1>
            <input type="text" name="email">
            <label class="error">${messageEmail}</label>
            <br>
            <h1>Please enter your number in the international format</h1>
            <input type="text" name="number">
            <label class="error">${messageNumber}</label>
            <br>
            <br>
            <button type="submit">Send a request</button>
    </form>
</div>
<script src="JS/bootstrap.min.js"></script>
</body>
</html>