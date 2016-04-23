package cn.classroom.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.classroom.dao.CourseArrangementDao;
import cn.classroom.domain.Course;
import cn.classroom.domain.CourseArrangement;
import cn.classroom.exception.DaoException;
import cn.classroom.utils.JdbcUtils;

//CourseArrangementDao的实现类
public class CourseArrangementDaoImpl implements CourseArrangementDao {
	public void addArrange(CourseArrangement arrangement) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into arrangement(id,room_no,name,day,start_section,end_section) values(?,?,?,?,?,?);";
			st = conn.prepareStatement(sql);
			st.setString(1, arrangement.getId());
			st.setString(2, arrangement.getRoom_no());
			st.setString(3, arrangement.getName());
			st.setInt(4, arrangement.getDay());
			st.setInt(5, arrangement.getStart_section());
			st.setInt(6, arrangement.getEnd_section());
			st.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	public void updateArrange(CourseArrangement arrangement) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update arrangement set room_no=?,name=?,day=?,start_section=?,end_section=? where id=?;";
			st = conn.prepareStatement(sql);
			st.setString(1, arrangement.getRoom_no());
			st.setString(2, arrangement.getName());
			st.setInt(3, arrangement.getDay());
			st.setInt(4, arrangement.getStart_section());
			st.setInt(5, arrangement.getEnd_section());
			st.setString(6, arrangement.getId());
			st.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	public void deleteArrange(String id) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from arrangement where id=?;";
			st = conn.prepareStatement(sql);
			st.setString(1, id);
			st.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	public void deleteArrangeByClassroom(String room_no) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from arrangement where room_no=?;";
			st = conn.prepareStatement(sql);
			st.setString(1, room_no);
			st.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	public void deleteArrangeByCourse(String name) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from arrangement where name=?;";
			st = conn.prepareStatement(sql);
			st.setString(1, name);
			st.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	public CourseArrangement findArrange(String id) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from arrangement where id=?;";
			st = conn.prepareStatement(sql);
			st.setString(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				CourseArrangement arrangement = new CourseArrangement();
				arrangement.setId(rs.getString("id"));
				arrangement.setRoom_no(rs.getString("room_no"));
				arrangement.setName(rs.getString("name"));
				arrangement.setDay(rs.getInt("day"));
				arrangement.setStart_section(rs.getInt("start_section"));
				arrangement.setEnd_section(rs.getInt("end_section"));
				return arrangement;
			}
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
		return null;
	}
	
	public List findArrangeByClassroom(String room_no) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from arrangement where room_no=? order by day,start_section;";
			st = conn.prepareStatement(sql);
			st.setString(1, room_no);
			rs = st.executeQuery();
			List list = new ArrayList();
			while (rs.next()) {
				CourseArrangement arrangement = new CourseArrangement();
				arrangement.setId(rs.getString("id"));
				arrangement.setRoom_no(rs.getString("room_no"));
				arrangement.setName(rs.getString("name"));
				arrangement.setDay(rs.getInt("day"));
				arrangement.setStart_section(rs.getInt("start_section"));
				arrangement.setEnd_section(rs.getInt("end_section"));
				list.add(arrangement);
			}
			return list;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	public boolean checkTime(String room_no,int day, int start_section, int end_section) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from arrangement where room_no=? and day=? and start_section<=? and end_section>=?;";
			st = conn.prepareStatement(sql);
			st.setString(1, room_no);
			st.setInt(2, day);
			st.setInt(3, end_section);
			st.setInt(4, start_section);
			rs = st.executeQuery();
			List list = new ArrayList();
			if (rs.next()) {
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	public List findArrangeByCourse(String name) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from arrangement where name=? order by day,start_section;";
			st = conn.prepareStatement(sql);
			st.setString(1, name);
			rs = st.executeQuery();
			List list = new ArrayList();
			while (rs.next()) {
				CourseArrangement arrangement = new CourseArrangement();
				arrangement.setId(rs.getString("id"));
				arrangement.setRoom_no(rs.getString("room_no"));
				arrangement.setName(rs.getString("name"));
				arrangement.setDay(rs.getInt("day"));
				arrangement.setStart_section(rs.getInt("start_section"));
				arrangement.setEnd_section(rs.getInt("end_section"));
				list.add(arrangement);
			}
			return list;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	public List<CourseArrangement> getAll() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from arrangement;";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			List<CourseArrangement> list = new ArrayList<CourseArrangement>();
			while (rs.next()) {
				CourseArrangement arrangement = new CourseArrangement();
				arrangement.setId(rs.getString("id"));
				arrangement.setRoom_no(rs.getString("room_no"));
				arrangement.setName(rs.getString("name"));
				arrangement.setDay(rs.getInt("day"));
				arrangement.setStart_section(rs.getInt("start_section"));
				arrangement.setEnd_section(rs.getInt("end_section"));
				list.add(arrangement);
			}
			return list;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}
}
