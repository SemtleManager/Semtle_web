package com.Study;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Post.postDAO;
import com.Post.postDTO;

public class StudyDeleteCommand implements StudyCommand{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		int postId = Integer.parseInt(request.getParameter("postId"));
		HttpSession session = request.getSession();
		String boardId = (String) session.getAttribute("boardId");
		postDAO dao = postDAO.getInstance();
		postDTO dto = dao.viewPost(postId);
		
		String fileName = dto.getFileUrl();
		String uploadFileName = request.getSession().getServletContext().getRealPath("/upload") + "/" + fileName;
		
		File uploadfile = new File(uploadFileName);
		PrintWriter writer = response.getWriter();
		
		if(dao.deletePost(postId) == 1) {
			if(uploadfile.exists() && uploadfile.isFile()) {
				uploadfile.delete();
			}
			writer.println("<script>alert('게시글이 삭제되었습니다.'); location.href='board_list_"+boardId+".doNotice';</script>");
			writer.close();
			return 1;
		}else {
			writer.println("<script>alert('삭제에 실패하였습니다.'); history.go(-1);</script>");
			writer.close();
			return 0;
		}
	}
	
}
