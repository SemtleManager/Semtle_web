package com.User;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Book.bookListDAO;
import com.Book.bookListDTO;

public class infoBookCommand implements UserCommand{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String userId = request.getParameter("userId");
		infoDAO dao = infoDAO.getInstance();
		List<bookListDTO> lists = dao.getInfoBookList(userId);
		
		request.setAttribute("list", lists);
		
		
		
		return 1;
	}

	
}
