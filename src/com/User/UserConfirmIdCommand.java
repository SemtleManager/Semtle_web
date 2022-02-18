package com.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserConfirmIdCommand implements UserCommand {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();
		userDAO dao = userDAO.getInstance();
		if(dao.confirmId(request.getParameter("userId")) == 1) {
			writer.println("<script>alert('이미 사용중인 아이디입니다.'); history.go(-1);</script>");
			writer.close();
		}else {
			writer.println("<script>alert('사용 가능한 아이디입니다.'); history.go(-1);</script>");
			writer.close();
		}
		
		return 1;
		
	}

}
