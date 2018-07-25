package service;

import java.sql.Connection;
import java.sql.SQLException;

import Jdbc.JdbcUtil;
import connection.ConnectionProvider;
import dao.BoardDao;

public class EditService {
	private EditService() { }
	
	private static EditService editService = new EditService();
	
	public static EditService getInstance() {
		return editService;
	}
	
	public void edit(int board_id, String title, String content) throws ServiceException {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			BoardDao dao = BoardDao.getInstance();
			dao.update(conn, board_id, title, content);
			conn.commit();
		} catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new ServiceException("글 수정 실패: " + e.getMessage(), e);
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