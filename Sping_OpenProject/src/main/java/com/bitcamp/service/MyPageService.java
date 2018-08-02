package com.bitcamp.service;

import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bitcamp.dao.MemberDaoInterface;
import com.bitcamp.dao.MyBatisMemberDao;
import com.bitcamp.model.MemberInfo;

@Controller
public class MyPageService {
/*	@Autowired
	JdbcTemplateMemberDao memberDao;*/
	
	@Autowired
	MyBatisMemberDao memberDao;
	
/*	@Autowired
	private SqlSessionTemplate template;
	
	private MemberDaoInterface memberDao;*/
	
	public MemberInfo getInfo(String id) throws SQLException {
		//memberDao = template.getMapper(MemberDaoInterface.class);
		MemberInfo member = memberDao.selectById(id);
		
		return member;
	}
}