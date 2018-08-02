package com.bitcamp.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.dao.JdbcTemplateBoardDao;
import com.bitcamp.dao.MyBatisBoardDao;


public class DeleteService {
/*	@Autowired
	JdbcTemplateBoardDao boardDao;*/
	@Autowired
	MyBatisBoardDao boardDao;
	
	@Transactional //이 안에서 실행되는 트랜잭션처리가 서버에 적용되지 않도록
	public int delete(int board_id) throws SQLException {
		return boardDao.delete(board_id);
	}
}