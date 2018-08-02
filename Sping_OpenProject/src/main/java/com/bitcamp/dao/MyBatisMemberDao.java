package com.bitcamp.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.model.MemberInfo;
import com.bitcamp.model.MemberInfoView;

public class MyBatisMemberDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public MemberInfo selectById(String userId) {
		System.out.println("MyBatisDao selectById 실행.....");
		return sqlSessionTemplate.selectOne("com.bitcamp.mapper.MemberMapper.selectById", userId);
	}
	
	public int insert(MemberInfo member) {
		System.out.println("MyBatisDao insert 실행.....");
		return sqlSessionTemplate.update("com.bitcamp.mapper.MemberMapper.insert", member);
	}
	
	public List<MemberInfoView> selectAll() {
		System.out.println("MyBatisDao selectAll 실행.....");
		return sqlSessionTemplate.selectList("com.bitcamp.mapper.MemberMapper.selectAll");
	}
}