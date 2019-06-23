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
    <title>Group</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>


<table>
    <tr>
        <th>Id</th>
        <th>Username</th>
        <th>User Information</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td><a href="user?userId=${user.id}">${user.id}</a></td>
        </tr>
    </c:forEach>
</table>

<%@ include file="/WEB-INF/footer.jsp" %>
</body>
</html>
