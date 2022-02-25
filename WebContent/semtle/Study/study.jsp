<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

    <section class="heading">
      <div class="heading-box">
        <span>printf("스터디 공부하고 공유하는 공간이에요")</span>
      </div>
    </section>

    <section class="studyroom">
      <div class="studyroom-top">
        <a href="board_list_Study.doStudy?title=C언어">
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

        <a href="board_list_Study.doStudy?title=JAVA">
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
        <a href="board_list_Study.doStudy?title=파이썬">
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
        
        <a href="board_list_Study.doStudy?title=리눅스">
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