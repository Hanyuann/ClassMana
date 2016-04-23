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

public class DelArrangeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			CourseArrangementDao dao = new CourseArrangementDaoImpl();
			dao.deleteArrange(id);
			request.setAttribute("alert", "É¾³ý³É¹¦£¡");
			String select = request.getParameter("select");
			if (select.equals("room_no")) {
				String room_no = request.getParameter("room_no");
				request.setAttribute("room_no", room_no);
				CourseArrangementDao dao2 = new CourseArrangementDaoImpl();
				ActivityDao dao3 = new ActivityDaoImpl();
				List c_list = dao2.findArrangeByClassroom(room_no);
				List a_list = dao3.findActivityByClassroom(room_no);
				request.setAttribute("c_list", c_list);
				request.setAttribute("a_list", a_list);
				request.getRequestDispatcher("/WEB-INF/jsp/room-arrange.jsp")
						.forward(request, response);
			} else if (select.equals("name")) {
				String name = request.getParameter("name");
				CourseArrangementDao dao2 = new CourseArrangementDaoImpl();
				List c_list = dao2.findArrangeByCourse(name);
				request.setAttribute("c_list", c_list);
				request.getRequestDispatcher("/WEB-INF/jsp/room-arrange.jsp")
						.forward(request, response);
			}
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
