package com.Comment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentDeleteCommand implements CommentCommand{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		int postId = Integer.parseInt(request.getParameter("postId"));
		
		commentDAO dao = commentDAO.getInstance();
		
		PrintWriter writer = response.getWriter();
		
		if(dao.deleteComment(postId) == 1) {
			writer.println("<script>alert('게시글이 삭제되었습니다.'); location.href='board_list_Free.doPost';</script>");
			writer.close();
			return 1;
		}else {
			writer.println("<script>alert('삭제에 실패하였습니다.'); history.go(-1);</script>");
			writer.close();
			return 0;
		}
	}

	
	
	
}
