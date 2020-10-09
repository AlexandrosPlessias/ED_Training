<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
    <head>
        <title>Spittlr Social Network</title>

    </head>

    <body>

        <h1> ${message} </h1>

        <hr>

        <p>Please choose <a href="<c:url value="/spitter/register" />">Here</a> to Register  </p>
        <p>Please choose <a href="<c:url value="/spittle/dashboard" />">Here</a> to View Recent Tweets <p>

    </body>
</html>
