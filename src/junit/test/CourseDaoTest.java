package junit.test;

import org.junit.Test;

import cn.classroom.dao.CourseDao;
import cn.classroom.dao.impl.CourseDaoImpl;
import cn.classroom.domain.Course;

public class CourseDaoTest {
	@Test
	public void testAdd(){
		Course c = new Course();
		c.setCourse_id("1000");
		c.setName("courseA");
		c.setTeacher("teacher1");
		CourseDao dao = new CourseDaoImpl();
		dao.addCourse(c);
	}
	
	@Test
	public void testUpdate(){
		Course c = new Course();
		c.setCourse_id("1000");
		c.setName("courseA");
		c.setTeacher("teacherA");
		CourseDao dao = new CourseDaoImpl();
		dao.updateCourse(c);
	}
	
	
	@Test
	public void testDelete(){
		CourseDao dao = new CourseDaoImpl();
		dao.deleteCourse("1000");
	}
}
