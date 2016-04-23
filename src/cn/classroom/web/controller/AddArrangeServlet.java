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
import cn.classroom.domain.CourseArrangement;
import cn.classroom.utils.WebUtils;
import cn.classroom.web.formbean.AddArrangeForm;

public class AddArrangeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 1.校验提交表单的字段进行合法性校验(把表单数据封装到formbean)
		AddArrangeForm form = WebUtils.request2Bean(request,
				AddArrangeForm.class);
		Boolean b = form.validate();
		String select = request.getParameter("select");

		// 2.如果校验失败,跳回到表单页面,回显校验失败信息
		if (!b) {
			request.setAttribute("form", form);
			if (select.equals("room_no")) {
				request.setAttribute("room_no", form.getRoom_no());
				request.getRequestDispatcher("/WEB-INF/jsp/addarrange.jsp")
						.forward(request, response);
			} else if (select.equals("name")) {
				request.setAttribute("name", form.getName());
				request.getRequestDispatcher("/WEB-INF/jsp/addarrange.jsp")
						.forward(request, response);
			}
			return;
		}

		// 3.如果校验成功,则调用service处理注册请求
		CourseArrangement ca = new CourseArrangement();
		WebUtils.copyBean(form, ca);
		ca.setId(WebUtils.generateID());
		CourseArrangementDao dao = new CourseArrangementDaoImpl();
		try {
			dao.addArrange(ca);
			// 6.如果service处理成功,跳回用户管理界面
			CourseArrangementDao dao2 = new CourseArrangementDaoImpl();
			ActivityDao dao3 = new ActivityDaoImpl();
			request.setAttribute("alert", "添加课程安排成功！");
			if (select.equals("room_no")) {
				List c_list = dao2.findArrangeByClassroom(form.getRoom_no());
				List a_list = dao3.findActivityByClassroom(form.getRoom_no());
				request.setAttribute("room_no", form.getRoom_no());
				request.setAttribute("c_list", c_list);
				request.setAttribute("a_list", a_list);
				request.getRequestDispatcher("/WEB-INF/jsp/room-arrange.jsp")
						.forward(request, response);
			} else if (select.equals("name")) {
				List c_list = dao2.findArrangeByCourse(form.getName());
				request.setAttribute("name", form.getName());
				request.setAttribute("c_list", c_list);
				request.getRequestDispatcher("/WEB-INF/jsp/room-arrange.jsp")
						.forward(request, response);
			}
			return;
		} catch (Exception e) {
			// 5.如果service处理不成功,并且不成功的原因是其他问题的话,则跳转到网站的全局消息显示页面,为用户显示友好错误消息
			request.setAttribute("message", "服务器出现错误！");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			e.printStackTrace();
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
