<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jQuery Event Handling</title>
<script src="../js/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function() {
		$("p").mouseenter(function() {
			$(this).text("들어옴");
		});
		
		$("p").mouseleave(function() {
			$(this).text("일단 와바");
		});
		
		$("button").dblclick(function() {
			$(this).css("background-color","#cccccc");
		});
	});
</script>
</head>
<body>
	<p>일단 와바</p>
	<button>더블클릭 ㄱㄱ</button>
	
</body>
</html>