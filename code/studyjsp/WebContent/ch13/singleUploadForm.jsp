<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/jquery-form.min.js"></script>
<script src="singleUpload.js"></script>
<title>Insert title here</title>
</head>
<body>
<%--실제 파일이 저장된 경로는 보고싶다면
D:\1501163\code\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\studyjsp\fileSave과
같은 실제 톰캣서버가 구동하는 폴더의 위치에 가서 봐야한다.(이클립스 프로젝트의 저장폴더에는
파일이 올라가지 않는다.--%>
<form id="upForm1" action="singleUploadPro.jsp" method="post"
enctype="multipart/form-data">
	<div id="form">
		<ul>
			<li>
			제목<input type="text" id="title" name="title" size="20"
			autofocus>
			<li>
			파일선택<input type="file" id="file1" name="file1">
			<li><input type="submit" id="upPro1" value="단일 파일 업로드">
		</ul>
	</div>
</form>
<div id="upResult2"></div>
</body>
</html>