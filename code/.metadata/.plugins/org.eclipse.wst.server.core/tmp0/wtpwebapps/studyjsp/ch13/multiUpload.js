/**
 * 
 */
$(document).ready(function() {
	$("#upForm2").ajaxForm({
		success: function(data,status) {
			$("#upResult2").html("파일 업로드 완료.<br/>");
			var appChild = "<p><button id='refreshForm' onclick='refresh()'>";
			appChild += "업로드 폼 초기화</button> *폼을 초기화할 경우, 클릭하십시오</p>";
			$("#upResult2").append(appChild);
		}
	});
});

function refresh() {
	location.reload(true);
}