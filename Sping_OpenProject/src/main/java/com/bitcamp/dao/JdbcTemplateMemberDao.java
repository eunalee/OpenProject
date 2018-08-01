package com.bitcamp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.bitcamp.model.MemberInfo;

public class JdbcTemplateMemberDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public MemberInfo selectById(String id) {
		MemberInfo resultObj = null;
		
		String sql = "select id, password, name, to_char(birthdate, 'YYYY-MM-DD') birthdate, gender, email, substr(phone, 1,3) || '-'  || substr(phone, 4,4) || '-'  || substr(phone, 8,4) phone, photoName from member where id=?";
		
/*		//방법1
		List<MemberInfo> result = jdbcTemplate.query(sql, new MemberRowMapper(), id);		
		resultObj = result.isEmpty() ? null : result.get(0);*/
		
		//방법2
		resultObj = jdbcTemplate.queryForObject(sql, new MemberRowMapper(), id);
		
		return resultObj;
	}
	
	
	public int insert(MemberInfo memberInfo) {
		int resultCnt = 0;
		
		//KeyHolder keyHolder = new GeneratedKeyHolder();
		
		String sql = "insert into member (id, password, name, birthdate, gender, email, phone, photoName) values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		resultCnt = jdbcTemplate.update(sql, memberInfo.getId(), memberInfo.getPassword(), memberInfo.getName(), memberInfo.getYear() + "-" + memberInfo.getMonth() + "-" + memberInfo.getDay(), memberInfo.getGender(), memberInfo.getEmail(), memberInfo.getPhone(), memberInfo.getPhotoName());	
		
/*		resultCnt = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = null;
				pstmt = conn.prepareStatement(sql, new String[] {"mIdx"});
				pstmt.setString(1, memberInfo.getId());
				pstmt.setString(2, memberInfo.getPassword());
				pstmt.setString(3, memberInfo.getName());
				pstmt.setString(4, memberInfo.getYear() + "-" + memberInfo.getMonth() + "-" + memberInfo.getDay());
				pstmt.setString(5, memberInfo.getGender());
				pstmt.setString(6, memberInfo.getEmail());
				pstmt.setString(7, memberInfo.getPhone());
				pstmt.setString(8, memberInfo.getPhotoName());
				
				return pstmt;
			}
		}, keyHolder);
		
		Number keyValue = keyHolder.getKey();
		memberInfo.setmIdx(keyValue.intValue());*/
		
		return resultCnt;
	}
}