<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html> 
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/semtle/css/style.css" />
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;500;700&display=swap" rel="stylesheet" />
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/semtle/images/favicon.ico" type="image/x-icon" sizes="16X16">
	<link rel="icon" href="${pageContext.request.contextPath}/semtle/images/favicon.ico" type="image/x-icon" sizes="16X16">
    <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
  </head>
  <body>   
	

    <section class="home">
    <jsp:include page="${pageContext.request.contextPath}/semtle/header.jsp" flush="true" />
      <div class="home-main">
        <img src="${pageContext.request.contextPath}/semtle/images/logo.PNG" alt="" />
        <h3>셈틀쟁이</h3>
      </div>
    </section>

    <section class="member">
      <div class="member-box">
        <div class="member-main1">
		<c:choose>
			<c:when test="${not empty userInfo.userId}">
				<c:set var="userId" value="${userId}" />
		          <div class="member-subject">셈하 :)</div>
		          <div class="member-header">
					<h3>${userInfo.userName}</h3>
		            <span> 님 환영합니다</span>
		          </div>
		        </div>
		        <div class="member-main2">
		          <img src="${pageContext.request.contextPath}/semtle/images/char.PNG" alt="" />
		        </div>
	        </c:when>
	        <c:otherwise>
				<div class="member-subject"></div>
         			 <div class="member-header">
						<h3><a href="login_form.do">로그인</a></h3>
           					 <span> 해주시기 바랍니다.</span>
         			</div>
        		</div>
		        <div class="member-main2">
		          <img src="${pageContext.request.contextPath}/semtle/images/char.PNG" alt="" />
		        </div>
	        </c:otherwise>
		</c:choose>
      </div>
    </section>

    <section class="calendar">
      <div class="calendar-subject">
        <span>셈틀 일정</span>
        <i class="fas fa-angle-right"></i>
      </div>
      <div class="calendar-box">
      	<jsp:include page="${pageContext.request.contextPath}/semtle/calendar.jsp" flush="true" />
      </div>
    </section>

	<section class="notice">
      <div class="notice-subject">
        <a href="notice.jsp"><span>공지사항</span></a>
        <a href="notice.jsp"><i class="fas fa-angle-right"></i></a>
      </div>

      <div class="notice-box">
        <div class="notice-heading">
          <h3>셈틀쟁이는 어떤 학회인가요?</h3>
          <i class="fas fa-angle-down"></i>
        </div>
        <div class="notice-content" id="thisone">
          <p>안녕하세요. 셈틀쟁이입니다. 환영해요!! 셈-하!!</p>
        </div>
      </div>

      <div class="notice-box">
        <div class="notice-heading">
          <h3>셈틀쟁이 웹은 어떻게 이용하나요?</h3>
          <i class="fas fa-angle-down"></i>
        </div>
        <div class="notice-content">
          <p>가입 문자 전화 디엠 주세요 ㅋㅋ</p>
        </div>
      </div>
    </section>
    
    <jsp:include page="${pageContext.request.contextPath}/semtle/booker.jsp" flush="true" />

	<jsp:include page="${pageContext.request.contextPath}/semtle/footer.jsp" flush="true" />
  </body>
</html>