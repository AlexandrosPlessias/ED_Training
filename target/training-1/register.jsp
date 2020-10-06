<%--
  Created by IntelliJ IDEA.
  User: aples
  Date: 10/6/2020
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
    <form action="register" method="post">
        Enter Username : <input type="text" name="username"> <br>
        Enter Password : <input type="password" name="password"> <br>
        Enter e-main : <input type="email" name="email"> <br>
        Enter Firstname : <input type="text" name="firstName"> <br>
        Enter Lastname : <input type="text" name="lastName"> <br>
        Enter Description : <input type="text" name="desc"> <br>
        <input type="submit" value="register">
    </form>

</body>
</html>
