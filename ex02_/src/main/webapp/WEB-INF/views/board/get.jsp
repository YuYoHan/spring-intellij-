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
	input:not(.button), textarea{
		border:1px solid black !important;
		color:#000000 !important;
		resize:none;
	}
	#banner .write_area ::placeholder{
		color:#888 !important;
	}
	.write_area{
		width:70%;
		margin:0 auto;	
	}
	.write_area input{
		margin-bottom: 32px;
	}
	.write_area > form > div{
		margin-bottom:32px;
	}
	.write_area > form > div:nth-of-type(odd) > h4 {
		float:left;
	}
	.write_area > form > div:nth-of-type(odd) > input {
		width:70%;
		float:right;
	}
	form h4{
		line-height:3.25rem;
	}
	hr{
		clear:both;	
	}
	.replyForm input, .replyForm textarea{
		width:100%;
	}
	.page{
		text-align: center;
		clear:both;
	}
	.mdf{
		height:75px; width:100%; resize:none;
	}
</style>
</head>
<body class="is-preload">
	<c:if test="${not empty mn}">
		<script>
			alert("${mn}번 게시글 수정완료!");
		</script>
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
				<p>&nbsp;</p>
				<a href="/board/list${cri.listLink}" class="button primary" style="float:right;
				border-radius:0px; border-bottom: 1px solid white;
				border-top: 1px solid white;">목록 보기</a>
				<br>
				<br>
				<br>
				<div class="write_area" style="clear:both;">
					<form name="boardForm" method="post" action="/board/remove">
						<input type="hidden" name="boardnum" value="${board.boardnum}">
						<input type="hidden" value="${cri.pagenum}" name="pagenum">
						<input type="hidden" value="${cri.amount }" name="amount">
						<input type="hidden" value="${cri.type }" name="type">
						<input type="hidden" value="${cri.keyword }" name="keyword">
						<div class="col-12">
							<h4>제목</h4>
							<input name="boardtitle" type="text" value="${board.boardtitle}" readonly>
						</div>
						<hr>
						<div class="col-12">
							<h4>내용</h4>
							<textarea name="boardcontents" rows="10" readonly>${board.boardcontents}</textarea>
						</div>
						<hr>
						<div>
							<h4>작성자</h4>
							<input name="userid" type="text" value="${board.userid}" readonly>
						</div>
						<c:if test="${loginUser == board.userid}">
							<hr>
							<div style="text-align: right;">
								<input type="button" value="수정" class="button primary"
								onclick="location.href = '/board/modify${cri.listLink}&boardnum=${board.boardnum}'">
								<input type="submit" value="삭제" class="button primary">
							</div>
						</c:if>
					</form>
					<hr>
					<h3>댓 글</h3>
					<p style="text-align: right;">
					<a href="#" class="button primary small regist">댓글 등록</a>
					</p>
					<div class="replyForm row" style="display:none;">
						<div style="width:15%;">
							<h4>작성자</h4>
							<input name="userid" value="${loginUser}" readonly style="text-align: center;">
						</div>
						<div style="width:65%;">
							<h4>내 용</h4>
							<textarea name="replycontents" placeholder="Contents" style="resize:none;"></textarea>
						</div>
						<div style="width:15%">
							<h4>&nbsp;</h4>
							<a href="#" class="button primary small finish" style="margin-bottom:1rem;">등록</a>
							<a href="#" class="button primary small cancel">취소</a>
						</div>
					</div>
					<br><br>
					<!-- 댓글 띄우는 ul -->
					<ul class="alt replies"></ul>
					<!-- 댓글 페이징 처리할 div -->
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
	<script src="/resources/assets/js/reply.js"></script>

</body>
<script>
	let pagenum = 0;
	let boardnum = "${board.boardnum}";
	const replies = $(".replies")
	let maxCnt = 0;
	const loginUser = "${loginUser}";
	const page = $(".page");
	
	$(document).ready(function(){
		pagenum = 1;
		showList(1);
	})
	
	$(".regist").on("click",function(e){
		e.preventDefault();
		$(".replyForm").show();
		$(this).hide();
	})
	$(".cancel").on("click",function(e){
		e.preventDefault();
		$(".replyForm").hide();
		$(".regist").show();
		$("[name='replycontents']").val("");
	})
	$(".finish").on("click",function(e){

		e.preventDefault();
		let replycontents = $("[name='replycontents']").val();
		replyService.add(
			{boardnum:boardnum, userid:loginUser, replycontents:replycontents},
			function(result){
				//DOM 구현
				alert(result+"번 댓글 등록 완료!");
				
				if(maxCnt < 5 || (Math.ceil(maxCnt/5)==pagenum && maxCnt%5!=0) ){
					let str = "";
					
					str += '<li style="clear:both;" class="li'+result+'">';
					str += '<div style="display:inline; float:left; width:80%;">';
					//<strong class="userid132">apple</strong>
					str += '<strong class="userid'+result+'">'+loginUser+'</strong>';
					//<p class="reply132">댓글 내용용요용용</p>"
					str += '<p class="reply'+result+'">'+replycontents+'</p></div>'
					str += '<div style="text-align:right;">'
					str += '<strong>방금 전</strong><br>'
					//<a href="132" class="modify">수정</a>
					str += '<a href="'+result+'" class="modify">수정</a>'
					str += '<a href="'+result+'" class="mfinish" style="display:none;">수정완료</a>&nbsp;&nbsp;'
					str += '<a href="'+result+'" class="remove">삭제</a>'
					str += "</div></li>";
					replies.append(str);
					
					$(".modify").on("click",modifyReply);
					$(".mfinish").on("click",modifyReplyOk);
					$(".remove").on("click",deleteReply);
					maxCnt++;
				}
				else{
					showList(pagenum);
				}
			}
		)
		$("[name='replycontents']").val("");
		$(".replyForm").hide();
		$(".regist").show();
	})
	
	
	function showList(pagenum){
		replyService.getList(
				{boardnum:boardnum,pagenum:pagenum||1},
				function(replyCnt, list){
					if(list == null || list.length == 0){
						//현재 게시글에 달린 댓글이 없다는 뜻
						return;
					}
					//DOM 구현
					let str = "";
					maxCnt = replyCnt;
					for(let i=0;i<list.length;i++){
						//<li style="clear:both;" class="li132">
						str += '<li style="clear:both;" class="li'+list[i].replynum+'">';
						str += '<div style="display:inline; float:left; width:80%;">';
						//<strong class="userid132">apple</strong>
						str += '<strong class="userid'+list[i].replynum+'">'+list[i].userid+'</strong>';
						//<p class="reply132">댓글 내용용요용용</p>"
						str += '<p class="reply'+list[i].replynum+'">'+list[i].replycontents+'</p></div>'
						str += '<div style="text-align:right;">'
						str += '<strong>'+replyService.displayTime(list[i])+'</strong><br>'
						if(list[i].userid == loginUser){
							//<a href="132" class="modify">수정</a>
							str += '<a href="'+list[i].replynum+'" class="modify">수정</a>'
							str += '<a href="'+list[i].replynum+'" class="mfinish" style="display:none;">수정완료</a>&nbsp;&nbsp;'
							str += '<a href="'+list[i].replynum+'" class="remove">삭제</a>'
						}
						str += "</div></li>";
					}
					replies.html(str);
					
					$(".modify").on("click",modifyReply);
					$(".mfinish").on("click",modifyReplyOk);
					$(".remove").on("click",deleteReply);
					
					showReplyPage(replyCnt);
				}
		)
	}
	function showReplyPage(replyCnt){
		let endPage = Math.ceil(pagenum/5)*5;
		let startPage = endPage-4;
		
		let prev = startPage!=1;
		let next = false;
		
		if(endPage*5 >= replyCnt){
			endPage = Math.ceil(replyCnt/5);
		}
		if(endPage*5 < replyCnt){
			next = true;
		}
		
		let str = "";
		if(prev){
			//<a class="changePage" href="5"><code>&lt;</code></a>
			str += '<a class="changePage" href="'+(startPage-1)+'"><code>&lt;</code></a>';
		}
		for(let i=startPage;i<=endPage;i++){
			if(i == pagenum){
				str += "<code>"+i+"</code>"
			}
			else{
				str += '<a class="changePage" href="'+i+'"><code>'+i+'</code></a>';
			}
		}
		if(next){
			str += '<a class="changePage" href="'+(endPage+1)+'"><code>&gt;</code></a>';
		}
		page.html(str);
		
		$(".changePage").on("click",function(e){
			e.preventDefault();
			let target = $(this).attr("href");
			pagenum = parseInt(target);
			showList(pagenum);
		})
	}
	function deleteReply(e){
		e.preventDefault();
		let replynum = $(this).attr("href");
		replyService.remove(
				replynum,
				function(result){
					if(result == "success"){
						$(".li"+replynum).remove();
						alert(replynum+"번 댓글 삭제 완료!");
						//실제로 마지막 페이지의 유일한 댓글을 삭제하는 경우에는
						//현재 보고있는 페이지로 다시 불러오는 것이 아니라 이전페이지로 불러와야 한다. 
						showList(pagenum);
					}
				},
				function(err){
					alert("에러발생")
				}
		)
	}
	let flag = false;
	function modifyReply(e){
		e.preventDefault();
		if(!flag){
			flag = true;
			let replynum = $(this).attr("href");
			const replyTag = $(".reply"+replynum);
			//<textarea class="123 mdf">노잼댓글내용</textarea>
			replyTag.html('<textarea class="'+replynum+' mdf">'+replyTag.text()+'</textarea>');
			$(this).hide();
			$(this).next().show();
		}
		else{
			alert("수정중인 댓글이 있습니다!");
		}
	}
	function modifyReplyOk(e){
		flag = false;
		e.preventDefault();
		
		let replynum = $(this).attr("href");
		let replycontents = $("."+replynum).val();
		
		if(replycontents == ""){
			alert("댓글 내용을 입력하세요!");
			return;
		}
		
		replyService.modify(
			{replynum:replynum, replycontents:replycontents, boardnum:boardnum, userid:loginUser},
			function(result){
				if(result == "success"){
					alert(replynum+"번 댓글 수정 완료!");
					$(".reply"+replynum).html(replycontents);
					const dateObj = new Date();
					let hh = dateObj.getHours();
					let mi = dateObj.getMinutes();
					let ss = dateObj.getSeconds();
					let str = (hh>9?'':'0')+hh+":"+(mi>9?'':'0')+mi+":"+(ss>9?'':'0')+ss;
					$(".li"+replynum+">div:nth-child(2)>strong").html("(수정됨) "+str);
				}
			}
		)
		$(this).hide();
		$(this).prev().show();
	}
</script>
</html>






