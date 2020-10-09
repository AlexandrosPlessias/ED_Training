<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>User Registration</title>
        <style>
            .registerFormStyle { width: 500px; clear: both; }
            .registerFormStyle input { width: 100%; clear: both; }
        </style>
    </head>

    <body>
        <div class="registerFormStyle">

            <h1>Register</h1>
            <p>Please fill in this form to create an account.</p>

            <hr>

            <form action="register" method="POST">

                <label>Username: </label>
                <input type="text" name="username" required> <br>

                <label>Password: </label>
                <input type="password" name="password" required> <br>

                <label>Email: </label>
                <input type="email" name="email" required> <br>

                <label>Firstname: </label>
                <input type="text" name="firstName" required> <br>

                <label>Lastname: </label>
                <input type="text" name="lastName" required> <br>

                <label>Description: </label>
                <input type="text" name="desc" required> <br>

                <p>By creating an account you agree to our Terms & Privacy.</p>
                <button type="submit" value="register">Register</button>
                <button type="reset" value="reset">Reset</button>

            </form>
        </div>

        <hr>

        <p>Please choose <a href="<c:url value="/homepage" />">Here</a> to go to Home page. <p>

    </body>
</html>