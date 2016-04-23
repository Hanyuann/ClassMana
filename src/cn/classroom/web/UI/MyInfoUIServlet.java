package cn.classroom.web.UI;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classroom.dao.UserDao;
import cn.classroom.dao.impl.UserDaoImpl;
import cn.classroom.domain.User;

public class MyInfoUIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		UserDao dao = new UserDaoImpl();
		User user = dao.findUser(id, true);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/WEB-INF/jsp/myinfo.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
