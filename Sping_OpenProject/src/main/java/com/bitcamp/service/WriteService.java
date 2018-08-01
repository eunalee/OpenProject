package com.bitcamp.service;


import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.dao.JdbcTemplateBoardDao;
import com.bitcamp.model.BoardInfo;

public class WriteService {
	@Autowired
	JdbcTemplateBoardDao boardDao;
	
	public int write(BoardInfo boardInfo) throws ServiceException {
		return boardDao.insert(boardInfo);
	}
}