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
    <script language="javascript">
    function btn_click(str) {
		if(str=="book") {
			info.action="infoBook.do";
		} else if(str=="post") {
			info.action="infoPost.do";
		}
		
	}
    </script>
  </head>

  <body>
    <jsp:include page="${pageContext.request.contextPath}/semtle/header.jsp" flush="true" />

    <section class="mypage-heading">
      <div class="mypage-heading-left"></div>
      <div class="mypage-heading-info">
        <img src="images/char.PNG" alt="" />
        <span>${ userInfo.userName }</span>
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
        <span>${ postCnt }</span>
      </div>
      <div class="mypage-box-content mypageboxborder">
        <span class="content-head">내가 쓴 댓글</span>
        <span>${ commentCnt }</span>
      </div>
      <div class="mypage-box-content">
        <span class="content-head">내가 대여한 책</span>
        <span>${ bookCnt }</span>
      </div>
    </section>

    <section class="mypage-content">
    <form id="info" name="info" method="post">
    	<input type="hidden" name="userId" value="${ userInfo.userId }">
    </form>
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
      <a href="infoBook.do?userId=${ userInfo.userId }">
      <div class="mypage-content-icon" onclick="btn_click('book');">
        <div class="mypage-content-icon-left">
          <i class="fas fa-book"></i>
          <span>대여한 책</span>
        </div>
        <div class="mypage-content-icon-right">
          <i class="fas fa-angle-right"></i>
        </div>
      </div>
      </a>
      <a href="infoPost.do?userId=${ userInfo.userId }">
      <div class="mypage-content-icon" onclick="btn_click('post');">
        <div class="mypage-content-icon-left">
          <i class="far fa-edit"></i>
          <span>내가 쓴 글</span>
        </div>
        <div class="mypage-content-icon-right">
          <i class="fas fa-angle-right"></i>
        </div>
      </div>
      </a>
    </section>

	<jsp:include page="${pageContext.request.contextPath}/semtle/footer.jsp" flush="true" />
  </body>
</html>