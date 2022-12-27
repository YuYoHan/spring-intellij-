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
        .replyForm input, .replyForm textarea {
            width: 100%;
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
            <p>${board.boardNum}번 게시글</p>
            <a href="/board/list" class="button primary" style="float: right; border-bottom: 1px solid #fff; border-radius: 0px; border-top: 1px solid #fff">목록 보기 </a>
            <br />
            <br />
            <br />
            <div class="write_area" style="clear: both">
                <form name="boardForm" method="post" action="/board/remove">
                    <input type="hidden" name="boardNum" value="${board.boardNum}">
                    <div class="col-12">
                        <h4>제목</h4>
                        <input name="boardTitle" type="text" placeholder="${board.boardTitle}" readonly>
                    </div>
                    <div class="col-12">
                        <h4>내용</h4>
                        <textarea name="boardContents"  rows="10" readonly>${board.boardContents}</textarea>
                    </div>
                    <hr />
                    <div>
                        <h4>작성자</h4>
                        <input name="userId" type="text" value="${board.userId}" readonly />
                    </div>
                    <c:if test="${loginUser == board.userId}">
                        <hr />
                        <div style="text-align: right">
                            <input type="button" value="수정"  class="button primary">
                            <input type="submit" value="삭제"  class="button primary">
                        </div>
                    </c:if>
                </form>
                <h3>댓 글</h3>
                <p style="text-align: right;">
                <a href="#" class="button primary small">댓글 등록</a>
                </p>
                <div class="replyForm row" style="" >
                    <div style="width: 15%">
                        <h4>작성자</h4>
                        <input name="replyWriter" value="${loginUser}" readonly style="text-align: center">
                    </div>
                    <div style="width: 65%;">
                        <h4>내 용</h4>
                        <textarea name="replyContents" placeholder="Contents" style="resize: none;"></textarea>
                    </div>
                    <div style="width: 15%">
                        <h4>&nbsp;</h4>
                        <a href="#" class="button primary small" style="margin-bottom: 1rem;">등록</a>
                        <a href="#" class="button primary small">취소</a>
                    </div>
                </div>
                <br/>
                <br/>
                <!-- 댓글 띄우는 ul-->
                <ul class="alt replies">

                </ul>
                <!-- 댓글 페이징 처리할 div-->
                <div class="page">
                </div>
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