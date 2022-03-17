package com.Comment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentWriteCommand implements CommentCommand{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
		String num = request.getParameter("num");
		int postId = Integer.parseInt(request.getParameter("postId"+num));
		String nickName = request.getParameter("nickName"+num);
		String userId = request.getParameter("userId"+num);
		String content = request.getParameter("content"+num);
		
		System.out.println("num = " + num);
		System.out.println("postId = " + postId);
		System.out.println("nickName = " + nickName);
		System.out.println("userId = " + userId);
		System.out.println("content = " + content);
		String createAt = sdf.format(new Timestamp(System.currentTimeMillis()));
		String updateAt = sdf.format(new Timestamp(System.currentTimeMillis()));
		
		commentDAO dao = commentDAO.getInstance();
		
		dao.writeComment(postId, nickName, userId, content, createAt);
		PrintWriter writer = response.getWriter();
		
		writer.println("<script>alert('댓글이 작성되었습니다.'); location.href='board_list_Free.doPost';</script>");
		writer.close();
		return 1;
	}

	
	
}
