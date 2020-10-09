<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
    <html>
    <head>
        <title>User created successfully !!!</title>
        <style>
            .showStyle { width: 500px; clear: both; }
        </style>
    </head>

    <body>
        <h1> User ${id} created successfully</h1>
        <hr>

        <div class="showStyle">

            <label>Username: </label> <label> ${username}</label><br>
            <label>Firstname: </label> <label> ${firstName}</label><br>
            <label>Lastname: </label> <label>${lastName} </label><br>
            <label>Description: </label> <label> ${desc} </label><br>

        </div >

        <hr>

        <p>Please choose <a href="<c:url value="/homepage" />">Here</a> to go to Home page. <p>

    </body>
</html>