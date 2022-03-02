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
<script>
	function getloginkeepCheckboxValue(event) {
		let login_result = "";
		if (event.target.checked) {
			login_result = event.target.value;
		}
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

	<a href="home.do"><section class="home" id="login-home">
			<div class="home-main">
				<img src="${pageContext.request.contextPath}/semtle/images/login.PNG" alt="" />
				<h3>셈틀쟁이</h3>
			</div>
		</section></a>

	<section class="login">
		<div class="login-box">
			<form action="login.do" id="loginform" method="post">
			<input type="hidden" name="type" value="login">
				<div class="idform">
					<input type="text" name="userId" class="id" placeholder="ID"
						onclick="this.placeholder=''" onblur="this.placeholder = 'ID'" />
				</div>
				<div class="pwform">
					<input type="password" name="userPassword" class="pw" placeholder="PASSWORD"
						onclick="this.placeholder=''"
						onblur="this.placeholder = 'PASSWORD'" />
				</div>
				<span style="color: #b0abab;font-size: 11px;">최초 회원가입 후 관리자의 승인 이후 로그인 가능합니다.</span>
				<div class="btnform">
					<input type="submit" class="login_btn" value="로그인"> </input>
				</div>

				<div class="appendform">
					<div class="loginkeep">
						<label><input type="checkbox"
							name="loginkeep_check" value="익명" id="loginkeep_check"
							onclick="getloginkeepCheckboxValue(event)" />
							로그인 상태 유지</label>
					</div>
					<div class="loginfind">
						<a href="#">아이디</a> / <a href="#">비밀번호 찾기</a>
					</div>
				</div>
				<div class="signupform">
					<a href="signup_user.do">Sign Up</a>
				</div>
			</form>
		</div>
	</section>
</body>
<script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>
<script src="js/script.js" defer></script>
</html>