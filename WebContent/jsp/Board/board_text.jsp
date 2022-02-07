<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>SemtleWeb</title>
    <script>
      function getfreeboardCheckboxValue(event) {
        let freeboard_result = "";
        if (event.target.checked) {
          freeboard_result = event.target.value;
        }
      }
    </script>
  </head>

  <body>
<jsp:include page="${pageContext.request.contextPath}/jsp/header.jsp" flush="true" />

    <section class="board_text">
      <div class="board_textbox">
        <div class="board_text-input">
          <form action="#" name="freeboard_text" accept-charset="utf-8" method="#">
            <textarea id="board_write" placeholder="내용을 입력해주세요" ></textarea>
            <div class="board_append">
              <label><input type="checkbox" name="freeboard_check" value="익명" id="freeboard_check" onclick="getfreeboardCheckboxValue(event)"/>익명</label>
              <input type="submit" id="write_submit" value="완료" />
            </div>
          </form>
        </div>
      </div>
    </section>
    <jsp:include page="${pageContext.request.contextPath}/jsp/footer.jsp" flush="true" />
  </body>
  
</html>