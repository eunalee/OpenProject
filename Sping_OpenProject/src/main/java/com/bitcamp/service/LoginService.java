package com.bitcamp.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.dao.JdbcTemplateMemberDao;
import com.bitcamp.dao.MemberDaoInterface;
import com.bitcamp.model.MemberInfo;

public class LoginService {
/*	//JDBC
	@Autowired
	MemberDao memberDao;*/
	
	//Spring Framework JdbcTemplate 클래스를 이용한 DAO
	@Autowired
	JdbcTemplateMemberDao memberDao;
	
/*	//Spring + Mybatis 이용한 DAO
	@Autowire
	MyBatisMemberDao memberDao;*/
	
/*	// Spring + Mybatis : 자동 매퍼 생성 시능이용한 DAO 
	private SqlSessionTemplate template;
	
	private MemberDaoInterface memberDao;*/
	
	public MemberInfo login(String id, String password) throws Exception {	
		//memberDao = template.getMapper(MemberDaoInterface.class);
		
		MemberInfo member = memberDao.selectById(id);
		
		if(member == null) 
			throw new Exception();
		
		if(!member.matchPassword(password)) 
			throw new Exception();
		
		else
			return member;
	}
}