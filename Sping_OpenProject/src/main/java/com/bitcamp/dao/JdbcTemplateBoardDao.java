package com.bitcamp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bitcamp.model.BoardInfo;

public class JdbcTemplateBoardDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int selectCount(String writer_id) {
		String sql = "select count(*) from board where writer_id=?";
		
		int count = jdbcTemplate.queryForObject(sql, Integer.class, writer_id);
		
		return count;
	}
	
	public BoardInfo selectById(int board_id) {
		String sql = "select board_id, title, content, writedate from board where board_id=?";
		
		BoardInfo resultObj = jdbcTemplate.queryForObject(sql, new BoardRowMapper(), board_id);
		
		return resultObj;
	}
	
	public List<BoardInfo> selectAll(String writer_id, int firstRow, int endRow) {
		String sql = "select board_id, title, content, writedate" 
				+ " from (select rownum rnum, board_id, title, content, to_char(writedate, 'YYYY-MM-DD') writedate" 
				+ " from (select * from board where writer_id=? order by board_id desc)" 
				+ "where rownum <= ?)" 
				+ "where rnum >= ?";
		
		List<BoardInfo> boardList = jdbcTemplate.query(sql, new BoardRowMapper(), writer_id, endRow, firstRow);
		
		return boardList;
	}	
	
	public int insert(BoardInfo boardInfo) {
		String sql = "insert into board (board_id, writer_id, title, content, writedate) values (board_id_seq.NEXTVAL, ?, ?, ?, sysdate)";
		
		int resultCnt = jdbcTemplate.update(sql, boardInfo.getWriter_id(), boardInfo.getTitle(), boardInfo.getContent());	
		
		return resultCnt;
	}
	
	public int update(int board_id, String title, String content) {
		String sql = "update board set title=?, content=? where board_id=?";
		
		int resultCnt = jdbcTemplate.update(sql, title, content, board_id);
		
		return resultCnt;
	}
	
	public int delete(int board_id) {
		String sql = "delete from board where board_id=?";
		
		int resultCnt = jdbcTemplate.update(sql, board_id);
		
		return resultCnt;
	}
}