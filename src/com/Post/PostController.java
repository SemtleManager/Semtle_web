package com.Post;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PostController
 */
@WebServlet("*.doPost")
public class PostController extends HttpServlet {
	PostCommand command = null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostController() {
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
	
	private synchronized void setCommand(PostCommand command) {
		this.command = command;
	}
	
	private synchronized void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do PostController");
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
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
			if(commandName.equals("/board_write.doPost")) {
				viewPage = "/semtle/Board/board_text.jsp";
				boardId = (String) request.getAttribute("boardId");
			}else if(commandName.equals("/board_text.doPost")) {
				viewPage = "/semtle/Board/board.jsp";
				boardId = (String) request.getAttribute("boardId");
				setCommand(new PostWriteCommand());
				command.execute(request, response);
			}else if(commandName.equals("/board_setting.doPost")) { 
				viewPage = "/semtle/Board/board_setting.jsp";
				setCommand(new PostViewCommand());
				command.execute(request, response);
			}else if(commandName.equals("/board_update.doPost")) {
				setCommand(new PostModifyCommand());
				command.execute(request, response);
				viewPage ="/semtle/Board/board.jsp";
			}else if(commandName.equals("/board_delete.doPost")) {
				viewPage = "/semtle/Board/board.jsp";
				setCommand(new PostDeleteCommand());
				command.execute(request, response);
			}else if(commandName.equals("/board_list_Free.doPost")) {
				viewPage = "/semtle/Board/board.jsp";
				title = "자유게시판";
				boardId = "Free";
				session.setAttribute("title", title);
				session.setAttribute("boardId", boardId);
				setCommand(new PostListCommand());
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
