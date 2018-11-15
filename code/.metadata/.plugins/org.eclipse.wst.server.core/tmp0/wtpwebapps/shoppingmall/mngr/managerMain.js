/**
 * 매니저 메인화면 버튼 핸들링
 */

var status=true;

$(document).ready(function() {
	$("#registProduct").click(function() {
		location.href="/shoppingmall/mg/bookRegisterForm.do";
	});
	$("#updateProduct").click(function() {
		location.href="/shoppingmall/mg/booklist.do?book_kind=all";
	});
	$("#orderedProduct").click(function() {
		location.href="/shoppingmall/mg/orderList.do";
	});
	$("#qna").click(function() {
		location.href="/shoppingmall/mg/qnaList.do";
	});
});