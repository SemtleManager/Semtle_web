<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
    document.freeboard_text.nickName.value = "익명";
  }else {
	  document.freeboard_text.nickName.value = ${ userInfo.userId };
  }
}
</script>
  </head>

  <body>
<jsp:include page="${pageContext.request.contextPath}/semtle/header.jsp" flush="true" />



    <section class="board_text">
      <div class="board_textbox">
        <div class="board_text-input">
          <form action="notice_text.doNotice" name="freeboard_text" accept-charset="utf-8" method="post"  enctype="multipart/form-data">
          <input type="hidden" name="userId" value="${ userInfo.userId }">
          <input type="hidden" name="userRole" value="${ userInfo.userRole }">
          <input type="hidden" name="nickName" value="${ userInfo.nickName }">
          <input type="hidden" name="userRole" value="${ userInfo.userRole }">
          <input style="margin-top:30px;" type="text" name="p_title" placeholder="제목을 입력해주세요">
            <textarea id="content" name="content" placeholder="내용을 입력해주세요" ></textarea>
            <input type="file" name="fileUrl">
            <div class="board_append">
              <label></label>
              <input type="submit" id="write_submit" value="완료" />
            </div>
          </form>
        </div>
      </div>
    </section>
    
    
    
    
    
    <jsp:include page="${pageContext.request.contextPath}/semtle/footer.jsp" flush="true" />
  </body>
  
</html>