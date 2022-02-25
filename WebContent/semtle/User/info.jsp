<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "com.User.*" %>
    
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/semtle/images/favicon.ico" type="image/x-icon" sizes="16X16">
	<link rel="icon" href="${pageContext.request.contextPath}/semtle/images/favicon.ico" type="image/x-icon" sizes="16X16">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>SemtleWeb</title>
  </head>

  <body>
   <jsp:include page="${pageContext.request.contextPath}/semtle/header.jsp"></jsp:include>

    <div class="join">
      <form action="#" class="joinform">
        <table align="center">
          <tr>
            <td align="center"><label class="info_must">*</label><label>이름</label></td>
            <td class="inputbox"><span>${userInfo.userName}</span></td>
          </tr>

          <tr>
            <td align="center"><label class="info_must">*</label><label>학번</label></td>
            <td class="inputbox"><input type="number" name="userCode" value=${userInfo.userCode} /></td>
          </tr>

          <tr>
            <td align="center"><label class="info_must">*</label><label>학년</label></td>
            <td class="inputbox">
              <select name="grade" id="#" >
                <option value="1gr">1</option>
                <option value="2gr">2</option>
                <option value="3gr">3</option>
                <option value="4gr">4</option>
              </select>
            </td>
          </tr>

          <tr>
            <td align="center"><label class="info_must">*</label><label>아이디</label></td>
            <td class="inputbox"><input type="text" name="id" /></td>
          </tr>

          <tr>
            <td align="center">
                <label class="info_must">*</label><label>비밀번호</label>
            </td>
            <td class="inputbox"><input type="password" name="pw" /></td>
          </tr>

          <tr>
            <td align="center">
                <label class="info_must">*</label><label>닉네임</label>
            </td>
            <td class="inputbox"><input type="text" name="nickname" /></td>
          </tr>

        </table>
        <input type="submit" class="join_btn" value="수정하기">
        
        
      </form>
    </div>
    
    <jsp:include page="${pageContext.request.contextPath}/semtle/footer.jsp"></jsp:include>
    
  </body>
</html>
    