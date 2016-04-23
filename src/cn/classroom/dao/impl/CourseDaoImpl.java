package cn.classroom.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.classroom.dao.CourseDao;
import cn.classroom.domain.Course;
import cn.classroom.exception.DaoException;
import cn.classroom.utils.JdbcUtils;

//CourseDao的实现类
public class CourseDaoImpl implements CourseDao {
	public void addCourse(Course course) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into course(course_id,name,teacher) values(?,?,?);";
			st = conn.prepareStatement(sql);
			st.setString(1, course.getCourse_id());
			st.setString(2, course.getName());
			st.setString(3, course.getTeacher());
			st.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	public void updateCourse(Course course) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update course set name=?,teacher=? where course_id=?;";
			st = conn.prepareStatement(sql);
			st.setString(1, course.getName());
			st.setString(2, course.getTeacher());
			st.setString(3, course.getCourse_id());
			st.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	public void deleteCourse(String course_id) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from course where course_id=?;";
			st = conn.prepareStatement(sql);
			st.setString(1, course_id);
			st.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	public List findCourseByTeacher(String username) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from course where teacher=?;";
			st = conn.prepareStatement(sql);
			st.setString(1, username);
			rs = st.executeQuery();
			List<Course> list = new ArrayList<Course>();
			while (rs.next()) {
				Course course = new Course();
				course.setCourse_id(rs.getString("course_id"));
				course.setName(rs.getString("name"));
				course.setTeacher(rs.getString("teacher"));
				list.add(course);
			}
			return list;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	public boolean findCourse(String course_id) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from course where course_id=?;";
			st = conn.prepareStatement(sql);
			st.setString(1, course_id);
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

	public boolean findCourseByName(String name) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from course where name=?;";
			st = conn.prepareStatement(sql);
			st.setString(1, name);
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

	public List<Course> getAll() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from course;";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			List<Course> list = new ArrayList<Course>();
			while (rs.next()) {
				Course course = new Course();
				course.setCourse_id(rs.getString("course_id"));
				course.setName(rs.getString("name"));
				course.setTeacher(rs.getString("teacher"));
				list.add(course);
			}
			return list;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}
}
