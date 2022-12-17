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
            <li class="current"><a href="/">Home</a></li>
            <li><a href="/user/join">Join</a></li>
            <li><a href="/user/login">Login</a></li>
        </ul>
    </nav>
</header>

<div id="main">
    <div class="wrapper style1 special">
        <div class="inner">
            <h2 class="heading alt">회원가입</h2>
            <br />
            <form class="joinForm" name="joinForm" id="joinForm" action="" method="post">
                <div class="col-12">
                    <h3>아이디</h3>
                    <input type="text" name="userId" />
                </div>
                <div class="col-12">
                    <h3>비밀번호</h3>
                    <input type="password" name="userPw"/>
                </div>
                <div class="col-12">
                    <h3>이름</h3>
                    <input type="text" name="userName"/>
                </div>
                <div class="col-12">
                    <input type="submit"  value="회원가입" class="primary"/>
                </div>
            </form>
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
