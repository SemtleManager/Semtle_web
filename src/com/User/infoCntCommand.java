package com.User;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class infoCntCommand implements UserCommand{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		infoDAO dao = infoDAO.getInstance();
		String userId = request.getParameter("userId");
		
		int bookCnt = dao.getBookCnt(userId);
		int commentCnt = dao.getCommentCnt(userId);
		int postCnt = dao.getPostCnt(userId);
		
		request.setAttribute("bookCnt", bookCnt);
		request.setAttribute("commentCnt", commentCnt);
		request.setAttribute("postCnt", postCnt);
		
		
		return 1;
	}
	
	

}
