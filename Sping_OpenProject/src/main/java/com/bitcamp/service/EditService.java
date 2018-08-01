package com.bitcamp.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.dao.JdbcTemplateBoardDao;

public class EditService {
	@Autowired
	JdbcTemplateBoardDao boardDao;
	
	@Transactional //이 안에서 실행되는 트랜잭션처리가 서버에 적용되지 않도록
	public int edit(int board_id, String title, String content) throws SQLException {
		return boardDao.update(board_id, title, content);
	}
}