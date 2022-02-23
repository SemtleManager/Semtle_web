package com.Study;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Notice.NoticeCommand;
import com.Notice.NoticeDownloadCommand;
import com.Notice.NoticeListCommand;
import com.Notice.NoticeModifyCommand;
import com.Notice.NoticeViewCommand;
import com.Notice.NoticeWriteCommand;

/**
 * Servlet implementation class StudyController
 */
@WebServlet("*.doStudy")
public class StudyController extends HttpServlet {
	StudyCommand command = null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudyController() {
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
	
	private synchronized void setCommand(StudyCommand command) {
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
			if(commandName.equals("/semtle/study_write.doStudy")) {
				viewPage = "/semtle/Study/notice_text.jsp";
				boardId = (String) request.getAttribute("boardId");
			}else if(commandName.equals("/semtle/study_text.doStudy")) {
				viewPage = "/semtle/Study/notice.jsp";
				boardId = (String) request.getAttribute("boardId");
				setCommand(new StudyWriteCommand());
				command.execute(request, response);
			}else if(commandName.equals("/semtle/study_view.doStudy")) {
				viewPage = "/semtle/Study/notice_view.jsp";
				setCommand(new StudyViewCommand());
				command.execute(request, response);
			}else if(commandName.equals("/semtle/study_download.doStudy")) {
				setCommand(new StudyDownloadCommand());
				int postId = command.execute(request, response);
				viewPage = "notice_view.doNotice?postId="+postId;
			}else if(commandName.equals("/semtle/study_setting.doStudy")) {
				viewPage = "/semtle/Study/notice_setting.jsp";
			}else if(commandName.equals("/semtle/study_update.doStudy")) {
				setCommand(new StudyModifyCommand());
				command.execute(request, response);
				viewPage = "/semtle/Study/notice.jsp";
			}else if(commandName.equals("/semtle/study_delete.doStudy")) {
				
			}else if(commandName.equals("/semtle/board_list_Study.doStudy")) {
				viewPage = "/semtle/Study/study_board.jsp";
				title = request.getParameter("title");
				boardId = title;
				session.setAttribute("title", title);
				session.setAttribute("boardId", boardId);
				setCommand(new StudyListCommand());
				command.execute(request, response);
			}else if(commandName.equals("/semtle/board_Study.doStudy")) {
				viewPage = "/semtle/Study/study.jsp";
				title = "스터디룸";
				boardId = "Study";
				session.setAttribute("title", title);
				session.setAttribute("boardId", boardId);
			}
			
			else {
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
