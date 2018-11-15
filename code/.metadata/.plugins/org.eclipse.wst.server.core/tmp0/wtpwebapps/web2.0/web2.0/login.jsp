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
<script>
$(document).ready(function() {
	$("#BeforeLogin").show();
	$("#Login").hide();
	$("#LoginResult").hide();
	
	$("#ToLogin").click(function() {
		$("#BeforeLogin").hide();//hidden
		$("#Login").show();//show
		$("#loginBtnLogin").click(function() {
			var query={ id: $("#loginTxtID").val(), passwd:$("#loginTxtPw").val()};
			$.ajax({
				type:"post",
				url:"loginPro.jsp",
				data:query,
				success:function(data) {
					if(data==0) {
						alert("비밀번호가 틀립니다.");
						$("#loginTxtPw").val("");
						$("#loginTxtPw").focus();
						$("#LoginResult").html("");
					}else if(data==-1) {
						alert("아이디가 없습니다.");
						$("#loginTxtID").val("");
						$("#loginTxtPw").val("");
						$("#loginTxtID").focus();
						$("#LoginResult").html("");
					}else {
						var result=JSON.parse(data);
						var area=result[0].mname;
						alert("환영합니다. <h3>" + area + "</h3> 님");
						$("#loginTxtID").val("");
						$("#loginTxtPw").val("");
						$("#LoginResult").html("<p>안녕하세요</p><h3>" + area + "</h3><p>님.</p>");
						$("#LoginResult").show();
						console.log(result);
					}
				}//success
			});//ajax
		});//loginBtnLogin
	});//tologin
});//document
</script>
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
	</div>
</body>
</html>