package cn.classroom.dao;

import java.util.List;

import cn.classroom.domain.Classroom;

//操作数据库classroom表的接口类
public interface ClassroomDao {

	void addClassroom(Classroom classroom);

	void updateClassroom(Classroom classroom);

	void deleteClassroom(String room_no);

	// Classroom findClassroom(String room_no);

	boolean findClassroom(String room_no);

	List<Classroom> getAll();

}