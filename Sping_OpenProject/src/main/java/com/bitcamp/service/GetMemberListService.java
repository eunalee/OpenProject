package com.bitcamp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.dao.MyBatisMemberDao;
import com.bitcamp.model.MemberInfoView;

public class GetMemberListService {
	@Autowired
	MyBatisMemberDao memberDao;
	
	public List<MemberInfoView> getList() throws Exception {
		return memberDao.selectAll();
	}
}