	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>SemtleWeb</title>

  </head>

  <body>
    <jsp:include page="${pageContext.request.contextPath}/semtle/header.jsp" flush="true" />

    <section class="board_text">
      <div class="board_textbox">
        <div class="board_text-input">
          <form action="#" name="freeboard_text" accept-charset="utf-8" method="post" >
            <textarea id="board_write" placeholder="내용을 입력해주세요"></textarea>
            <div class="board_append">
              <input type="file" name="filename" />
              <input type="submit" id="write_submit" value="완료" />
            </div>
          </form>
        </div>
      </div>
    </section>
    <jsp:include page="${pageContext.request.contextPath}/semtle/footer.jsp" flush="true" />
  </body>
</html>