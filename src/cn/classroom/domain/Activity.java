package cn.classroom.domain;

//封装活动的JavaBean
public class Activity {
	private String aid;
	private String username;
	private String name;
	private String room_no;
	private int day;
	private int start_section;
	private int end_section;
	private int status;

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
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
