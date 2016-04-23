package cn.classroom.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classroom.dao.UserDao;
import cn.classroom.dao.impl.UserDaoImpl;
import cn.classroom.domain.QueryResult;
import cn.classroom.service.BusinessService;
import cn.classroom.service.impl.BusinessServiceImpl;

public class DelUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			UserDao dao = new UserDaoImpl();
			dao.deleteUser(id);
			request.setAttribute("alert", "É¾³ý³É¹¦£¡");
			BusinessService service = new BusinessServiceImpl();
			QueryResult qr = service.queryUser();
			request.setAttribute("queryresult", qr);
			request.getRequestDispatcher("/WEB-INF/jsp/user-mana-main.jsp")
			.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "É¾³ýÊ§°Ü!");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
