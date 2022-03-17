package com.Book;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class bookCheckoutCommand implements BookCommand{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String num = request.getParameter("num");
		System.out.println("num = " + num);
		int bookId = Integer.parseInt(request.getParameter("bookId"+num));
		String userId = request.getParameter("userId");
		bookListDAO dao = bookListDAO.getInstance();
		PrintWriter writer = response.getWriter();
		
		if(dao.checkOut(bookId, "대출 중", userId) == 1) {
			writer.println("<script>alert('대출 되었습니다.'); location.href='booklist.doBook';</script>");
			writer.close();
			return 1;
		}else {
			writer.println("<script>alert('대출 실패하였습니다.'); history.go(-1);</script>");
			writer.close();
			return 0;
		}
	}

	
}
