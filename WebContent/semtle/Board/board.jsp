<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.User.*"%>
<%@page import="com.Post.*"%>
<%@ page import = "java.util.List"%>
<%@ page import = "java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/semtle/images/favicon.ico" type="image/x-icon" sizes="16X16">
	<link rel="icon" href="${pageContext.request.contextPath}/semtle/images/favicon.ico" type="image/x-icon" sizes="16X16">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>SemtleWeb</title>
	<script language="javascript">
	function input_hidden2(num) {
		  var ck = document.getElementById("comment_check"+num).checked;
		  var nickName = "${ userInfo.nickName }";
		  if (ck) {
			  document.getElementsByName("nickName"+num)[0].value = "익명";
		  }else {
			  document.getElementsByName("nickName"+num)[0].value = nickName;
		  }
		}
	function btn_click2(num) {
		document.getElementById("comment_text"+num).submit();
		
	}
    </script>
  </head>

  <body>
    <jsp:include page="${pageContext.request.contextPath}/semtle/header.jsp" flush="true" />

    <section class="heading">
      <div class="heading-box">
        <span>printf("셈회원들과 마음껏 소통하는 공간이에요")</span>
      </div>
    </section>

    <section class="talkboard">
    
    <c:choose>
    	<c:when test="${not empty userInfo.userId}">
      <div class="talkboard-head">
        <a href="board_write.doPost"
          ><span class="talkboard-head_write">글쓰기</span></a
        >
      </div>
      	</c:when>
    </c:choose>
    
    <c:choose>
    	<c:when test="${ post_count eq 0}">
      	<table style="margin:0 auto;">
			<td style="height:300px;">
				게시판에 저장된 글이 없습니다.
			</td>
		</table>
		</c:when>
      	<c:otherwise>
      	<c:forEach items="${ list }" var="dto" varStatus="i">
      <div class="talkboard-box">
        <div class="talk-content">
          <div class="talk-content-head">
            <div class="talk-content-left">
              <img src="${pageContext.request.contextPath}/semtle/images/char.PNG" alt="" />
              <div class="talk-content-head2">
                <span>${ dto.nickName }</span>
              <span>${ dto.updateAt }</span>
              </div>
            </div>
            <c:choose>
          	<c:when test="${ dto.userId eq userInfo.userId }">
            <div class="talk-content-right">
              <div class="talk-content-head3">
                <a style="color: #c0baba;font-size: 11px;text-decoration: underline;" href="board_setting.doPost?postId=${ dto.postId }">수정/삭제</a>
              </div>
            </div>
            </c:when>
          </c:choose>
          </div>
          
          <c:set var="comment_cnt" value="${ dto.postId }n" />

          <div class="talk-content-main">
            <span style="word-break : break-all; white-space: pre-line;">
				${ dto.content }
             </span>
          </div>
          <div class="talk-content-footone" onclick="comment_click(${ dto.postId });">
            <div class="talk-content-foot-etc">
              <i class="far fa-comment-dots talk-comment"></i>
              <span class="commenttext">댓글</span>
              <span>${ requestScope[comment_cnt] }</span>
            </div>
          </div>
			
          <div class="talk-content-foot aa${ dto.postId }">
            <div class="talk-content-comment">
            <c:choose>
            <c:when test="${ userInfo ne null }">
            <form action="comment_write.doComment?num=${ i.index }" id="comment_text${ i.index }" name="comment_text${ i.index }"  accept-charset="utf-8" method="post" class="commentwrite-form">
              	<input type="hidden" name="userId${ i.index }" id="userId${ i.index }" value="${ userInfo.userId }">
              	<input type="hidden" name="postId${ i.index }" id="postId${ i.index }" value="${ dto.postId }">
              	<input type="hidden" name="nickName${ i.index }" id="nickName${ i.index }" value="${ userInfo.nickName }">
              	<input type="hidden" name="num${ i.index }" id="num${ i.index }" value="${ i.index }">
                <textarea name="content${ i.index }" class="commentwrite"></textarea>
              </form>
              <div class="commentwrite_btn">
                <input
                  type="checkbox"
                  name="comment_check${ i.index }"
                  value="익명"
                  id="comment_check${ i.index }"
                  onclick="input_hidden2(${ i.index });"
                />
                <label for="" id="freeboard_check">익명</label>
                <button type="submit" onclick='btn_click2(${i.index});' class="commentbtn">작성</button>
              </div>
              </c:when>
              </c:choose>
            <c:forEach items="${ comment_lists }" var="comment" varStatus="i">
            <c:choose>
	            <c:when test="${ dto.postId == comment.postId }">
		            <div class="commentbox_name">
	                	<span class="comment_name">${ comment.nickName }</span>
	                	<span>${ comment.createAt }</span>
	             	</div>
	            	<div class="talk-content-commentbox">
		                <div class="talk-content-comment-text">
		                  <span>${ comment.content }</span>
		                </div>
		                <c:choose>
		                <c:when test="${ userInfo.userId ne null && userInfo.userId == comment.userId }">
			                <div class="talk-content-comment-icon">
			                  <a href="comment_delete.doComment?postId=${ comment.commentId }"><i class="fas fa-times"></i></a>
			                </div>
		                </c:when>
		                </c:choose>
              		</div>
			
                </c:when>
              </c:choose>
              </c:forEach>
              
              
              
            </div>
          </div>
        </div>
      </div>
      
      </c:forEach>
       <div class="page">
		<ul class="paging modal">
		
			<li> <a href="board_list_Free.doPost?cpage=${prevBlock}" class="arrow left">&lt;&lt;</a></li>
			<c:forEach var="i" begin="1" end="${ pageCount }" step="1">
     		<li> <a href="board_list_Free.doPost?cpage=${i}" class="num">${i}</a></li>
     		</c:forEach>
      		<li> <a href="board_list_Free.doPost?cpage=${nextBlock}" class="arrow right">&gt;&gt;</a></li>
		
      	</ul>
	</div>
      
      	</c:otherwise>
      </c:choose>

    </section>

<jsp:include page="${pageContext.request.contextPath}/semtle/footer.jsp" flush="true" />
  </body>
</html>

