<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jQuery ajax Test</title>
<style type="text/css">
	#result{
		width :200px;
		height:200px;
		border:5px double #6699FF;
	}
</style>
<script src="../js/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function() {
		$("#b1").click(function() {
			var query={name :"sss",
					stus:"homebody"};
			$.ajax({
				type:"POST",
				url:"process.jsp",
				data:query,
				success:function(data) {
					$("#result").html(data);
				}
			});//ajax
		});//#b1
	});//document
</script>
</head>
<body>
	<button id="b1">결과</button>
	<div id="result"></div>
</body>
</html>