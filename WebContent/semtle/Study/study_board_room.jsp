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
              <span>C언어 스터디계획 필독!! 잘해봅시다 :)</span>
              <span>역곡불주먹 | 01.08</span>
            </div>
          </div>
          <div class="notice_text-content-main">
            <span>
              2022 c언어 스터디 계획입니다. 첨부파일 꼭 확인해주세요! 앞으로
              잘해봅시당~~ 2022 c언어 스터디 계획입니다. 첨부파일 꼭
              확인해주세요! 앞으로 잘해봅시당~~ 2022 c언어 스터디 계획입니다.
              첨부파일 꼭 확인해주세요! 앞으로 잘해봅시당~~ 2022 c언어 스터디
              계획입니다. 첨부파일 꼭 확인해주세요! 앞으로 잘해봅시당~~
            </span>
          </div>
          <div class="notice_text-content-foot studyboard-foot">
            <div class="notice_text-content-foot-etc studyboard-foot-etc">
              <span id="studyboard-foot-attach">첨부파일</span>
              <i class="fas fa-paperclip"></i>
            </div>
          </div>
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
    <jsp:include page="${pageContext.request.contextPath}/semtle/footer.jsp" flush="true" />
  </body>
</html>