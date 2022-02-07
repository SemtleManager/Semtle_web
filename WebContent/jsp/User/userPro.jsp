<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.Timestamp" %>
<%@ page import = "java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.User.*"%>

<% request.setCharacterEncoding("utf-8");%> 
<jsp:useBean id="article" class="com.User.userDTO">
	<jsp:setProperty name="article" property="*" />
</jsp:useBean>

<%

	String type = request.getParameter("type");
	System.out.println("type = " + type);
	String id = request.getParameter("userId");
	String passwd  = request.getParameter("userPassword");
	System.out.println("id = " + id);
	System.out.println("passwd = " + passwd);
	userDAO user = userDAO.getInstance();
	
	if(type.equals("confirmId")) {
		
		if(user.confirmId(id)==1){
			
			session.setAttribute("userId",id);//id가져옴
			
			session.setMaxInactiveInterval(60*10*60*60);
			
			//response.sendRedirect("../index.jsp");
			
			System.out.println("findID 성공");
			
%>			
			<script>
				alert("이미 사용중인 아이디입니다.");
				history.go(-1);
			</script>
<%			
		}else{%>
	    <script> 
		  alert("사용 가능한 아이디입니다.");
		  history.go(-1);
		</script>
	<%
		}
	}else if(type.equals("login")) {
		if(user.login(id, passwd)==1){
			
			session.setAttribute("userId", id);//id가져옴
			
			session.setMaxInactiveInterval(60*10*60*60);
			
			System.out.println("login 성공");
			
			response.sendRedirect("../index.jsp");
		}else{%>
	    <script> 
		  alert("아이디 또는 비밀번호가 맞지 않습니다.");
		  history.go(-1);
		</script>
<%
		}
	}else if(type.equals("signup")) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		article.setCreateAt(sdf.format(new Timestamp(System.currentTimeMillis())));
		article.setUpdateAt(sdf.format(new Timestamp(System.currentTimeMillis())));
		article.setUserRole("JE"); //M - 관리자  JS - 회장 JA - 부회장  JB - 총무  JC - 서기  JD - 홍보 JE -회원
		article.setStatus("1");
		user.signUp(article);
%>
	    <script> 
		  alert("셈틀회원이 되신걸 축하합니다~~");
		  location.href = "../jsp/index.jsp";
		</script>
<%
	}else if(type.equals("updateInfo")) {
		
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			article.setCreateAt(sdf.format(new Timestamp(System.currentTimeMillis())));
			article.setUpdateAt(sdf.format(new Timestamp(System.currentTimeMillis())));

			if(user.updateInfo(article) == 1) {
%>
				<script> 
					alert("정보가 변경되었습니다.");
					history.go(-1);
				</script>
				
<%			
			}else {
%>				
				<script> 
				  alert("양식에 맞게 작성해주시기 바랍니다.");
				  history.go(-1);
				</script>
<%		
			}
			
		}else if(type.equals("findUserId")) {
			String userName = request.getParameter("userName");
			String grade = request.getParameter("grade");
			String userCode = request.getParameter("userCode");
			
			String userId = user.findUserId(userName, grade, userCode);
			
%>			
			<script>
				alert("회원님의 아이디는 < <%=userId%> > 입니다.");
				history.go(-1);
			</script>
<%			
		}else if(type.equals("changePasswd")) {
			if(user.changePassword(id, passwd) == 1) {
%>
				<script>
					alert("비밀번호가 변경되었습니다.");
					history.go(-1);
				</script>
<%				
			}
			
		}
%>

	
	