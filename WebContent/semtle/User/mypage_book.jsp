<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/semtle/images/favicon.ico" type="image/x-icon" sizes="16X16">
	<link rel="icon" href="${pageContext.request.contextPath}/semtle/images/favicon.ico" type="image/x-icon" sizes="16X16">
    <title>SemtleWeb</title>
  </head>

  <body>
    <jsp:include page="${pageContext.request.contextPath}/semtle/header.jsp" flush="true" />

    <section class="mypagebookbox">
      <div class="takeoutbox-head">
        <span>대여한 책 목록</span>
      </div>
      <div class="mybook">
        <div class="mybook-img">
          <img src="images/pic-1.png" alt="" />
        </div>
        <div class="mybook-info">
          <div class="bookdate">
            <span>02.22</span>
            <span>~</span>
          </div>
          <div class="bookreturn">
            <button class="returnbtn">반납하기</button>
          </div>
        </div>
      </div>

      <div class="mybook">
        <div class="mybook-img">
          <img src="images/pic-1.png" alt="" />
        </div>
        <div class="mybook-info">
          <div class="bookdate">
            <span>02.22</span>
            <span>~</span>
          </div>
          <div class="bookreturn">
            <button class="returnbtn">반납하기</button>
          </div>
        </div>
      </div>

      <div class="mybook">
        <div class="mybook-img">
          <img src="images/pic-1.png" alt="" />
        </div>
        <div class="mybook-info">
          <div class="bookdate">
            <span>02.22</span>
            <span>~</span>
          </div>
          <div class="bookreturn">
            <button class="returnbtn">반납하기</button>
          </div>
        </div>
      </div>

      <div class="mybook">
        <div class="mybook-img">
          <img src="images/pic-1.png" alt="" />
        </div>
        <div class="mybook-info">
          <div class="bookdate">
            <span>02.22</span>
            <span>~</span>
          </div>
          <div class="bookreturn">
            <button class="returnbtn">반납하기</button>
          </div>
        </div>
      </div>

      <div class="mybook">
        <div class="mybook-img">
          <img src="images/pic-1.png" alt="" />
        </div>
        <div class="mybook-info">
          <div class="bookdate">
            <span>02.22</span>
            <span>~</span>
          </div>
          <div class="bookreturn">
            <button class="returnbtn">반납하기</button>
          </div>
        </div>
      </div>

      <div class="mybook">
        <div class="mybook-img">
          <img src="images/pic-1.png" alt="" />
        </div>
        <div class="mybook-info">
          <div class="bookdate">
            <span>02.22</span>
            <span>~</span>
          </div>
          <div class="bookreturn">
            <button class="returnbtn">반납하기</button>
          </div>
        </div>
      </div>
    </section>

<jsp:include page="${pageContext.request.contextPath}/semtle/footer.jsp" flush="true" />
  </body>
  <script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>
  <script src="js/script.js" defer></script>
</html>