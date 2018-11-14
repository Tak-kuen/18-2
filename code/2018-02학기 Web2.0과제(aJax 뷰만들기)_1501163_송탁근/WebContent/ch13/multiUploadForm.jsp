<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MultiUpload</title>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/jquery-form.min.js"></script>
<script src="multiUpload.js"></script>
</head>
<body>
	<form id="upForm2" action="multiUploadPro.jsp" method="post" enctype="multipart/form-data">
		<div id="form">
			<ul>
				<li>
				<p>* 파일선택기에서 ctrl,shift키를 눌러 파일을 다중선택 하십시오.</p>
				<label for="file2">파일선택</label>
				<input type="file" id="file2" name="file2" multiple>
				<li><input type="submit" id="upPro2" value="다중 파일 업로드">
			</ul>
		</div>
	</form>
	<div id="upResult2"></div>
</body>
</html>