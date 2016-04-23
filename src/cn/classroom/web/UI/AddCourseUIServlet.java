package cn.classroom.web.UI;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCourseUIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String course_id = request.getParameter("course_id");
		String name = request.getParameter("name");
		request.setAttribute("course_id", course_id);
		request.setAttribute("name", name);
		request.getRequestDispatcher("/WEB-INF/jsp/addcourse.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
