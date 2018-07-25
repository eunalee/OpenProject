package service;

import java.sql.Connection;
import java.sql.SQLException;

import Jdbc.JdbcUtil;
import connection.ConnectionProvider;
import dao.BoardDao;
import model.BoardInfo;

public class WriteService {
	private WriteService() { }
	
	private static WriteService writeService = new WriteService();
	
	public static WriteService getInstance() {
		return writeService;
	}
	
	public void write(BoardInfo boardInfo) throws ServiceException {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			BoardDao dao = BoardDao.getInstance();
			dao.insert(conn, boardInfo);
		} catch(SQLException e) {
			throw new ServiceException("글 등록 실패: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}