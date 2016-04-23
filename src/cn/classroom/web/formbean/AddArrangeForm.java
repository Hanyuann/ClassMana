package cn.classroom.web.formbean;

import java.util.HashMap;
import java.util.Map;

import cn.classroom.dao.ActivityDao;
import cn.classroom.dao.ClassroomDao;
import cn.classroom.dao.CourseArrangementDao;
import cn.classroom.dao.CourseDao;
import cn.classroom.dao.impl.ActivityDaoImpl;
import cn.classroom.dao.impl.ClassroomDaoImpl;
import cn.classroom.dao.impl.CourseArrangementDaoImpl;
import cn.classroom.dao.impl.CourseDaoImpl;

public class AddArrangeForm {
	private String room_no;
	private String name;
	private int day;
	private int start_section;
	private int end_section;
	private Map errors = new HashMap<String, String>();

	public String getRoom_no() {
		return room_no;
	}

	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getStart_section() {
		return start_section;
	}

	public void setStart_section(int start_section) {
		this.start_section = start_section;
	}

	public int getEnd_section() {
		return end_section;
	}

	public void setEnd_section(int end_section) {
		this.end_section = end_section;
	}

	public Map getErrors() {
		return errors;
	}

	public void setErrors(Map errors) {
		this.errors = errors;
	}

	public boolean validate() {
		boolean isOK = true;
		if (this.room_no == null || this.room_no.trim().equals("")) {
			isOK = false;
			errors.put("room_no", "教室号不能为空！");
		} else {
			if (!this.room_no.matches("[A-Za-z0-9]{1,4}")) {
				isOK = false;
				errors.put("room_no", "教室号太长！");
			} else {
				ClassroomDao dao = new ClassroomDaoImpl();
				if (!dao.findClassroom(this.room_no)) {
					isOK = false;
					errors.put("room_no", "该教室不存在，请先完善教室信息！");
				} else {
					CourseArrangementDao dao1 = new CourseArrangementDaoImpl();
					ActivityDao dao2 = new ActivityDaoImpl();
					if (dao1
							.checkTime(room_no, day, start_section, end_section)
							|| dao2.checkTime(room_no, day, start_section,
									end_section)) {
						isOK = false;
						errors.put("day", "该时间段已有安排！");
					}
				}
			}
		}

		if (this.name == null || this.name.trim().equals("")) {
			isOK = false;
			errors.put("name", "课程名不能为空！");
		} else {
			CourseDao dao = new CourseDaoImpl();
			if (!dao.findCourseByName(name)) {
				isOK = false;
				errors.put("name", "该课程名不存在，请先完善教室信息！！");
			}
		}

		if (this.start_section > this.end_section) {
			isOK = false;
			errors.put("day", "上课时间错误，开始时间应早于结束时间！");
		}
		return isOK;
	}
}
