<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-12-13
  Time: 오후 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>error_page</title>
</head>
<body>
    <h2 style="background-color: black; color: yellow;">오류발생</h2>
    <a href="#">백신 프로그램 다운받기</a>
    <ul style="color: red;">
        <c:forEach var="stack" items="${exception.stackTrace}">
            <li>${stack}</li>
        </c:forEach>
    </ul>

</body>
</html>
