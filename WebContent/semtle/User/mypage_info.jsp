<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/semtle/images/favicon.ico" type="image/x-icon" sizes="16X16">
	<link rel="icon" href="${pageContext.request.contextPath}/semtle/images/favicon.ico" type="image/x-icon" sizes="16X16">
    <title>SemtleWeb</title>
    <script>
      function getloginkeepCheckboxValue(event) {
        let login_result = "";
        if (event.target.checked) {
          login_result = event.target.value;
        }
      }
		const autoHyphen = (target) => {
			 target.value = target.value
			   .replace(/[^0-9]/, '')
			   .replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
			}
	function loginRSA(id, pw) {
		//rsa 암호화
		var rsa = new RSAKey();
		rsa.setPublic($('#RSAModulus')).val(), $('#RSAExponent').val());
		
		$("#userId").val(rsa.encrypt(id));
		$("#userPassword").val(rsa.encrypt(pw));
		
		return true;
	}
    </script>
  </head>

  <body>
    <jsp:include page="${pageContext.request.contextPath}/semtle/header.jsp" flush="true" />

		<div class="join">
		      <form action="updateInfo.do" class="joinform" method="post">
		        <div class="join_input">
		          <label for="id">아이디</label>
		          <span>${ userInfo.userId }</span>
		        </div>
		
		        <div class="join_input">
		          <label for="nickname">닉네임</label>
		          <input
		            type="text"
		            id="nickname"
		            name="nickName"
		            value="${ userInfo.nickName }"
		            placeholder="닉네임을 입력해주세요"
		          />
		        </div>
		
		        <div class="join_input">
		          <label for="name">이름</label>
		          <span>${ userInfo.userName }</span>
		        </div>
		        <input type="hidden" name="userId" value="${ userInfo.userId }">
		        <input type="hidden" name="userId" value="${ userInfo.userPassword }">
				<input type="hidden" name="userName" value="${ userInfo.userName }">
		        <div class="join_input">
		          <label for="number">학번</label>
		          <input
		            type="number"
		            id="number"
		            name="userCode"
		            value="${ userInfo.userCode }"
		            placeholder="학번을 입력해주세요"
		          />
		        </div>
		
		        <div class="join_input">
		          <label for="grade">학년</label>
		          <select id="grade" name="grade" value="${ userInfo.grade }">
		            <option value="1">1</option>
		            <option value="2">2</option>
		            <option value="3">3</option>
		            <option value="4">4</option>
		          </select>
		        </div>
		
		        <div class="join_input">
		          <label for="email">이메일</label>
		          <input
		            type="email"
		            id="email"
		            name="userEmail"
		            value="${ userInfo.userEmail }"
		            placeholder="이메일을 입력해주세요"
		          />
		        </div>
		
		        <div class="join_input">
		          <label for="phone">핸드폰 번호</label>
		          <input
		            type="tel"
		            id="phone"
		            name="userPhone"
		            value="${ userInfo.userPhone }"
		            oninput="autoHyphen(this)"
		            placeholder="핸드폰 번호를 입력해주세요"
		          />
		        </div>
		        
		        <div class="join_input">
          		  <label for="pw">비밀번호</label>
		          <input
		            type="password"
		            id="pw"
		            name="userPassword"
		            placeholder="비밀번호를 입력해주세요"
		          />
		        </div>
		
		        <div class="join_input join_btnbox">
		          <button type="submit" class="join_btn">수정하기</button>
		        </div>
		      </form>
		    </div>
    
    <jsp:include page="${pageContext.request.contextPath}/semtle/footer.jsp" flush="true" />
  </body>
  <script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>
  <script src="js/script.js" defer></script>
</html>