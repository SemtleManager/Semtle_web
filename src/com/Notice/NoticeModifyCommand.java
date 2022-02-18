package com.Notice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Post.postDAO;

public class NoticeModifyCommand implements NoticeCommand{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		HttpSession session = request.getSession();
		String title = (String)session.getAttribute("title");
		String boardId = (String)session.getAttribute("boardId");
		String p_title = request.getParameter("p_title");
		String content = request.getParameter("content");
		String fileUrl = "";
		String updateAt = sdf.format(new Timestamp(System.currentTimeMillis()));
		int postId = Integer.parseInt(request.getParameter("postId"));
		
		postDAO dao = postDAO.getInstance();
		PrintWriter writer = response.getWriter();
		
		if(dao.updatePost(title, content, fileUrl, updateAt, postId) == 1) {
			writer.println("<script>alert('게시물이 수정되었습니다.'); location.href='board_list_"+boardId+".doNotice';</script>");
			writer.close();
			return 1;
		}else {
			writer.println("<script>alert('양식에 맞게 작성해주시기 바랍니다.'); history.go(-1);</script>");
			writer.close();
			return 0;
		}
		
	}

	
	
}
