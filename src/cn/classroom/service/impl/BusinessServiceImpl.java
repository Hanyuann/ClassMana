package cn.classroom.service.impl;

import java.util.List;

import cn.classroom.dao.ActivityDao;
import cn.classroom.dao.ClassroomDao;
import cn.classroom.dao.CourseDao;
import cn.classroom.dao.UserDao;
import cn.classroom.dao.impl.ActivityDaoImpl;
import cn.classroom.dao.impl.ClassroomDaoImpl;
import cn.classroom.dao.impl.CourseDaoImpl;
import cn.classroom.dao.impl.UserDaoImpl;
import cn.classroom.domain.QueryResult;
import cn.classroom.domain.User;
import cn.classroom.exception.UserExistException;
import cn.classroom.factory.DaoFactory;
import cn.classroom.service.BusinessService;
import cn.classroom.utils.WebUtils;

//对web层提供所有的业务服务
public class BusinessServiceImpl implements BusinessService {

	//工厂模式 spring
	private UserDao dao = DaoFactory.getInstance().createDao(UserDao.class);

	// 对web层提供注册服务
	public void register(User user) throws UserExistException {
		// 先判断当前要注册的用户是否存在
		Boolean b = dao.findUser(user.getUsername());
		if (b) {
			throw new UserExistException(); // 发现要注册的用户已存在,则给web层抛一个编译时异常,提醒web层处理这个异常,给用户一个友好提示
		} else {
			user.setPassword(WebUtils.md5(user.getPassword()));
			dao.addUser(user);
		}
	}

	// 对web层提供登录服务
	public User login(String username, String password, String type) {
		password = WebUtils.md5(password);
		return dao.findUser(username, password, type);
	}

	// 查询所有用户信息
	public QueryResult queryUser() {
		QueryResult qr = new QueryResult();
		UserDao dao = new UserDaoImpl();
		List list = dao.getAll();
		qr.setList(list);
		return qr;
	}

	// 查询所有教室信息
	public QueryResult queryClassroom() {
		QueryResult qr = new QueryResult();
		ClassroomDao dao = new ClassroomDaoImpl();
		List list = dao.getAll();
		qr.setList(list);
		return qr;
	}

	// 查询所有课程信息
	public QueryResult queryCourse() {
		QueryResult qr = new QueryResult();
		CourseDao dao = new CourseDaoImpl();
		List list = dao.getAll();
		qr.setList(list);
		return qr;
	}

	// 查询所有活动申请信息
	public QueryResult queryActivity() {
		QueryResult qr = new QueryResult();
		ActivityDao dao = new ActivityDaoImpl();
		List list = dao.getAll();
		qr.setList(list);
		return qr;
	}
}
