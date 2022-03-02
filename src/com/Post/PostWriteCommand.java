package com.Post;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PostWriteCommand implements PostCommand{
	
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		HttpSession session = request.getSession();
		String title = (String)session.getAttribute("title");
		
		String boardId = (String)session.getAttribute("boardId");
		String nickName = request.getParameter("nickName");
		String userId = request.getParameter("userId");
		String content = request.getParameter("content");
		String createAt = sdf.format(new Timestamp(System.currentTimeMillis()));
		String fileUrl = "";
		int lookUp = 0;
		String updateAt = sdf.format(new Timestamp(System.currentTimeMillis()));
		String status = "1";
		String p_title = "";
		String userRole = request.getParameter("userRole");
		
		
		postDAO dao = postDAO.getInstance();
		dao.writePost(boardId, p_title, userRole, nickName, userId, content, fileUrl, lookUp, createAt, updateAt, status);
		PrintWriter writer = response.getWriter();
		
		writer.println("<script>alert('게시글이 작성되었습니다.'); location.href='board_list_"+boardId+".doPost';</script>");
		writer.close();
		
		return 1;
	}
}
