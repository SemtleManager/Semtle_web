package com.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserModifyCommand implements UserCommand{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		
		int grade = Integer.parseInt(request.getParameter("grade"));
		String nickName = request.getParameter("nickName");
		int userCode = Integer.parseInt(request.getParameter("userCode"));
		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId");
		String status = request.getParameter("status");
		String userEmail = request.getParameter("userEmail");
		String userPhone = request.getParameter("userPhone");
		String updateAt = sdf.format(new Timestamp(System.currentTimeMillis()));
		
		userDAO dao = userDAO.getInstance();
		PrintWriter writer = response.getWriter();
		
		if(dao.updateInfo(grade, nickName, userCode, userName, userEmail, userPhone, status, updateAt, userId) == 1) {
			writer.println("<script>alert('정보가 변경되었습니다.'); location.href='/semtle/index.jsp';</script>");
			writer.close();
			return 1;
		}else {
			writer.println("<script>alert('양식에 맞게 작성해주시기 바랍니다.'); history.go(-1);</script>");
			writer.close();
			return 0;
		}
		
	}

}
