package cn.classroom.dao;

import java.util.List;

import cn.classroom.domain.Course;

//操作数据库course表的接口类
public interface CourseDao {

	void addCourse(Course course);

	void updateCourse(Course course);

	void deleteCourse(String course_id);

	boolean findCourse(String course_id);

	boolean findCourseByName(String name);

	List findCourseByTeacher(String username);

	List<Course> getAll();

}