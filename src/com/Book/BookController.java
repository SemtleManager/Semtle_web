package com.Book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Study.StudyCommand;

/**
 * Servlet implementation class BookController
 */
@WebServlet("*.doBook")
public class BookController extends HttpServlet {
	private BookCommand command;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookController() {
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
		System.out.println("doGet");
		doAction(request, response);
	}
	public void setCommand(BookCommand command) {
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
			if(commandName.equals("/booklist.doBook")) {
				viewPage = "/semtle/Bookboard/book.jsp";
				title = "책 대여";
				session.setAttribute("title", title);
			}
			else if(commandName.equals("/checkout.doBook")) {
				viewPage = "/semtle/Bookboard/book.jsp";
				setCommand(new bookCheckoutCommand());
				command.execute(request, response);
			}else if(commandName.equals("/cancel.doBook")) {
				viewPage = "/semtle/Bookboard/book.jsp";
				setCommand(new BookCancelCommand());
				command.execute(request, response);
			}else if(commandName.equals("/searchBook.doBook")) {
				viewPage = "/semtle/Bookboard/book.jsp";
				title = "책 대여";
				session.setAttribute("title", title);
				setCommand(new BookSearchCommand());
				command.execute(request, response);
			}else {
				System.out.println("해당 Command가 없습니다.");
				viewPage = "notCommand.jsp";
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}catch(IllegalStateException e) {
			System.out.println("Illegal");
		}
		
		
	}
	
}
