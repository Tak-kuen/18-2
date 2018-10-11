<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="practice_181004.TodoBean, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1501163</title>
</head>
<body>
	<style>
	ul {
	list-style:none;
	}
	</style>
	<h2>할일 리스트 생성 및 조회</h2>
	<h3>추가하기</h3>
	<form action = "TodoServlet" method="post">
		할일 : <input type="text" name="detail" ><input type="submit" value="추가하기"><br/>
	</form>
	<h3>조회하기</h3>
	<ul>
	<%
		ArrayList<TodoBean> todoList = (ArrayList<TodoBean>)session.getAttribute("todoList");
		if(todoList !=null) {
			for(int i=0; i<todoList.size();i++) {%>
				<li ><%=todoList.get(i).getDetail() %>
			<%}
			
			 }%>
	</ul>

</body>
</html>