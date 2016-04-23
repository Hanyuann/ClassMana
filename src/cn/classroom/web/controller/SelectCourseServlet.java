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

public class SelectCourseServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String name = (String) request.getParameter("name");
			String username = request.getParameter("username");
			if (username != null) {
				request.setAttribute("username", username);
			}
			request.setAttribute("name", name);
			CourseArrangementDao dao = new CourseArrangementDaoImpl();
			ActivityDao dao2 = new ActivityDaoImpl();
			List c_list = dao.findArrangeByCourse(name);
			request.setAttribute("c_list", c_list);
			request.getRequestDispatcher("/WEB-INF/jsp/room-arrange.jsp")
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
