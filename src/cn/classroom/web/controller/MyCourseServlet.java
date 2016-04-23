package cn.classroom.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classroom.dao.ActivityDao;
import cn.classroom.dao.CourseArrangementDao;
import cn.classroom.dao.CourseDao;
import cn.classroom.dao.impl.ActivityDaoImpl;
import cn.classroom.dao.impl.CourseArrangementDaoImpl;
import cn.classroom.dao.impl.CourseDaoImpl;
import cn.classroom.domain.QueryResult;

public class MyCourseServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		try {
			request.setCharacterEncoding("UTF-8");
			CourseDao dao = new CourseDaoImpl();
			List list = dao.findCourseByTeacher(username);
			QueryResult qr = new QueryResult();
			qr.setList(list);
			request.setAttribute("username", username);
			request.setAttribute("queryresult", qr);
			request.getRequestDispatcher("/WEB-INF/jsp/course-mana-main.jsp")
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
