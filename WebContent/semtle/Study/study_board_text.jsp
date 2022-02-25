	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <jsp:include page="${pageContext.request.contextPath}/semtle/header.jsp" flush="true" />

     <section class="board_text">
      <div class="board_textbox">
        <div class="board_text-input">
          <form action="study_text.doStudy" name="freeboard_text" accept-charset="utf-8" method="post"  enctype="multipart/form-data">
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