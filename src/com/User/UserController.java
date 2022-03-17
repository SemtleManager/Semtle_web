package com.User;

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
 * Servlet implementation class UserController
 */
@WebServlet("*.do")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
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
	
	private synchronized void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do UserController");
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter writer = response.getWriter();
		String title = "";
		String viewPage = null;
		
		UserCommand command = null;
		
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		System.out.println("requestURi : " + requestUri);
		System.out.println("ContextPath : " + contextPath);
		String commandName = null;
		
		viewPage = requestUri;
		commandName = viewPage.substring(contextPath.length());
		
		System.out.println("commandName : " + commandName);
		
		try {
			if(commandName.equals("/signup_user.do" )) {
				viewPage = "/semtle/User/signup.jsp";
				title = "회원가입";
				session.setAttribute("title", title);
			}else if(commandName.equals("/signup.do")) {
				command = new UserSignupCommand();
				command.execute(request, response);
				viewPage = "/semtle/index.jsp";
			}else if(commandName.equals("/login.do")) {
				command = new UserLoginCommand();
				if(command.execute(request, response) == 1) {
					command = new UserInfoCommand();
					command.execute(request, response);
					viewPage = "";
				}else {
					writer.println("<script>alert(\"아이디 또는 비밀번호가 맞지 않습니다.\"); history.go(-1);</script>");
					writer.close();
					viewPage = "/login.do";
				}
				title = null;
				session.setAttribute("title", title);
			}else if(commandName.equals("/confirmId.do")) {
				command = new UserConfirmIdCommand();
				command.execute(request, response);
				viewPage = "/semtle/signup.jsp";
				title = "회원가입";
				session.setAttribute("title", title);
			}else if(commandName.equals("/updateInfo.do")) {
				command = new UserModifyCommand();
				command.execute(request, response);
				viewPage = "login_form.do";
				title = "정보 수정";
				session.setAttribute("title", title);
			}else if(commandName.equals("/userInfo.do")) {
				command = new infoCntCommand();
				command.execute(request, response);
				viewPage = "/semtle/User/mypage.jsp";
				title = "내 정보";
				session.setAttribute("title", title);
			}else if(commandName.equals("/userUpdate.do")) {
				viewPage = "/semtle/User/mypage_info.jsp";
				title = "정보 수정";
				session.setAttribute("title", title);
			}else if(commandName.equals("/infoBook.do")) {
				title = "대여 목록";
				session.setAttribute("title", title);
				command = new infoBookCommand();
				command.execute(request, response);
				viewPage = "/semtle/User/infoBook.jsp";
			}else if(commandName.equals("/infoPost.do")) {
				title = "내가 쓴 글";
				session.setAttribute("title", title);
				command = new infoPostCommand();
				command.execute(request, response);
				viewPage = "/semtle/User/infoPost.jsp";
			}
			else if(commandName.equals("/login_form.do")){
				viewPage = "/semtle/User/login.jsp";
				title = "로그인";
				session.setAttribute("title", title);
			}else if(commandName.equals("/home.do")) {
				viewPage = "";
				title = null;
				session.setAttribute("title", title);
			}else if(commandName.equals("/logout.do")) {
				command = new UserLogoutCommand();
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
