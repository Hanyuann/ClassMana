package cn.classroom.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classroom.dao.ActivityDao;
import cn.classroom.dao.ClassroomDao;
import cn.classroom.dao.CourseArrangementDao;
import cn.classroom.dao.impl.ActivityDaoImpl;
import cn.classroom.dao.impl.ClassroomDaoImpl;
import cn.classroom.dao.impl.CourseArrangementDaoImpl;
import cn.classroom.domain.QueryResult;
import cn.classroom.service.BusinessService;
import cn.classroom.service.impl.BusinessServiceImpl;

public class DelClassroomServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String room_no = request.getParameter("room_no");
			ClassroomDao dao = new ClassroomDaoImpl();
			dao.deleteClassroom(room_no);
			CourseArrangementDao dao2 = new CourseArrangementDaoImpl();
			dao2.deleteArrangeByClassroom(room_no);
			ActivityDao dao3 = new ActivityDaoImpl();
			dao3.deleteActivityByClassroom(room_no);
			request.setAttribute("alert", "É¾³ý³É¹¦£¡");
			BusinessService service = new BusinessServiceImpl();
			QueryResult qr = service.queryClassroom();
			request.setAttribute("queryresult", qr);
			request
					.getRequestDispatcher(
							"/WEB-INF/jsp/classroom-mana-main.jsp").forward(
							request, response);
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
