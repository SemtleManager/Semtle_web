<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.util.List" %>
<%@ page import="com.User.*" %>

<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="article" class="com.User.userDTO">
	<jsp:setProperty name="article" property="*" />
</jsp:useBean>


<%
	
	userDAO user = userDAO.getInstance();
	int user_cnt = user.getUserCnt();
	List<userDTO> userList = null;
	
	if(user_cnt > 0)
		userList = user.getUserList(1, 10);
	
	
	for(int i = 0; i < user_cnt; i++) {
		userDTO list = userList.get(i);
		
		System.out.println(list.getGrade());
		System.out.println(list.getUserName());
		System.out.println(list.getUserId());
		System.out.println(list.getUserPassword());
		System.out.println(list.getUserEmail());
		System.out.println(list.getUserPhone());
		System.out.println(list.getUserRole());
		System.out.println(list.getCreateAt());
		System.out.println(list.getUpdateAt());
		System.out.println(list.getStatus());
		
		System.out.println("---------------");
	}


%>
<html>
<body>

<span></span>

</body>

</html>

