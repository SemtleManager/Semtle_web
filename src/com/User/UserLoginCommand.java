package com.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLoginCommand implements UserCommand {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		userDAO dao = userDAO.getInstance();
		
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		dao.login(userId, userPassword);
		
		if(dao.login(userId, userPassword) == 1) {
			return 1;
		}else {
			return 0;
		}
		
	}

}
