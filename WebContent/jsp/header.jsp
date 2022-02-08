<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

   String userId = (String) session.getAttribute("userId");
   String title = request.getParameter("title");
   
%>



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
<%
   
   if(title == null) {   
%>
   <header>
   <a href=""></a>

   <nav class="navbar">
     <a href="${pageContext.request.contextPath}/jsp/Notice/notice.jsp?title=공지사항">공지사항</a>
     <a href="${pageContext.request.contextPath}/jsp/Board/board.jsp?title=자유게시판">자유게시판</a>
     <a href="${pageContext.request.contextPath}/jsp/Study/study.jsp?title=스터디룸">스터디룸</a>
     <a href="${pageContext.request.contextPath}/jsp/Bookboard/book.jsp?title=책대여">책 대여</a>
     <a href="#">공모전(아직 준비중입니다)</a>
   </nav>
   
   <div class="icons">
 <%
       if(userId == null) {
 %>
        <a href="${pageContext.request.contextPath}/jsp/User/login.jsp?title=로그인"><i class="fas fa-user" id="sm-login"></i></a>
<% }else {
%>
      <a href="${pageContext.request.contextPath}/jsp/User/info.jsp?title=정보수정"><i class="fas fa-user" id="sm-login"></i></a>
<%         
}
 %>
        <i class="fas fa-bars header-menu" id="menu-bars"></i>
      </div>
<%}else { %>
   <header>
    <a href=""></a>

    <nav class="navbar">
     <a href="${pageContext.request.contextPath}/jsp/Notice/notice.jsp?title=공지사항">공지사항</a>
     <a href="${pageContext.request.contextPath}/jsp/Board/board.jsp?title=자유게시판">자유게시판</a>
     <a href="${pageContext.request.contextPath}/jsp/Study/study.jsp?title=스터디룸">스터디룸</a>
     <a href="${pageContext.request.contextPath}/jsp/Bookboard/book.jsp?title=책대여">책 대여</a>
     <a href="#">공모전(아직 준비중입니다)</a>
    </nav>

  </header>
  <header>
    <a href="javascript:history.back();" id="header-before"><i class="fas fa-angle-left"></i></a>

    <nav class="navbar">
     <a href="${pageContext.request.contextPath}/jsp/Notice/notice.jsp?title=공지사항">공지사항</a>
     <a href="${pageContext.request.contextPath}/jsp/Board/board.jsp?title=자유게시판">자유게시판</a>
     <a href="${pageContext.request.contextPath}/jsp/Study/study.jsp?title=스터디룸">스터디룸</a>
     <a href="${pageContext.request.contextPath}/jsp/Bookboard/book.jsp?title=책대여">책 대여</a>
      <a href="#">공모전(아직 준비중입니다)</a>
    </nav>

    <span id="header-name"><%=title %></span>
    
   
     <div class="icons">
      <a href="${pageContext.request.contextPath}/jsp/index.jsp"><i class="fas fa-home" id="home-bar"></i></a>
      <i class="fas fa-bars header-menu" id="menu-bars"></i> 
    </div>
  <%} %>


    
</header>

<script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/jsp/js/script.js" defer></script>
</header>
</body>
</html>


 