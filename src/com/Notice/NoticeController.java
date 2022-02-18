package com.Notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Post.PostCommand;
import com.Post.PostListCommand;

/**
 * Servlet implementation class NoticeController
 */
@WebServlet("*.doNotice")
public class NoticeController extends HttpServlet {
	NoticeCommand command = null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		doAction(request, response);
	}
	
	private synchronized void setCommand(NoticeCommand command) {
		this.command = command;
	}
	
	private synchronized void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do PostController");
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String title = null;
		String viewPage = null;
		String boardId = null;
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String commandName =  null;
		
		viewPage = requestUri;
		commandName = viewPage.substring(contextPath.length());

		title = (String) session.getAttribute("title");
		
		try {
			if(commandName.equals("/semtle/notice_write.doNotice")) {
				viewPage = "/semtle/Notice/notice_text.jsp";
				boardId = (String) request.getAttribute("boardId");
			}else if(commandName.equals("/semtle/notice_text.doNotice")) {
				viewPage = "/semtle/Notice/notice.jsp";
				boardId = (String) request.getAttribute("boardId");
				setCommand(new NoticeWriteCommand());
				command.execute(request, response);
			}else if(commandName.equals("/semtle/notice_view.doNotice")) {
				viewPage = "/semtle/Notice/notice_view.jsp";
				setCommand(new NoticeViewCommand());
				command.execute(request, response);
			}else if(commandName.equals("/semtle/notice_download.doNotice")) {
				setCommand(new NoticeDownloadCommand());
				int postId = command.execute(request, response);
				viewPage = "notice_view.doNotice?postId="+postId;
			}else if(commandName.equals("/semtle/notice_setting.doNotice")) {
				viewPage = "/semtle/Notice/notice_setting.jsp";
			}else if(commandName.equals("/semtle/noctice_update.doPost")) {
				setCommand(new NoticeModifyCommand());
				command.execute(request, response);
				viewPage = "/semtle/Notice/notice.jsp";
			}else if(commandName.equals("/semtle/notice_delete.doNotice")) {
				
			}else if(commandName.equals("/semtle/board_list_Notice.doNotice")) {
				viewPage = "/semtle/Notice/notice.jsp";
				title = "공지사항";
				boardId = "Notice";
				session.setAttribute("title", title);
				session.setAttribute("boardId", boardId);
				setCommand(new NoticeListCommand());
				command.execute(request, response);
			}else {
				System.out.println("해당 Command가 없습니다.");
				viewPage = "notCommand.jsp";
			}
			
			System.out.println("commandName : " + commandName);
			System.out.println("boardId = " + boardId);
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}catch(IllegalStateException e) {
			System.out.println("Illegal");
		}
		
	}
}
