<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ch11.logon.LogonDBBean" %>
<% request.setCharacterEncoding("utf-8"); %>
<%
	String id=request.getParameter("id");
	
	LogonDBBean manager = LogonDBBean.getInstance();
	
	int check = manager.confirmId(id);
	
	out.println(check);
%>