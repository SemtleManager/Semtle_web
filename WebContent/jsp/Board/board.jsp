<%@page import="com.User.*"%>
<%@page import="com.Post.*"%>
<%@ page import = "java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%

	String userId = (String) session.getAttribute("userId");
		
	List<postDTO> postList = null;
	
	
	postDAO posts = postDAO.getInstance();
	int number = 0;
	int post_count = posts.getPostCount("free");
	
	if(post_count > 0)
		postList = posts.getPosts("free", 1, 10);
	

%>


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
        <span>printf("셈회원들과 마음껏 소통하는 공간이에요")</span>
      </div>
    </section>

    <section class="talkboard">
    
    <%
    	if(userId != null) {
    %>
    
      <div class="talkboard-head">
        <a href="${pageContext.request.contextPath}/jsp/Board/board_text.jsp?title=자유게시판"
          ><span class="talkboard-head_write">글쓰기</span></a
        >
      </div>
    <%
    	}
    
       if(post_count == 0) { %>
      	<table style="margin:0 auto;">
			<td style="height:300px;">
				게시판에 저장된 글이 없습니다.
			</td>
		</table>
      <!--  -->
      <% }else { 
      	for(int i = 0; i < postList.size(); i++) {
      		postDTO post =  postList.get(i);
      %>		
      
      <div class="talkboard-box">
        <div class="talk-content">
          <div class="talk-content-head">
            <img src="${pageContext.request.contextPath}/jsp/images/char.PNG" alt="" />
            <div class="talk-content-head2">
              <span><%=post.getUserId() %></span>
              <span><%=post.getUpdateAt() %></span>
            </div>
          </div>
          <div class="talk-content-main">
            <span>
				<%=post.getContent() %>
             </span>
          </div>
          <div class="talk-content-foot">
            <div class="talk-content-foot-etc">
              <span>댓글<i class="far fa-comment-dots talk-comment"></i></span>
            </div>
          </div>
        </div>
      </div>
      
      <%		
      	}
      }
      %>
      
<%--       <div class="talkboard-box">
        <div class="talk-content">
          <div class="talk-content-head">
            <img src="${pageContext.request.contextPath}/jsp/images/char.PNG" alt="" />
            <div class="talk-content-head2">
              <span>역곡불주먹</span>
              <span>01.08</span>
            </div>
          </div>
          <div class="talk-content-main">
            <span
              >동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세
              무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세</span
            >
          </div>
          <div class="talk-content-foot">
            <div class="talk-content-foot-etc">
              <i class="far fa-comment-dots talk-comment"></i>
              <span class="abc">댓글 3</span>
            </div>
            <div class="talk-content-comment">
              <div class="talk-content-commentbox">
                <div class="talk-content-comment-text">
                  <span>오~~ 좋아요~!!</span>
                </div>
                <div class="talk-content-comment-icon">
                  <i class="fas fa-times"></i>
                </div>
              </div>

              <div class="talk-content-commentbox">
                <div class="talk-content-comment-text">
                  <span>오~~ 좋아요~!!</span>
                </div>
                <div class="talk-content-comment-icon">
                  <i class="fas fa-times"></i>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div> --%>

    </section>

<jsp:include page="${pageContext.request.contextPath}/jsp/footer.jsp" flush="true" />
  </body>
</html>
