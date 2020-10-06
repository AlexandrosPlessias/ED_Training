<%@ page import="domain.Spittle" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: aples
  Date: 10/6/2020
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Tweets Table</title>
    </head>

    <body>

        <% List<Spittle> allTweets = (List<Spittle>) request.getAttribute("spittles"); %>

        <table style="width:100%">
            <tr>
                <th>Tweet ID</th>
                <th>Message</th>
                <th>Date</th>
                <th>Latitude</th>
                <th>Longitude</th>
                <th>Author ID</th>
            </tr>
            <% for(Spittle tweet : allTweets) { %>
            <tr>
                <td><%  tweet.getId(); %></td>
                <td><%  tweet.getMessage(); %></td>
                <td><%  tweet.getTime(); %></td>
                <td><%  tweet.getLatitude(); %></td>
                <td><%  tweet.getLontitude(); %></td>
                <td><%  tweet.getOwnerId(); %></td>
            </tr>
            <% } %>
        </table>

    </body>

</html>
