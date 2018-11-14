/**
 * 로그인 처리
 */
$(document).ready(function() {
	$("#BeforeLogin").show();
	$("#Login").hide();
	$("#LoginResult").hide();
	
	$("#ToLogin").click(function() {
		$("#BeforeLogin").toggle();
		$("#Login").toggle();//ajax
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
					}else if(data==-1) {
						alert("아이디가 없습니다.");
						$("#loginTxtID").val("");
						$("#loginTxtPw").val("");
						$("#loginTxtID").focus();
					}else {
						var result=JSON.parse(data);
						alert(result[0].mname + "환영");
						$("#loginTxtID").val("");
						$("#loginTxtPw").val("");
						$("#LoginResult").toggle();
						$("#LoginName").text(result[0].mname);
						console.log(result[0]);
						
					}
				}//success
			});//ajax
		});//loginBtnLogin
	});//tologin
});//document