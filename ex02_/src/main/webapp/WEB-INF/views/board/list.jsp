<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="/resources/assets/css/main.css" />
<style>
	#banner input, #banner select, #banner option{
		color:#000000;
	}
	select{
		width:15%;
		text-align: center;
		padding:0 20px;
		display: inline;
	}
	#keyword{
		width:55%;
		display: inline;	
	}
	#keyword+a{
		border:1px solid white;
	}
	th, td{
		text-align: center !important;
	}
	tbody tr:hover{
		background-color:rgba(255,255,255,0.3) !important;
	}
	.nowPage{
		background-color:#F9F8FF !important;
		color:#8086F1 !important;
		font-weight: 900;
	}
</style>
</head>
<body class="is-preload">
	<c:if test="${boardnum != null}">
		<script>alert("${boardnum}번 게시글 작성 완료!");</script>
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
				<a href="/board/regist" class="button primary" style="float:right; border-radius:0px; border-bottom: 1px solid white; border-top: 1px solid white;">글 등록</a>
				<div class="table-wrapper" style="clear: both;">
					<table>
						<thead>
							<tr>
								<th style="width:10%;">번호</th>
								<th style="width:40%;">제목</th>
								<th style="width:15%;">작성자</th>
								<th style="width:35%;">작성시간</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${list != null and list.size()>0 }">
									<c:forEach items="${list}" var="board">
										<tr>
											<td>${board.boardnum }</td>
											<td><a href="${board.boardnum}" class="get">${board.boardtitle }</a></td>
											<td>${board.userid }</td>
											<td>${board.regdate }
												<c:if test="${board.regdate != board.updatedate}">
													(${board.updatedate})
												</c:if>
											</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="5">작성된 게시글이 없습니다.</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</div>
				<form id="searchForm" action="/board/list" onsubmit="return sendit()">
					<div>
						<select name="type">
							<option value="" ${pageMaker.cri.type == null ? "selected" : ""}>검색</option>
							<option value="T" ${pageMaker.cri.type == "T" ? "selected" : ""}>제목</option>
							<option value="C" ${pageMaker.cri.type == "C" ? "selected" : ""}>내용</option>
							<option value="W" ${pageMaker.cri.type == "W" ? "selected" : ""}>작성자</option>
							<option value="TC" ${pageMaker.cri.type == "TC" ? "selected" : ""}>제목 또는 내용</option>
							<option value="TW" ${pageMaker.cri.type == "TW" ? "selected" : ""}>제목 또는 작성자</option>
							<option value="TCW" ${pageMaker.cri.type == "TCW" ? "selected" : ""}>제목 또는 내용 또는 작성자</option>
						</select>
						<input type="text" name="keyword" id="keyword" value="${pageMaker.cri.keyword}">
						<a href="#" class="button primary">검색</a>
					</div>
					<input type="hidden" value="1" name="pagenum">
					<input type="hidden" value="10" name="amount">
				</form>
				<div class="pagination center">
					<c:if test="${pageMaker.prev}">
						<a class="changePage" href="${pageMaker.startPage-1}"><code>&lt;</code></a>
					</c:if>
					<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="i">
						<c:choose>
							<c:when test="${i == pageMaker.cri.pagenum}">
								<code class="nowPage">${i}</code>
							</c:when>
							<c:otherwise>
								<a class="changePage" href="${i}"><code>${i}</code></a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${pageMaker.next}">
						<a class="changePage" href="${pageMaker.endPage+1}"><code>&gt;</code></a>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<form name="pageForm" id="pageForm" action="/board/list">
		<input type="hidden" value="${pageMaker.cri.pagenum }" name="pagenum">
		<input type="hidden" value="${pageMaker.cri.amount }" name="amount">
		<input type="hidden" value="${pageMaker.cri.type}" name="type">
		<input type="hidden" value="${pageMaker.cri.keyword }" name="keyword">
	</form>
<!-- Scripts -->
	<script src="/resources/assets/js/jquery.min.js"></script>
	<script src="/resources/assets/js/jquery.dropotron.min.js"></script>
	<script src="/resources/assets/js/browser.min.js"></script>
	<script src="/resources/assets/js/breakpoints.min.js"></script>
	<script src="/resources/assets/js/util.js"></script>
	<script src="/resources/assets/js/main.js"></script>

	</body>
<script>
	const pageForm = $("#pageForm");
	const searchForm = $("#searchForm")
	$(".get").on("click",function(e){
		//e(이벤트)의 기본 작동 막기
		e.preventDefault();
		let boardnum = $(this).attr("href");
		//				 <input type='hidden' name='boardnum' value='   5452780  '>
		pageForm.append("<input type='hidden' name='boardnum' value='"+boardnum+"'>");
		//jQuery 요소일때는
		pageForm.attr("action","/board/get");
		//바닐라 요소일때는
		//pageForm.setAttribute("action","/board/get");
		pageForm.submit();		
	})
	$(".changePage").on("click",function(e){
		e.preventDefault();
		let pagenum = $(this).attr("href");
		pageForm.find("input[name='pagenum']").val(pagenum);
		pageForm.submit();
	})
	$("#searchForm a").on("click",sendit)
	function sendit(e){
		//검색 조건을 선택하지 않았을 때
		/*
			if("") ---> if(false)
		*/
		if(!searchForm.find("option:selected").val()){
			alert("검색 기준을 선택하세요")
			return false;
		}
		if(!searchForm.find("input[name='keyword']").val()){
			alert("키워드를 입력하세요")
			return false;
		}
		if(searchForm.find("input[name='keyword']").val().length<2){
			alert("키워드는 두 글자 이상 입력하세요")
			return false;
		}
		searchForm.submit();
	}
</script>
</html>






