<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

    <section class="heading">
      <div class="heading-box">
        <span>printf("책 대여하세용~!")</span>
      </div>
    </section>

    <section class="bookboard talkboard">
      <div class="bookboard-head talkboard-head">
        <form action="" class="booksearch_form">
          <input
            type="text"
            placeholder="책 제목을 입력해주세요"
            class="booksearch"
          />
          <i class="fas fa-search"></i>
        </form>
      </div>
    </section>

    <div class="takeoutbox-head">
      <span>책 상세 정보</span>
    </div>

    <section class="takeoutbox">
      <div class="takeoutbox-left">
        <div class="takeout-image">
          <img src="images/pic-1.png" alt="" />
        </div>
      </div>
      <div class="takeoutbox-right">
        <div class="takeoutbox-title">
          <span>C언어 일취월장</span>
        </div>
        <div class="takeoutbox-info">
          <span>저자 </span>
          <span class="info_slash">|</span>
          <span>김대현</span>
        </div>
        <div class="takeoutbox-state">
          <span>대출상태</span>
          <span class="info_slash">|</span>
          <span class="state_text">대출가능</span>
        </div>
        <div class="takeoutbox-count">
          <span>대출가능 수량</span>
          <span class="info_slash">|</span>
          <span>2</span>
        </div>
        <div class="takeoutbox-btn">
          <button class="takeout_btn">대출하기</button>
          <button class="reserve_btn">예약하기</button>
        </div>
      </div>
    </section>

    <div class="takeoutbox-head">
      <span>책 목록</span>
    </div>
    <div class="book">
      <jsp:include page="${pageContext.request.contextPath}/semtle/booker.jsp" flush="true" />
	</div>
    <jsp:include page="${pageContext.request.contextPath}/semtle/footer.jsp" flush="true" />
  </body>
</html>