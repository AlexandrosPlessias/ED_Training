<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Registration fails</title>

</head>

<body>
    <h1> User already exists....</h1>

    <hr>

    <p>Please choose <a href="<c:url value="/spitter/register" />">Here</a> to go Register page </p>
    <p>Please choose <a href="<c:url value="/homepage" />">Here</a> to go to Home page. <p>

    </body>
</html>
