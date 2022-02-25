<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.User.*" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/semtle/images/favicon.ico" type="image/x-icon" sizes="16X16">
	<link rel="icon" href="${pageContext.request.contextPath}/semtle/images/favicon.ico" type="image/x-icon" sizes="16X16">
    <title>SemtleWeb</title>
	<script type="text/javascript">
		const autoHyphen = (target) => {
			 target.value = target.value
			   .replace(/[^0-9]/, '')
			   .replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
			}
	
	</script>
  </head>

  <body>
    <jsp:include page="${pageContext.request.contextPath}/semtle/header.jsp" flush="true" />

    <div class="join">
      <form action="signup.do" method="post" class="joinform">
        <table align="center">
        
          <tr><input type="hidden" name="type" value="signup">
          <td align="center"><label>닉네임</label></td>
            <td class="inputbox"><input type="text" name="nickName" /></td>
          </tr>
          
          <tr>
            <td align="center"><label>이름</label></td>
            <td class="inputbox"><input type="text" name="userName" /></td>
          </tr>

          <tr>
            <td align="center"><label>학년</label></td>
            <td class="inputbox">
              <select name="grade" id="#">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
              </select>
            </td>
          </tr>
          
          <tr>
            <td align="center"><label>학번</label></td>
            <td class="inputbox"><input type="text" name="userCode" /></td>
          </tr>
			
		  <tr>
            <td align="center"><label>이메일</label></td>
            <td class="inputbox"><input type="text" name="userEmail" placeholder="example@example.com" /></td>
          </tr>
          
          <tr>
            <td align="center"><label>아이디</label></td>
            <td class="inputbox"><input type="text" name="userId" /></td>
          </tr>

          <tr>
            <td align="center">
              <label>비밀번호</label>
            </td>
            <td class="inputbox"><input type="password" name="userPassword" /></td>
          </tr>
          
          <tr>
            <td align="center">
              <label>비밀번호 확인</label>
            </td>
            <td class="inputbox"><input type="password" name="userPassword" /></td>
          </tr>

          <tr>
            <td align="center"><label>전화번호</label></td>
            <td class="inputbox"><input type="tel" id="phoneNum" name="userPhone" placeholder="010-0000-0000" oninput="autoHyphen(this)"/></td>
          </tr>
        </table>
        <input type="submit" class="join_btn" value="가입하기">
        </input>
        
      </form>
    </div>
    <jsp:include page="${pageContext.request.contextPath}/semtle/footer.jsp" flush="true" />
  </body>
</html>