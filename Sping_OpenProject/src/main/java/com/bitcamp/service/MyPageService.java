package com.bitcamp.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bitcamp.dao.JdbcTemplateMemberDao;
import com.bitcamp.model.MemberInfo;

@Controller
public class MyPageService {
	@Autowired
	JdbcTemplateMemberDao memberDao;
	//MyBatisMemberDao memberDao;
	
	public MemberInfo getInfo(String id) throws SQLException {
		MemberInfo member = memberDao.selectById(id);
		
		return member;
	}
}