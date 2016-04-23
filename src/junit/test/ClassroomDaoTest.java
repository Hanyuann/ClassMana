package junit.test;

import org.junit.Test;

import cn.classroom.dao.ClassroomDao;
import cn.classroom.dao.impl.ClassroomDaoImpl;
import cn.classroom.domain.Classroom;

public class ClassroomDaoTest {
	@Test
	public void testAdd(){
		Classroom c = new Classroom();
		c.setRoom_no("101");
		c.setLocation("building A,1 floor");
		ClassroomDao dao = new ClassroomDaoImpl(); 
		dao.addClassroom(c);
	}
	
	@Test
	public void testUpdate(){
		Classroom c = new Classroom();
		c.setRoom_no("101");
		c.setLocation("building A,1st floor,room 1");
		ClassroomDao dao = new ClassroomDaoImpl(); 
		dao.updateClassroom(c);
	}
	
	@Test
	public void deleteTest(){
		ClassroomDao dao = new ClassroomDaoImpl(); 
		dao.deleteClassroom("101");
	}
}
