var status1=true;

$(document).ready(function() {
	$("#register").click(function() {
		$("#main_auth").load("registerForm.jsp");
	});
	
	$("#login").click(function() {
		checkIt();
		if(status1) {
			var query = {id: $("#id").val(), passwd: $("#passwd").val()};
			
			$.ajax({
				type:"post",
				url:"loginPro.jsp",
				data:query,
				success:function(data) {
					if(data==1) {
						$("#main_auth").load("loginForm.jsp");
						console.log("1");
					}else if(data==0){
						alert("비밀번호가 틀립니다.");
						$("#passwd").val("");
						$("#passwd").focus();
						console.log("2");
					}else if(data== -1) {
						alert("아이디가 틀립니다");
						$("#id").val("")
						$("#passwd").val("");
						$("#id").focus();
						console.log("3");
					}//if - else if
				}//success
			});//ajax
		}//if
	});//#login
	
	$("#update").click(function() {
		$("#main_auth").load("modify.jsp");
	});
	
	$("#logout").click(function() {
		$.ajax({
			type:"post",
			url:"logout.jsp",
			success: function(data) {
				$("#main_auth").load("loginForm.jsp");
			}//success
		});//ajax
	});//logout
	
});//document

function checkIt() {
	status1=true;
	if(!$.trim($("#id").val())) {
		alert("아이디를 입력하세요");
		$("#id").focus();
		status1=false;
		return false;
	}
	if(!$.trim($("#passwd").val())) {
		alert("비밀번호를 입력하세요");
		$("#passwd").focus();
		status1=false;
		return false;
	}
}