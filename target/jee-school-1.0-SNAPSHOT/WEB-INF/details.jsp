<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MarDem
  Date: 2019-05-25
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Solution details</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>


<table>
    <tr>
        <th>Id</th>
        <th>Created</th>
        <th>Updated</th>
        <th>Description</th>
        <th>Exercise Id</th>
        <th>User Id</th>
        <th>Rating</th>
    </tr>
    <tr>
        <td>${solution.id}</td>
        <td>${solution.created}</td>
        <td>${solution.updated}</td>
        <td>${solution.description}</td>
        <td>${solution.exercise_id}</td>
        <td>${solution.user_id}</td>
        <td>${solution.rating}</td>
    </tr>
</table>

<%@ include file="/WEB-INF/footer.jsp" %>
</body>
</html>
