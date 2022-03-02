package com.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLogoutCommand implements UserCommand{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		session.getAttribute("userInfo");
		
		session.invalidate();
		
		PrintWriter writer = response.getWriter();
		
		writer.println("<script>alert('로그아웃 되었습니다.'); location.href='home.do';</script>");
		writer.close();
		
		return 1;
	}

	
	
}
