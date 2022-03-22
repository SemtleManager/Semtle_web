package com.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserModifyCommand implements UserCommand{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
		HttpSession session = request.getSession();
		String value = request.getParameter("value");
		int grade = Integer.parseInt(request.getParameter("grade"));
		String nickName = request.getParameter("nickName");
		int userCode = Integer.parseInt(request.getParameter("userCode"));
		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		String status = "1";
		String userEmail = request.getParameter("userEmail");
		String userPhone = request.getParameter("userPhone");
		String updateAt = sdf.format(new Timestamp(System.currentTimeMillis()));
		System.out.println("userNickName = " + nickName);
		userDAO dao = userDAO.getInstance();
		PrintWriter writer = response.getWriter();
		
		if(value.equals("kakao")) {
			userDTO dto =  (userDTO) session.getAttribute("userInfo");
			userPassword = dto.getUserEmail();
			System.out.println("userPassword = " + userPassword);
			
		}
		
		
		if(dao.login(userId, userPassword) == 1) {
			userDTO dto = dao.selectInfo(userId, userPassword);
			
			if(dao.updateInfo(grade, nickName, userCode, userName, userEmail, userPhone, status, updateAt, userId) == 1) {
				session.setAttribute("userInfo", dto);
				writer.println("<script>alert('정보가 변경되었습니다.'); location.href='login_form.do';</script>");
				writer.close();
				return 1;
			}else {
				writer.println("<script>alert('양식에 맞게 작성해주시기 바랍니다.'); history.go(-1);</script>");
				writer.close();
				return 0;
			}
		}else {
			writer.println("<script>alert('비밀번호가 맞지 않습니다.'); history.go(-1);</script>");
			writer.close();
			return 0;
		}
		
		
	}

}
