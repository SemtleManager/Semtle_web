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

    <section class="heading">
      <div class="heading-box">
        <span>printf("스터디 공부하고 공유하는 공간이에요")</span>
      </div>
    </section>

    <section class="studyroom">
      <div class="studyroom-top">
        <a href="${pageContext.request.contextPath}/semtle/Study/study_board.jsp?title=스터디룸&lang=C">
          <div class="studyroom-box">
            <div class="study-content">
              <div class="study-content-head">
                <img src="${pageContext.request.contextPath}/semtle/images/clanguage.jpg" alt="" />
              </div>
              <div class="study-content-main">
                <span>꾸르꾸르잼 C언어</span>
              </div>
            </div>
          </div>
        </a>

        <a href="${pageContext.request.contextPath}/semtle/Study/study_board.jsp?title=스터디룸&lang=JAVA">
          <div class="studyroom-box">
            <div class="study-content">
              <div class="study-content-head">
                <img src="${pageContext.request.contextPath}/semtle/images/java.PNG" alt="" />
              </div>
              <div class="study-content-main">
                <span>냠냠 씹어먹는 JAVA</span>
              </div>
            </div>
          </div>
        </div>
        </a>
        
      <div class="studyroom-top">
        <a href="${pageContext.request.contextPath}/semtle/Study/study_board.jsp?title=스터디룸&lang=PYTHON">
          <div class="studyroom-box">
            <div class="study-content">
              <div class="study-content-head">
                <img src="${pageContext.request.contextPath}/semtle/images/python.PNG" alt="" />
              </div>
              <div class="study-content-main">
                <span>뽀개버려 PYTHON</span>
              </div>
            </div>
          </div>
        </a>
        
        <a href="${pageContext.request.contextPath}/semtle/Study/study_board.jsp?title=스터디룸&lang=LINUX">
          <div class="studyroom-box">
            <div class="study-content">
              <div class="study-content-head">
                <img src="${pageContext.request.contextPath}/semtle/images/linux.PNG" alt="" />
              </div>
              <div class="study-content-main">
                <span>개천재 짱짱맨 LINUX</span>
              </div>
            </div>
          </div>
        </a>
        
      </div>
    </section>

    <jsp:include page="${pageContext.request.contextPath}/semtle/footer.jsp" flush="true" />
    </body>
</html>