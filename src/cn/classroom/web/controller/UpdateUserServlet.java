package cn.classroom.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classroom.dao.UserDao;
import cn.classroom.dao.impl.UserDaoImpl;
import cn.classroom.domain.User;
import cn.classroom.utils.WebUtils;
import cn.classroom.web.formbean.UpdateUserForm;

public class UpdateUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 1.校验提交表单的字段进行合法性校验(把表单数据封装到formbean)
		UpdateUserForm form = WebUtils.request2Bean(request,
				UpdateUserForm.class);
		Boolean b = form.validate();

		// 2.如果校验失败,跳回到表单页面,回显校验失败信息
		if (!b) {
			request.setAttribute("form", form);
			User user = new User();
			user.setId(form.getId());
			user.setUsername(form.getUsername());
			user.setType(form.getType());
			request.setAttribute("user", user);
			request.getRequestDispatcher("/WEB-INF/jsp/updateuser.jsp")
					.forward(request, response);
			return;
		}

		// 3.如果校验成功,则调用service处理注册请求
		User user = new User();
		WebUtils.copyBean(form, user);
		user.setPassword(WebUtils.md5(user.getPassword()));
		UserDao dao = new UserDaoImpl();
		try {
			dao.updateUser(user);
			// 6.如果service处理成功,跳回用户管理界面
			user = dao.findUser(user.getId(), true);
			request.setAttribute("user", user);
			request.setAttribute("alert", "修改密码成功！");
			request.getRequestDispatcher("/WEB-INF/jsp/myinfo.jsp").forward(
					request, response);
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
