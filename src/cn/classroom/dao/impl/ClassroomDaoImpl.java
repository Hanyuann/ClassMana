package cn.classroom.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.classroom.dao.ClassroomDao;
import cn.classroom.domain.Classroom;
import cn.classroom.exception.DaoException;
import cn.classroom.utils.JdbcUtils;

//ClassroomDao的实现类
public class ClassroomDaoImpl implements ClassroomDao {
	public void addClassroom(Classroom classroom) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into classroom(room_no,location) values(?,?);";
			st = conn.prepareStatement(sql);
			st.setString(1, classroom.getRoom_no());
			st.setString(2, classroom.getLocation());
			st.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	public void updateClassroom(Classroom classroom) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update classroom set location=? where room_no=?;";
			st = conn.prepareStatement(sql);
			st.setString(1, classroom.getLocation());
			st.setString(2, classroom.getRoom_no());
			st.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	public void deleteClassroom(String room_no) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from classroom where room_no=?;";
			st = conn.prepareStatement(sql);
			st.setString(1, room_no);
			st.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	//
	// public Classroom findClassroom(String room_no) {
	// Connection conn = null;
	// PreparedStatement st = null;
	// ResultSet rs = null;
	// try {
	// conn = JdbcUtils.getConnection();
	// String sql = "select * from classroom where room_no=?;";
	// st = conn.prepareStatement(sql);
	// st.setString(1, room_no);
	// rs = st.executeQuery();
	// if (rs.next()) {
	// Classroom classroom = new Classroom();
	// classroom.setRoom_no(room_no);
	// classroom.setLocation(rs.getString("location"));
	// return classroom;
	// }
	// } catch (Exception e) {
	// throw new DaoException(e);
	// } finally {
	// JdbcUtils.release(conn, st, rs);
	// }
	//		return null;
	//	}

	public boolean findClassroom(String room_no) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from classroom where room_no=?;";
			st = conn.prepareStatement(sql);
			st.setString(1, room_no);
			rs = st.executeQuery();
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

	public List<Classroom> getAll() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from classroom order by room_no;";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			List<Classroom> list = new ArrayList<Classroom>();
			while (rs.next()) {
				Classroom classroom = new Classroom();
				classroom.setRoom_no(rs.getString("room_no"));
				classroom.setLocation(rs.getString("location"));
				list.add(classroom);
			}
			return list;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}
}
