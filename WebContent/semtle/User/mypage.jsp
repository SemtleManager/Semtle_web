<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    <section class="mypage-heading">
      <div class="mypage-heading-left"></div>
      <div class="mypage-heading-info">
        <img src="images/char.PNG" alt="" />
        <span>김대현</span>
        <span style="font-size: 13px;">${ userInfo.grade }학년</span>
      </div>
      <a href="logout.do">
	      <div class="mypage-heading-right">
	        <span>로그아웃</span>
	      </div>
      </a>
    </section>

    <section class="mypage-box">
      <div class="mypage-box-content">
        <span class="content-head">내가 쓴 글</span>
        <span>3</span>
      </div>
      <div class="mypage-box-content mypageboxborder">
        <span class="content-head">내가 쓴 글</span>
        <span>3</span>
      </div>
      <div class="mypage-box-content">
        <span class="content-head">내가 쓴 글</span>
        <span>3</span>
      </div>
    </section>

    <section class="mypage-content">
    <a href="userUpdate.do">
      <div class="mypage-content-icon">
        <div class="mypage-content-icon-left">
          <i class="fas fa-user-edit"></i>
          <span>정보 수정</span>
        </div>
        <div class="mypage-content-icon-right">
          <i class="fas fa-angle-right"></i>
        </div>
      </div>
      </a>
      <div class="mypage-content-icon">
        <div class="mypage-content-icon-left">
          <i class="fas fa-book"></i>
          <span>대여한 책</span>
        </div>
        <div class="mypage-content-icon-right">
          <i class="fas fa-angle-right"></i>
        </div>
      </div>
      <div class="mypage-content-icon">
        <div class="mypage-content-icon-left">
          <i class="far fa-edit"></i>
          <span>내가 쓴 글</span>
        </div>
        <div class="mypage-content-icon-right">
          <i class="fas fa-angle-right"></i>
        </div>
      </div>
      <div class="mypage-content-icon">
        <div class="mypage-content-icon-left">
          <i class="fas fa-comment"></i>
          <span>내가 쓴 댓글</span>
        </div>
        <div class="mypage-content-icon-right">
          <i class="fas fa-angle-right"></i>
        </div>
      </div>
    </section>

	<jsp:include page="${pageContext.request.contextPath}/semtle/footer.jsp" flush="true" />
  </body>
  <script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>
  <script src="js/script.js" defer></script>
</html>