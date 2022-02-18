package com.Post;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PostListCommand implements PostCommand{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		HttpSession session = request.getSession();
		String title = (String) session.getAttribute("title");
		System.out.println("title = " + title);
		
		String boardId = "Free";
		int post_count = 0;
		int start = 1;
		int end = 10;
		postDAO dao = postDAO.getInstance();
		
		List<postDTO> lists = null;
		
		System.out.println("@@");
		lists = dao.getPosts(boardId, start, end);
		post_count = dao.getPostCount(boardId);
	
		
		request.setAttribute("list", lists);
		request.setAttribute("post_count", post_count);
		request.setAttribute("title", title);
		
		return 1;
	}

}
