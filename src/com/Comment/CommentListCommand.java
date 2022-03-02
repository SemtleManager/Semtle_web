package com.Comment;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentListCommand implements CommentCommand{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		
		commentDAO dao = commentDAO.getInstance();
		int postId = Integer.parseInt(request.getParameter("postId"));
		List<commentDTO> lists = dao.getComments(postId);
		
		request.setAttribute("list", lists);
		
		return 1;
	}

	
}
