package com.Notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Post.postDAO;
import com.Post.postDTO;

public class NoticeListCommand implements NoticeCommand{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//Paging
		String cpStr = request.getParameter("cpage");
		String psStr = request.getParameter("pageSize");
		
		if(cpStr == null || cpStr.trim().isEmpty())
			cpStr = "1";
		
		HttpSession session = request.getSession();
		
		if(psStr == null || psStr.trim().isEmpty()) {
			psStr = (String) session.getAttribute("pageSize");
			if(psStr == null)
				psStr = "5";
		}
		session.setAttribute("pageSize", psStr);
		int cpage = Integer.parseInt(cpStr);
		int pageSize = 5;
		if(psStr != null)
			pageSize = Integer.parseInt(psStr);
		
		String title = (String) session.getAttribute("title");
		System.out.println("title = " + title);
		
		String boardId = "Notice";
		int post_count = 0;
		postDAO dao = postDAO.getInstance();
		
		List<postDTO> lists = null;
		
		post_count = dao.getPostCount(boardId);
		
		int pageCount = (post_count - 1)/pageSize + 1;
		if(cpage < 1)
			cpage = 1;
		else if (cpage > pageCount)
			cpage = pageCount;
		
		int end = pageSize*cpage;
		int start = end-pageSize + 1;
		System.out.println("start = " + start);
		System.out.println("end = " + end);
		lists = dao.getPosts(boardId, start, end);
		
		int pagingBlock = 5;
		int prevBlock = 0, nextBlock = 1;
		prevBlock = (cpage-1)/pagingBlock * pagingBlock;
		nextBlock = prevBlock + pagingBlock + 1;
		
		request.setAttribute("cpage", cpage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pagingBlock", pagingBlock);
		request.setAttribute("prevBlock", prevBlock);
		request.setAttribute("nextBlock", nextBlock);
		System.out.println("cpage = " + cpage);
		System.out.println("pageCount = " + pageCount);
		System.out.println("pagingBlock = " + pagingBlock);
		System.out.println("prevBlock = " + prevBlock);
		System.out.println("nextBlock = " + nextBlock);
		
		request.setAttribute("list", lists);
		request.setAttribute("post_count", post_count);
		request.setAttribute("title", title);
		
		return 1;
	}

	
}
