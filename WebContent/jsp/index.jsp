<%@page import="com.User.userDTO"%>
<%@page import="com.User.userDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.User.*" %>
    
<%
	String userId = (String) session.getAttribute("userId");
	String nickName = null;

	userDAO instance = userDAO.getInstance();
	userDTO user = new userDTO();
	
	if(userId != null)
		user = instance.selectInfo(userId);
	
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
	

    <section class="home">
    <jsp:include page="${pageContext.request.contextPath}/jsp/header.jsp" flush="true" />
      <div class="home-main">
        <img src="${pageContext.request.contextPath}/jsp/images/logo.PNG" alt="" />
        <h3>셈틀쟁이</h3>
      </div>
    </section>

    <section class="member">
      <div class="member-box">
        <div class="member-main1">
<%
		if(userId != null) {
			
%>
          <div class="member-subject">셈하 :)</div>
          <div class="member-header">
			<h3><%=user.getUserName()%></h3>
            <span> 님 환영합니다</span>
          </div>
        </div>
        <div class="member-main2">
          <img src="${pageContext.request.contextPath}/jsp/images/char.PNG" alt="" />
        </div>
<%
		} else {
%>			
	      <div class="member-subject"></div>
          <div class="member-header">
			<h3><a href="${pageContext.request.contextPath}/jsp/User/login.jsp">로그인</a></h3>
            <span> 해주시기 바랍니다.</span>
          </div>
        </div>
        <div class="member-main2">
          <img src="${pageContext.request.contextPath}/jsp/images/char.PNG" alt="" />
        </div>
	
			
<%		
		}
%>
      </div>
    </section>

    <section class="calendar">
      <div class="calendar-subject">
        <span>셈틀 일정</span>
        <i class="fas fa-angle-right"></i>
      </div>
      <div class="calendar-box">
      	<jsp:include page="${pageContext.request.contextPath}/jsp/calendar.jsp" flush="true" />
      </div>
    </section>

    <section class="notice">
      <div class="notice-subject">
        <a href="notice.jsp"><span>공지사항</span></a>
        <a href="notice.jsp"><i class="fas fa-angle-right"></i></a>
      </div>

      <div class="notice-box notice-box1">
        <div class="notice-heading notice-heading1">
          <h3>셈틀쟁이는 어떤 학회인가요?</h3>
          <i class="fas fa-angle-down"></i>
        </div>
        <div class="notice-content notice-content1">
          <p>안녕하세요. 셈틀쟁이입니다. 환영해요!! 셈-하!!</p>
        </div>
      </div>

      <div class="notice-box notice-box2">
        <div class="notice-heading notice-heading2">
          <h3>셈틀쟁이 웹은 어떻게 이용하나요?</h3>
          <i class="fas fa-angle-down"></i>
        </div>
        <div class="notice-content notice-content2">
          <p>안녕하세요. 셈틀쟁이입니다. 환영해요!! 셈-하!!</p>
        </div>
      </div>
    </section>
    
    <jsp:include page="${pageContext.request.contextPath}/jsp/booker.jsp" flush="true" />

	<jsp:include page="${pageContext.request.contextPath}/jsp/footer.jsp" flush="true" />
  </body>
</html>