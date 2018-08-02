package com.bitcamp.service;


import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.dao.JdbcTemplateBoardDao;
import com.bitcamp.dao.MyBatisBoardDao;
import com.bitcamp.model.BoardInfo;

public class WriteService {
/*	@Autowired
	JdbcTemplateBoardDao boardDao;*/
	
	@Autowired
	MyBatisBoardDao boardDao;
	
	public int write(BoardInfo boardInfo) throws ServiceException {
		return boardDao.insert(boardInfo);
	}
}