package cn.classroom.dao;

import java.util.List;

import cn.classroom.domain.User;

//操作数据库user表的接口类
public interface UserDao {

	void addUser(User user);

	void updateUser(User user);

	void deleteUser(String id);

	List<User> getAll();

	boolean findUser(String username);

	boolean findUser(String username, String type);
	
	User findUser(String id, boolean b);

	User findUser(String username, String password, String type);
}