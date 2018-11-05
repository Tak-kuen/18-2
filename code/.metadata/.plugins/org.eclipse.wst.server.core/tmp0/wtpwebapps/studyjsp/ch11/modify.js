/**
 * 
 */

var status = true;

$(document).ready(function() {
	$("#modify").click(function() {
		var query={passwd:$("#passwd").val()};
		$.ajax({
			type:"post",
			url:"memberCheck.jsp",
			data:query,
			success:function(data) {
				if(data==1) {
					$("#main_auth").load("modifyForm.jsp?passwd=" + $("#passwd").val());
				}else {
					alert("비밀번호가 틀립니다.");
					$("#passwd").val("");
					$("#passwd").focus();
				}//if-else
			}//success
		});//ajax
	});//modify
	
	$("#modifyProcess").click(function() {
		var query={id: $("#id").val(),
				passwd:$("#passwd").val(),
				name:$("#name").val(),
				address:$("#address").val(),
				tel:$("#tel").val()};
			
		$.ajax({
			type:"post",
			url:"modifyPro.jsp",
			data:query,
			success:function(data) {
				console.log("1");
				if(data==1) {
					alert("수정되었습니다.");
					location.href="main.jsp";
				}else if(data==0) {
					alert("비밀번호가 일치하지않습니다.");
					$("#passwd").val("");
					$("#passwd").focus();
					console.log("2");
				}
			}//success
		});//ajax
	});//modifyProcess
	
	$("#cancel").click(function() {
		location.href="main.jsp";
	});
	
	$("#delete").click(function() {
		var query = {passwd :$("#passwd").val()};
		console.log("1");
		$.ajax({
	         type:"POST",
	         url:"memberCheck.jsp",
	         data:query,
	         success:function(data){
	            if(data == 1) { // 비밀번호 맞음
	               //회원 탈퇴 페이지 deletePro.jsp 실행
	               $.ajax({
	                  type:"post",
	                  url:"deletePro.jsp",
	                  data: query,
	                  success: function(data){
	                     if(data == 1){ // 탈퇴 성공
	                        alert("회원 탈퇴가 되었습니다.");
	                        location.href="main.jsp";
	                     }
	                  }
	               });
	            } else { // 비밀번호 틀림
	               alert("비밀번호가 맞지 않습니다.");
	               $("#passwd").val("");
	               $("#passwd").focus();
	            }
	         }
	         
	      });
	});//delete
	
});