package com.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class kakaoLoginCommand implements UserCommand {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
		
		String code = request.getParameter("code");
		KakaoAPI kakao = new KakaoAPI();
		String access_Token = kakao.getAccessTocken(code);
		
		String createAt = sdf.format(new Timestamp(System.currentTimeMillis()));
		String updateAt = sdf.format(new Timestamp(System.currentTimeMillis()));
		
		userDAO dao = userDAO.getInstance();
		
		System.out.println("Command access_Token : " + access_Token);

		HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);

		if (userInfo.get("userId") != null) {
			// 사용자가 db에 없는 경우
			if (dao.confirmId(userInfo.get("userId").toString()) == -1) {
				dao.signUp(0, userInfo.get("nickName").toString(), 000000000, userInfo.get("nickName").toString(), userInfo.get("userId").toString(), userInfo.get("email").toString(), userInfo.get("email").toString(), "", "셈틀회원", createAt, updateAt, "1");
				PrintWriter writer = response.getWriter();
				userDTO dto = dao.selectInfo(userInfo.get("userId").toString(), userInfo.get("email").toString());
				session.setAttribute("userInfo", dto);
				writer.println("<script>location.href='userUpdate.do?value=kakao';</script>");
				writer.close();
				return 1;
			} else {
				userDTO dto = dao.selectInfo(userInfo.get("userId").toString(), userInfo.get("email").toString());
				System.out.println("userName = " + dto.getUserName());
				session.setAttribute("userInfo", dto);
			}
		}
		
		
		
		return 1;
	}

}
