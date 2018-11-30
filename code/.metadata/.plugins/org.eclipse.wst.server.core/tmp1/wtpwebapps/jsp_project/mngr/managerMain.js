/**
 * 매니저 메인화면 버튼 핸들링
 */

var status=true;

$(document).ready(function() {
	
	
	$("#registProduct").click(function() {
		location.href="/jsp_project/mg/bookRegisterForm.do";
	});
	$("#updateProduct").click(function() {
		location.href="/jsp_project/mg/booklist.do?book_kind=all";
	});
	$("#orderedProduct").click(function() {
		location.href="/jsp_project/mg/orderList.do";
	});
	$("#qna").click(function() {
		location.href="/jsp_project/mg/qnaList.do";
	});
});