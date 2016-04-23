package cn.classroom.web.formbean;

import java.util.HashMap;
import java.util.Map;

import cn.classroom.dao.ActivityDao;
import cn.classroom.dao.ClassroomDao;
import cn.classroom.dao.CourseArrangementDao;
import cn.classroom.dao.impl.ActivityDaoImpl;
import cn.classroom.dao.impl.ClassroomDaoImpl;
import cn.classroom.dao.impl.CourseArrangementDaoImpl;

public class AddActivityForm {
	private String room_no;
	private String username;
	private String name;
	private int day;
	private int start_section;
	private int end_section;
	private int status;
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
					errors.put("room_no", "该教室不存在！");
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
			errors.put("name", "活动名称不能为空！");
		} else {
			if (!name.matches("^.{1,40}$")) {
				isOK = false;
				errors.put("name", "活动名称太长！");
			}
		}

		if (this.start_section > this.end_section) {
			isOK = false;
			errors.put("day", "时间错误，开始时间应早于结束时间！");
		}
		return isOK;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
