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

    <section class="heading">
      <div class="heading-box">
        <span>printf("꾸르꾸르잼 C언어 스터디룸입니당~~")</span>
      </div>
    </section>

    <section class="noticeboard">
      <div class="studyroom-head">
        <a href="${pageContext.request.contextPath}/jsp/Study/study_board_text.jsp?title=스터디룸"><span>글쓰기</span></a>
      </div>
      <div class="noticeboard-box">
        <a href="${pageContext.request.contextPath}/jsp/Study/study_board_room.jsp?title=스터티룸">
          <div class="notice-content">
            <div class="notice-content-head">
              <span>C언어 스터디계획 필독!! 잘해봅시다 :)</span>
              <i class="fas fa-paperclip"></i>
            </div>
            <div class="notice-content-foot">
              <span>역곡불주먹</span>
              <span>|</span>
              <span>01.06</span>
            </div>
          </div>
        </a>

        <div class="notice-content">
          <div class="notice-content-head">
            <span>C언어 스터디계획 필독!! 잘해봅시다 :)</span>
            <i class="fas fa-paperclip"></i>
          </div>
          <div class="notice-content-foot">
            <span>역곡불주먹</span>
            <span>|</span>
            <span>01.06</span>
          </div>
        </div>

        <div class="notice-content">
          <div class="notice-content-head">
            <span>C언어 스터디계획 필독!! 잘해봅시다 :)</span>
          </div>
          <div class="notice-content-foot">
            <span>역곡불주먹</span>
            <span>|</span>
            <span>01.06</span>
          </div>
        </div>

        <div class="notice-content">
          <div class="notice-content-head">
            <span>C언어 스터디계획 필독!! 잘해봅시다 :)</span>
            <i class="fas fa-paperclip"></i>
          </div>
          <div class="notice-content-foot">
            <span>역곡불주먹</span>
            <span>|</span>
            <span>01.06</span>
          </div>
        </div>

        <div class="notice-content">
          <div class="notice-content-head">
            <span>C언어 스터디계획 필독!! 잘해봅시다 :)</span>
          </div>
          <div class="notice-content-foot">
            <span>역곡불주먹</span>
            <span>|</span>
            <span>01.06</span>
          </div>
        </div>
      </div>
    </section>

<jsp:include page="${pageContext.request.contextPath}/jsp/footer.jsp" flush="true" />
  </body>
</html>