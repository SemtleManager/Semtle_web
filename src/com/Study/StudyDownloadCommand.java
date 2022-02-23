package com.Study;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Post.postDAO;
import com.Post.postDTO;

public class StudyDownloadCommand implements StudyCommand{
	
	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		int postId = Integer.parseInt(request.getParameter("postId"));
		postDAO dao = postDAO.getInstance();
		postDTO dto = dao.viewPost(postId);
		
		String fileName = dto.getFileUrl();
		
		ServletContext context = request.getSession().getServletContext();
		String downaloadPath = context.getRealPath("upload");
		String filePath = downaloadPath + "/" + fileName;
		File file = new File(filePath);
		
		System.out.println("경로는  : " + filePath);
		String mimeType = context.getMimeType(filePath);
		if(mimeType == null)
			mimeType = "application/octet-stream";
		response.setContentType(mimeType);
		
		String encoding = new String(fileName.getBytes("utf-8"), "8859_1");
		response.setHeader("Content-Disposition", "attachment; filename=" + encoding);
		response.setContentType("text/html; charset=utf-8");
		response.setHeader("Chche-Control", "no-cache");
		
		FileInputStream in = new FileInputStream(file);
		ServletOutputStream outStream = response.getOutputStream();
		
		byte b[] = new byte[4096];
		int data = 0;
		while ((data = in.read(b, 0, b.length)) != -1) {
			outStream.write(b, 0, data);
		}

		outStream.flush();
		outStream.close();
		in.close();
		
		return postId;
	}
	
}
