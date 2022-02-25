package com.Study;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Post.postDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class StudyWriteCommand implements StudyCommand {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String realFolder = "";
		String filename = "null";
		String saveFolder = "/upload";
		String encType = "utf-8";
		int maxSize = 20*1024*1024;
		MultipartRequest multi = null;
		
		ServletContext context = request.getSession().getServletContext();
		realFolder = context.getRealPath(saveFolder);
		System.out.println("realFolder = " + realFolder + "\nsaveFolder = " + saveFolder);
		
		HttpSession session = request.getSession();
		String title = (String)session.getAttribute("title");
		
		String boardId = (String)session.getAttribute("boardId");
		//int sizeLimit = 20 * 1024 * 1024;
		//String savePath = request.getSession().getServletContext().getRealPath("/upload");
		//System.out.println("SavePath = " + savePath);

		try {
			multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
			
			Enumeration files = multi.getFileNames();
			
			while(files.hasMoreElements()) {
				String name = (String)files.nextElement();
				filename = multi.getFilesystemName(name);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		String nickName = multi.getParameter("nickName");
		String userId = multi.getParameter("userId");
		String content = multi.getParameter("content");
		String createAt = sdf.format(new Timestamp(System.currentTimeMillis()));
		int lookUp = 0;
		String updateAt = sdf.format(new Timestamp(System.currentTimeMillis()));
		String status = "1";
		String p_title = multi.getParameter("p_title");
		String userRole = multi.getParameter("userRole");
		String fileUrl = filename;
		postDAO dao = postDAO.getInstance();
		dao.writePost(boardId, p_title, userRole, nickName, userId, content, fileUrl, lookUp, createAt, updateAt, status);
		PrintWriter writer = response.getWriter();
		
		writer.println("<script>alert('게시글이 작성되었습니다.'); location.href='board_list_Study.doStudy?title="+boardId+"';</script>");
		writer.close();
		return 1;
		
	}
}
