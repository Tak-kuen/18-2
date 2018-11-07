<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>

<% request.setCharacterEncoding("utf-8"); %>

<%
	//서블릿에서 하게 될 작업
	String result="--------------------------------------------<br>";
	String realFolder ="";
	String saveFolder ="/fileSave";
	String encType="utf-8";
	int maxSize = 5*1024*1024;
	
	//현재 jsp 페이지의 was의 절대경로를 구함
	ServletContext context = getServletContext();
	realFolder = context.getRealPath(saveFolder);
	
	try{
		MultipartRequest upload =null;
		
		//파일 업로드를 수행하는 MultipartRequest 객체 생성
		upload = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		
		//input 타입이 파일이 아닌 모든 파라미터를 얻어냄
		Enumeration<?> params = upload.getParameterNames();
		//파일 아닌 것들 출력
		while(params.hasMoreElements()) {
			String name=(String)params.nextElement();
			String value=upload.getParameter(name);
			result += name + " : " + value + "<br>";
		}//while input type="file" 아닌애들
				
				
		//input 타입이 파일인 파라미터들을 얻어냄
		Enumeration<?> files = upload.getFileNames();
		//input 타입이 파일인 파라미터들의 정보 얻어냄
		while(files.hasMoreElements()) {
			String name=(String)files.nextElement();
			String filename = upload.getFilesystemName(name);
			String original = upload.getOriginalFileName(name);
			String type=upload.getContentType(name);
			result += "파라미터 이름 : " + name + "<br>";
			result += "실제 파일 이름 : " + original + "<br>";
			result += "저장된 파일 이름 : " + filename + "<br>";
			result += "파일 타입 : " + type + "<br>";
			
			File file = upload.getFile(name);
			if(file != null) {
				result +="크기" + file.length() + "bytes <br>";
			}//if(file!=null)
		}//while input type="file"
		result +="--------------------------------------------<br>";
		out.println(result);
		//보통 결과를 JSON으로 리턴
	}catch(Exception e) {
		e.printStackTrace();
	}
%>