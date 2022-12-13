<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-12-13
  Time: 오후 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>ex04</title>
</head>
<body>
    <h1>ex04</h1>
    <p>
        Model<br/>
        <c:forEach var="data" items="${datas}">
            ${data} <br />
        </c:forEach>
        sum : ${sum}
    </p>
</body>
</html>
