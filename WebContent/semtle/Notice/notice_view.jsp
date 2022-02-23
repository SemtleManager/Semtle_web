<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
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
          <div class="notice_text-content-main">
            <span style="word-break : break-all; white-space: pre-line;">
              ${ post.content }
            </span>
          </div>
          <div style="width:100%;">
            <p style="font-size : 10px;">
            <c:choose>
            	<c:when test="${ post.fileUrl ne null }">
             		<a href="notice_download.doNotice?postId=${ post.postId }">파일 : ${ post.fileUrl }</a>
             	</c:when>
            </c:choose>
            </p>
          </div>
          <div class="notice_text-content-foot">
            <div class="notice_text-content-foot-etc"></div>
          </div>
        </div>
      </div>
    </section>
<jsp:include page="${pageContext.request.contextPath}/semtle/footer.jsp" flush="true" />
  </body>
  <script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>
  <script src="js/script.js" defer></script>
</html>