<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/semtle/images/favicon.ico" type="image/x-icon" sizes="16X16">
	<link rel="icon" href="${pageContext.request.contextPath}/semtle/images/favicon.ico" type="image/x-icon" sizes="16X16">
    <title>SemtleWeb</title>
  </head>

  <body>
    <jsp:include page="${pageContext.request.contextPath}/semtle/header.jsp" flush="true" />

    <section class="heading">
      <div class="heading-box">
        <span>printf("책 대여하세용~!")</span>
      </div>
    </section>

    <section class="bookboard">
      <div class="book-head">
        <input
          type="text"
          placeholder="책 제목을 검색하세요"
          onclick="this.placeholder=''"
          onblur="this.placeholder = '책 제목을 검색하세요'"
        />
        <i class="fas fa-search"></i>
      </div>

      <jsp:include page="${pageContext.request.contextPath}/semtle/booker.jsp" flush="true" />
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