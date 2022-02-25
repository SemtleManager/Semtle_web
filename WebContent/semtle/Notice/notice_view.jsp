<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <section class="notice_text">
      <div class="notice_text-box">
        <div class="notice_text-content">
          <div class="notice_text-content-head">
            <img src="${pageContext.request.contextPath}/semtle/images/char.PNG" alt="" />
            <div class="notice_text-content-head2">
              <span>${ post.p_title }</span>
              <span>${ post.nickName } | ${ post.updateAt }</span>
            </div>
          </div>
          <c:choose>
          <c:when test="${ post.userId eq userInfo.userId }">
          <span class="setting"><a style="color: #c0baba;" href="notice_setting.doNotice?postId=${ post.postId }">수정/삭제</a></span>
          </c:when>
          </c:choose>
          <div class="notice_text-content-main">
            <span style="word-break : break-all; white-space: pre-line;">
              ${ post.content }
            </span>
          </div>
          <c:choose>
          	<c:when test="${ post.fileUrl ne null }">
        	 <div class="notice_text-content-foot studyboard-foot">
           	<div class="notice_text-content-foot-etc studyboard-foot-etc">
           	  <span id="studyboard-foot-attach"><a href="study_download.doStudy?postId=${ post.postId }">${ post.fileUrl }</a></span>
           	  <i class="fas fa-paperclip"></i>
         		</div>
        	 </div>
         </c:when>
        </c:choose>
        </div>
      </div>
    </section>
<jsp:include page="${pageContext.request.contextPath}/semtle/footer.jsp" flush="true" />
  </body>
  <script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>
  <script src="js/script.js" defer></script>
</html>