package cn.classroom.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classroom.dao.ActivityDao;
import cn.classroom.dao.impl.ActivityDaoImpl;
import cn.classroom.domain.Activity;
import cn.classroom.utils.WebUtils;
import cn.classroom.web.formbean.AddActivityForm;

public class AddActivityServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 1.校验提交表单的字段进行合法性校验(把表单数据封装到formbean)
		AddActivityForm form = WebUtils.request2Bean(request,
				AddActivityForm.class);
		Boolean b = form.validate();

		// 2.如果校验失败,跳回到表单页面,回显校验失败信息
		if (!b) {
			request.setAttribute("form", form);
			request.setAttribute("username", form.getUsername());
			request.getRequestDispatcher("/WEB-INF/jsp/addactivity.jsp")
					.forward(request, response);
			return;
		}

		// 3.如果校验成功,则调用service处理注册请求
		Activity a = new Activity();
		WebUtils.copyBean(form, a);
		a.setAid(WebUtils.generateID());
		ActivityDao dao = new ActivityDaoImpl();
		try {
			dao.addActivity(a);
			// 6.如果service处理成功,跳回用户管理界面
			String username = request.getParameter("username");
			request.setAttribute("alert", "预约已提交,请等待管理员审核！");
			List a_list = dao.findActivityByUsername(username);
			request.setAttribute("a_list", a_list);
			request.getRequestDispatcher("/WEB-INF/jsp/myactivity.jsp")
					.forward(request, response);
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
