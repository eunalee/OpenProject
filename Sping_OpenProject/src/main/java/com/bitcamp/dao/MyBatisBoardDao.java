package com.bitcamp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.model.BoardInfo;

public class MyBatisBoardDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int selectCount(String writer_id) {
		return sqlSessionTemplate.selectOne("com.bitcamp.mapper.BoardMapper.selectCount", writer_id);
	}
	
	public BoardInfo selectById(int board_id) {
		return sqlSessionTemplate.selectOne("com.bitcamp.mapper.BoardMapper.selectById", board_id);
	}
	
	public List<BoardInfo> selectAll(String writer_id, int firstRow, int endRow) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("writer_id", writer_id);
		map.put("endRow", endRow);
		map.put("firstRow", firstRow);
		
		return sqlSessionTemplate.selectList("com.bitcamp.mapper.BoardMapper.selectAll", map);
	}	
	
	public int insert(BoardInfo boardInfo) {
		return sqlSessionTemplate.update("com.bitcamp.mapper.BoardMapper.insert", boardInfo);
	}
	
	public int update(BoardInfo boardInfo) {
		return sqlSessionTemplate.update("com.bitcamp.mapper.BoardMapper.update", boardInfo);
	}
	
	public int delete(int board_id) {
		return sqlSessionTemplate.delete("com.bitcamp.mapper.BoardMapper.delete", board_id);
	}
}