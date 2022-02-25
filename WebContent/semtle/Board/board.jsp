<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.User.*"%>
<%@page import="com.Post.*"%>
<%@ page import = "java.util.List"%>
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
            <img src="${pageContext.request.contextPath}/semtle/images/char.PNG" alt="" />
            <div class="talk-content-head2">
              <span>${ dto.nickName }</span>
              <span>${ dto.updateAt }</span>
              
            </div>
          </div>
          <c:choose>
          <c:when test="${ dto.userId eq userInfo.userId }">
          <span class="setting"><a style="color: #c0baba;" href="board_setting.doPost?postId=${ dto.postId }">수정/삭제</a></span>
          </c:when>
          </c:choose>
          <div class="talk-content-main">
            <span style="word-break : break-all; white-space: pre-line;">
				${ dto.content }
             </span>
          </div>
          <div class="talk-content-foot">
            <div class="talk-content-foot-etc">
              <span>댓글<i class="far fa-comment-dots talk-comment"></i></span>
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
<%--       <div class="talkboard-box">
        <div class="talk-content">
          <div class="talk-content-head">
            <img src="${pageContext.request.contextPath}/semtle/images/char.PNG" alt="" />
            <div class="talk-content-head2">
              <span>역곡불주먹</span>
              <span>01.08</span>
            </div>
          </div>
          <div class="talk-content-main">
            <span
              >동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세
              무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세</span
            >
          </div>
          <div class="talk-content-foot">
            <div class="talk-content-foot-etc">
              <i class="far fa-comment-dots talk-comment"></i>
              <span class="abc">댓글 3</span>
            </div>
            <div class="talk-content-comment">
              <div class="talk-content-commentbox">
                <div class="talk-content-comment-text">
                  <span>오~~ 좋아요~!!</span>
                </div>
                <div class="talk-content-comment-icon">
                  <i class="fas fa-times"></i>
                </div>
              </div>

              <div class="talk-content-commentbox">
                <div class="talk-content-comment-text">
                  <span>오~~ 좋아요~!!</span>
                </div>
                <div class="talk-content-comment-icon">
                  <i class="fas fa-times"></i>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div> --%>

    </section>

<jsp:include page="${pageContext.request.contextPath}/semtle/footer.jsp" flush="true" />
  </body>
</html>
