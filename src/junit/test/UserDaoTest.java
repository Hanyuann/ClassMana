package junit.test;

import org.junit.Test;

import cn.classroom.dao.UserDao;
import cn.classroom.dao.impl.UserDaoImpl;
import cn.classroom.domain.User;
import cn.classroom.utils.WebUtils;

public class UserDaoTest {
	@Test
	public void testAdd(){
		User user = new User();
		user.setId(WebUtils.generateID());
		user.setUsername("admin");
		user.setPassword("123456");
		user.setType("admin");
		UserDao dao = new UserDaoImpl();
		dao.addUser(user);
	}
	
	@Test
	public void testUpdate(){
		User user = new User();
		user.setId("5b05e736-5519-4b84-952a-bd2c888d1936");
		user.setUsername("student1");
		user.setPassword("111111");
		user.setType("student");
		UserDao dao = new UserDaoImpl();
		dao.updateUser(user);
	}
	
	@Test
	public void deleteTest(){
		UserDao dao = new UserDaoImpl();
		dao.deleteUser("5b05e736-5519-4b84-952a-bd2c888d1936");
	}
}
