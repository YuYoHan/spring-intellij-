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
    <style>
        #banner input, #banner select, #banner option {
            color: #000000;
        }
        select {
            width: 15%;
            text-align: center;
            padding: 9px;
            display: inline;
        }

        #keyword {
            width: 55%;
            display: inline;
        }
        #keyword+a {
            border: 1px solid #fff;
        }
        th, td {
            text-align: center !important;
        }
    </style>
</head>
<body class="is-preload">
<c:if test="${boardNum != null}">
    <script>alert("${boardNum}번 게시글 작성 완료!")</script>
</c:if>
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
            <a href="/board/regist" class="button primary" style="float: right; border-bottom: 1px solid #fff; border-radius: 0px; border-top: 1px solid #fff">글 등록 </a>
            <div class="table-wrapper" style="clear: both">
                <table>
                    <thead>
                        <tr>
                            <th style="width: 10%;">번호</th>
                            <th style="width: 40%">제목</th>
                            <th style="width: 15%;">작성자</th>
                            <th style="width: 35%;">작성시간</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:choose>
                        <c:when test="${list != null and list.size() > 0}" >
                            <c:forEach items="${list}" var="board">
                                    <tr>
                                        <td>${board.boardNum}</td>
                                        <td>${board.boardTitle}</td>
                                        <td>${board.userId}</td>
                                        <td>${board.regDate}
                                            <c:if test="${board.regDate != board.updateDate}">
                                                (${board.updateDate})</td>
                                            </c:if>
                                    </tr>
                                </c:forEach>
                            </c:when>
                        </c:choose>
                    </tbody>
                </table>
            </div>
            <form>
                <div>
                    <select name="type">
                        <option value="">검색</option>
                        <option value="">제목</option>
                        <option value="">내용</option>
                        <option value="">작성자</option>
                        <option value="">제목 또는 내용</option>
                        <option value="">제목 또는 작성자</option>
                        <option value="">제목 또는 내용 또는 작성자</option>
                    </select>
                    <input type="text" name="keyword" id="keyword">
                    <a href="#" class="button primary">검색</a>
                </div>
            </form>
            <div>
                <code>&lt;</code>
                <code>1</code>
                <code>2</code>
                <code>3</code>
                <code>4</code>
                <code>5</code>
                <code>&gt;&gt;</code>
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