<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "com.User.*" %>
<%
	String userId = (String) session.getAttribute("userId");

	userDAO users = userDAO.getInstance();
	userDTO user = users.selectInfo(userId);

%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>SemtleWeb</title>
<script language="javascript">
function input_hidden() {
  var ck = document.freeboard_text.freeboard_check.checked;
  if (ck) {
    document.freeboard_text.userId.value = "익명";
  }else {
	  document.freeboard_text.userId.value = '<%=user.getUserId()%>';
  }
}
</script>
  </head>

  <body>
<jsp:include page="${pageContext.request.contextPath}/jsp/header.jsp" flush="true" />



    <section class="board_text">
      <div class="board_textbox">
        <div class="board_text-input">
          <form action="boardPro.jsp?boardId=free&type=posting" name="freeboard_text" accept-charset="utf-8" method="post">
          <input type="hidden" name="userId" value="<%=userId%>">
            <textarea id="content" name="content" placeholder="내용을 입력해주세요" ></textarea>
            <div class="board_append">
              <label><input type="checkbox" name="freeboard_check" value="익명" id="freeboard_check" onclick="input_hidden()"/>익명</label>
              <input type="submit" id="write_submit" value="완료" />
            </div>
          </form>
        </div>
      </div>
    </section>
    
    
    
    
    
    <jsp:include page="${pageContext.request.contextPath}/jsp/footer.jsp" flush="true" />
  </body>
  
</html>