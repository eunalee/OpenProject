package com.bitcamp.dao;

import com.bitcamp.model.MemberInfo;

public interface MemberDaoInterface {
	public MemberInfo selectById(String userId);
	public void inserMember(MemberInfo memberInfo);
}