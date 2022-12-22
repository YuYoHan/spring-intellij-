<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>list</title>
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
                    <li><a href="/user/join">Join</a></li>
                    <li><a href="/user/login">Login</a></li>
                </c:when>
                <c:otherwise>
                    <li>${loginUser}님 환영합니다!</li>
                    <li class="current"><a href="/">Home</a></li>
                    <li><a href="/board/list">Board</a></li>
                    <li><a href="/user/logout">Logout</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </nav>
</header>

<!-- Banner -->
<div id="banner">
    <div class="wrapper style1 special">
        <div class="inner">
            <h1 class="heading alt">Board</h1>
            <p>게시판 목록</p>
            <a href="#" class="primary">글 등록 </a>
            <div class="table-wrapper">
                <table>
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>작성시간</th>
                            <th>수정시간</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <form>
                <div>

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