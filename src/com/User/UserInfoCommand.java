package com.User;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserInfoCommand implements UserCommand{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		userDAO dao = userDAO.getInstance();
		HttpSession session = request.getSession();
		System.out.println("s : " + request.getParameter("userId"));
		System.out.println("s : " + request.getParameter("userPassword"));
		userDTO dto = dao.selectInfo(request.getParameter("userId"), request.getParameter("userPassword"));
		
		session.setAttribute("userInfo", dto);
		
		return 1;
		
	}

}
