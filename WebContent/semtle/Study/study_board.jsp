<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <span>printf("꾸르꾸르잼 C언어 스터디룸입니당~~")</span>
      </div>
    </section>

    <section class="noticeboard">
     <c:choose>
    <c:when test="${ empty userInfo.userId }">
    
    	<table style="margin:0 auto;">
			<td style="height:300px;">
				셈틀회원만이 이용 가능한 공간입니다.
			</td>
		</table>
    
      </c:when>
      <c:otherwise>
      	<c:choose>
    	<c:when test="${not empty userInfo.userId && userIndo.userRole != '셈틀회원'}">
            <div class="studyroom-head">
       			 <a href="study_write.doStudy"><span>글쓰기</span></a>
      		</div>		
      	</c:when>
    </c:choose>
   
    
	<c:choose>
    	<c:when test="${ post_count == 0}">
      	<table style="margin:0 auto;">
			<td style="height:300px;">
				게시판에 저장된 글이 없습니다.
			</td>
		</table>
		</c:when>
		<c:otherwise>
		<c:forEach items="${ list }" var="dto" varStatus="i">
      <div class="noticeboard-box">
        <a href="study_view.doStudy?postId=${ dto.postId }">
          <div class="notice-content">
            <div class="notice-content-head">
              <span>${ dto.p_title }</span>
              <c:choose>
              <c:when test="${ dto.fileUrl  ne null }" >
              	<i class="fas fa-paperclip"></i>
              </c:when>
              </c:choose>
            </div>
            <div class="notice-content-foot">
              <span>${ dto.userRole }</span>
              <span>|</span>
              <span>${ dto.updateAt }</span>
            </div>
          </div>
        </a>

       </div>
       </c:forEach>
      <div class="page">
		<ul class="paging modal">
		
			<li> <a href="board_list_Study.doStudy?cpage=${prevBlock}" class="arrow left">&lt;&lt;</a></li>
			<c:forEach var="i" begin="1" end="${ pageCount }" step="1">
     		<li> <a href="board_list_Study.doStudy?cpage=${i}" class="num">${i}</a></li>
     		</c:forEach>
      		<li> <a href="board_list_Study.doStudy?cpage=${nextBlock}" class="arrow right">&gt;&gt;</a></li>
		
      	</ul>
	</div>
      </c:otherwise>
      
      </c:choose>
      
      </c:otherwise>
      </c:choose>
      
    </section>

<jsp:include page="${pageContext.request.contextPath}/semtle/footer.jsp" flush="true" />
  </body>
</html>