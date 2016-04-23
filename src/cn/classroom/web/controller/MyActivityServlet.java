package cn.classroom.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classroom.dao.ActivityDao;
import cn.classroom.dao.CourseArrangementDao;
import cn.classroom.dao.impl.ActivityDaoImpl;
import cn.classroom.dao.impl.CourseArrangementDaoImpl;

public class MyActivityServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		try {
			request.setCharacterEncoding("UTF-8");
			ActivityDao dao = new ActivityDaoImpl();
			List a_list = dao.findActivityByUsername(username);
			request.setAttribute("username", username);
			request.setAttribute("a_list", a_list);
			request.getRequestDispatcher("/WEB-INF/jsp/myactivity.jsp")
					.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "²é¿´Ê§°Ü£¡");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
