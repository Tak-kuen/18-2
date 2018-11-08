package ch17.controller;

import javax.servlet.http.*;

public interface CommandProcess {
	public String requestPro(
			HttpServletRequest request, HttpServletResponse response)
			throws Throwable;
}
