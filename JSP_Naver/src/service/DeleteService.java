package service;

import java.sql.Connection;
import java.sql.SQLException;

import Jdbc.JdbcUtil;
import connection.ConnectionProvider;
import dao.BoardDao;

public class DeleteService {
	private DeleteService() { }
	
	private static DeleteService deleteService = new DeleteService();
	
	public static DeleteService getInstance() {
		return deleteService;
	}
	
	public void delete(int board_id) throws ServiceException {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			BoardDao dao = BoardDao.getInstance();
			dao.delete(conn, board_id);
			conn.commit();
		} catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new ServiceException("글 삭제 실패: " + e.getMessage(), e);
		} finally {
			if(conn != null) {
				try {
					conn.setAutoCommit(false);
				} catch(SQLException e) { }
				
				JdbcUtil.close(conn);
			}
		}
	}
}