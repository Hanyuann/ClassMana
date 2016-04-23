package cn.classroom.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classroom.dao.ActivityDao;
import cn.classroom.dao.ClassroomDao;
import cn.classroom.dao.CourseArrangementDao;
import cn.classroom.dao.CourseDao;
import cn.classroom.dao.impl.ActivityDaoImpl;
import cn.classroom.dao.impl.ClassroomDaoImpl;
import cn.classroom.dao.impl.CourseArrangementDaoImpl;
import cn.classroom.dao.impl.CourseDaoImpl;
import cn.classroom.domain.QueryResult;
import cn.classroom.service.BusinessService;
import cn.classroom.service.impl.BusinessServiceImpl;

public class DelCourseServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String course_id = request.getParameter("course_id");
			String name = request.getParameter("name");
			CourseDao dao = new CourseDaoImpl();
			dao.deleteCourse(course_id);
			CourseArrangementDao dao2 = new CourseArrangementDaoImpl();
			dao2.deleteArrangeByCourse(name);
			request.setAttribute("alert", "É¾³ý³É¹¦£¡");
			BusinessService service = new BusinessServiceImpl();
			QueryResult qr = service.queryCourse();
			request.setAttribute("queryresult", qr);
			request
					.getRequestDispatcher(
							"/WEB-INF/jsp/course-mana-main.jsp").forward(
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
