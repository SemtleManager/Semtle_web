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
		function signup() {
			var id = document.sign.userId.value;
			var hak = document.sign.userCode.value;
			var nick = document.sign.nickName.value;
			var passwd = document.sign.userPassword.value;
			var ck_passwd = document.sign.userPassword_ck.value;
			var mail = document.sign.userEmail.value;
			var name = document.sign.userName.value;
			var phone = document.sign.userPhone.value;
			
			var agree = document.getElementsByName("marketing");
			var ck = false;
			for(var i = 0; i < agree.length; i++) {
				if(agree[i].checked) {	
					ck = true;
				}else {
					ck = false;
				}
			}
			
			
				
				
			if(ck) { 
				if(id =="" || id == null) {alert("ID를 적어주세요")}
				else if(hak =="" || hak == null) {alert("학번을 적어주세요")}
				else if(nick =="" || nick == null) {alert("닉네임을 적어주세요")}
				else if(passwd =="" || passwd == null) {alert("비밀번호를 적어주세요")}
				else if(ck_passwd =="" || ck_passwd == null) {alert("비밀번호확인을 적어주세요")}
				else if(mail =="" || mail == null) {alert("메일을 적어주세요")}
				else if(name =="" || name == null) {alert("닉네임을 적어주세요")}
				else if(phone =="" || phone == null) {alert("전화번호를 적어주세요")}
				
				else {sign.submit();}
				
			}else { alert("약관에 동의해 주세요."); history.go(-1);}
			
			
			
				
		}
	</script>
	<style>
		.agree_wrap{margin:36px 0 0;}
		.agree_wrap .checkbox_wrap{text-align:left;}
		.form_txtInput .checkbox_wrap {position: relative;padding: 5px;text-align: right;}
		.form_txtInput .checkbox_wrap input[type="checkbox"] {width: 1px;height: 1px;padding: 0;margin: -1px;overflow: hidden;clip: rect(0,0,0,0);border: 0;}
		.form_txtInput .checkbox_wrap input[type="checkbox"] + label {display: inline-block; line-height:14px;position: relative;padding-left: 20px;font-size: 13px;color: #818181;cursor: pointer;-webkit-user-select: none;-moz-user-select: none;-ms-user-select: none;}
		.form_txtInput .checkbox_wrap input[type="checkbox"] + label:before {content: '';position: absolute;top: 0px;left: 0;width: 12px;height: 12px;text-align: center;background: #fff;border: 1px solid #c2c2c2;}
		.form_txtInput .checkbox_wrap input[type="checkbox"] + label:active:before, .checkbox_wrap input[type="checkbox"]:checked + label:active:before {box-shadow: 0 1px 2px rgba(0,0,0,0.05), inset 0px 1px 3px rgba(0,0,0,0.1);}
		.form_txtInput .checkbox_wrap input[type="checkbox"]:checked + label:before {background: #fff;border-color: #ddd;}
		.form_txtInput .checkbox_wrap input[type="checkbox"]:checked + label:after {content: '✓';color: #0094ff;position: absolute;top:0px;left:2px;width: 7px;height: 7px;font-size: 13px;font-weight: bold;}
		.explan_txt {margin:3px 0 0 22px;}
		.red_txt{color:#ee7272;}
		.explan_txt li{color:#b2b2b2;font-size:10px; line-height:17px;}
	</style>
  </head>

  <body>
    <jsp:include page="${pageContext.request.contextPath}/semtle/header.jsp" flush="true" />

		 <div class="join">
		      <form action="signup.do" id="sign" name="sign"  class="joinform" method="post">
		        <div class="join_input">
		          <label for="id">아이디</label>
		          <input
		            type="text"
		            id="id"
		            name="userId"
		            placeholder="아이디를 입력해주세요"
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
		
		        <div class="join_input">
		          <label for="pw_check">비밀번호 확인</label>
		          <input
		            type="password"
		            id="pw_check"
		            name="userPassword_ck"
		            placeholder="비밀번호를 한 번 더 입력해주세요"
		          />
		        </div>
		
		        <div class="join_input">
		          <label for="nickname">닉네임</label>
		          <input
		            type="text"
		            id="nickname"
		            name="nickName"
		            placeholder="닉네임을 입력해주세요"
		          />
		        </div>
		
		        <div class="join_input">
		          <label for="name">이름</label>
		          <input
		            type="text"
		            id="name"
		            name="userName"
		            placeholder="이름을 입력해주세요"
		          />
		        </div>
		
		        <div class="join_input">
		          <label for="number">학번</label>
		          <input
		            type="number"
		            id="number"
		            name="userCode"
		            placeholder="학번을 입력해주세요"
		          />
		        </div>
		
		        <div class="join_input">
		          <label for="grade">학년</label>
		          <select id="grade" name="grade">
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
		            placeholder="이메일을 입력해주세요"
		          />
		        </div>
		
		        <div class="join_input">
		          <label for="phone">핸드폰 번호</label>
		          <input
		            type="tel"
		            id="phone"
		            name="userPhone"
		            oninput="autoHyphen(this);"
		            placeholder="핸드폰 번호를 입력해주세요"
		          />
		        </div>
			<div class="agree_wrap">
            <div class="checkbox_wrap mar27" style="font-size: 10px;">
              <input type="checkbox" id="marketing" name="marketing" class="agree_chk" style="width: 10px;position: inherit;float: left;margin-top: -10px;">
              <label for="marketing">[필수]마케팅 목적 개인정보 수집 및 이용에 대한 동의</label>
              <ul class="explan_txt">
                <li><span class="red_txt" style="position: relative;">항목 : 이름, 학번, 성별, 전화번호</span></li>
                <li>고객님께서는 위의 개인정보 및 회원정보 수정 등을 통해 추가로 수집하는 개인정보에<br/>
                  를 셈틀쟁이에서 스터디 및 엠티 각종행사에 이용할수있습니다.<br/>
                </li>
              </ul>
            </div>
          </div>
		        <div class="join_input join_btnbox">
		          <button onclick="javascript:signup();" type="button" class="join_btn">가입하기</button>
		        </div>
		      </form>
		    </div>
    <jsp:include page="${pageContext.request.contextPath}/semtle/footer.jsp" flush="true" />
  </body>
</html>