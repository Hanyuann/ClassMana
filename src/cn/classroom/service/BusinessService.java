package cn.classroom.service;

import cn.classroom.domain.QueryResult;
import cn.classroom.domain.User;
import cn.classroom.exception.UserExistException;

//业务类的接口
public interface BusinessService {

	// 对web层提供注册服务
	void register(User user) throws UserExistException;

	// 对web层提供登录服务
	User login(String username, String password, String type);

	QueryResult queryUser();
	
	QueryResult queryClassroom();
	
	QueryResult queryCourse();
	
	QueryResult queryActivity();
}