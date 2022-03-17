package com.Book;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookSearchCommand implements BookCommand{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String bookName = request.getParameter("bookName");
		System.out.println("bookName : " + bookName);
		bookListDAO dao = bookListDAO.getInstance();
		List<bookListDTO> lists = dao.getSearchBookList(bookName);
		
		request.setAttribute("list", lists);
		
		return 0;
	}

	
	
}
