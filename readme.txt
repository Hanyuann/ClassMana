一.建立数据库classroom_manage
	所包含的表及字段
		1.用户表user
			id                varchar(40) not null,primary key
			username          varchar(20) not null
			password          varchar(32) not null
			type              varchar(3) not null
		2.教室表classroom
			room_no           varchar(4) not null,primary key
			location          varchar(40) not null
		3.课程表course
			course_id         varchar(4) not null,primary key
			name              varchar(20) not null
			teacher           varchar(20) not null
		4.课程-教室安排表arrangement
			id                varchar(40) not null,primary key
			room_no           varchar(4) not null
			course_id         varchar(4) not null
			day               int(1) not null
			start_section     int(1) not null
			end_section       int(1) not null
		5.活动表activity
			aid               varchar(40) not null,primary key
			name              varchar(40) not null
			room_no           varchar(4) not null
			day               int(1) not null
			start_section     int(1) not null
			end_section       int(1) not null
			status            int(1)
			
二.搭建开发环境
	1.所用环境
		主要:
		MyEclipse 6.6
		MySql 5.0
		Apache-Tomcat-6.0.44
		辅助:
		Dreamweaver CS6
		Photoshop CS6
	2.开发语言
		Java,Jsp
	3.软件架构
		B/S
	4.所需要的外部jar包
		mysql驱动
        beanUtils
        log4j开发
        jstl开发包
        
三.创建组织程序的包	
		cn.classroom.dao
		cn.classroom.dao.impl
		cn.classroom.domain
		cn.classroom.service
		cn.classroom.service.impl
		cn.classroom.web.contorller
		cn.classroom.web.formbean
		cn.classroom.web.UI
		cn.classroom.factory
		cn.classroom.utils
		cn.classroom.exception
		junit.test
		
		WEB-INF/jsp
		