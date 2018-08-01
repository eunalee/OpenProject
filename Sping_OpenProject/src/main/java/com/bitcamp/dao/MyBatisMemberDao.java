package com.bitcamp.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.model.MemberInfo;

public class MyBatisMemberDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public MemberInfo selectById(String userId) {
		System.out.println("MyBatisDao selectById 실행.....");
		return sqlSessionTemplate.selectOne("com.bitcamp.mapper.MemberMapper.selectById", userId);
	}
	
	public int insertMember(MemberInfo member) {
		System.out.println("MyBatisDao insertMember 실행.....");
		return sqlSessionTemplate.update("com.bitcamp.mapper.MemberMapper.insertMember", member);
	}
}