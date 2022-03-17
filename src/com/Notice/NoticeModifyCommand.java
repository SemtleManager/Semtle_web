package com.Notice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.TimeZone;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Post.postDAO;
import com.Post.postDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class NoticeModifyCommand implements NoticeCommand{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
		String realFolder = "";
		String fileUrl = "";
		String filename = "null";
		String saveFolder = "/upload";
		String encType = "utf-8";
		int maxSize = 20*1024*1024;
		MultipartRequest multi = null;
		ServletContext context = request.getSession().getServletContext();
		realFolder = context.getRealPath(saveFolder);
		System.out.println("realFolder = " + realFolder + "\nsaveFolder = " + saveFolder);
		
		HttpSession session = request.getSession();
		
		try {
			multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
			
			Enumeration files = multi.getFileNames();
			
			while(files.hasMoreElements()) {
				String name = (String)files.nextElement();
				filename = multi.getFilesystemName(name);
				System.out.println("filename_update = " + filename);
				fileUrl = filename; 
					
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		String title = (String)session.getAttribute("title");
		String boardId = (String)session.getAttribute("boardId");
		String p_title = multi.getParameter("p_title");
		String content = multi.getParameter("content");
		
		String updateAt = sdf.format(new Timestamp(System.currentTimeMillis()));
		int postId = Integer.parseInt(multi.getParameter("postId"));
		
		postDAO dao = postDAO.getInstance();
		PrintWriter writer = response.getWriter();
		
		
		if(dao.updatePost(p_title, content, fileUrl, updateAt, postId) == 1) {
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
