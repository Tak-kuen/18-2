<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jQuery Test</title>
<style type="text/css">
	div#displayArea {
		width:636px;
		height:358px;
		border: 5px double #6699FF;
	}
</style>
<script src="../js/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function() {
		$("button").click(function() {
			$("#displayArea").html("<img src='nvidia.gif'/>");
		});
	});
</script>
</head>
<body>
	<div id="displayArea">이곳의 내용이 변경</div>
	<button>표시</button>
</body>
</html>