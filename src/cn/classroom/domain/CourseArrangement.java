package cn.classroom.domain;

//封装课程安排的JavaBean
public class CourseArrangement {
	private String id;
	private String name;
	private String room_no;
	private int day;
	private int start_section;
	private int end_section;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoom_no() {
		return room_no;
	}

	public void setRoom_no(String room_no) {
		this.room_no = room_no;
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
}
