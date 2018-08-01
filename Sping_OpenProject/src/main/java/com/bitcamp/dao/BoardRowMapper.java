package com.bitcamp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bitcamp.model.BoardInfo;

public class BoardRowMapper implements RowMapper<BoardInfo> {

	@Override
	public BoardInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardInfo boardInfo = new BoardInfo();
		
		boardInfo.setBoard_id(rs.getInt(1));
		boardInfo.setTitle(rs.getString(2));
		boardInfo.setContent(rs.getString(3));
		boardInfo.setWritedate(rs.getString(4));
		
		return boardInfo;
	}
}