package edu.seedit.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		try {
			// admin�̶�� ����key�� ���� ������ ���ϰ�� �α����������� �̵�
			if (request.getSession().getAttribute("userId") == null) {
				response.sendRedirect("/edu01/login/login.do");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// admin ����key ����� main ������ �̵�
		return true;
	}

}
