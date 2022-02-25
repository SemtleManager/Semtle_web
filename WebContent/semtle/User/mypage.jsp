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
    <link rel="stylesheet" href="css/style.css" />
    <link
      href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;500;700&display=swap"
      rel="stylesheet"
    />

    <link
      rel="stylesheet"
      href="https://unpkg.com/swiper@7/swiper-bundle.min.css"
    />

    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
    />
  </head>

  <body>
    <header>
      <a href="javascript:history.back();" id="header-before"
        ><i class="fas fa-angle-left"></i
      ></a>

      <nav class="navbar">
        <a href="notice.html">공지사항</a>
        <a href="board.html">자유게시판</a>
        <a href="study.html">스터디룸</a>
        <a href="book.html">책 대여</a>
        <a href="#">공모전</a>
      </nav>

      <span id="header-name">마이 페이지</span>

      <div class="icons">
        <a href="index.html"><i class="fas fa-home" id="home-bar"></i></a>
        <i class="fas fa-bars header-menu" id="menu-bars"></i>
      </div>
    </header>

    <section class="mypage-heading">
      <div class="mypage-heading-left"></div>
      <div class="mypage-heading-info">
        <img src="images/char.PNG" alt="" />
        <span>김대현</span>
      </div>
      <div class="mypage-heading-right">
        <span>로그아웃</span>
      </div>
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
      <div class="mypage-content-icon">
        <div class="mypage-content-icon-left">
          <i class="fas fa-user-edit"></i>
          <span>정보 수정</span>
        </div>
        <div class="mypage-content-icon-right">
          <i class="fas fa-angle-right"></i>
        </div>
      </div>
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

    <footer class="footer">
      <div class="footer-box">
        <div class="footer-content">
          셈틀쟁이 : 가톨릭대 성심교정 다솔관 D410
        </div>
        <div class="footer-content">회장 김대현 010-3249-7669</div>
        <div class="footer-content">
          <i class="fab fa-facebook"></i>
          <i class="fab fa-instagram"></i>
        </div>
      </div>
    </footer>
  </body>
  <script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>
  <script src="js/script.js" defer></script>
</html>