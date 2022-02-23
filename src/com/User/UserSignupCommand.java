package com.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserSignupCommand implements UserCommand{
	
	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		int grade = Integer.parseInt(request.getParameter("grade"));
		String nickName = request.getParameter("nickName");
		int userCode = Integer.parseInt(request.getParameter("userCode"));
		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		String userEmail = request.getParameter("userEmail");
		String userPhone = request.getParameter("userPhone");
		String userRole = "셈틀회원";
		String createAt = sdf.format(new Timestamp(System.currentTimeMillis()));
		String updateAt = sdf.format(new Timestamp(System.currentTimeMillis()));
		String status = "1";
		userDAO dao = userDAO.getInstance();
		dao.signUp(grade, nickName, userCode, userName, userId, userPassword, userEmail, userPhone, userRole, createAt, updateAt, status);
		
		PrintWriter writer = response.getWriter();
		writer.println("<script>alert('셈틀회원이 되신걸 축하합니다~~'); location.href='home.do';</script>");
		writer.close();
		
		userDTO dto = dao.selectInfo(userId, userPassword);
		
		return 1;

	}
	/* https://chrismare.tistory.com/entry/MVC-%ED%8C%A8%ED%84%B4Model1-Model2 */
}
