package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Jdbc.JdbcUtil;
import model.BoardInfo;

public class BoardDao {
	private BoardDao() { }
	
	private static BoardDao boardDao = new BoardDao();
	
	public static BoardDao getInstance() {
		return boardDao;
	}

	public int insert(Connection conn, BoardInfo boardInfo) throws SQLException {
		PreparedStatement pstmt = null;
		
		String sql = "insert into board (board_id, writer_id, title, content, writedate) values (board_id_seq.NEXTVAL, ?, ?, ?, sysdate)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardInfo.getWriter_id());
			pstmt.setString(2, boardInfo.getTitle());
			pstmt.setString(3, boardInfo.getContent());
			
			return pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
	
	public BoardInfo select(Connection conn, int board_id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select board_id, title, content, writedate from board where board_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
				return boardInfoResultSet(rs);
			else
				return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public List<BoardInfo> select(Connection conn, String writer_id, int firstRow, int endRow) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardInfo> boardList = new ArrayList<BoardInfo>();
		
		String sql = "select board_id, title, content, writedate" 
				+ " from (select rownum rnum, board_id, title, content, to_char(writedate, 'YYYY-MM-DD') writedate" 
				+ " from (select * from board where writer_id=? order by board_id desc)" 
				+ "where rownum <= ?)" 
				+ "where rnum >= ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer_id);
			pstmt.setInt(2, endRow);
			pstmt.setInt(3, firstRow);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					boardList.add(boardInfoResultSet(rs));
				} while(rs.next());
				
				return boardList;
			}
			else 
				return Collections.emptyList();
			
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public int selectCount(Connection conn, String writer_id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select count(*) from board where writer_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer_id);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			return rs.getInt(1);
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	private BoardInfo boardInfoResultSet(ResultSet rs) throws SQLException {
		BoardInfo boardInfo = new BoardInfo();
		
		boardInfo.setBoard_id(rs.getInt(1));
		boardInfo.setTitle(rs.getString(2));
		boardInfo.setContent(rs.getString(3));
		boardInfo.setWritedate(rs.getString(4));
		
		return boardInfo;
	}
	
	public int update(Connection conn, int board_id, String title, String content) throws SQLException {
		PreparedStatement pstmt = null;
		
		String sql = "update board set title=?, content=? where board_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, board_id);
			
			return pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
	
	public int delete(Connection conn, int board_id) throws SQLException {
		PreparedStatement pstmt = null;
		
		String sql = "delete from board where board_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_id);
			
			return pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
}