<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/semtle/images/favicon.ico" type="image/x-icon" sizes="16X16">
	<link rel="icon" href="${pageContext.request.contextPath}/semtle/images/favicon.ico" type="image/x-icon" sizes="16X16">
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
function btn_click(str) {
	if(str=="update") {
		freeboard_text.action="study_update.doStudy";
	} else if(str=="delete") {
		freeboard_text.action="study_delete.doStudy";
	}
	
}
</script>
  </head>

  <body>
<jsp:include page="${pageContext.request.contextPath}/semtle/header.jsp" flush="true" />



    <section class="board_text">
      <div class="board_textbox">
        <div class="board_text-input">
          <form action="#" name="freeboard_text" accept-charset="utf-8" method="post"  enctype="multipart/form-data">
          <input type="hidden" name="userId" value="${ userInfo.userId }">
          <input type="hidden" name="userRole" value="${ userInfo.userRole }">
          <input type="hidden" name="nickName" value="${ userInfo.nickName }">
          <input type="hidden" name="userRole" value="${ userInfo.userRole }">
          <input type="hidden" name="fileUrl" value="${ post.fileUrl }">
          <input type="hidden" name="postId" value="${ post.postId }">
          <input style="margin-top:30px;" type="text" name="p_title" value="${ post.p_title }">
            <textarea id="content" name="content" placeholder="내용을 입력해주세요" >${ post.content }</textarea>
            <input type="file" name="fileUrl">
            <div class="board_append" style="margin-top : 15px;">
            <input type="submit" id="write_submit" onclick='btn_click("update");' value="수정" />
              <input type="submit" style="margin-left:15px;" id="write_submit" onclick='btn_click("delete");' value="삭제" />
            </div>
          </form>
        </div>
      </div>
    </section>
    
    
    
    
    
    <jsp:include page="${pageContext.request.contextPath}/semtle/footer.jsp" flush="true" />
  </body>
  
</html>