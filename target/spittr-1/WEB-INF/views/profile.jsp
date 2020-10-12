<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
    <head>
        <title>Profile User: ${spitter.getUsername()} </title>
        <style>
            .showStyle { width: 500px; clear: both; }
        </style>
    </head>

    <body>
    <h1> Profile User: <b>${spitter.getUsername()} </b></h1>
    <hr>

    <div class="showStyle">
        <label>User name: </label> <label> ${spitter.getUsername()}</label><br>
        <label>First name: </label> <label> ${spitter.getLastName()}</label><br>
        <label>Last name: </label> <label>${spitter.getLastName()} </label><br>
        <label>Description: </label> <label> ${spitter.getDescription()} </label><br>

    </div >

    <hr>

    <p>Please choose <a href="<c:url value="/homepage" />">Here</a> to go to Home page. <p>

    </body>
</html>