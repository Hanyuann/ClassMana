package cn.classroom.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classroom.domain.QueryResult;
import cn.classroom.service.BusinessService;
import cn.classroom.service.impl.BusinessServiceImpl;

public class UserManaServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			BusinessService service = new BusinessServiceImpl();
			QueryResult qr = service.queryUser();
			request.setAttribute("queryresult", qr);
			request.getRequestDispatcher("/WEB-INF/jsp/user-mana-main.jsp")
			.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "�鿴�û�ʧ�ܣ�");
			request.getRequestDispatcher("/message.jsp")
			.forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
