<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>infoTest</title>
</head>
<body>
<%

int age = Integer.parseInt(request.getParameter("age"));
String result;
//배열값을 setAttribute로 전송 테스트
String[] test={"a","b","c"};

request.setAttribute("test",test);

if(age>=20) result="성인";
else result="미성년";


//포워드 방식으로 전송할 경우 setAttribute로 더많은 값을 저장가능
//리턴타입이 객체(Object)이므로 getAttribute로 불러쓸때 원하는 값으로 형변환 해줘야 한다.
request.setAttribute("result",result);
//첫번째 이름의 변수를 만들어 두번째 값을 저장
RequestDispatcher dispatcher = request.getRequestDispatcher("146-2_result.jsp");
dispatcher.forward(request,response);
%>

</body>
</html>