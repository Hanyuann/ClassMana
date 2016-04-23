package cn.classroom.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classroom.dao.CourseDao;
import cn.classroom.dao.impl.CourseDaoImpl;
import cn.classroom.domain.Course;
import cn.classroom.domain.QueryResult;
import cn.classroom.service.BusinessService;
import cn.classroom.service.impl.BusinessServiceImpl;
import cn.classroom.utils.WebUtils;
import cn.classroom.web.formbean.AddCourseForm;
import cn.classroom.web.formbean.UpdateCourseForm;

public class UpdateCourseServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 1.校验提交表单的字段进行合法性校验(把表单数据封装到formbean)
		UpdateCourseForm form = WebUtils.request2Bean(request,
				UpdateCourseForm.class);
		Boolean b = form.validate();

		// 2.如果校验失败,跳回到表单页面,回显校验失败信息
		if (!b) {
			request.setAttribute("form", form);
			request.setAttribute("course_id", form.getCourse_id());
			request.setAttribute("name", form.getName());
			request.getRequestDispatcher("/WEB-INF/jsp/addcourse.jsp").forward(
					request, response);
			return;
		}

		// 3.如果校验成功,则调用service处理注册请求
		Course c = new Course();
		WebUtils.copyBean(form, c);
		CourseDao dao = new CourseDaoImpl();
		try {
			dao.updateCourse(c);
			// 6.如果service处理成功,跳回用户管理界面
			BusinessService service = new BusinessServiceImpl();
			QueryResult qr = service.queryCourse();
			request.setAttribute("queryresult", qr);
			request.setAttribute("alert", "添加课程成功！");
			request.getRequestDispatcher("/WEB-INF/jsp/course-mana-main.jsp")
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
