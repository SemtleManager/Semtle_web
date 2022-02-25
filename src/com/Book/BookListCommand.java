package com.Book;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookListCommand implements BookCommand{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		ServletContext context = request.getSession().getServletContext();
		String downaloadPath = context.getRealPath("bookIMG");
		
		bookListDAO dao = bookListDAO.getInstance();
		
		List<bookListDTO> lists = dao.getBookList();
		
		
		response.setContentType("image/jpg");
		ServletOutputStream bout = response.getOutputStream();
		FileInputStream f;
		byte[] buffer = new byte[10];
		int length;
		for(int i = 0; i < lists.size(); i++) {
			String path = downaloadPath + "/" + lists.get(i).getBookImage();
			f = new FileInputStream(path);
			while((length=f.read(buffer)) != -1) {
				bout.write(buffer, 0, length);
			}
		}
		
		request.setAttribute("list", lists);
		
		return 1;
	}

	
	
	
}
