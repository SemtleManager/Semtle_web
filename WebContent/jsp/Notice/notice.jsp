<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/css/style.css" />
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;500;700&display=swap" rel="stylesheet" />

    <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
  </head>
  <body>
<jsp:include page="${pageContext.request.contextPath}/jsp/header.jsp" flush="true" />

    <section class="heading">
      <div class="heading-box">
        <span>printf("공지사항 꼭 확인해주세요")</span>
      </div>
    </section>

    <section class="noticeboard">
      <div class="noticeboard-box">
        <a href="notice_text.jsp?title=공지사항">
          <div class="notice-content">
            <div class="notice-content-head">
              <span>[공지] 셈틀 회원 모집합니다 :)</span>
            </div>
            <div class="notice-content-foot">
              <span>2022.01.06</span>
            </div>
          </div>
        </a>

        <div class="notice-content">
          <div class="notice-content-head">
            <span>[공지] 셈틀 회원 모집합니다 :)</span>
          </div>
          <div class="notice-content-foot">
            <span>2022.01.06</span>
          </div>
        </div>

        <div class="notice-content">
          <div class="notice-content-head">
            <span>[공지] 셈틀 회원 모집합니다 :)</span>
          </div>
          <div class="notice-content-foot">
            <span>2022.01.06</span>
          </div>
        </div>

        <div class="notice-content">`
          <div class="notice-content-head">
            <span>[공지] 셈틀 회원 모집합니다 :)</span>
          </div>
          <div class="notice-content-foot">
            <span>2022.01.06</span>
          </div>
        </div>

        <div class="notice-content">
          <div class="notice-content-head">
            <span>[공지] 셈틀 회원 모집합니다 :)</span>
          </div>
          <div class="notice-content-foot">
            <span>2022.01.06</span>
          </div>
        </div>
      </div>
    </section>

<jsp:include page="${pageContext.request.contextPath}/jsp/footer.jsp" flush="true" />

</body>
</html>