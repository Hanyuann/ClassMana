package cn.classroom.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.classroom.dao.ActivityDao;
import cn.classroom.domain.Activity;
import cn.classroom.exception.DaoException;
import cn.classroom.utils.JdbcUtils;

//ActivityDao的实现类
public class ActivityDaoImpl implements ActivityDao {
	public void addActivity(Activity activity) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into activity(aid,username,name,room_no,day,start_section,end_section,status) values(?,?,?,?,?,?,?,?);";
			st = conn.prepareStatement(sql);
			st.setString(1, activity.getAid());
			st.setString(2, activity.getUsername());
			st.setString(3, activity.getName());
			st.setString(4, activity.getRoom_no());
			st.setInt(5, activity.getDay());
			st.setInt(6, activity.getStart_section());
			st.setInt(7, activity.getEnd_section());
			st.setInt(8, activity.getStatus());
			st.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	public void updateActivity(String aid, int status) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update activity set status=? where aid=?;";
			st = conn.prepareStatement(sql);
			st.setInt(1, status);
			st.setString(2, aid);
			st.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	public void deleteActivity(String aid) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from activity where aid=?;";
			st = conn.prepareStatement(sql);
			st.setString(1, aid);
			st.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	public void deleteActivityByClassroom(String room_no) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from activity where room_no=?;";
			st = conn.prepareStatement(sql);
			st.setString(1, room_no);
			st.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	public Activity findActivity(String aid) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from activity where aid=?;";
			st = conn.prepareStatement(sql);
			st.setString(1, aid);
			rs = st.executeQuery();
			if (rs.next()) {
				Activity activity = new Activity();
				activity.setAid(rs.getString("aid"));
				activity.setUsername(rs.getString("username"));
				activity.setName(rs.getString("name"));
				activity.setRoom_no(rs.getString("room_no"));
				activity.setDay(rs.getInt("day"));
				activity.setStart_section(rs.getInt("start_section"));
				activity.setEnd_section(rs.getInt("end_section"));
				activity.setStatus(rs.getInt("status"));
				return activity;
			}
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
		return null;
	}

	public List findActivityByClassroom(String room_no) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from activity where room_no=? and status=? order by status,day,start_section;";
			st = conn.prepareStatement(sql);
			st.setString(1, room_no);
			st.setInt(2, 1);
			rs = st.executeQuery();
			List list = new ArrayList();
			while (rs.next()) {
				Activity activity = new Activity();
				activity.setAid(rs.getString("aid"));
				activity.setUsername(rs.getString("username"));
				activity.setName(rs.getString("name"));
				activity.setRoom_no(rs.getString("room_no"));
				activity.setDay(rs.getInt("day"));
				activity.setStart_section(rs.getInt("start_section"));
				activity.setEnd_section(rs.getInt("end_section"));
				activity.setStatus(rs.getInt("status"));
				list.add(activity);
			}
			return list;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	public List findActivityByUsername(String username) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from activity where username=? order by status,day,start_section;";
			st = conn.prepareStatement(sql);
			st.setString(1, username);
			rs = st.executeQuery();
			List list = new ArrayList();
			while (rs.next()) {
				Activity activity = new Activity();
				activity.setAid(rs.getString("aid"));
				activity.setUsername(rs.getString("username"));
				activity.setName(rs.getString("name"));
				activity.setRoom_no(rs.getString("room_no"));
				activity.setDay(rs.getInt("day"));
				activity.setStart_section(rs.getInt("start_section"));
				activity.setEnd_section(rs.getInt("end_section"));
				activity.setStatus(rs.getInt("status"));
				list.add(activity);
			}
			return list;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	public boolean checkTime(String room_no, int day, int start_section,
			int end_section) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from activity where room_no=? and day=? and start_section<=? and end_section>=?;";
			st = conn.prepareStatement(sql);
			st.setString(1, room_no);
			st.setInt(2, day);
			st.setInt(3, start_section);
			st.setInt(4, end_section);
			rs = st.executeQuery();
			List list = new ArrayList();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	public List<Activity> getAll() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from activity;";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			List<Activity> list = new ArrayList<Activity>();
			while (rs.next()) {
				Activity activity = new Activity();
				activity.setAid(rs.getString("aid"));
				activity.setUsername(rs.getString("username"));
				activity.setName(rs.getString("name"));
				activity.setRoom_no(rs.getString("room_no"));
				activity.setDay(rs.getInt("day"));
				activity.setStart_section(rs.getInt("start_section"));
				activity.setEnd_section(rs.getInt("end_section"));
				activity.setStatus(rs.getInt("status"));
				list.add(activity);
			}
			return list;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}
}
