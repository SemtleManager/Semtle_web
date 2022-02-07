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
    <jsp:include page="${pageContext.request.contextPath}/jsp/header.jsp" flush="true" />

    <section class="notice_text">
      <div class="notice_text-box">
        <div class="notice_text-content">
          <div class="notice_text-content-head">
            <img src="${pageContext.request.contextPath}/jsp/images/char.PNG" alt="" />
            <div class="notice_text-content-head2">
              <span>[공지] 2022 셈틀 회원 모집합니다 :)</span>
              <span>회장 | 01.08</span>
            </div>
          </div>
          <div class="notice_text-content-main">
            <span>
              2022 셈틀 회원 모집! 1~2월 모집 모집! 많은 신청 부탁드립니당~
            </span>
          </div>
          <div class="notice_text-content-foot">
            <div class="notice_text-content-foot-etc"></div>
          </div>
        </div>
      </div>
    </section>

<jsp:include page="${pageContext.request.contextPath}/jsp/footer.jsp" flush="true" />
  </body>
  <script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>
  <script src="js/script.js" defer></script>
</html>