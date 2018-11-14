<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1501163_송탁근</title>
<script
  src="https://code.jquery.com/jquery-3.3.1.js"
  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  crossorigin="anonymous"></script>
<script src="login.js"></script>
</head>
<body>
	<div id="BeforeLogin">
		<img src='https://www.yju.ac.kr/sites/kr/images/img_symbol_mark.png'
			width='300px' height='300px' /><br/>
		<button id="ToLogin"> 인트로화면에서 로그인화면으로가기</button>
	</div>
	<div id="Login">
		<h1>My SNS Service</h1>
		<br/>
		<h3>로그인해주세요</h3>
		<p>아이디</p>
		<input type="text" id="loginTxtID" maxlength="50"/>
		<p>비밀번호</p>
		<input type="password" id="loginTxtPw" maxlength="50"/>
		<br/><br/>
		<button id="loginBtnLogin">로그인</button>
		<button id="loginBtnJoin">회원가입</button>
	</div>
	<div id="LoginResult">
		<p>안녕하세요</p>
		<h1 id="LoginName"></h1>
		<p>님.</p>
	</div>
</body>
</html>