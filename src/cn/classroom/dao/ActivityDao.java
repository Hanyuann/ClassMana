package cn.classroom.dao;

import java.util.List;

import cn.classroom.domain.Activity;

//操作数据库activity表的接口类
public interface ActivityDao {

	void addActivity(Activity activity);

	void updateActivity(String aid, int status);

	void deleteActivity(String aid);

	void deleteActivityByClassroom(String room_no);

	Activity findActivity(String aid);

	List findActivityByClassroom(String room_no);

	List findActivityByUsername(String username);

	boolean checkTime(String room_no, int day, int start_section,
			int end_section);

	List<Activity> getAll();
}