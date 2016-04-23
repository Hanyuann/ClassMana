package cn.classroom.dao;

import java.util.List;

import cn.classroom.domain.CourseArrangement;

//操作数据库arrangement表的接口类
public interface CourseArrangementDao {

	void addArrange(CourseArrangement arrangement);

	void updateArrange(CourseArrangement arrangement);

	void deleteArrange(String id);
	
	void deleteArrangeByClassroom(String room_no);
	
	void deleteArrangeByCourse(String name);

	CourseArrangement findArrange(String id);

	List findArrangeByClassroom(String room_no);
	
	List findArrangeByCourse(String name);
	
	boolean checkTime(String room_no,int day, int start_section, int end_section);

	List<CourseArrangement> getAll();

}