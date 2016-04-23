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
import cn.classroom.domain.QueryResult;
import cn.classroom.service.BusinessService;
import cn.classroom.service.impl.BusinessServiceImpl;

public class DelActivityServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String aid = request.getParameter("aid");
			String room_no = request.getParameter("room_no");
			String username = request.getParameter("username");
			ActivityDao dao = new ActivityDaoImpl();
			dao.deleteActivity(aid);
			request.setAttribute("alert", "É¾³ý³É¹¦£¡");
			if (room_no != null) {
				request.setAttribute("room_no", room_no);
				CourseArrangementDao dao2 = new CourseArrangementDaoImpl();
				ActivityDao dao3 = new ActivityDaoImpl();

				List c_list = dao2.findArrangeByClassroom(room_no);
				List a_list = dao3.findActivityByClassroom(room_no);
				request.setAttribute("c_list", c_list);
				request.setAttribute("a_list", a_list);
				request.getRequestDispatcher("/WEB-INF/jsp/room-arrange.jsp")
						.forward(request, response);
			} else {
				if (username == null) {
					BusinessService service = new BusinessServiceImpl();
					QueryResult qr = service.queryActivity();
					request.setAttribute("queryresult", qr);
					request.getRequestDispatcher(
							"/WEB-INF/jsp/activity-mana-main.jsp").forward(
							request, response);
				} else {
					ActivityDao dao3 = new ActivityDaoImpl();
					List a_list = dao3.findActivityByUsername(username);
					request.setAttribute("a_list", a_list);
					request.getRequestDispatcher("/WEB-INF/jsp/myactivity.jsp")
							.forward(request, response);
				}
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
