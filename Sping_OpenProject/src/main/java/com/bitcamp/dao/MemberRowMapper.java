package com.bitcamp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bitcamp.model.MemberInfo;

public class MemberRowMapper implements RowMapper<MemberInfo> {

	@Override
	public MemberInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberInfo memberInfo = new MemberInfo();
		
		memberInfo.setId(rs.getString(1));
		memberInfo.setPassword(rs.getString(2));
		memberInfo.setName(rs.getString(3));
		memberInfo.setGender(rs.getString(5));
		memberInfo.setEmail(rs.getString(6));
		memberInfo.setPhone(rs.getString(7));
		memberInfo.setPhotoName(rs.getString(8));
		
		String birthdate = rs.getString(4);
		
		String split[] = birthdate.split("-");
		
		memberInfo.setYear(split[0]);
		memberInfo.setMonth(split[1]);
		memberInfo.setDay(split[2]);
		
		return memberInfo;
	}
}