package ch17.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ch17.model.MemberDBBean;

public class ListProcessURI implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//DBCP에 접속한 뒤 사용자 정보를 모두 받아와서 ArrayList<Bean>으로 저장
		//어레이리스트를 리퀘스트에 붙여 포워딩할수있도록
		//request.setAttribute("members",list);
		MemberDBBean db= MemberDBBean.getInstance();
		request.setAttribute("list", db.browseMember());
		return "/ch17/list.jsp";
	}
}
