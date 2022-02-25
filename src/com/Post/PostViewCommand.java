package com.Post;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PostViewCommand implements PostCommand{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int postId = Integer.parseInt(request.getParameter("postId"));
		
		postDAO dao = postDAO.getInstance();
		postDTO dto = dao.readPost(postId);
		
		request.setAttribute("post", dto);
		
		return 0;
	}

}
