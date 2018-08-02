package com.bitcamp.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.dao.MyBatisBoardDao;
import com.bitcamp.model.BoardInfo;

public class GetBoardListService {
/*	@Autowired
	JdbcTemplateBoardDao boardDao;*/
	
	@Autowired
	MyBatisBoardDao boardDao;
	
/*	@Autowired
	private SqlSessionTemplate template;
	
	private BoardDaoInterface boardDao;*/
	
	private static final int BOARD_COUNT_PER_PAGE = 5;
	
	public BoardListView getList(String writer_id, int pageNumber) throws SQLException {
		int currentPageNumber = 1;
		
		if(pageNumber > 0)
			currentPageNumber = pageNumber;
		
		int boardTotalCount = boardDao.selectCount(writer_id);
		List<BoardInfo> boardList = null;
		
		int firstRow = 0;
		int endRow = 0;
		
		if(boardTotalCount > 0) {
			firstRow = (pageNumber - 1) * BOARD_COUNT_PER_PAGE + 1;
			endRow = firstRow + BOARD_COUNT_PER_PAGE - 1;
			
			boardList = boardDao.selectAll(writer_id, firstRow, endRow);
		}
		else {
			currentPageNumber = 0;
			boardList = Collections.emptyList();
		}			
		
		return new BoardListView(boardTotalCount, currentPageNumber, boardList, BOARD_COUNT_PER_PAGE, firstRow, endRow);
	}
	
	public BoardInfo getListById(int board_id) throws SQLException {
		return boardDao.selectById(board_id);
	}
}