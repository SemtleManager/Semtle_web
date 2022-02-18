package com.Post;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PostDeleteCommand implements PostCommand{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int postId = Integer.parseInt(request.getParameter("postId"));
		HttpSession session = request.getSession();
		String boardId = (String) session.getAttribute("boardId");
		postDAO dao = postDAO.getInstance();
		
		PrintWriter writer = response.getWriter();
		
		if(dao.deletePost(postId) == 1) {
			writer.println("<script>alert('게시글이 삭제되었습니다.'); location.href='board_list_"+boardId+".doPost';</script>");
			writer.close();
			return 1;
		}else {
			writer.println("<script>alert('삭제에 실패하였습니다.'); history.go(-1);</script>");
			writer.close();
			return 0;
		}
		
	}
	
}
