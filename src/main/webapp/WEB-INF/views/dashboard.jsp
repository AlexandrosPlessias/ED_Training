<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
    <head>
        <title>All Spittles</title>

    </head>

    <body>

        <h1>All Spittles List:</h1>

        <hr>

        <c:forEach items="${spittleList}" var="spittle" >
            <label>Message ID: </label> <label> ${spittle.getId()}</label><br>
            <label>Message: </label> <label> <b> ${spittle.getMessage()} </b></label><br>
            <label>Time: </label> <label> ${spittle.getTime()}</label><br>
            <label>Location: (</label> <label>${spittle.getLatitude()} </label>, </label> <label> ${spittle.getLontitude()})</label><br>
            <br>
        </c:forEach>

        <hr>

        <p>Please choose <a href="<c:url value="/homepage" />">Here</a> to go to Home page. <p>

    </body>
</html>
