<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1501163</title>
<script src="../js/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function() {
		$("#b1").click(function() {
			var query={
					userid:	$("#userid").val(),
					password: $("#password").val()
			};//query
			
			$.ajax({
				type:"POST",
				url:"/studyjsp/MemberServlet",
				data:query,
				success:function(data) {
					if(data==1) {
						$("#result").text("로그인성공");
					} else if(data==0) {
						$("#result").text("비번틀림");
						$("#password").val("");
						$("#password").focus();
					} else if(data==-1) {
						$("#result").text("비회원");
						$("#userid").val("")
						$("#password").val("");
						$("#userid").focus();
					}//if - else if
				}//success
			});//ajax
		});//#b1
	});//document
</script>
</head>
<body>
아이디와 비밀번호 입력<br>
	<input name="userid" id="userid" type="text"><br>
	<input name="password" id="password" type="password"><br>
	<button id="b1" >클릭</button><br>
	<hr/>
결과
<div id="result"></div>
</body>
</html>