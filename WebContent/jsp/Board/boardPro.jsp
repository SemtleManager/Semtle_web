<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.Timestamp" %>
<%@ page import = "java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.Post.*"%>

<% request.setCharacterEncoding("utf-8");%> 
<jsp:useBean id="article" class="com.Post.postDTO">
	<jsp:setProperty name="article" property="*" />
</jsp:useBean>

<%

	int postId = 0;
	String boardId = request.getParameter("boardId");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm:ss");
	String type = request.getParameter("type");
	System.out.println("type = " + type);
	String id = request.getParameter("id");
	String passwd  = request.getParameter("passwd");
	
	postDAO post = postDAO.getInstance();
	
	//글쓰기
	if(type.equals("posting")) {
		
		
		article.setCreateAt(sdf.format(new Timestamp(System.currentTimeMillis())).toString());
		article.setUpdateAt(sdf.format(new Timestamp(System.currentTimeMillis())).toString());
		article.setBoardId(boardId);
		post.writePost(article);
%>
		<script>
			alert("게시물을 작성하였습니다.");
			location.href = "${pageContext.request.contextPath}/jsp/Board/board.jsp?title=자유게시판";
		</script>

<%
	}else if(type.equals("updatePost")) {
		
		postId = Integer.parseInt(request.getParameter("postId"));
		article.setUpdateAt(sdf.format(new Timestamp(System.currentTimeMillis())).toString());
		if(post.updatePost(article, postId) == 1) {
%>		
		<script>
			alert("게시물이 수정되었습니다.");
			location.href = "${pageContext.request.contextPath}/jsp/Board/board.jsp?postId=<%=postId%>";
		</script>	
<%
		}else {
%>
		<script>
			alert("수정에 실패했습니다.");	
			history.go(-1);
		</script>		
<%			
		}
	} else if(type.equals("deletePost")) {
%>
		postId = Integer.parseInt(request.getParameter("postId"));
		<script>
			var bool = confirm("정말로 삭제하시겠습니까?");
			if(bool) {

				<%post.deletePost(postId);%>
				alert("성공적으로 삭제되었습니다.");
				location.href = "${pageContext.request.contextPath}/jsp/Board/board.jsp";
			}else {
				history.go(-1);
			}
		</script>
	
<%		
	}

%>			
	

	