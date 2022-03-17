<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script language="javascript">
    function btn_click() {
		document.getElementById("bookSearch").submit();
		
	}
    
    function checkout_btn(num) {
    	document.getElementById("checkout"+num).submit();
    }
    
    function cancel_btn(num) {
    	document.getElementById("cancel"+num).submit();
    }
    
    </script>
  </head>

  <body>
    <jsp:include page="${pageContext.request.contextPath}/semtle/header.jsp" flush="true" />

    <section class="heading">
      <div class="heading-box">
        <span>printf("책 대여 목록 확인하세요 ~~")</span>
      </div>
    </section>

	<c:choose>
	<c:when test="${ not empty list }">
	    <div class="takeoutbox-head">
	      <span>책 상세 정보</span>
	    </div>
		<c:forEach items="${ list }" var="dto" varStatus="i">
		    <section class="takeoutbox">
		      <div class="takeoutbox-left">
		        <div class="takeout-image">
		          <img src="${pageContext.request.contextPath}/bookIMG/${ dto.bookImage }" alt="" />
		        </div>
		      </div>
		      <div class="takeoutbox-right">
		        <div class="takeoutbox-title">
		          <span>${ dto.bookName }</span>
		        </div>
		        <div class="takeoutbox-info">
		          <span>저자 </span>
		          <span class="info_slash">|</span>
		          <span>${ dto.bookAuthor }</span>
		        </div>
		        <div class="takeoutbox-state">
		          <span>대출상태</span>
		          <span class="info_slash">|</span>
		          <c:choose>
		          <c:when test="${ dto.bookCount != 0 }">
		          <span class="state_text" style="color:green">${ dto.status }</span>
		          </c:when>
		          <c:otherwise>
		          <span class="state_text" style="color:red">${ dto.status }</span>
		          </c:otherwise>
		          </c:choose>
		        </div>
		        <div class="takeoutbox-count">
		          <span>대출가능 수량</span>
		          <span class="info_slash">|</span>
		          <span>${ dto.bookCount }</span>
		        </div>
		        <c:choose>
		        <c:when test="${ not empty userInfo.userId }">
			        <form method="post" action="checkout.doBook?num=${ i.index }" id="checkout${ i.index }">
			        	<input type="hidden" name="bookId${ i.index }" value="${ dto.bookId }">
			        	<input type="hidden" name="userId" value="${ userInfo.userId }">
			        </form>
			        <form method="post" action="cancel.doBook?num=${ i.index }" id="cancel${ i.index }">
			        	<input type="hidden" name="bookId${ i.index }" value="${ dto.bookId }">
			        	<input type="hidden" name="userId" value="${ userInfo.userId }">
			        </form>
			        <div class="takeoutbox-btn">
			        <c:choose>
			        <c:when test="${ userInfo.userId eq dto.userId }">
						<button class="takeout_btn" onclick='cancel_btn(${ i.index });'>반납하기</button>			          
			        </c:when>
			        </c:choose>
			        </div>
		        </c:when>
		        </c:choose>
		      </div>
		    </section>
	    </c:forEach>
	</c:when>
	</c:choose>
    <jsp:include page="${pageContext.request.contextPath}/semtle/footer.jsp" flush="true" />
  </body>
</html>