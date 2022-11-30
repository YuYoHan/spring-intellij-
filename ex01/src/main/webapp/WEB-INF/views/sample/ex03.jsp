<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-30
  Time: 오후 2:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>ex03</title>
</head>
<body>
  <h1>ex03</h1>
  <p>
    <c:forEach items="${datas}" var="data">
      ${data} <br />
    </c:forEach>
  </p>
</body>
</html>
