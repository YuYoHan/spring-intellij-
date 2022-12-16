<%@page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spring Board</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
    <link rel="shortcut icon" href="#">
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <link rel="stylesheet" href="/resources/assets/css/main.css"/>
</head>
<body class="is-preload">

<!-- Header -->
<header id="header" class="alt">
    <a class="logo" href="/">Spring <span>Board</span></a>
    <nav id="nav">
        <ul>
            <c:choose>
                <c:when test="${loginUser == null}">
                    <li class="current"><a href="/">Home</a></li>
                    <li><a href="#">Join</a></li>
                    <li><a href="#">Login</a></li>
                </c:when>
                <c:otherwise>
                    <li>${loginUser}님 환영합니다!</li>
                    <li class="current"><a href="/">Home</a></li>
                    <li><a href="#">Board</a></li>
                    <li><a href="#">Logout</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </nav>
</header>

<!-- Banner -->
<div id="banner">
    <div class="wrapper style1 special">
        <div class="inner">
            <h1 class="heading alt">스프링 게시판</h1>
            <p>스프링 최종 예제</p>
            <div class="image fit special">
                <img src="https://images.unsplash.com/photo-1657497850516-de7b59ac243b?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1160&q=80" alt="" />
            </div>
        </div>
    </div>
</div>

<!-- Scripts -->
<script src="/resources/assets/js/jquery.min.js"></script>
<script src="/resources/assets/js/jquery.dropotron.min.js"></script>
<script src="/resources/assets/js/browser.min.js"></script>
<script src="/resources/assets/js/breakpoints.min.js"></script>
<script src="/resources/assets/js/util.js"></script>
<script src="/resources/assets/js/main.js"></script>
</body>
</html>
