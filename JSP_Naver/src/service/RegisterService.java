package service;

import java.sql.Connection;
import java.sql.SQLException;

import Jdbc.JdbcUtil;
import connection.ConnectionProvider;
import dao.MemberDao;
import model.MemberInfo;

public class RegisterService {
	private RegisterService() { }
	
	private static RegisterService registerService = new RegisterService();
	
	public static RegisterService getInstance() {
		return registerService;
	}
	
	public int register(MemberInfo memberInfo) throws ServiceException {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			MemberDao dao = MemberDao.getInstance();
			return dao.insert(conn, memberInfo);
		} catch(SQLException e) {
			throw new ServiceException("회원가입 실패: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}