package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import Jdbc.JdbcUtil;
import connection.ConnectionProvider;
import dao.BoardDao;
import model.BoardInfo;

public class GetBoardListService {
	private GetBoardListService() { }
	
	private static GetBoardListService getBoardListService = new GetBoardListService();
	
	public static GetBoardListService getInstance() {
		return getBoardListService;
	}
	
	private static final int BOARD_COUNT_PER_PAGE = 5;
	
	public BoardListView getList(String writer_id, int pageNumber) throws ServiceException {
		Connection conn = null;
		
		int currentPageNumber = 1;
		
		if(pageNumber > 0)
			currentPageNumber = pageNumber;
		
		try {
			conn = ConnectionProvider.getConnection();
			BoardDao dao = BoardDao.getInstance();
			
			int boardTotalCount = dao.selectCount(conn, writer_id);
			List<BoardInfo> boardList = null;
			
			int firstRow = 0;
			int endRow = 0;
			
			if(boardTotalCount > 0) {
				firstRow = (pageNumber - 1) * BOARD_COUNT_PER_PAGE + 1;
				endRow = firstRow + BOARD_COUNT_PER_PAGE - 1;
				
				boardList = dao.select(conn, writer_id, firstRow, endRow);
			}
			else {
				currentPageNumber = 0;
				boardList = Collections.emptyList();
			}			
			
			return new BoardListView(boardTotalCount, currentPageNumber, boardList, BOARD_COUNT_PER_PAGE, firstRow, endRow);
	
		} catch(SQLException e) {
			throw new ServiceException("게시글 정보 가져오기 실패: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	public BoardInfo getList(int board_id) throws ServiceException {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			BoardDao dao = BoardDao.getInstance();
			
			return dao.select(conn, board_id);
		} catch(SQLException e) {
			throw new ServiceException("게시글 정보 가져오기 실패: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}