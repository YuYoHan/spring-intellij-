<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Board</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
    <link rel="shortcut icon" href="#">
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <link rel="stylesheet" href="/resources/assets/css/main.css"/>
    <style>
        #banner input, #banner select, #banner option {
            color: #000000;
        }
        input:not(.button), textarea {
            border: 1px solid black !important;
            color: #000000 !important;
        }
        #banner .write_area input::placeholder {
            color: #ccc !important;
        }
        .write_area {
            width: 70%;
            margin: 0 auto;
        }
        .write_area input {
            margin-bottom: 32px;
        }
        .write_area > form > div {
            margin-bottom: 32px;
        }
        .write_area > form > div:nth-of-type(odd) > h4 {
            float: left;
        }
        .write_area > form > div:nth-of-type(odd) > input {
            float: right;
            width: 70%;
        }
        form h4 {
            line-height: 3.25rem;
        }
        hr {
            clear: both;
        }
    </style>
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
            <p>게시판 등록</p>
            <a href="/board/list" class="button primary" style="float: right; border-bottom: 1px solid #fff; border-radius: 0px; border-top: 1px solid #fff">목록 보기 </a>
            <br />
            <br />
            <br />
            <div class="write_area" style="clear: both">
                <form name="boardForm" method="post" action="/board/regist">
                    <div class="col-12">
                        <h4>제목</h4>
                        <input name="boardTitle" type="text" placeholder="Title">
                    </div>
                    <div class="col-12">
                        <h4>내용</h4>
                        <textarea name="boardContents" placeholder="Contents" rows="10"></textarea>
                    </div>
                    <hr />
                    <div>
                        <h4>작성자</h4>
                        <input name="userId" type="text" value="${loginUser}" readonly />
                    </div>
                    <hr />
                    <div>
                        <input type="submit" value="등록"  class="button primary">
                    </div>
                </form>
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