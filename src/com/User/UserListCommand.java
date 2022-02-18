package com.User;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserListCommand implements UserCommand{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// TODO Auto-generated method stub
		
		userDAO dao = userDAO.getInstance();
		List<userDTO> lists = dao.getUserList(1, 10);
		request.setAttribute("list", lists);
		
		return 1;
	}
	
}
